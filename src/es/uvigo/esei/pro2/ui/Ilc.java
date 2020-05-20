package es.uvigo.esei.pro2.ui;

import es.uvigo.esei.pro2.core.Asegurado;
import es.uvigo.esei.pro2.core.CitaMedica;
import es.uvigo.esei.pro2.core.Clinica;
import es.uvigo.esei.pro2.core.Fecha;
import es.uvigo.esei.pro2.core.Hora;
import es.uvigo.esei.pro2.core.Medico;
import es.uvigo.esei.pro2.core.Paciente;
import es.uvigo.esei.pro2.core.Persona;
import es.uvigo.esei.pro2.core.Privado;
import java.util.List;

import java.util.Scanner;

/**
 * Interfaz de lin. de comando
 */
public class Ilc {

    /* EXCEPCIONES */
    public static class IlcException extends Exception {

        public IlcException(String msg) {
            super(msg);
        }
    }

    public static class FaltanElementosException extends IlcException {

        public FaltanElementosException(String msg) {
            super(msg);
        }

    }

    /* ------------------------------------------------------------------ */
 /* GESTION DE LOS MENUS */
    /**
     * Realiza el reparto de la funcionalidad ler = lee, evalua, repite
     */
    public void ler() {
        int opcionPri = 0;

        // Prepara
        Clinica coleccion = crearClinica();

        // Bucle ppal
        do {
            try {
                System.out.println("\nGestión de una clínica hospitalaria");

                opcionPri = menuPrincipal(coleccion);

                switch (opcionPri) {
                    case 1:
                        gestionPacientes(coleccion);
                        break;
                    case 2:
                        gestionMedicos(coleccion);
                        break;
                    case 3:
                        gestionCitas(coleccion);
                        break;
                }
            } catch (NumberFormatException exc) {
                System.err.println("\nError. Formato numÃ©rico invÃ¡lido.");
            } catch (Exception e) {
                System.err.println("\nERROR inesperado: " + e.getMessage());
            }
        } while (opcionPri != 4);

    }

    /**
     * Muestra las distintas opciones para gestionar los pacientes y lanza los
     * métodos que realiza cada operación
     *
     * @param coleccion La clinica sobre la que actua
     */
    private void gestionPacientes(Clinica coleccion) throws Exception {
        int opcionSec = 0;
        char c;
        do {
            try {
                opcionSec = menuGestionPacientes();

                switch (opcionSec) {
                    case 1:
                        insertaPaciente(coleccion);
                        break;
                    case 2:
                        modificaPaciente(coleccion);
                        break;
                    case 3:
                        eliminaPaciente(coleccion);
                        break;
                    case 4:
                        System.out.println(coleccion.toStringPacientes());
                        break;
                    case 5:
                        c = leeTipoPaciente();
                        System.out.println(coleccion.listarPorTipoPaciente(c));
                        break;
                }
            } catch (Clinica.ClinicaException e) {
                System.err.println("\nERROR: " + e.getMessage());
            }
        } while (opcionSec != 6);
    }

    /**
     * Muestra las distintas opciones para gestionar los médicos y lanza los
     * métodos que realiza cada operación
     *
     * @param coleccion La clinica sobre la que actua
     */
    private void gestionMedicos(Clinica coleccion) throws Exception {
        int opcionSec = 0;

        do {
            try {
                opcionSec = menuGestionMedicos();
                switch (opcionSec) {
                    case 1:
                        insertaMedico(coleccion);
                        break;
                    case 2:
                        modificaMedico(coleccion);
                        break;
                    case 3:
                        eliminaMedico(coleccion);
                        break;
                    case 4:
                        System.out.println(coleccion.toStringMedicos());
                        break;
                }
            } catch (Clinica.ClinicaException e) {
                System.err.println("\nERROR: " + e.getMessage());
            }
        } while (opcionSec != 5);
    }

    /**
     * Muestra las distintas opciones para gestionar las citas médicas y lanza
     * los métodos que realiza cada operación
     *
     * @param coleccion La clinica sobre la que actua
     */
    private void gestionCitas(Clinica coleccion) throws Exception {
        int opcionSec = 0;

        do {
            try {
                opcionSec = menuGestionCitas();
                switch (opcionSec) {
                    case 1:
                        insertaCita(coleccion);
                        break;
                    case 2:
                        modificaCita(coleccion);
                        break;
                    case 3:
                        eliminaCita(coleccion);
                        break;
                    case 4:
                        System.out.println(coleccion.toStringCitas());
                        break;
                }
            } catch (Clinica.ClinicaException e) {
                System.err.println("\nERROR: " + e.getMessage());
            }
        } while (opcionSec != 5);
    }

    /* ------------------------------------------------------------------ */
 /* MENUS */
    /**
     * Presenta un menu principal con las opciones, y permite seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menuPrincipal(Clinica coleccion) {
        int toret;

        do {
            System.out.println("\n\tMENU GESTIÓN CLÍNICA HOSPITALARIA\n"
                    + "\n1. Gestión Pacientes "
                    + "\n2. Gestión Médicos "
                    + "\n3. Gestión Citas Médicas"
                    + "\n4. Salir\n");
            toret = leeNum("Selecciona: ");
        } while (toret < 1
                || toret > 4);

        System.out.println();
        return toret;
    }

    /**
     * Presenta un menu con las opciones para gestionar pacientes y permite
     * seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menuGestionPacientes() {
        int toret;

        do {
            System.out.println("\n\tGESTIÓN PACIENTES: "
                    + "\n1. Inserta un nuevo paciente\n"
                    + "2. Modifica un paciente\n"
                    + "3. Elimina un paciente\n"
                    + "4. Lista pacientes\n"
                    + "5. Lista pacientes por tipo\n"
                    + "6. Vuelve al menú principal\n");
            toret = leeNum("Selecciona: ");
        } while (toret < 1
                || toret > 6);

        System.out.println();
        return toret;
    }

    /**
     * Presenta un menu con las opciones para gestionar médicos y permite
     * seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menuGestionMedicos() {
        int toret;

        do {
            System.out.println("\n\tGESTIÓN MÉDICOS: "
                    + "\n1. Inserta un nuevo médico\n"
                    + "2. Modifica un médico\n"
                    + "3. Elimina un médico\n"
                    + "4. Lista médicos\n"
                    + "5. Vuelve al menú principal\n");
            toret = leeNum("Selecciona: ");
        } while (toret < 1
                || toret > 5);

        System.out.println();
        return toret;
    }

    /**
     * Presenta un menu con las opciones para gestionar citas médicas y permite
     * seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menuGestionCitas() {
        int toret;

        do {
            System.out.println("\n\tGESTION CITAS MEDICAS"
                    + "\n1. Inserta una nueva cita médica\n"
                    + "2. Modifica una cita médica\n"
                    + "3. Elimina una cita médica\n"
                    + "4. Lista citas medicas\n"                   
                    + "5. Vuelve al menú principal\n");
            toret = leeNum("Selecciona: ");
        } while (toret < 1
                || toret > 5);

        System.out.println();
        return toret;
    }

    /* ------------------------------------------------------------------ */
 /* OPCIONES DEL MENÚ GESTIÓN PACIENTES */
    /**
     * Crea un nuevo paciente y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el paciente.
     */
    private void insertaPaciente(Clinica coleccion) throws Clinica.ClinicaException {
        Fecha fechaNac = new Fecha(0, 0, 0);
        Paciente p = new Asegurado("", "", "", fechaNac, "", "");

        switch (leeTipoPaciente()) {
            case 'A':
                p = new Asegurado("", "", "", fechaNac, "", "");
                break;
            case 'P':
                p = new Privado("", "", "", fechaNac, "");
                break;
        }
        modificaPaciente(p, coleccion);
        coleccion.insertaPaciente(p);
    }

    /**
     * Modifica un paciente existente.
     *
     * @param coleccion La coleccion de la cual modificar un paciente.
     */
    private void modificaPaciente(Clinica coleccion) throws Clinica.ClinicaException {
        if (coleccion.getNumPacientes() > 0) {
            this.modificaPaciente(coleccion.getPaciente(leePosPaciente(coleccion)), coleccion);
        } else {
            System.out.println("La coleccion no contiene pacientes.");
        }
    }

    /**
     * Borra un paciente por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el paciente
     */
    private void eliminaPaciente(Clinica coleccion)
            throws Clinica.ClinicaException {
        if (coleccion.getNumPacientes() > 0) {
            coleccion.eliminaPaciente(leePosPaciente(coleccion));
        } else {
            System.out.println("La coleccion no contiene pacientes.");
        }
    }

    /* ================================== METODOS MODIFICA */
    /**
     * Obtiene los datos de un paciente.
     *
     * @param p El paciente a modificar.
     */
    private void modificaPaciente(Paciente p, Clinica coleccion)
            throws Clinica.ClinicaException {
        modificaPersona(p);
        modificaPacienteBasica(p, coleccion);
        if (p instanceof Asegurado) {
            Asegurado a = (Asegurado) p;
            modificaAsegurado(a);
        } else if (p instanceof Privado) {
            Privado pr = (Privado) p;
            modificaPrivado(pr);
        }
    }

    /**
     * Modifica los datos comunes a cualquier tipo de referencia de un paciente
     * o de un médico
     *
     * @param p La persona a modificar.
     */
    private void modificaPersona(Persona p) {
        String info;
        Scanner teclado = new Scanner(System.in);

        // Nombre
        System.out.print("Nombre ");
        if (p.getNombre().length() > 0) {
            System.out.print("[" + p.getNombre() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            p.setNombre(info);
        }

        // Domicilio
        System.out.print("Domicilio ");
        if (p.getDomicilio().length() > 0) {
            System.out.print("[" + p.getDomicilio() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            p.setDomicilio(info);
        }

    }

    /**
     * Modifica los datos comunes a cualquier tipo de referencia de un paciente.
     *
     * @param p El paciente a modificar.
     */
    private void modificaPacienteBasica(Paciente p, Clinica coleccion)
            throws Clinica.ClinicaException {
        String info;
        Scanner teclado = new Scanner(System.in);

        // Numero de historial
        System.out.print("Numero de historial del paciente ");
        if (p.getNumHistorial().length() > 0) {
            System.out.print("[" + p.getNumHistorial() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if ((info.length() != 0) && (coleccion.existeHistorial(info))) {
            throw new Clinica.ExistePacienteException("Existe un paciente"
                    + " con ese mismo numero de historial: " + info);
        }

        if (info.length() > 0) {
            p.setNumHistorial(info);
        }

        // Fecha de nacimiento del paciente 
        modificaFecha(p.getFechaNacimiento());
    }

    /**
     * Modifica los datos propios de un paciente privado.
     *
     * @param pr El paciente a modificar.
     */
    private void modificaPrivado(Privado pr) {
        String info;
        Scanner teclado = new Scanner(System.in);

        // Número Factura
        System.out.print("D.N.I.");
        if (pr.getDni().length() > 0) {
            System.out.print("[" + pr.getDni() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            pr.setDni(info);
        }
    }

    /**
     * Modifica los datos propios de un paciente asegurado por una compañia.
     *
     * @param p El paciente a modificar.
     */
    private void modificaAsegurado(Asegurado a) {
        String info;
        Scanner teclado = new Scanner(System.in);

        // Poliza
        System.out.print("Poliza");
        if (a.getPoliza().length() > 0) {
            System.out.print("[" + a.getPoliza() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setPoliza(info);
        }

        // Compañia
        System.out.print("Compañia");
        if (a.getCompanhia().length() > 0) {
            System.out.print("[" + a.getCompanhia() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setCompanhia(info);
        }
    }

    /**
     * Modifica los datos de una fecha (puede ser fecha nacimiento del paciente
     * o la fecha de la cita medica.
     *
     * @param f Fecha a modificar.
     */
    private void modificaFecha(Fecha f) {
        Scanner teclado = new Scanner(System.in);
        String info;

        // dia
        System.out.print("Dia");
        if (f.getDia() > 0) {
            System.out.print("[" + f.getDia() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            f.setDia(Integer.parseInt(info));
        }
        // mes
        System.out.print("Mes");
        if (f.getMes() > 0) {
            System.out.print("[" + f.getMes() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            f.setMes(Integer.parseInt(info));
        }
        // año
        System.out.print("Año");
        if (f.getAnho() > 0) {
            System.out.print("[" + f.getAnho() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            f.setAnho(Integer.parseInt(info));
        }
    }

    /**
     * Modifica los datos de la hora de la cita médica
     *
     * @param h Hora a modificar.
     */
    private void modificaHora(Hora h) {
        Scanner teclado = new Scanner(System.in);
        String info;

        // hora
        System.out.print("Hora");
        if (h.getHora() > 0) {
            System.out.print("[" + h.getHora() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            h.setHora(Integer.parseInt(info));
        }
        // minutos
        System.out.print("Minutos");
        if (h.getMinutos() > 0) {
            System.out.print("[" + h.getMinutos() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            h.setMinutos(Integer.parseInt(info));
        }
    }

    /* ------------------------------------------------------------------ */
 /* OPCIONES DEL MENÚ GESTIÓN MEDICOS */
    /**
     * Crea un nuevo médico y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el medico.
     */
    private void insertaMedico(Clinica coleccion) throws Clinica.ClinicaException {

        Medico m = new Medico("", "", "");

        modificaMedico(m, coleccion);
        coleccion.insertaMedico(m);
    }

    /**
     * Modifica un medico existente.
     *
     * @param coleccion La coleccion de la cual modificar un medico.
     */
    private void modificaMedico(Clinica coleccion)
            throws Clinica.ClinicaException {
        if (coleccion.getNumMedicos() > 0) {
            this.modificaMedico(coleccion.getMedico(leePosMedico(coleccion)), coleccion);
        } else {
            System.out.println("La coleccion no contiene medicos.");
        }
    }

    /**
     * Obtiene los datos de un medico.
     *
     * @param p El medico a modificar.
     */
    private void modificaMedico(Medico m, Clinica coleccion)
            throws Clinica.ExisteMedicoException {
        String info;
        Scanner teclado = new Scanner(System.in);

        modificaPersona(m);

        // Número colegiado
        System.out.print("Número de colegiado ");
        if (m.getNumColegiado().length() > 0) {
            System.out.print("[" + m.getNumColegiado() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if ((info.length() != 0) && (coleccion.existeNumeroColegiado(info))) {
            throw new Clinica.ExisteMedicoException("Existe un medico"
                    + " con ese mismo numero de colegiado: " + info);
        }

        if (info.length() > 0) {
            m.setNumColegiado(info);
        }
    }

    /**
     * Borra un medico por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el medico
     */
    private void eliminaMedico(Clinica coleccion)
            throws Clinica.ClinicaException {
        if (coleccion.getNumMedicos() > 0) {
            coleccion.eliminaMedico(leePosMedico(coleccion));
        } else {
            System.out.println("La coleccion no contiene médicos.");
        }
    }

    /* ------------------------------------------------------------------ */
 /* OPCIONES DEL MENÚ GESTIÓN CITAS MÉDICAS */
    /**
     * Crea una nueva cita médica y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta la cita medica.
     */
    private void insertaCita(Clinica coleccion)
            throws FaltanElementosException, Clinica.ClinicaException {
        Fecha fecha = new Fecha(0, 0, 0);
        Medico m = new Medico("", "", "");
        Paciente p = new Asegurado("", "", "", fecha, "", "");
        Hora hora = new Hora(0, 0);
        CitaMedica c = new CitaMedica(p, m, fecha, hora);

        if ((coleccion.getNumMedicos() == 0) || (coleccion.getNumPacientes() == 0)) {
            throw new FaltanElementosException("Faltan pacientes o medicos para elaborar una cita médica.");
        }
        modificaCita(c, coleccion);
        coleccion.insertaCita(c);
    }

    /**
     * Modifica una cita medica existente.
     *
     * @param coleccion La coleccion de la cual modificar una cita medica.
     */
    private void modificaCita(Clinica coleccion)
            throws Clinica.ClinicaException {
        if (coleccion.getNumCitas() > 0) {
            this.modificaCita(coleccion.getCita(leePosCita(coleccion)), coleccion);
        } else {
            System.out.println("La coleccion no contiene citas médicas.");
        }
    }

    /**
     * Obtiene los datos de una cita medica.
     *
     * @param c La cita medica a modificar.
     */
    private void modificaCita(CitaMedica c, Clinica coleccion) {
        Scanner entrada = new Scanner(System.in);
        String info;
        Medico m = c.getMedico();
        Paciente p = c.getPaciente();

        // Obtenemos el médico de la cita
        do {
            System.out.print("Introduce el numero de colegiado del médico ");
            if (c.getMedico().getNumColegiado().length() > 0) {
                System.out.print("[" + c.getMedico().getNumColegiado() + "]");
            }
            System.out.print(": ");
            info = entrada.nextLine().trim();
            if (info.length() > 0) {
                m = coleccion.existeMedico(info, m);
            }
        } while (m.equals(c.getMedico()) && (info.length() > 0));
        c.setMedico(m);

        do {	// Obtenemos el paciente de la cita
            System.out.print("Introduce el numero de historial del paciente ");
            if (c.getPaciente().getNumHistorial().length() > 0) {
                System.out.print("[" + c.getPaciente().getNumHistorial() + "]");
            }
            System.out.print(": ");
            info = entrada.nextLine().trim();
            if (info.length() > 0) {
                p = coleccion.existePaciente(info, p);
            }
        } while (p.equals(c.getPaciente()) && (info.length() > 0));
        c.setPaciente(p);

        // modificamos la fecha
        modificaFecha(c.getFechaCita());

        // modificamos la hora
        modificaHora(c.getHoraCita());
    }

    /**
     * Borra una cita medica por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina la cita médica
     */
    private void eliminaCita(Clinica coleccion) throws Clinica.ClinicaException {
        if (coleccion.getNumCitas() > 0) {
            coleccion.eliminaCita(leePosCita(coleccion));
        } else {
            System.out.println("La coleccion no contiene citas médicas.");
        }
    }

    /* ------------------------------------------------------------------ */
 /* METODOS FUNCIONES AUXILIARES */
    private Clinica crearClinica() {
        String nombre;
        int maxPac;
        int maxMed;
        int maxCitas;

        nombre = leeCadena("Introduce el nombre de la clinica: ");

        maxPac = leeNum("Introduce el numero máximo de pacientes: ");
        maxMed = leeNum("Introduce el numero máximo de medicos: ");
        maxCitas = leeNum("Introduce el numero máximo de citas médicas: ");

        return new Clinica(nombre, maxPac, maxMed, maxCitas);
    }

    /**
     * Lee del teclado la posición de un paciente en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición del paciente, como entero.
     */
    private int leePosPaciente(Clinica coleccion) {
        final int numPacientes = coleccion.getNumPacientes();
        int toret;

        do {
            toret = leeNum("Introduzca posición del paciente (1..." + numPacientes + "): ");
        } while (toret < 1
                || toret > numPacientes);

        return toret - 1;
    }

    /**
     * Lee del teclado la posición de un medico en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición del medico, como entero.
     */
    private int leePosMedico(Clinica coleccion) {
        final int numMedicos = coleccion.getNumMedicos();
        int toret;

        do {
            toret = leeNum("Introduzca posición del medico (1..."
                    + numMedicos + "): ");
        } while (toret < 1
                || toret > numMedicos);

        return toret - 1;
    }

    /**
     * Lee del teclado la posición de una cita médica en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición de la cita medica, como entero.
     */
    private int leePosCita(Clinica coleccion) {
        final int numCitas = coleccion.getNumCitas();
        int toret;

        do {
            toret = leeNum("Introduzca posición de la cita médica (1..."
                    + numCitas + "): ");
        } while (toret < 1
                || toret > numCitas);

        return toret - 1;
    }

    /**
     * Lee un caracter del teclado
     *
     * @param men Mensaje a visualizar
     * @return el caracter introducido por el usuario
     */
    private char leeCaracter(String men) {
        String cadena;

        cadena = leeCadena(men);

        return (cadena.charAt(0));
    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizap.
     * @return El num., como entero
     */
    private int leeNum(String msg) {
        boolean repite;
        int toret = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            repite = false;
            System.out.print(msg);

            try {
                toret = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException exc) {
                repite = true;
            }
        } while (repite);

        return toret;
    }

    /**
     * Lee una cadena del teclado
     *
     * @param men Mensaje a visualizar
     * @return la cadena introducid por el usuario
     */
    private String leeCadena(String men) {
        String cad;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print(men);
            cad = teclado.nextLine().trim();
        } while (cad.equals(""));

        return cad;
    }

    private char leeTipoPaciente() {
        char tipoPac;
        String cadena;
        
        do {
            cadena = leeCadena("Introduce tipo de paciente (A: Asegurado y P: Privado): ");
            tipoPac = cadena.toUpperCase().charAt(0);
        } while ((tipoPac != 'P') && (tipoPac != 'A'));

        return tipoPac;
    }

}