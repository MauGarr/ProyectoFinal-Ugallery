
package EditarImagen;

import Handlers.ImageHandler;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class JPEGImageHandlerColors extends ImageHandler {

    String nombreCorto;
    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    String nombreInicial;
    int R, G, B;

    public JPEGImageHandlerColors(String filename, String nombreInicial, int R, int G, int B) {
        super(filename);

        File f = new File(getFileName());
        this.nombreCorto = FilenameUtils.removeExtension(f.getName());
        this.nombreInicial = nombreInicial;
        this.R = R;
        this.G = G;
        this.B = B;
    }

    @Override
    public void readFile() throws Exception {

        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal);
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {

        String rutaCarpeta = "./imagenes/filtroColor/";
            // Crea la carpeta de reportes si no esiste
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
           
        if (nombreInicial.equals("Serpia-")) {
            for (int x = 0; x < bmp.getWidth(); x++) {
                for (int y = 0; y < bmp.getHeight(); y++) {
                    Color color = new Color(bmp.getRGB(x, y));
                    int red = (int) (color.getRed() * 0.393 + color.getGreen() * 0.769 + color.getBlue() * 0.189);
                    int green = (int) (color.getRed() * 0.349 + color.getGreen() * 0.686 + color.getBlue() * 0.168);
                    int blue = (int) (color.getRed() * 0.272 + color.getGreen() * 0.534 + color.getBlue() * 0.131);

                    Color newColor = new Color((red > 255) ? 255 : red, (green > 255) ? 255 : green, (blue > 255) ? 255 : blue);
                    bmp.setRGB(x, y, newColor.getRGB());
                }
            }
            
            ImageIO.write(bmp, "jpg", new File(rutaCarpeta + nombreInicial + nombreCorto + ".jpg"));
            bmpTemporal.delete();

        } else {
            for (int x = 0; x < bmp.getWidth(); x++) {
                for (int y = 0; y < bmp.getHeight(); y++) {
                    Color color = new Color(bmp.getRGB(x, y));
                    Color newColor = new Color(color.getRed() * R, color.getGreen() * G, color.getBlue() * B);
                    bmp.setRGB(x, y, newColor.getRGB());
                }
            }

            ImageIO.write(bmp, "jpg", new File(rutaCarpeta + nombreInicial + nombreCorto + ".jpg"));
            bmpTemporal.delete();
        }

    }

}
