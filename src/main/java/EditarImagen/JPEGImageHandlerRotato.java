
package EditarImagen;

import Handlers.ImageHandler;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class JPEGImageHandlerRotato extends ImageHandler {

    String nombreCorto;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    BufferedImage bmp2 = null;
    BufferedImage bmp3 = null;
    File bmpTemporal;
    File bmpTemporal2;
    File bmpTemporal3;

    public JPEGImageHandlerRotato(String filename) {
        super(filename);

        File f = new File(getFileName());
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal =  new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal);
        bmp = ImageIO.read(bmpTemporal);
        
        bmpTemporal2 =  new File("./bmpTemporal2.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal2);
        bmp2 = ImageIO.read(bmpTemporal2);
 
        bmpTemporal3 =  new File("./bmpTemporal3.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal3);
        bmp3 = ImageIO.read(bmpTemporal3);
    }
    
    @Override
    public void generateFiles() throws Exception {

        String rutaCarpeta = "./imagenes/rotacion/";
            // Crea la carpeta de reportes si no esiste
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {
                Color color = new Color(bmp.getRGB(x, y));
                Color newColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
                bmp2.setRGB(x, bmp.getHeight() - y - 1, newColor.getRGB());
            }
        }
        
        for (int x = 0; x < bmp.getWidth(); x++) {
            for (int y = 0; y < bmp.getHeight(); y++) {
                Color color = new Color(bmp.getRGB(x, y));
                Color newColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
                bmp3.setRGB(bmp.getWidth()-x-1, y, newColor.getRGB());
            }
        }
        
        ImageIO.write(bmp3, "jpg", new File(rutaCarpeta+"Vrotation-" + nombreCorto + ".jpg"));
        ImageIO.write(bmp2, "jpg", new File(rutaCarpeta+"Hrotation-" + nombreCorto + ".jpg"));
        bmpTemporal.delete();
        bmpTemporal2.delete();
        bmpTemporal3.delete();
    }

}
