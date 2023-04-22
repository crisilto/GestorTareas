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
        System.out.println("Ingrese la descripci�n de la tarea:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese la fecha de vencimiento de la tarea:");
        String fechaVencimiento = sc.nextLine();
        System.out.println("Ingrese la prioridad de la tarea (alta/media/baja):");
        String prioridad = sc.nextLine();
        Tarea tarea = new Tarea(descripcion, fechaVencimiento, prioridad);
        tarea.setPrioridad(prioridad);
        tareas.add(tarea);
        System.out.println("Tarea agregada con �xito.");
    }

    public void marcarTareaComoCompletada() {
        System.out.println("Seleccione el �ndice de la tarea completada:");
        mostrarTareasPendientes();
        int indice = Integer.parseInt(sc.nextLine()) - 1;
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.setCompletada(true);
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("�ndice inv�lido. Intente nuevamente.");
        }
    }

    public void mostrarTareasPendientes() {
        System.out.println("Lista de tareas pendientes:");
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (!tarea.isCompletada()) {
                System.out.println((i + 1) + ". " + tarea.getDescripcion() + " - Fecha de vencimiento: "
                        + tarea.getFechaVencimiento() + " - Prioridad: " + tarea.getPrioridad());
            }
        }
    }

    public void eliminarTareaCompletada() {
        System.out.println("Seleccione el �ndice de la tarea completada a eliminar:");
        mostrarTareasCompletadas();
        int indice = Integer.parseInt(sc.nextLine()) - 1;
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            if (tarea.isCompletada()) {
                tareas.remove(indice);
                System.out.println("Tarea eliminada con �xito.");
            } else {
                System.out.println("La tarea seleccionada no est� completada. Intente nuevamente.");
            }
        } else {
            System.out.println("�ndice inv�lido. Intente nuevamente.");
        }
    }

    public void mostrarTareasCompletadas() {
        System.out.println("Lista de tareas completadas:");
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (tarea.isCompletada()) {
                System.out.println((i + 1) + ". " + tarea.getDescripcion() + " - Fecha de vencimiento: "
                        + tarea.getFechaVencimiento() + " - Prioridad: " + tarea.getPrioridad());
            }
        }
    }

    public void editarTarea() {
        System.out.println("Seleccione la tarea que desea editar (ingrese el �ndice): ");
        mostrarTareasPendientes();
        int indice = sc.nextInt() - 1;
        sc.nextLine(); // Limpiar el buffer del scanner

        if (indice < 0 || indice >= tareas.size()) {
            System.out.println("El �ndice seleccionado no es v�lido.");
            return;
        }

        Tarea tarea = tareas.get(indice);

        System.out.println("Seleccione qu� desea editar:");
        System.out.println("1. Descripci�n");
        System.out.println("2. Fecha de vencimiento");
        System.out.println("3. Prioridad");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la nueva descripci�n:");
                String nuevaDescripcion = sc.nextLine();
                tarea.setDescripcion(nuevaDescripcion);
                System.out.println("Tarea editada correctamente.");
                break;
            case 2:
                System.out.println("Ingrese la nueva fecha de vencimiento:");
                String nuevaFechaVencimiento = sc.nextLine();
                tarea.setFechaVencimiento(nuevaFechaVencimiento);
                System.out.println("Tarea editada correctamente.");
                break;
            case 3:
                System.out.println("Ingrese la nueva prioridad:");
                String nuevaPrioridad = sc.nextLine();
                tarea.setPrioridad(nuevaPrioridad);
                System.out.println("Tarea editada correctamente.");
                break;
            default:
                System.out.println("Opci�n no v�lida.");
                break;
        }
    }

    private static class Tarea {

        private String descripcion;
        private String fechaVencimiento;
        private String prioridad;
        private boolean completada;

        public Tarea(String descripcion, String fechaVencimiento, String prioridad) {
            this.descripcion = descripcion;
            this.fechaVencimiento = fechaVencimiento;
            this.prioridad = prioridad;
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

        public String getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(String prioridad) {
            this.prioridad = prioridad;
        }

        public void setDescripcion(String nuevaDescripcion) {
            // L�gica para establecer la descripci�n
        }

        public void setFechaVencimiento(String nuevaFechaVencimiento) {
            // L�gica para establecer la fecha de vencimiento
        }

    }

    public static void main(String[] args) {
        GestorTareas GestionTareasApp1 = new GestorTareas();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("------- Gestor de Tareas -------");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea completada");
            System.out.println("4. Mostrar tareas pendientes");
            System.out.println("5. Mostrar tareas completadas");
            System.out.println("6. Editar tarea"); // Nueva opci�n para editar tarea
            System.out.println("7. Salir");
            System.out.println("==========================");
            System.out.println("Seleccione una opci�n:");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    GestionTareasApp1.agregarTarea();
                    break;
                case 2:
                    GestionTareasApp1.marcarTareaComoCompletada();
                    break;
                case 3:
                    GestionTareasApp1.eliminarTareaCompletada();
                    break;
                case 4:
                    GestionTareasApp1.mostrarTareasPendientes();
                    break;
                case 5:
                    GestionTareasApp1.mostrarTareasCompletadas();
                    break;
                case 6:
                    GestionTareasApp1.editarTarea(); // Llamar al m�todo para editar tarea
                    break;
                case 7:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opci�n inv�lida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 7);
        sc.close();
    }
}
