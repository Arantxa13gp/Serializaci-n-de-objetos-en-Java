import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;



public class main {
    /**
     * Ejercicio 5 de implementar un menu
     * @param args
     */
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        GestionProducto gp = new GestionProducto();
        String nombreArchivo = "productos.dat";
        int opcion = 0;


        do {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Guardar productos");
            System.out.println("4. Cargar productos");
            System.out.println("5. Cerrar el programa");

            System.out.print("Seleccione una opción: ");

            try {
                opcion = Scan.nextInt();
                Scan.nextLine();
                switch (opcion) {
                    case 1: //Añadir Producto
                        System.out.println("Ha escogido añadir productos: ");
                        System.out.print("ID: ");
                        int id = Scan.nextInt();
                        Scan.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = Scan.nextLine();

                        System.out.print("Precio: ");
                        double precio = Scan.nextDouble();
                        Scan.nextLine();

                        System.out.print("¿Disponible? (true/false): ");
                        boolean disponible = Scan.nextBoolean();
                        Scan.nextLine();

                        System.out.print("Categoría: ");
                        String categoria = Scan.nextLine();

                        System.out.print("Categoría: ");
                        String informacionAdicional = Scan.nextLine();

                        Producto p = new Producto(id, nombre, precio, disponible, LocalDate.now(), categoria);
                        gp.agregaProducto(p);
                        System.out.println("Producto añadido con éxito");
                        break;
                    case 2: // Mostrar Productos
                        System.out.println("Ha escogido mostrar productos");
                        gp.mostrarproducto();
                        break;

                    case 3: //Guardar productos
                        System.out.println("Ha escogido guardar productos");
                        gp.guardar(nombreArchivo);
                        break;

                    case 4: // Cargar Productos
                        System.out.println("Ha escogido cargar productos");
                        gp.cargar(nombreArchivo);
                        break;

                    case 5:
                        System.out.println("Ha escogido cerrar el programa");
                        break;

                    default:
                        System.err.println("La opcion escogida es erronea");
                }
            } catch (InputMismatchException e) {
                System.err.println("No has ingresado un dato correctamente.");
                Scan.nextLine();
            }
        } while (opcion != 5) ;
        Scan.close();
    }

}
/**
 * Ejercicio 3 Asegurarse de que funcione con lo que me dice los pasos
 */
/*
        String nombreArchivo = "!productos.dat";

        Producto p1 = new Producto (1,"Portatil", 299.99, true, LocalDate.now(), "Electronico");
        Producto p2 = new Producto (2,"PS5", 385.99, true, LocalDate.now(), "Entretenimiento");
        Producto p3 = new Producto (3,"Television", 89.99, true, LocalDate.now(), "Electronico");
        GestionProducto gp = new GestionProducto();
        gp.agregaProducto(p1);
        gp.agregaProducto(p2);
        gp.agregaProducto(p3);

        System.out.println("A continuacion mostraremos los productos guardados");
        gp.mostrarproducto();

        System.out.println("----------------------------------------------------------------");


        System.out.println("Guardaremos los productos en un archivo (productos.dat)");
        gp.guardar(nombreArchivo);

        GestionProducto gp2 = new GestionProducto();

        System.out.println("Aqui veremos que no hay nada en el gp2");
        gp2.mostrarproducto();
        System.out.println("----------------------------------------------------------------");

        System.out.println("Aqui cargaremos los productos del archivo en el gp2");
        gp2.cargar(nombreArchivo);

        System.out.println("----------------------------------------------------------------");

        System.out.println("Aqui veremos que los productos hay en el gp2");
        gp2.mostrarproducto();

   */

/**
 * Ejercicio 6:
 *
 * ¿Qué ocurre si añadimos a Producto una propiedad de tipo Object que contenga un objeto que no
 * implemente Serializable? Modifica el programa para comprobar qué ocurre al intentar guardar el
 * producto. Analiza la excepción obtenida y explica por qué se produce.
 *
 * He creado una clase en el producto que es garantia lo he establecido en los constructores
 * lo que pasa es que al crear un producto y luego cargarlo el producto da un error al no ser serializable
 * debido a que java ve que la garantia no es serializable forma un error.
 * - ¿Que ocurre cuando añadimos a una propiedad el modificador transient y serializamos y
 * deserializamos?
 * private transient String informacionAdicional;
 * Lo que ocurre es que el modificador transient ignora su inicializacion y al mostrar la lista se vera que no se ha visto afectada
 * por la serializacion
 */
