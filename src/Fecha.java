import java.util.ArrayList;
public class Fecha {
    private String fecha;
    private ArrayList<String> horarios = new ArrayList<>();


    public Fecha() {
    }

    public Fecha(String fecha, ArrayList<String> horarios) {
        this.fecha = fecha;
        this.horarios = horarios;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }



}
