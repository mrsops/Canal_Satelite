import java.util.ArrayList;

public class GrupoSat {
    ArrayList<Satelite> satelites;
    ArrayList<Desco> descos;

    public GrupoSat() {
        this.satelites = new ArrayList<Satelite>();
        this.descos = new ArrayList<Desco>();
    }

    /**
     * Metodo para añadir un Satelite al programa
     * @param sat
     */
    public void anyadirSat(Satelite sat){
        this.satelites.add(sat);
        refrescar();
    }

    /**
     * Metodo para añadir un Descodificador al programa.
     * @param desc
     */
    public void anyadirDesco(Desco desc){
        this.descos.add(desc);
        refrescar();

    }

    /**
     * Metodo que refresca la informacion de los satelites a los que los descodificadores son capaces de acceder.
     */
    private void refrescar(){

        for (int i = 0; i <this.descos.size() ; i++) {
            for (int j = 0; j <this.descos.get(i).getEncriptacion().size() ; j++) {
                for (int k = 0; k <this.satelites.size() ; k++) {
                    if (this.descos.get(i).getEncriptacion().get(j).equals(this.satelites.get(k))){
                        this.descos.get(i).anyadirSat(this.satelites.get(k));
                    }
                }
            }
        }
    }
}
