import com.fiji.fivm.r1.libc;

public class AudioPlayer implements Runnable {
    private String fileName;
    private String devName;
    public AudioPlayer(String fileName, String devName) {
        this.fileName = fileName;
        this.devName = devName;
    }
    public void run() {
        libc.system("aplay -D " + devName + " " + fileName);
    }
}
