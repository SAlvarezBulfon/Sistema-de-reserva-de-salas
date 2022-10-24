import java.util.ArrayList;
import java.util.Vector;

public class User {
    private String nick;
    private String pass;

    private ArrayList<Sala> salasReservadas = new ArrayList<>();
    private ArrayList <String> fechaReservada = new ArrayList<>();
    private ArrayList <String> horaReservada = new ArrayList<>();
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


    public void setFechaReservada(ArrayList<String> fechaReservada) {
        this.fechaReservada = fechaReservada;
    }

    public ArrayList<String> getHoraReservada() {
        return horaReservada;
    }

    public void setHoraReservada(ArrayList<String> horaReservada) {
        this.horaReservada = horaReservada;
    }

    public ArrayList<Sala> getSalasReservadas() {
        return salasReservadas;
    }

    public void setSalasReservadas(ArrayList<Sala> salasReservadas) {
        this.salasReservadas = salasReservadas;
    }

    public void addFechaReservada(String fecha){
        fechaReservada.add(fecha);
    }

    public void mostrarSalasReservas(){
                System.out.println();
                for (int i = 0; i < salasReservadas.size(); i++) {
                    System.out.println("Nombre: " + salasReservadas.get(i).getName());
                    System.out.println("Descripción: " + salasReservadas.get(i).getDescription());
                    System.out.println("Hora: " + horaReservada.get(i));
                    System.out.println("Fecha:" + fechaReservada.get(i));
                }

    }


}
