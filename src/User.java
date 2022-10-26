import java.util.ArrayList;
import java.util.Vector;

public class User {
    private String nick;
    private String pass;

    private ArrayList<Sala> salasReservadas = new ArrayList<>();
    private  ArrayList<FechaYHora> fechaYHora = new ArrayList<>();
    public User() {
    }

    public User(String nick, String pass) {
        this.nick = nick;
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Sala> getSalasReservadas() {
        return salasReservadas;
    }

    public void setSalasReservadas(ArrayList<Sala> salasReservadas) {
        this.salasReservadas = salasReservadas;
    }

//Getter y setter de la fecha junto con la hora

    public void setFechaYHora(ArrayList<FechaYHora> fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public ArrayList<FechaYHora> getFechaYHora() {
        return fechaYHora;
    }

    public void addFechaYHora(FechaYHora fecha){
        getFechaYHora().add(fecha);
    }


    public void mostrarSalasReservas(){
                for (int i = 0; i < salasReservadas.size(); i++) {
                    System.out.println("Nombre: " + salasReservadas.get(i).getName());
                    System.out.println("Descripción: " + salasReservadas.get(i).getDescription());
                    System.out.println("Hora: " + getFechaYHora().get(i).getHora());
                    System.out.println("Fecha: " + getFechaYHora().get(i).getFecha());
                    System.out.println();
                }

    }



}
