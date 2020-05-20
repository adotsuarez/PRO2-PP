/*
 * Definicion de la clase Fecha
 */

package es.uvigo.esei.pro2.core;

/**
 *
 * @author Nani
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anho;

    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }
    
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        
        toret.append (getDia());
        toret.append ("/");
        toret.append (getMes());
        toret.append ("/");
        toret.append (getAnho());
        
        return toret.toString();
    }
        
    /* ---------------------------------------------------------- */
    // METODOS GESTCLINICA3
    
    public boolean esIgual ( Fecha fecha ){  // NO USADO
        return  ( ( this.getAnho() == fecha.getAnho() ) &&
                ( this.getMes() == fecha.getMes() ) &&
                ( this.getDia() == fecha.getDia() ) );       
    }
}
