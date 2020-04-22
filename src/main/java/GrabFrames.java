import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GrabFrames {
    public static void main(String[] args) throws IOException {
        //FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("udp://localhost:1234");
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("C:\\Users\\Jeffrey\\Desktop\\short.ts");
        grabber.start();
        Frame frame;
        int imageNumber = 1;
        while((frame = grabber.grabImage()) != null) {
            BufferedImage image = new Java2DFrameConverter().convert(frame);
            File outputfile = new File("C:\\Users\\Jeffrey\\Desktop\\stills\\image"+imageNumber+".jpg");
            ImageIO.write(image, "jpg", outputfile);
            imageNumber++;
        }
    }
}
