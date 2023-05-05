/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exitosos_colaborativo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jorge
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private DateTimeFormatter GUION = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter BARRAS = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter FORMATO_GUION = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {

        if (nombre.length() <= 0 || apellidos.length() <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento); //Devolvera excepcion en caso de que la fecha no sea correcta y se propagará

        }

    }
   
        public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
        

    public Persona(String nombre, String apellidos) {

        if (nombre.length() <= 0 || apellidos.length() <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = null;

        }

    }
    
     public void setFechaNacimiento(String fechaNacimiento)throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private LocalDate generarFecha(String fechaNacimiento) { //Funcion creada para devolver un dato correcto y en LocalDate
        LocalDate esFechaCorrecta = null;
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        String[] fechaSeparada = fechaNacimiento.split("[-/]");
        if (!fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")
                && !fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")) { //Compruebo que el formato de la fecha sea correcta
            throw new IllegalArgumentException();
        }
        try {
            dia = Integer.parseInt(fechaSeparada[0]);
            mes = Integer.parseInt(fechaSeparada[1]);
            anyo = Integer.parseInt(fechaSeparada[2]);
            return LocalDate.of(anyo, mes, dia); //Comprueba que la fecha es correcta ya que al crearlo si no es correcta salta excepcion

        } catch (DateTimeException ex) {
            throw new IllegalArgumentException();
        }

    }

    public int getEdadEnFecha(String cadenaFecha) throws IllegalArgumentException {

        int edad = -1;

        LocalDate fechaIntro = generarFecha(cadenaFecha);
        Period periodo;

        if (this.fechaNacimiento != null && (this.fechaNacimiento.isBefore(fechaIntro) || this.fechaNacimiento.isEqual(fechaIntro))) {

            periodo = Period.between(this.fechaNacimiento, fechaIntro);
            edad = periodo.getYears();

        }

        return edad;
    }

    public int getEdad() { //Faltan comentarios
   
        return 1+1;
    }
    
}

