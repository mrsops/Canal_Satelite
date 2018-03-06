import java.util.ArrayList;
import java.util.Calendar;

public class Desco {
    private ArrayList<String> encriptacion;
    private String marca;
    private String modelo;
    private ArrayList<SatDescos> listaSatelites;

    public Desco(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.listaSatelites = new ArrayList<SatDescos>();
        this.encriptacion = new ArrayList<String>();
    }

    public Desco() {
    }

    /**
     * Metodo que devuelve la lista de formatos de encriptacion a los que el Desco es capaz de utilizar.
     * @return Retorna el Arraylist de Encriptacion
     */
    public ArrayList<String> getEncriptacion() {
        return encriptacion;
    }



    /**
     * Añade un Satelite a la lista de los posibles accesibles por este Desco, guardando la fecha en la que ha sido añadido a la lista.
     * @param sat Añadir nuevo satelite.
     */
    public boolean anyadirSat(Satelite sat){
        Calendar fechaAgregacion = Calendar.getInstance();
        SatDescos nuevo = new SatDescos(fechaAgregacion, sat);
        if (!existe(nuevo)){
            this.listaSatelites.add(nuevo);
            return true;
        }else {
            return false;
        }
    }

    public String verSatelites(){
        String cadena ="";
        cadena = "Marca: "+this.marca+" ";
        cadena += "Modelo: "+this.modelo+"\n";
        for (SatDescos sd:this.listaSatelites){
            cadena += "\tNombre Sat: "+sd.getSat().getNombre()+ "  Fecha Agregacion: "+sd.fechaAgregacion.get(Calendar.DAY_OF_MONTH)+"/"+sd.fechaAgregacion.get(Calendar.MONTH)+"/"+sd.fechaAgregacion.get(Calendar.YEAR)
                    +" "+sd.fechaAgregacion.get(Calendar.HOUR)+":"+sd.fechaAgregacion.get(Calendar.MINUTE)+"\n";
        }
        return cadena;
    }



    /**
     * Metodo que añade una codificacion a la lista de las soportadas por el desco, solo si no existe ya.
     * @param codificacion String con el contenido de la nueva codificacion a añadir
     */
    public boolean anyadirCodificacion(String codificacion){
        if (!codifExiste(codificacion)){
            this.encriptacion.add(codificacion);
            return true;
        }else {
            return false;
        }
    }

    private boolean codifExiste(String codificacion){
        for (int i = 0; i <this.encriptacion.size() ; i++) {
            if(codificacion.equals(this.encriptacion.get(i))){
                return true;
            }
        }
        return false;
    }


    private boolean existe(SatDescos sd){
        for (int i = 0; i <listaSatelites.size() ; i++) {
            if (this.listaSatelites.get(i).getSat().getNombre().equals(sd.getSat().getNombre())){
                return true;
            }
        }
        return false;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
