package gestortareas;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorTareas {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea() {
        System.out.println("Ingrese la descripción de la tarea:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese la fecha de vencimiento de la tarea:");
        String fechaVencimiento = sc.nextLine();
        System.out.println("Ingrese la prioridad de la tarea (alta/media/baja):"); // Nueva línea para solicitar la prioridad
        String prioridad = sc.nextLine(); // Nueva línea para leer la prioridad ingresada
        Tarea tarea = new Tarea(descripcion, fechaVencimiento, prioridad);
        tarea.setPrioridad(prioridad); // Nueva línea para establecer la prioridad de la tarea
        tareas.add(tarea);
        System.out.println("Tarea agregada con éxito.");
    }

    public void marcarTareaComoCompletada() {
        System.out.println("Seleccione el índice de la tarea completada:");
        mostrarTareasPendientes();
        int indice = Integer.parseInt(sc.nextLine()) - 1;
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.setCompletada(true);
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("Índice inválido. Intente nuevamente.");
        }
    }

    public void mostrarTareasPendientes() {
        System.out.println("Lista de tareas pendientes:");
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (!tarea.isCompletada()) {
                System.out.println((i + 1) + ". " + tarea.getDescripcion() + " - Fecha de vencimiento: "
                        + tarea.getFechaVencimiento() + " - Prioridad: " + tarea.getPrioridad()); // Nueva línea para mostrar la prioridad
            }
        }
    }

    public void eliminarTareaCompletada() {
        System.out.println("Seleccione el índice de la tarea completada a eliminar:");
        mostrarTareasCompletadas();
        int indice = Integer.parseInt(sc.nextLine()) - 1;
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            if (tarea.isCompletada()) {
                tareas.remove(indice);
                System.out.println("Tarea eliminada con éxito.");
            } else {
                System.out.println("La tarea seleccionada no está completada. Intente nuevamente.");
            }
        } else {
            System.out.println("Índice inválido. Intente nuevamente.");
        }
    }

    public void mostrarTareasCompletadas() {
        System.out.println("Lista de tareas completadas:");
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (tarea.isCompletada()) {
                System.out.println((i + 1) + ". " + tarea.getDescripcion() + " - Fecha de vencimiento: "
                        + tarea.getFechaVencimiento() + " - Prioridad: " + tarea.getPrioridad()); // Nueva línea para mostrar la prioridad
            }
        }
    }

    private static class Tarea {

        private String descripcion;
        private String fechaVencimiento;
        private boolean completada;

        public Tarea(String descripcion, String fechaVencimiento, String prioridad) {
            this.descripcion = descripcion;
            this.fechaVencimiento = fechaVencimiento;
            this.prioridad = prioridad; // Añadir la prioridad al constructor
            this.completada = false;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getFechaVencimiento() {
            return fechaVencimiento;
        }

        public boolean isCompletada() {
            return completada;
        }

        public void setCompletada(boolean completada) {
            this.completada = completada;
        }

        private String prioridad;

        public String getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(String prioridad) {
            this.prioridad = prioridad;
        }

    }

    public static void main(String[] args) {
        GestorTareas GestionTareasApp1 = new GestorTareas();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("------- Gestor de Tareas -------");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Ver lista de tareas pendientes");
            System.out.println("4. Eliminar tarea completada");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción:");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    GestionTareasApp1.agregarTarea();
                    break;
                case 2:
                    GestionTareasApp1.marcarTareaComoCompletada();
                    break;
                case 3:
                    GestionTareasApp1.mostrarTareasPendientes();
                    break;
                case 4:
                    GestionTareasApp1.eliminarTareaCompletada();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
        sc.close();
    }
}
