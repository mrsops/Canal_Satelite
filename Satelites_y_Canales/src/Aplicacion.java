import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        String opcion;
        Scanner tc = new Scanner(System.in);
        String nombre, codificacion, marca, modelo, calidad;
        Gestor gestor = new Gestor();
        Satelite sat;
        Desco descoActivo=null;
        Satelite satActivo = null;
        Desco decodificador;
        int puntero;
        Canal canal;
        limpiar();
        System.out.print("Introduce el nombre del Gestor: ");
        gestor.setNombre(tc.nextLine());
        limpiar();
        menu();
        do{
            menu();
            opcion = tc.nextLine();
            switch (opcion){
                case "1": //AGREGAR SATELITE
                    do {
                        menuSat();
                        opcion = tc.nextLine();
                        switch (opcion){
                            case "1": //SELECCIONAR SATELITE
                                limpiar();
                                gestor.muestraSat();
                                System.out.print("Introduce el numero del Satelite: ");
                                puntero = tc.nextInt();
                                if (puntero<gestor.getSatelites().size() && puntero>=0 ){
                                    satActivo = gestor.getSatelites().get(puntero);
                                }else{
                                    System.out.println("No existe ese satelite");
                                }
                                break;
                            case "2": //AGREGAR SATELITE
                                limpiar();
                                System.out.print("Introduce el nombre del Satelite: ");
                                nombre = tc.nextLine();
                                System.out.print("Introduce el formato de encriptación del satelite: ");
                                codificacion = tc.nextLine();
                                sat = new Satelite(codificacion,nombre);
                                gestor.anyadirSat(sat);
                                limpiar();

                            case "3": //ELIMINAR SATELITE
                                if (satActivo!=null){
                                    gestor.eliminaSatelite(satActivo);
                                    satActivo=null;
                                }else {
                                    System.out.println("Debes seleccionar un satelite.");
                                }

                                break;

                            case "4": //ATRAS
                                limpiar();
                                satActivo=null;
                                break;
                                default:
                                    System.out.println("Opcion Incorrecta");
                                    break;
                        }
                    }while (!opcion.equals("4"));
                    break;
                case "2": //MENU DESCOS
                    limpiar();
                    do {
                        menuDesco();
                        opcion = tc.nextLine();
                        switch (opcion) {
                            case "1": //Agregar Nuevo Desco
                                limpiar();
                                System.out.print("Introduce marca: ");
                                marca = tc.nextLine();
                                System.out.print("Introduce modelo: ");
                                modelo = tc.nextLine();
                                decodificador = new Desco(marca, modelo);
                                gestor.anyadirDesco(decodificador);
                                limpiar();
                                break;
                            case "2": //Seleccionar Desco
                                limpiar();
                                System.out.println(gestor.muestraDescos());
                                System.out.print("Introduce el numero de Desco: ");
                                puntero = tc.nextInt();
                                descoActivo = gestor.getDescos().get(puntero);
                                tc.nextLine();
                                limpiar();
                                break;
                            case "3": //Agregar codificacion a Desco seleccionado.
                                if (descoActivo!=null){
                                System.out.print("Introduce el formato de codificacion que soporta el desco: ");
                                codificacion = tc.nextLine();
                                    if(!descoActivo.anyadirCodificacion(codificacion)){
                                        limpiar();
                                        System.out.println("Imposible añadir la codificacion. Ya existe.");
                                    }else{
                                        gestor.refrescar();
                                        limpiar();
                                    }
                                }else {
                                    limpiar();
                                    System.out.println("No se ha seleccionado ningun desco.");
                                }
                                break;
                            case "4": // VER LISTA DE SATELITES ACCESIBLES POR DESCO
                                limpiar();
                                if (descoActivo!=null){
                                    System.out.println(descoActivo.verSatelites());
                                }else{
                                    System.out.println("No se ha seleccionado ningun desco.");
                                }

                                break;

                            case "5":
                                if (descoActivo!=null){
                                    gestor.eliminaDesco(descoActivo);
                                    descoActivo=null;
                                }
                                limpiar();

                                break;

                            case "6": //SALIR
                                descoActivo = null;
                                limpiar();
                                break;
                                default:
                                    limpiar();
                                    System.out.printf("Opcion incorrecta.");
                                    menuDesco();
                        }
                    }while(!opcion.equals("6"));
                    break;
                case "3": //ACCEDEMOS AL MENU DE LOS CANALES
                    limpiar();
                    do{
                        menuCanales();
                        opcion = tc.nextLine();
                        switch (opcion){
                            case "1": // SELECCIONAR SATELITE
                                limpiar();
                                System.out.println(gestor.muestraSat());
                                System.out.print("Introduce el numero del satelite: ");
                                puntero = tc.nextInt();
                                tc.nextLine();
                                satActivo = gestor.getSatelites().get(puntero);
                                limpiar();
                                break;
                            case "2": //AGREGAR CANAL
                                limpiar();
                                if (satActivo!=null) {
                                    System.out.print("Introduce el nombre del Canal: ");
                                    nombre = tc.nextLine();
                                    if (!satActivo.canalExiste(nombre)) {
                                        System.out.print("Introduce la calidad del canal (0.HD  1.Normal): ");
                                        calidad = tc.nextLine();
                                        if (calidad.equals("HD") || calidad.equals("hd") || calidad.equals("0")) {
                                            canal = new Canal(nombre, Canal.HD);
                                            satActivo.anyadirCanal(canal);
                                            limpiar();
                                        } else if (calidad.equals("normal") || calidad.equals("normal") || calidad.equals("1")) {
                                            canal = new Canal(nombre, Canal.NORMAL);
                                            satActivo.anyadirCanal(canal);
                                            limpiar();
                                        } else {
                                            limpiar();
                                            System.out.println("Opcion Incorrecta\n");
                                        }
                                    }else{
                                        System.out.println("EL Canal ya existe.");
                                    }
                                }else{
                                    limpiar();
                                    System.out.println("No se ha seleccionado ningun Satelite\n");
                                }
                                break;
                            case "3":
                                if (satActivo!=null){
                                    limpiar();
                                    System.out.println(satActivo.visualizar());
                                }
                                break;

                            case "4": //ELIMINAR CANAL

                                if (satActivo!=null) {
                                    System.out.println(satActivo.verCanales());
                                    System.out.print("Selecciona un canal: ");
                                    puntero = tc.nextInt();
                                    tc.nextLine();
                                    if (puntero < satActivo.getCanales().size()&& puntero>=0){
                                        canal = satActivo.getCanales().get(puntero);
                                        satActivo.getCanales().remove(canal);
                                        limpiar();
                                    }else {
                                        System.out.println("Valor introducido no valido");
                                    }
                                }else {
                                    System.out.println("Selecciona primero un Satelite.");
                                }
                                break;
                            case "5": // ATRAS
                                limpiar();
                                satActivo = null;
                                descoActivo = null;
                                break;
                                default:
                                    limpiar();
                                    System.out.println("Opcion incorrecta.\n");
                                    break;
                        }
                    }while(!opcion.equals("5"));
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    menu();
                    break;
            }
        }while(!opcion.equals("0"));
    }

    public static void menu(){

        System.out.println("1. Agregar/Eliminar Satelite");
        System.out.println("2. Agregar/Eliminar Descos");
        System.out.println("3. Agregar Canales a un Satelite");
        System.out.println("0. Salir");
    }
    public static void menuSat(){
        System.out.println("1. Seleccionar Satelite");
        System.out.println("2. Agregar Satelite");
        System.out.println("3. Eliminar Satelite");
        System.out.println("4. Atras");

    }

    public static void menuCanales(){
        System.out.println("1. Seleccionar Satelite");
        System.out.println("2. Agregar Canal");
        System.out.println("3. Visualizar Canales del satelite");
        System.out.println("4. Eliminar canal");
        System.out.println("5. Atras");
    }

    public static void menuDesco(){
        System.out.println("1. Nuevo Desco");
        System.out.println("2. Seleccionar Desco");
        System.out.println("3. Agregar codificacion a Desco");
        System.out.println("4. Ver todos los satelites accesibles por Desco Seleccionado.");
        System.out.println("5. Eliminar desco.");
        System.out.println("6. Atras");

    }


    public static void limpiar(){
        for (int i = 0; i <50 ; i++) {
            System.out.println("");
        }
    }
}
