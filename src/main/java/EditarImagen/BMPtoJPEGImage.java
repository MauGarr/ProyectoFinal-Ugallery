
package EditarImagen;

import Handlers.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class BMPtoJPEGImage extends ImageHandler {

    String nombreCorto;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File jpgTemporal;

    public BMPtoJPEGImage(String filename) {
        super(filename);

        File f = new File(getFileName());
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        bmp = ImageIO.read(file);
        String rutaCarpeta = "./imagenes/cambioFormato/";

        // Crea la carpeta de reportes si no esiste
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        ImageIO.write(bmp, "jpg", new File(rutaCarpeta + "converted-" + nombreCorto + ".jpg"));

    }

    @Override
    public void generateFiles() throws Exception {
    }

}
