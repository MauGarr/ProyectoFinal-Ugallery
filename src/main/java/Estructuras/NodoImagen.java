
package Estructuras;

import Principal.Imagen;

public class NodoImagen {
    
    private Imagen imagen;
    private NodoImagen siguiente;
    private NodoImagen anterior;

    public NodoImagen(Imagen imagen) {
        this.imagen = imagen;
    }
    
    public NodoImagen(Imagen imagen, NodoImagen siguiente, NodoImagen anterior) {
        this.imagen = imagen;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public NodoImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoImagen siguiente) {
        this.siguiente = siguiente;
    }

    public NodoImagen getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoImagen anterior) {
        this.anterior = anterior;
    }   
    
}
