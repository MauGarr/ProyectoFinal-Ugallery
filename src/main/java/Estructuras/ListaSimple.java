
package Estructuras;

import Principal.AppState;
import Principal.Usuario;

public class ListaSimple extends EstructuraDeDatos {

    int contador = 0;
    NodoUsuario primerNodo;
    private NodoUsuario cabeza = null;
    String categoria = "Categoria";
    Usuario usuario = null;

    public void listarNombres() {
        NodoUsuario nodoAuxiliar = cabeza;
        while (nodoAuxiliar != null) {
            System.out.print(nodoAuxiliar.getUsuario().nombre + " -> ");
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        System.out.print("null \n");
    }
    
    @Override
    public void add(Object e) {

        Usuario usuario = (Usuario)e;
        // Si el usuario ya existia en la lista no se hace nada
        if (find(usuario.nombre) != null) {
            return;
        }
        
        NodoUsuario nodoUsuario = new NodoUsuario(usuario);
        if (cabeza == null) {
            // Si la lista estaba vacia se convierte en el primer nodo
            cabeza = nodoUsuario;
        } else {
            // Si no existia y ya hay elemetos en la lista se inserta de ultimo
            NodoUsuario nodoAuxiliar = cabeza;
            while (nodoAuxiliar.getSiguiente() != null) {
                nodoAuxiliar = nodoAuxiliar.getSiguiente();
            }
            nodoAuxiliar.setSiguiente(nodoUsuario);
        }
        
        index++;
        AppState.usuarioLogeado = (Usuario) AppState.listaSimple.get(contador);

        contador++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {

        String nombreUsuario = e.toString();
        NodoUsuario nodoAuxiliar = cabeza;
        for (int i = 0; i < index; i++) {
            AppState.usuarioLogeado = (Usuario) AppState.listaSimple.get(i);
            if (nodoAuxiliar.getUsuario().nombre.equals(nombreUsuario)) {
               return nodoAuxiliar.getUsuario();
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }

        //AppSatate.usuarioLogeado = (Usuario) AppState.listaSimple.find(index);
     
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
        
        if (i < 0 || i >= index) {
            throw new IllegalArgumentException("Indice fuera de los limites.");
        }
        
        NodoUsuario nodoAuxiliar = cabeza;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getUsuario();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
