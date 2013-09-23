
CRACK DETECTION USING PIEZO TRANSDUCERS
----------------------------------------

This is the data that I obtained with Sungmin by using a 4KHz signal
and exciting the blades to their natural frequency by hitting with a 
small hammer. The sidebands have to be normalized to the 10Hz peak natural
frequency to make them immune to the differences in intensity of the 
excitation.

The files in this folder show the results of using piezo transducers
to detect cracks. 

The blades 1 and 2 are healthy and the blade 3 has a crack. Each blade has
two piezo transducers: in-piezo and out-piezo. The position
of the transducer is the same in all the blades. In the blade with the crack 
the in-piezo and out-piezo are located in each side of the crack.

The out-piezo is excited with 4KHz from the audio output of the PC computer
amplified using a LM386 audio amplifier. 

The signal of the in-piezo is amplified using a FET amplifier of high impedance
and then recorded in the microphone input in the PC.

The blade has a 10Hz natural frequency that is excited by hitting the blade.
We expect that this natural frequency will also be excited when the blades rotate.

The 4KHz and 10Hz signal are combined in different ways in the different blades.

You see that in B1_4000_1.JPG and B2_4000_1.JPG the sidebands of 4KHz +/- 10Hz
are not as pronounced as in B3_4000_1.JPG, that shows stronger sidebands 
due to the non-linearity of the crack.

The WAV files are in B*_4000_1.WAV. The data passed to Matlab is in B*_4000_1.DAT.

The matlab file Analysis.mat produces the graphs.

Gustavo Rodriguez-Rivera
grr@cs.purdue.edu


