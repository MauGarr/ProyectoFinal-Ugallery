
package EditarImagen;

import Handlers.ImageHandler;
import Handlers.JPEGHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class JPEGImageCopy extends ImageHandler{

    String nombreCorto;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    
    public JPEGImageCopy(String filename) {
        super(filename);
        
        File f = new File(getFileName());
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
    }

    public static void copia(String rutaImagen) {
        BmpHandlerCopy handlerBn = new BmpHandlerCopy(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerBn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void readFile() throws Exception {
        
        String rutaCarpeta = "./imagenes/CopyJPEG/";
            // Crea la carpeta de reportes si no esiste
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
        
    File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal =  new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal); 
        bmp = ImageIO.read(bmpTemporal);
        String nombre = "bmpTemporal.bmp";
        copia(nombre);
        ImageIO.write(bmp, "jpg", new File(rutaCarpeta+"BN-" + nombreCorto + ".jpg")); 
        
        bmpTemporal.delete();
        
        ImageIO.write(bmp, "jpg", new File(rutaCarpeta+"BN-" + nombreCorto + ".jpg"));   
    }

    @Override
    public void generateFiles() throws Exception {
    }
    
}
