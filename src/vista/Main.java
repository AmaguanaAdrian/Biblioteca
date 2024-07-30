/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.LibroControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.libro;
/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        LibroControlador libroControlador = new LibroControlador();
        int op1; // Variable para la opción del usuario

        do {
            System.out.println("BIENVENIDO");
            System.out.println("""
                               Elija la opción que Usted requiera ejecutar:
                               1. Insertar libro
                               2. Mostrar lista de libros
                               3. Actualizar información de un libro
                               4. Eliminar libro
                               0. Salir""");

            op1 = es.nextInt();
            es.nextLine(); // Consumir la línea pendiente después de nextInt()

            if (op1 == 1) {
                // Insertar libro
                System.out.println("Ingrese el título del libro:");
                String titulo = es.nextLine();

                System.out.println("Ingrese la fecha de publicación (YYYY-MM-DD):");
                String fechaPublicado = es.nextLine();

                System.out.println("Ingrese el ISBN del libro:");
                String isbn = es.nextLine();

                libro nuevoLibro = new libro(0, titulo, fechaPublicado, isbn);
                libroControlador.crearLibro(nuevoLibro);

            } else if (op1 == 2) {
                // Mostrar lista de libros
                ArrayList<libro> listaLibros = libroControlador.listarLibros();
                for (libro l : listaLibros) {
                    System.out.println(l.imprimir());
                }

            } else if (op1 == 3) {
                // Actualizar información de un libro
                System.out.println("Ingrese el ISBN del libro que desea actualizar:");
                String isbn = es.nextLine();

                libro libroExistente = libroControlador.buscarDatosLibro(isbn);
                if (libroExistente.getIdLibro() != 0) {
                    System.out.println("Ingrese el nuevo título del libro:");
                    String nuevoTitulo = es.nextLine();

                    System.out.println("Ingrese la nueva fecha de publicación (YYYY-MM-DD):");
                    String nuevaFechaPublicado = es.nextLine();

                    libro actualizadoLibro = new libro(libroExistente.getIdLibro(), nuevoTitulo, nuevaFechaPublicado, isbn);
                    libroControlador.actualizarLibro(actualizadoLibro, isbn);
                } else {
                    System.out.println("Libro no encontrado.");
                }

            } else if (op1 == 4) {
                // Eliminar libro
                System.out.println("Ingrese el ISBN del libro que desea eliminar:");
                String isbn = es.nextLine();
                libroControlador.eliminarLibro(isbn);

            } else if (op1 == 0) {
                // Salir
                System.out.println("Saliendo...");

            } else {
                // Opción no válida
                System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
            }
        } while (op1 != 0);

        es.close(); // Cerrando el escáner
    }
}
