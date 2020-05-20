/*
 * Definicion de la clase Hora
 */

package es.uvigo.esei.pro2.core;

/**
 *
 * @author Nani
 */
public class Hora {
    private int hora;
    private int minutos;

    /** Crea una nueva hora, con sus datos: hora y minutos
     * @param hora hora
     * @param minutos minutos
     */
    public Hora(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    /** Devuelve la hora 
     * @return la hora, como int.
     */ 
    public int getHora() {
        return hora;
    }
    
    /** Devuelve los minutosss
     * @return los minutos, como int.
     */ 
    public int getMinutos() {
        return minutos;
    }

   /** Cambia la hora
     * @param hora la hora
     */  
    public void setHora(int hora) {
        this.hora = hora;
    }
    
   /** Cambia los minutos
     * @param minutos los minutos
     */  
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    @Override
    public String toString()
    {
        StringBuilder toret = new StringBuilder();
        
        toret.append("(").append(getHora())
             .append(":").append(getMinutos())
             .append(")");
             
        return toret.toString();
    } 
    
}
