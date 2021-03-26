package com.company.myapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tarea tarea = new Tarea("Colgar ropa","omar",Estado.EN_PROCESO);


        System.out.println("Las tareas: ");
        Casa casa = new Casa();
        //casa.agregarTarea(tarea);

        System.out.println("Las tareas de pablo: ");
        casa.mostrarTareaPorResponsable("pablo");
        System.out.println("Tareas pendientes de pablo:");
        casa.mostrarTareasPendientesPorResponsable("pablo");

        System.out.println("\n\n\tVamos a cambiar el estado de una tarea.\n\n");
        System.out.println("Estas son las tareas:");
        casa.listarTareas();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresá el ID de la tarea que querés cambiar: ");
        int idACambiar = Integer.parseInt(sc.nextLine());
        System.out.println("Ingresá el nro de estado que querés asignarle: ");
        System.out.println("0: PENDIENTE, 1: CANCELADA, 2: FINALIZADA, 3: EN PROCESO;");
        int idEstado = Integer.parseInt(sc.nextLine());
        casa.cambiarEstadoDeTarea(idACambiar, idEstado);
        System.out.println("Las tareas son: ");
        casa.listarTareas();
    }
}
