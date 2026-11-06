import java.io.Serializable;
import java.time.LocalDate;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private double precio;
    private boolean disponible;
    private LocalDate fechaAlta;
    private String categoria;
    private Object informacionExtra;
    private transient String informacionAdicional;

    public Producto(){
        id = 0;
        nombre = categoria = "";
        precio = 0.0;
        fechaAlta = null ;
      //  informacionExtra = new Garantia();
        informacionAdicional = "";
    }
    public Producto(int id, String nombre, double precio, boolean disponible, LocalDate fechaAlta, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.fechaAlta = fechaAlta;
        this.categoria = categoria;
        // this.informacionExtra = new Garantia();
        this.informacionAdicional = "";
    }

    public Producto(int id, String nombre, double precio, boolean disponible, LocalDate fechaAlta, String categoria, String informacionAdicional) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.fechaAlta = fechaAlta;
        this.categoria = categoria;
        // this.informacionExtra = new Garantia();
        this.informacionAdicional = informacionAdicional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String toString(){
        return "El producto cuyo ID es "  + id + " llamado " + nombre + " Vale un total de " + precio + "\n" +
                "Actualmente su disponibilidad es " + disponible + " sus fecha de alta es " + fechaAlta + " y su categoria es " + categoria;
    }

}

class Garantia {
    private int meses = 24;
}
