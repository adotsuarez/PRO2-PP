/*
 * Definicion de la clase Privado
 */

package es.uvigo.esei.pro2.core;

/**
 * Paciente que asiste a la clínica de forma privada
 * Created by nanny on 8/03/2018.
 */
public class Privado extends Paciente {
    private String dni;
   
     /** Crea un nuevo paciente que va a la clínica por privado, 
     * con sus datos: numero historial, nombre, 
     * domicilio, fecha de nacimiento, numero factura e importe
     * @param numHistorial número del historial médico
     * @param nombre nombre completo del paciente
     * @param domicilio  el domicilio del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     * @param dni D.N.I del paciente para emitirle las facturas
     */
    public Privado( String nombre, String domicilio, String numHistorial,
            Fecha fechaNacimiento, String dni) {
        super( nombre, domicilio, numHistorial, fechaNacimiento);
        this.setDni(dni);
    }

    /** Devuelve el D.N.I. del paciente
     * @return el D.N.I. del paciente, como String.
     */ 
    public String getDni() {
        return dni;
    }

   /** Cambia el  D.N.I. del paciente
     * @param dni el  D.N.I. del paciente
     */     
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        
        toret.append("Paciente privado. ");
        toret.append(super.toString());
        toret.append(getDni()).append(" ; ");    
             
        return toret.toString();
    }
    
}
