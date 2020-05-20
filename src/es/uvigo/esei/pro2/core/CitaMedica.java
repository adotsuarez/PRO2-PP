/*
 * Definicion de la clase CitaMedica
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author Nani
 */
public class CitaMedica {
    private Paciente paciente;
    private Medico medico;
    private Fecha fechaCita;
    private Hora horaCita;

    /** Crea una nueva cita médica, con sus datos: paciente, medico,
     *  fecha y hora de la cita
     * @param paciente paciente 
     * @param medico médico
     * @param fechaCita  fecha de la cita médica
     * @param horacita hora de la cita médica
     */
    public CitaMedica(Paciente paciente, Medico medico, Fecha fechaCita, Hora horaCita) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

    /** Devuelve el paciente involucrado en la cita medica 
     * @return el paciente, como Paciente.
     */     
    public Paciente getPaciente() {
        return paciente;
    }
    
    /** Devuelve el medico involucrado en la cita medica 
     * @return el medico, como Medico.
     */    
    public Medico getMedico() {
        return medico;
    }

   /** Devuelve la fecha de la cita medica 
     * @return fechaCita, como Fecha.
     */ 
    public Fecha getFechaCita() {
        return fechaCita;
    }

   /** Devuelve la hora de la cita medica 
     * @return horaCita, como Hora.
     */     
    public Hora getHoraCita() {
        return horaCita;
    }
    
    /** Cambia el paciente involucrado en la cita médica
     * @param paciente el paciente
     */    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    /** Cambia el medico involucrado en la cita médica
     * @param medico el medico
     */  
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    /** Cambia la fecha de la cita médica
     * @param fechaCita la fecha
     */  
    public void setFechaCita(Fecha fechaCita) {
        this.fechaCita = fechaCita;
    }
    
    /** Cambia la hora de la cita médica
     * @param horaCita la Hora
     */ 
    public void setHoraCita(Hora horaCita) {
        this.horaCita = horaCita;
    }
    
    @Override
    public String toString()
    {
        StringBuilder toret = new StringBuilder();
        
        toret.append("La cita medica es:\n ")
             .append("\tPaciente: ").append(getPaciente())
             .append("\n\tMedico: ").append(getMedico())
             .append("\n\tFecha/Hora: ").append(getFechaCita())
             .append("/").append(getHoraCita());
             
        return toret.toString();
    } 
    
}
