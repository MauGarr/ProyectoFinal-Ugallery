
package Estructuras;

import Principal.Imagen;

public class ListaDoble extends EstructuraDeDatos {

    NodoImagen primerNodo;
    NodoImagen ultimoNodo;

    @Override
    public void add(Object e) {
        Imagen imagen = (Imagen) e;
        if (primerNodo == null) {
            primerNodo = ultimoNodo = new NodoImagen(imagen);
        } else {
            NodoImagen nuevoNodo = new NodoImagen(imagen, null, ultimoNodo);
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        if (primerNodo == null) {
            return null;
        }
        String ruta = e.toString();
        NodoImagen nodoAuxiliar = primerNodo;
        for (int i = 0; i < index; i++) {
            if (nodoAuxiliar.getImagen().getRuta().equals(ruta)) {
                return nodoAuxiliar.getImagen();
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > index) {
            return new IndexOutOfBoundsException();
        }
        NodoImagen nodoAuxiliar = primerNodo;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getImagen();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        String ruta = e.toString();
        NodoImagen nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null && !nodoAuxiliar.getImagen().getRuta().equals(ruta)) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        if (nodoAuxiliar == null) {
            return;
        } else if (nodoAuxiliar == primerNodo) {
            primerNodo = primerNodo.getSiguiente();
            if(primerNodo != null){
               primerNodo.setAnterior(null); 
            }      
        } else if (nodoAuxiliar == ultimoNodo) {
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        } else {
            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
        }
        index--;
    }
    
}
