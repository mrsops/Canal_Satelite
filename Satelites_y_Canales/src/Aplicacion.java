import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        String opcion;
        Scanner tc = new Scanner(System.in);

        menu();
        do{
            opcion = tc.nextLine();
            switch (opcion){
                case "1":


                    break;
                case "2":


                    break;
                case "3":



                    break;
                case "4":


                    break;
                case "0":



                    break;
                default:
                    break;
            }
        }while(!opcion.equals("0"));
    }

    public static void menu(){

        System.out.println("1. Agregar Satelite");
        System.out.println("2. Modificar Descos");
        System.out.println("3. Agregar Canales a un Satelite");
        System.out.println("0. Salir");
    }

    public static void menuCanales(){
        System.out.println("1. Seleccionar Satelite");
        System.out.println("2. Agregar Canal");
        System.out.println("3. Atras");
    }

    public static void menuDesco(){
        System.out.println("1. Nuevo Desco");
        System.out.println("2. Seleccionar Desco");
        System.out.println("3. Agregar codificacion a Desco");
        System.out.println("4. Atras");

    }
}
