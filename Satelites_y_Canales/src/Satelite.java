import java.util.ArrayList;
import java.util.Random;

public class Satelite {
    private ArrayList<Canal> canales;
    private String encriptacion;
    private String nombre;
    private int id;

    /**
     *
     * @param encriptacion Formato de encriptacion que utiliza el satelite para transmitir sus canales
     * @param nombre Nombre del Satelite.
     */
    public Satelite(String encriptacion, String nombre) {
        this.encriptacion = encriptacion;
        this.nombre = nombre;
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        this.id = rnd.nextInt(9000) + 1000;
        this.canales = new ArrayList<Canal>();
    }

    /**
     * Metodo que devuelve el formato de encriptacion del Satelite.
     * @return
     */
    public String getEncriptacion() {
        return encriptacion;
    }

    /**
     * Metodo que devuelve el nombre del Satelite
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devuvelve el ID del Satelite.
     * Este ID Ha sido generado aleatoriamente con su creacion.
     * @return
     */
    public int getId() {
        return id;
    }

    public void anyadirCanal(Canal c){
        String nom = c.getNombre();
        int calidad = c.getCalidad();

        if (!idCanalExiste(c)){
            this.canales.add(c);
        }else{
            c = new Canal(nom, calidad);
            anyadirCanal(c);
        }
    }

    public String visualizar(){
        String cadena="";
        cadena += "Nombre: "+this.nombre+"  ID: "+this.id+"\n";
        for (Canal c:this.canales) {
            cadena+="\tCanal: "+c.getNombre()+"  Calidad "+c.verCalidad()+"\n";
        }
        return cadena;
    }

    public String verCanales(){
        String cadena="";
        for (int i = 0; i <this.canales.size() ; i++) {
            cadena+="Nº "+i+"  Nombre: "+this.canales.get(i).getNombre();
        }
        return cadena;
    }



    private boolean idCanalExiste(Canal c){
        int numCanal = c.getId();
        for (int i = 0; i <this.canales.size() ; i++) {
            if (this.canales.get(i).getId()==numCanal){
                return true;
            }

        }
        return false;
    }

    public void eliminaCanal(Canal c){

    }

    public ArrayList<Canal> getCanales() {
        return canales;
    }

    public boolean canalExiste(String nombre){
        for (Canal c:this.canales) {
            if (c.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

}
