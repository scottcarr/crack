import java.lang.Thread;

public class AudioTestMain {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("USAGE: AudioTestMainFIVM outFile inFile devName duration channels");
            return;
        }
        String outFile = args[0];
        String inFile = args[1];
        String devName = args[2];
        int duration = Integer.parseInt(args[3]);
        int channels = Integer.parseInt(args[4]);
        AudioRecorder ar = new AudioRecorder(outFile, duration, devName, channels);
        AudioPlayer ap = new AudioPlayer(inFile, devName);
        Thread arThread = new Thread(ar);
        Thread apThread = new Thread(ap);
        arThread.start(); // start recording first
        apThread.start();
        try {
            apThread.join();
            arThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
