JMP=jmathplot.jar
FFT=./com/meapsoft
LIBS=.:WavFile:$(JMP):$(FFT)
all: ReadRecording.class test CrackFFT.class

ReadRecording.class: ReadRecording.java
	javac -cp $(LIBS) ReadRecording.java 

CrackFFT.class: CrackFFT.java
	javac -cp $(LIBS) CrackFFT.java

test: ReadRecording.class CrackFFT.class
#java -cp $(LIBS) ReadRecording
	java -cp $(LIBS) CrackFFT

