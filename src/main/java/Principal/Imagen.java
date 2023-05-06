
package Principal;

import javax.swing.ImageIcon;

public class Imagen {

    public ImageIcon imageIcon;
    public String ruta;

    public Imagen(ImageIcon imageIcon, String ruta) {
        this.imageIcon = imageIcon;
        this.ruta = ruta;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}
