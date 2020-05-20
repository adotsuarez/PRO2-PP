/*
 * Definicion de la clase Paciente
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
abstract public class Paciente extends Persona{   
    private String numHistorial; // Código de la historia médica 
    private Fecha fechaNacimiento;    // Fecha de nacimiento del paciente
  

    /** Crea un nuevo paciente, con sus datos: numero historial, nombre, 
     *  domicilio y fecha de nacimiento
     * @param numHistorial número del historial médico
     * @param nombre nombre completo del paciente
     * @param domicilio  el domicilio del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     */
    public Paciente( String nombre, String domicilio, String numHistorial,
                    Fecha fechaNacimiento)
    {
        super(nombre, domicilio);
        this.setNumHistorial( numHistorial );
        this.setFechaNacimiento(fechaNacimiento);
    }
    
    /** Devuelve el número del historial médico del paciente
     * @return el numHistorial del paciente, como String.
     */
    public String getNumHistorial()
    {
        return numHistorial;
    }

    /** Cambia el  número del historial médico del paciente
     * @param nH el numHistorial del paciente
     */
    public void setNumHistorial(String nH)
    {
        numHistorial = nH;
    }    

    /** Devuelve la fecha de nacimiento del paciente
     *  @return El valor como objeto Fecha
     **/
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    /** Cambia la fecha de nacimiento del paciente
     * @param Fecha El nuevo valor, como objeto Fecha
     */
    public void setFechaNacimiento(Fecha fechaNac) {
        this.fechaNacimiento = fechaNac;
    }

    @Override
    public String toString()
    {
        StringBuilder toret = new StringBuilder();
        
        toret.append(super.toString());
        toret.append(getNumHistorial()).append(" ; ");
        toret.append(getFechaNacimiento()).append(" ; ");
             
        return toret.toString();
    }
}

