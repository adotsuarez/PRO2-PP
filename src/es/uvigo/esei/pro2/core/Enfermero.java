/*
 * Definicion de la clase Medico
 */

package es.uvigo.esei.pro2.core;

/**
 *
 * @author Nani
 */

public class Enfermero extends Persona {
    public enum AreasMedicas {
        PEDIATRIA,
        UCI,
        URGENCIAS
    }

    private String numIdentificacion;   // Numero de identificacion del enfermero
    private Fecha fechaIncorporacion;   // Fecha de incorporacion del enfermero
    private AreasMedicas areaMedica;    // Area medica del enfermero


    /** Crea un nuevo enfermero, con sus datos:
     * @param nombre nombre completo del enfermero
     * @param domicilio el domicilio del enfermero
     * @param numIdentificacion el numero de indentificacion del enfermero
     * @param fechaIncorporacion la fecha de incorp. del enfermero
     * @param areaMedica el area medica del enfermero
     */
    public Enfermero(String nombre, String domicilio, String numIdentificacion, Fecha fechaIncorporacion, AreasMedicas areaMedica) {
        super(nombre, domicilio);
        this.numIdentificacion = numIdentificacion;
        this.fechaIncorporacion = fechaIncorporacion;
        this.areaMedica = areaMedica;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public Fecha getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Fecha fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public AreasMedicas getAreaMedica() {
        return areaMedica;
    }

    public void setAreaMedica(AreasMedicas areaMedica) {
        this.areaMedica = areaMedica;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; NUM. IDENT.: ").append(numIdentificacion).append('\'');
        sb.append("; FECHA INCORP.: ").append(fechaIncorporacion);
        sb.append("; AREA MEDICA: ").append(areaMedica.name());
        return sb.toString();
    }
}
