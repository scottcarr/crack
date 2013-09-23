import numpy as np
from pylab import *

ion()
data = np.loadtxt("../data/B1_4000_1_rec.dat", skiprows=2)
# print data
# figure(1); clf()
# plot(data[:1000,0], data[:1000,1])
#fs = 44100.0
fs = 48000
N = float(data.shape[0])

X = np.fft.fft(data)
freq = np.r_[0.0:fs/2.0:fs/N]

figure(1); clf()
subplot("211")
semilogy(freq[0:N/2], np.abs(X[0:N/2]))
xlim([0, 20])

subplot("212")
semilogy(freq[0:N/2], np.abs(X[0:N/2]))
xlim([3950, 4050])
