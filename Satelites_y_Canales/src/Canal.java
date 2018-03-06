import java.util.Random;

public class Canal {
    public static final int HD = 0;
    public static final int NORMAL = 1;
    private String nombre;
    private int id;
    private int calidad;

    public Canal(String nombre, int calidad) {
        this.nombre = nombre;
        this.calidad = calidad;
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        this.id = rnd.nextInt(1000)+100;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getCalidad() {
        return calidad;
    }

    public String verCalidad(){
        if (this.getCalidad()==0){
            return "HD";
        }else if(this.getCalidad()==1){
            return "NORMAL";
        }else {
            return null;
        }
    }
}
