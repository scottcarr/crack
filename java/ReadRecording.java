import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;

public class ReadRecording {
    public static void main(String[] args) {
        try {
            double[] ch0 = readCh0("rec.wav");
            double[] x = getTimestamps(ch0.length, 44100);
            plotWav("ch0", x, ch0);
        } catch (IOException e) {
            System.out.println("file failed to open");
        } catch (WavFileException e) {
            System.out.println("wav class exception");
            e.printStackTrace();
        }
    }
    public static void plotWav(String label, double[] timestamps, double[] data) {
        Plot2DPanel plot = new Plot2DPanel();
        plot.addLinePlot(label, timestamps, data);
        JFrame frame = new JFrame("a plot panel");
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
     }
    public static double[] getTimestamps(int n, double samplingRate) {
        double[] ts = new double[n];
        for (int i = 0; i < n; i++) {
            ts[i] = (double)i*(1.0/samplingRate);
        }
        return ts;
    }
    public static double[] readCh0(String filename) throws IOException, WavFileException{
        double[] chan0;
        File f;
        int[] buff;
        int nFrames;
        int nChannels;
        double[] x;
        f = new File(filename);
        WavFile wavFile = WavFile.openWavFile(f);
        nFrames = (int)wavFile.getNumFrames();
        nChannels = wavFile.getNumChannels();
        buff = new int[nChannels*nFrames];
        chan0 = new double[nFrames];
        wavFile.readFrames(buff,nFrames);
        // ch samples are interleaved
        int j = 0;
        for(int i = 0; i < nFrames*nChannels; i=i+2) {
            chan0[j++] = (double)buff[i];
        }
        return chan0;
    }
}
