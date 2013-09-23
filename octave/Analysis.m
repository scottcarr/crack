fname=strcat('B3_4000_1','.dat')
fid=fopen(fname);
C=textscan(fid,'%f %f %f','HeaderLines', 3);
t=C{1};
x=C{2};

plot(t,x);

X=fft(x);
N=size(x,1);

fs=44100;
freq=0:fs/N:fs/2;

figure;
subplot(211);
semilogy(freq(1:N/2),abs(X(1:N/2)));
xlim([0 20])

subplot(212);
semilogy(freq(1:N/2),abs(X(1:N/2)));
xlim([3950 4050])