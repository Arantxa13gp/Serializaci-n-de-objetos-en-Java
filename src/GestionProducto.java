import java.io.*;
import java.util.ArrayList;

public class GestionProducto {
    private ArrayList<Producto> GestionProductos = new ArrayList<>();

    public void agregaProducto(Producto producto) {
        GestionProductos.add(producto);
    }

    public void mostrarproducto() {
        for (int i = 0; i < GestionProductos.size(); i++) {
            System.out.println(GestionProductos.get(i));
        }
        // Otra forma de hacerlo es con el
        // GestionProductos.forEach(producto -> System.out.println(producto));
    }

    public void guardar(String archivo) {
        try (ObjectOutputStream pro = new ObjectOutputStream(new FileOutputStream(archivo))) {
            pro.writeObject(this.GestionProductos);
            System.out.println("Productos guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los productos: " + e.getMessage());
        }
    }

    public void cargar(String archivo){
        try(ObjectInputStream lee = new ObjectInputStream(new FileInputStream(archivo)))  {
            this.GestionProductos = (ArrayList<Producto>) lee.readObject();
            System.out.println("Productos cargados correctamente desde " + archivo);

        } catch (FileNotFoundException e) {
            System.err.println("Error al buscar el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al guardar los productos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error al buscar la Clase: " + e.getMessage());
        }
    }
}
