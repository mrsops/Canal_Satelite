import java.util.ArrayList;

public class Gestor {
    private String nombre;
    private ArrayList<Satelite> satelites;
    private ArrayList<Desco> descos;


    public Gestor() {
        this.satelites = new ArrayList<Satelite>();
        this.descos = new ArrayList<Desco>();
    }

    public Gestor(String nombre){
        this.nombre = nombre;
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
    public void refrescar(){

        for (int i = 0; i <this.descos.size() ; i++) {
            for (int j = 0; j <this.descos.get(i).getEncriptacion().size() ; j++) {
                for (int k = 0; k <this.satelites.size() ; k++) {
                    if (this.descos.get(i).getEncriptacion().get(j).equals(this.satelites.get(k).getEncriptacion())){
                       this.descos.get(i).anyadirSat(this.satelites.get(k));
                    }
                }
            }
        }
    }



    public String muestraSat(){
        String cadena="";
        for (int i = 0; i <satelites.size() ; i++) {
            cadena+="Num: "+i+" Nombre: "+satelites.get(i).getNombre()+" ID: "+satelites.get(i).getId()+"\n";
        }
        return cadena;
    }

    public String muestraDescos(){
        String cadena="";
        for (int i = 0; i <this.descos.size() ; i++) {
            cadena+="Num: "+i+" Marca: "+descos.get(i).getMarca()+" Modelo: "+descos.get(i).getModelo()+"\n";
        }
        return cadena;
    }

    public void eliminaSatelite(Satelite s){
        this.getSatelites().remove(s);
    }

    public void eliminaDesco(Desco d){
        this.getDescos().remove(d);
    }


    public ArrayList<Satelite> getSatelites() {
        return satelites;
    }


    public ArrayList<Desco> getDescos() {
        return descos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
