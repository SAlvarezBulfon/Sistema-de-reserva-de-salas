public class FechaYHora {
    private String fecha;
    private  String hora;

    public FechaYHora() {
    }

    public FechaYHora(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public boolean equals(Object obj){
        FechaYHora fyh = (FechaYHora) obj;

        if(fyh.getFecha().equals(this.fecha) && fyh.getHora().equals(this.hora)){
            return true;
        }
        return false;
    }
}
