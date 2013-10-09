# Introduction


This document is a edited collection of Scott's notes for the data collection app.

# Building the data collection

Prerequisties: 

* Linux with a package manager, I'm using Ubuntu 12.04 LTS 64

Download the Raspbian cross-compiler.

         git clone https://github.com/raspberrypi/tools.git

Add the `tools/arm-bcm2708/gcc-linaro-arm-linux-gnueabihf-raspbian/bin` directory to your path

# Download and build Fiji

See [checkout-instructions.txt](https://github.com/scottcarr/crack/raw/master/checkout-instructions.txt) for how to download and required packages.

I also needed to still the following packages:

* lib32stdc++6 
* lib32z1 
* lib32z1-dev

After running configure but before running make, run:

      bin/add-target --host arm-linux-gnueabi-hf --posix --sync-type gcc-intrinsic

Now make.

# Setup the USB sound card on your RPi

It's pretty much plug and play.  I read that you need to add your username to the audio group.  You can test it with Audacity.  Your package manager should have it.  Remember the RPi has a built in sound out!

We're using aplay and arecord to play/record the sound.  See their man pages for more information.  While they have many options not all of them work with our sound card.  The max rate is 48kHz and the input is mono.  There is a list option to list the available sound cards.

# Generating a 4kHz tone

Use your package manger to install sox.

This command generates a 16-bit 30 second duration 4kHz stereo wav file (with volume 0.5)

     sox -b 16 -n s4kwav.wav synth 30 sin 4000 channels 2 vol .5
     
If you don't want to generate your own tone, there's one at [data/s4kwav.wav](https://github.com/scottcarr/crack/raw/master/data/s4kwav.wav)

# Build the data collection app

Download the source:

         git clone https://github.com/scottcarr/crack.git
        
Go into the java directory and make.  You will need to update the variable FIVM in java/Makefile with the folder you built Fiji in.

# Run the app on the Raspberry Pi

Setup your RPi for ssh and scp AudioTestMainFIVMRPi to it.  Then just run it like any other binary.  If you run it without any arguments it'll print out a help message.

# Reading the data

I wrote a Octave script to convert a .wav (binary) file to a .dat (text) file.  It's at [octave/wav2dat.m](https://github.com/scottcarr/crack/blame/master/octave/wav2dat.m)

Once you've converted the .wav file you want to analyze you can see [python/check.py](https://raw.github.com/scottcarr/crack/master/python/check.py) for an example of how to do an analysis using numpy.