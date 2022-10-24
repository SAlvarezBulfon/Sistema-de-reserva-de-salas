import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Sala {
    private String name;
    private ArrayList<String> dates = new ArrayList<>();
    private String description;
    private ArrayList<String> horarios = new ArrayList<>();
    ;

    public Sala() {
    }

    public Sala(String name, ArrayList<String> dates, String description, ArrayList<String> horarios) {
        this.name = name;
        this.dates = dates;
        this.description = description;
        this.horarios = horarios;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }


    //Métodos
    public void mostrarHorarios(){
        for (int i = 0; i < horarios.size(); i++){
            System.out.println((i+1) + ". " + getHorarios().get(i));
        }
    }


    public void mostrarSala(){
        System.out.println("Nombre: " + getName() +
                            "\nDescripción: " + getDescription());
    }

    public void mostrarFechas(){
        for (int i = 0; i < dates.size(); i++) {
            System.out.println((i + 1) + ". " + getDates().get(i));
        }
    }

}
