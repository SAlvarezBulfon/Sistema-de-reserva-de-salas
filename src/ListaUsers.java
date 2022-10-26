import java.util.ArrayList;
import java.util.Vector;

public class ListaUsers {
    //Lista de usuarios que vamos a crear
    private ArrayList<User> data = new ArrayList<>();

    public ListaUsers() {
    }

  public ListaUsers(ArrayList<User> data) {
        this.data = data;

    }


    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }
    public void displayData(){
        for (User e : data) {
            System.out.println(e.getNick() + " " + e.getPass());
        }
    }

    public boolean userExists(User user){
        boolean exist = false;
        for (User e : data) {
            if(e.getNick().equals(user.getNick()) && e.getPass().equals(user.getPass())){
                exist = true;
            }
        }
        return exist;
    }

    public boolean nickExists(User user){
        boolean exist = false;
        for (User e : data) {
            if(e.getNick().equals(user.getNick())){
                exist = true;
            }
        }
        return  exist;
    }

    public User obtenerUsuario(String nick){
        for (User e : data){
            if(e.getNick().equals(nick)){
                return e;
            }
        }
        return null;
    }


 public boolean yaReservado(User user){
        boolean reservado = false;
        for (int j  = 0; j < data.size(); j++){
            for (int i = 0; i < data.get(j).getFechaYHora().size(); i++){
                for (int k = 0; i < user.getFechaYHora().size(); k++){
                    if(data.get(j).getFechaYHora().get(i).equals(user.getFechaYHora().get(k))){
                        reservado = true;
                    }
                }
            }
        }
        return  reservado;
    }
}
