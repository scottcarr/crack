import java.io.IOException;
import java.util.Arrays;
import com.meapsoft.FFT;

public class CrackFFT {
    public static void main(String[] args) {
        //CrackFFT.doFFT("rec.wav");
        CrackFFT.doFFT("B1_4000_1.wav");
    }
    public static void doFFT(String filename) {
      try {
            double[] data = ReadRecording.readCh0(filename);
            double[] x = ReadRecording.getTimestamps(data.length, 44100);
            System.out.println("all data length: " + data.length);
            // N needs to be a power of 2
            int exp = findLargestPower2(data.length);
            int n = (int)Math.pow(2.0, (double)exp);
            System.out.println("Previous pow 2: " + n);
            double[] truncd = Arrays.copyOf(data, n);
            double[] img = new double[n];
            Arrays.fill(img, 0);
            FFT fft = new FFT(n);
            fft.fft(truncd, img);
            double[] bins = new double[n];
            for (int i = 0; i < n; i++) {
                bins[i] = i * (44100.0/n);
            }
            ReadRecording.plotWav("fft", bins, truncd);
            
        } catch (IOException e) {
            System.out.println("file failed to open");
        } catch (WavFileException e) {
            System.out.println("wav class exception");
            e.printStackTrace();
        }
    }
    public static int findLargestPower2(int n) {
        double exp = Math.log(n) / Math.log(2);
        return (int) exp;
    }
}
