
package Principal;

import VentanasFrame.VentanaPrincipal;
import EditarImagen.BMPtoJPEGImage;
import EditarImagen.JPEGImageCopy;
import EditarImagen.JPEGImageHandlerBN;
import EditarImagen.JPEGImageHandlerColors;
import EditarImagen.JPEGImageHandlerRotato;
import EditarImagen.JPEGtoBMPImage;
import Handlers.JPEGHandler;

public class ProyectoFinal_IPC1 {

    public static void convertirBlancoNegro(String rutaImagen) {
        JPEGImageHandlerBN handlerBn = new JPEGImageHandlerBN(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerBn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void rotarHorizontal(String rutaImagen) {
        JPEGImageHandlerRotato handlerHV = new JPEGImageHandlerRotato(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerHV);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void convertirColores(String rutaImagen, String nombreIncial, int R, int G, int B) {
        JPEGImageHandlerColors handlerColor = new JPEGImageHandlerColors(rutaImagen, nombreIncial, R, G, B);
        try {
            JPEGHandler.runHandler(handlerColor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copiaJPEG(String rutaImagen) {
        JPEGImageCopy handlerBn = new JPEGImageCopy(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerBn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void jpgToBmp(String rutaImagen) {
        JPEGtoBMPImage handlerBn = new JPEGtoBMPImage(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerBn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void bmpToJpg(String rutaImagen) {
        BMPtoJPEGImage handlerBn = new BMPtoJPEGImage(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerBn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        Categoria categoria = new Categoria("General");
        //Usuario.categoria.add(categoria);
        
        /*
        ListaSimple listaSimple = new ListaSimple();
        Usuario jose = new Usuario("Jose");
        Usuario daniel = new Usuario("Jose");
        Usuario alvarado = new Usuario("alvarado");
        listaSimple.add(jose);
        listaSimple.add(daniel);
        listaSimple.add(alvarado);
        listaSimple.listarNombres();
        */
        VentanaPrincipal VentanaPrincipal = new VentanaPrincipal();
        VentanaPrincipal.setVisible(true);
    }
    
}
