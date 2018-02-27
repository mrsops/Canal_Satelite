import java.util.ArrayList;

public class Satelite {
    private ArrayList<Canal> canales;
    private int encriptacion;
    private String nombre;
    private int id;

    public Satelite(int encriptacion, String nombre, int id) {
        this.encriptacion = encriptacion;
        this.nombre = nombre;
        this.id = id;
        this.canales = new ArrayList<Canal>();
    }
}
