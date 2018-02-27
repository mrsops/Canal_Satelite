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
}
