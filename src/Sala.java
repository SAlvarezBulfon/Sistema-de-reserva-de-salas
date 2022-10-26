import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Sala {
    private String name;
    private ArrayList<Fecha> dates = new ArrayList<>();
    private String description;

    public Sala() {
    }

    public Sala(String name, ArrayList<Fecha> dates, String description) {
        this.name = name;
        this.dates = dates;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public ArrayList<Fecha> getDates() {
        return dates;
    }



//Métodos
    public void mostrarSala(){
        System.out.println("Nombre: " + getName() +
                            "\nDescripción: " + getDescription());
        System.out.println();
    }

    public void mostrarFechas(){
            for (int i = 0; i < dates.size(); i++) {
                System.out.println((i+1)+". " + dates.get(i).getFecha());
        }
    }
    public void mostrarHorarios(Fecha fecha){
        for (int i = 0; i < fecha.getHorarios().size(); i++) {
            System.out.println((i+1) + ". " + fecha.getHorarios().get(i));
        }
    }


}
