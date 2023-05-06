
package Principal;

import java.util.LinkedList;

public class Usuario {
    
    public String nombre;
    public LinkedList<Categoria> categoria = new LinkedList<>();
   
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int agregarCategoria(Categoria cat){
       this.categoria.add(cat);
       return this.categoria.size();
    }
    
    /*
    public void agregarCategoria(String ct) {
        categoria.add(new Categoria(ct));
    }
    /*
    public int agregarCategoria(Categoria categoria){
       this.categoria.add(categoria);
       return this.categoria.size();
    }
    
     public int agragarCategoria(Categoria contenedorCategoria) {
        this.categoria.add(contenedorCategoria);
        return this.categoria.size();
    }
    */
  
    
}
