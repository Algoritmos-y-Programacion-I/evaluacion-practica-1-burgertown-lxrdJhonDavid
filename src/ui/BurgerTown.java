package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a BurgerTown!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada plato vendido en el dia");
            System.out.println("2. Calcular la cantidad total de platos vendidos en el dia");
            System.out.println("3. Calcular el precio promedio de los platos vendidos en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de platos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de platos vendidos en el dia fue de: "+calcularTotalPlatosVendidos());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de los platos vendidos en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarPlatosSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = reader.nextInt();

        precios = new double[platos];
        unidades = new int[platos];

    }

    /**
     * Descripción: Solicita los precios y las cantidades de cada plato vendido y almacena los datos.
     * pre: Los arreglos precios y unidades deben estar inicializados.
     * pos: Los datos ingresados quedan almacenados en los arreglos.
     */
    public static void solicitarDatos(){
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Digite el precio del plato " + (i + 1) + ":");
            precios[i] = reader.nextDouble();
            System.out.println("Digite la cantidad vendida del plato " + (i + 1) + ":");
            unidades[i] = reader.nextInt();
        }
     
    }

    /**
     * Descripción: Calcula la cantidad total de platos vendidos.
     * pre: El arreglo unidades debe estar lleno.
     * pos: Retorna la cantidad total de platos vendidos.
     */
    public static int calcularTotalPlatosVendidos(){
        int total = 0;
        for (int unidad : unidades) {
            total += unidad;
        }
        return total;
    }

    /**
     * Descripción: Calcula el precio promedio de los platos vendidos.
     * pre: El arreglo precios debe estar lleno.
     * pos: Retorna el precio promedio de los platos vendidos.
     */
    public static double calcularPrecioPromedio(){
        double suma = 0;
        for (double precio : precios) {
            suma += precio;
        }
        return suma / precios.length;

    }

    /**
     * Descripción: Calcula las ventas totales del día.
     * pre: Los arreglos precios y unidades deben estar llenos.
     * pos: Retorna el total de dinero recaudado en el día.
     */
    public static double calcularVentasTotales(){
        double totalVentas = 0;
        for (int i = 0; i < precios.length; i++) {
            totalVentas += precios[i] * unidades[i];
        }
        return totalVentas;
    }

    /**
     * Descripción: Consulta cuántos platos superaron un límite mínimo de ventas.
     * pre: Los arreglos precios y unidades deben estar llenos.
     * pos: Retorna la cantidad de platos que superaron el límite.
     */
    public static int consultarPlatosSobreLimite(double limite){
        int contador = 0;
        for (int i = 0; i < precios.length; i++) {
            if (precios[i] * unidades[i] > limite) {
                contador++;
            }
        }
        return contador;

    }

}