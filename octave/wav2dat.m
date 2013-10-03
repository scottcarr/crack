#! /usr/bin/octave
arg_list = argv();
if (length(arg_list) != 2) 
  printf("Usage: wav2dat INFILE OUTFILE");
  exit();
end
infile = arg_list(1){1,1};
outfile = arg_list(2){1,1};
printf("Converting %s to %s\n", infile, outfile);
dat = wavread(infile);
save(outfile, "dat")
