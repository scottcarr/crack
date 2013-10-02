import com.fiji.fivm.r1.libc;

public class AudioRecorder implements Runnable {
    private String fileName;
    private int duration;
    private String devName;
    private int channels;
    public AudioRecorder(String fileName, int duration, String devName, int channels) {
        this.fileName = fileName;
        this.duration = duration;
        this.devName = devName;
        this.channels = channels;
    }
    public void run() {
        libc.system("arecord -f S16_LE -r 48000 -d " 
                    + Integer.toString(duration) + " "
                    + "-D " + devName + " "
                    + "-c " + Integer.toString(channels) + " "
                    + fileName);
    }
}
