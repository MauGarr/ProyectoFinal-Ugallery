
package EditarImagen;

import Handlers.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class JPEGtoBMPImage extends ImageHandler {

    String nombreCorto;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;

    public JPEGtoBMPImage(String filename) {
        super(filename);

        File f = new File(getFileName());
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("si");
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        
        String rutaCarpeta = "./imagenes/cambioFormato/";
            // Crea la carpeta de reportes si no esiste
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

        ImageIO.write(jpg, "bmp", new File(rutaCarpeta + "converted-" + nombreCorto + ".bmp"));

    }

    @Override
    public void generateFiles() throws Exception {
    }

}
