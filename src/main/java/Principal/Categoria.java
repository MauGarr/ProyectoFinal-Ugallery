
package Principal;

import Estructuras.ListaDoble;

public class Categoria {
  
    public String nombreCategorria;
    public static ListaDoble listaDoble = new ListaDoble();
    
    public Categoria(String nombreCategorria) {
        this.nombreCategorria = nombreCategorria;
    }

    public String getNombreCategorria() {
        return nombreCategorria;
    }

    public void setNombreCategorria(String nombreCategorria) {
        this.nombreCategorria = nombreCategorria;
    }
    
}
