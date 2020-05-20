/*
 * Proyecto de Programación II.
 * Gestión de una clínica. 
 */
package es.uvigo.esei.pro2.ui;
/**
 *
 * @author nrufino
 */

public class Main {
    public static void main(String[] args) {

        /* Prueba de programacion:

            1. Implementa la clase Enfermero. Utiliza la clase StringBuilder para la implementación del método toString.

            2. Añade a la clase Clinica el ArrayList<T> para la gestión de los objetos de la clase Enfermero. Realiza
            los cambios oportunos para que el código se adapte al hecho de que no existe límite en el número de
            enfermeros, aunque se debe solicitar al usuario una estimación del número máximo de enfermeros.

            3. Añade y modifica el código necesario en las clases Ilc y Clinica para que funcionen correctamente todas
            las opciones del menú “GESTIÓN ENFERMEROS”. Ten en cuenta que no pueden existir dos enfermeros con el
            mismo número de identificación.

            4. Añade otra opción al menú “GESTIÓN ENFERMEROS” que liste para cada posible área médica, el nombre de
            todos los enfermeros que tienen asignada dicha área. Tienes que usar para ello un HashMap.

        ------------------------------------------------------

        !! Puedes consultar las modificaciones en GitHub:
        https://github.com/adotsuarez/PRO2-PP

         */

        new Ilc().ler();
    }
}