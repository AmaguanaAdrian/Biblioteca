/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class libro {
    private int idLibro;
    private String titulo;
    private String fechaPublicado;
    private String isbn;

    public libro() {
    }

    public libro(int idLibro, String titulo, String fechaPublicado, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicado = fechaPublicado;
        this.isbn = isbn;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaPublicado() {
        return fechaPublicado;
    }

    public void setFechaPublicado(String fechaPublicado) {
        this.fechaPublicado = fechaPublicado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
        public String imprimir() {
        return "-------DATOS DEL LIBRO-----------\n"
                + "ISBN:"+getIsbn()  + "\n"
                + "Título:" + getTitulo()+ "\n"
                + "Fecha Publicado:" + getFechaPublicado();
    }
  public class ISBNValidador {

    public static boolean isValidISBN(String isbn) {
        // Verifica si el ISBN tiene 10 o 13 dígitos
        if (isbn.length() != 10 && isbn.length() != 13) {
            return false;
        }
        // Calcula el dígito de control (International Standard Book Numbers) 
        // es un dígito adicional que se agrega al final del número ISBN para verificar su validez
        int sum = 0;
        for (int i = 0; i < isbn.length() - 1; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checkDigit = 10 - (sum % 10);

        // Compara el dígito de control con el último dígito del ISBN
        // Character.getNumericValue toma un carácter como argumento y devuelve su valor numérico.
        int lastDigit = Character.getNumericValue(isbn.charAt(isbn.length() - 1));
        return checkDigit == lastDigit;
    }
 }
}
