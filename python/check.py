import numpy as np
from pylab import *

def doAnalysis():
    i = 0
    data = np.loadtxt(datasets[i]["filename"], skiprows=2)
    X, freq = getFFT(data, datasets[i]["fs"])
    makePlots(X, freq, data.shape[0])


def getFFT(sig, fs):
    N = float(sig.shape[0])
    X = np.fft.fft(sig[:,1])
    freq = np.r_[0.0:fs/2.0:fs/N]
    return X, freq
    
def makePlots(sig, freq, N):
    figure(1); clf()
    subplot("211")
    semilogy(freq[0:N/2], np.abs(sig[0:N/2]))
    xlim([0, 20])
    subplot("212")
    semilogy(freq[0:N/2], np.abs(sig[0:N/2]))
    xlim([3950, 4050])
    # figure(2); clf()
    # semilogy(freq[0:N/2], np.abs(sig[0:N/2]))

def compareSideBands():
    figure(1); clf()
    for d in datasets:
        data = np.loadtxt(d["filename"], skiprows=2)
        N = float(data.shape[0])
        fs = d["fs"]
        X, freq = getFFT(data, fs)
        lower = 0
        upper = np.nonzero(freq > (20 - fs/N))[0][0]
        peak = np.abs(np.max(X[lower:upper]))
        print peak
        coeff = 1./peak
        # coeff = 1.
        subplot("212")
        semilogy(freq[0:N/2], np.abs(coeff)*np.abs(X[0:N/2]))
        xlim([3950, 4050])
        subplot("211")
        semilogy(freq[0:N/2], np.abs(coeff)*np.abs(X[0:N/2]))
        xlim([0, 20])
    legend(["healthy", "healthy", "cracked"])

def compare10Hz():
    figure(2); clf()
    for d in datasets:
        data = np.loadtxt(d["filename"], skiprows=2)
        N = data.shape[0]
        fs = d["fs"]
        X, freq = getFFT(data, fs)
        semilogy(freq[0:N/2], np.abs(X[0:N/2]))
        xlim([0, 20])

def onekHztone():
    filename = "../data/tones/1kHz_44100Hz_16bit_30sec.dat"
    fs = 44100.0 # frequency samples
    duration = 30.0
    N = duration*fs # number data pts
    data = np.loadtxt(filename, skiprows=2)
    X = np.fft.fft(data)
    freq = np.r_[0.0:fs/2.0:fs/N]
    figure(3); clf()
    semilogy(freq[0:N/2], np.abs(X[0:N/2]))
    
        
                    
    
ion()
datasets = [{"filename": "../data/B1_4000_1.dat", "fs" : 44100.0},\
            {"filename": "../data/B2_4000_1.dat", "fs" : 44100.0},\
            {"filename": "../data/B3_4000_1.dat", "fs" : 44100.0}]
#doAnalysis()
#compareSideBands()
#compare10Hz()
onekHztone()
