import java.util.ArrayList;

public class Desco {
    private ArrayList<String> encriptacion;
    private String marca;
    private String modelo;
    private ArrayList<Satelite> listaSatelites;

    public Desco(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.listaSatelites = new ArrayList<Satelite>();
    }

    public Desco() {
    }

    /**
     * Metodo que devuelve la lista de formatos de encriptacion a los que el Desco es capaz de utilizar.
     * @return
     */
    public ArrayList<String> getEncriptacion() {
        return encriptacion;
    }


    /**
     * Añade un Satelite a la lista de los posibles accesibles por este Desco.
     * @param sat
     */
    public void anyadirSat(Satelite sat){
        if (noEsta(sat)){
            this.listaSatelites.add(sat);
        }
    }

    private boolean noEsta(Satelite sat){
        for (int i = 0; i <listaSatelites.size() ; i++) {
            if (this.listaSatelites.get(i).getId()==sat.getId()){
                return false;
            }
        }
        return true;
    }
}
