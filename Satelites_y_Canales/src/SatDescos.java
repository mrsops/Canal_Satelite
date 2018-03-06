import java.util.ArrayList;
import java.util.Calendar;

public class SatDescos {
    private Satelite sat;
    Calendar fechaAgregacion;

    public SatDescos(Calendar modificacion, Satelite sat) {
        modificacion = Calendar.getInstance();
        this.fechaAgregacion = modificacion;
        this.sat = sat;
    }

    public Satelite getSat() {
        return sat;
    }

    public void setSat(Satelite sat) {
        this.sat = sat;
    }

    public Calendar getFechaAgregacion() {
        return fechaAgregacion;
    }

    public void setFechaAgregacion(Calendar fechaAgregacion) {
        this.fechaAgregacion = fechaAgregacion;
    }
}
