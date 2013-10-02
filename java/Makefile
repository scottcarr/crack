# JMP=jmathplot.jar
# FFT=./com/meapsoft
# LIBS=.:WavFile:$(JMP):$(FFT)
# all: ReadRecording.class test CrackFFT.class

# ReadRecording.class: ReadRecording.java
# 	javac -cp $(LIBS) ReadRecording.java 

# CrackFFT.class: CrackFFT.java
# 	javac -cp $(LIBS) CrackFFT.java

# test: ReadRecording.class CrackFFT.class
# #java -cp $(LIBS) ReadRecording
# 	java -cp $(LIBS) CrackFFT

FIVM=/home/carr27/fijiVM
FIVMLIB=$(FIVM)/lib
FIVMR=$(FIVMLIB)/fivmr.jar
FIVMCOM=$(FIVMLIB)/fivmcommon.jar
LIBS=$(FIVMR):$(FIVMCOM)
FIVMC=$(FIVM)/bin/fivmc
SRC=AudioTestMain.java AudioRecorder.java AudioPlayer.java
CLASS=AudioTestMain.class AudioRecorder.class AudioPlayer.class

all: AudioTestMainFIVM AudioTestMainFIVMRPi

AudioTestMainFIVMRPi: AudioTestMain.class
	$(FIVMC) -m AudioTestMain $(CLASS) -o AudioTestMainFIVMRPi --target=arm

AudioTestMainFIVM: AudioTestMain.class
	$(FIVMC) -m AudioTestMain $(CLASS) -o AudioTestMainFIVM

AudioTestMain.class: AudioTestMain.java AudioRecorder.java AudioPlayer.java
	javac AudioTestMain.java -cp .:$(LIBS)

AudioRecorder.class: AudioRecorder.java
	javac AudioRecorder.java -cp $(LIBS)

AudioPlayer.class: AudioPlayer.java
	javac AudioPlayer.java -cp $(LIBS)

clean:
	rm *.class AudioTestMainFIVM AudioTestMainFIVMRPi

