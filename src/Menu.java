import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String args[]) {
        //GENERAMOS LAS SALAS Y SUS RESPECTIVOS HORARIOS

        //Le agregamos los horarios disponibles
        ArrayList<String> horariosIndividual = new ArrayList<>();
        {
            horariosIndividual.add("9:00 AM");
            horariosIndividual.add("11:00 AM");
            horariosIndividual.add("12:00 PM");
        }
        ArrayList<String> horariosDoble = new ArrayList<>();
        {
            horariosDoble.add("8:00 AM");
            horariosDoble.add("13:00 PM");
            horariosDoble.add("18:00 PM");
        }
        ArrayList<String> horariosTriple = new ArrayList<>();
        {
            horariosTriple.add("14:00 PM");
            horariosTriple.add("16:00 PM");
            horariosTriple.add("20:00 PM");
        }
        ArrayList<String> horarioKing = new ArrayList<>();
        {
            horarioKing.add("20:00 PM");
            horarioKing.add("22:00 PM");
            horarioKing.add("00:00 AM");
        }
        //Generamos las fechas disponibles

        //Fechas con horarios para individual
        Fecha aInd = new Fecha("25 de Octubre", horariosIndividual);
        Fecha bInd = new Fecha("02 de Noviembre", horariosIndividual);
        Fecha cInd = new Fecha("10 de Noviembre", horariosIndividual);
        ArrayList<Fecha> fechasInd = new ArrayList<>();
        fechasInd.add(aInd);
        fechasInd.add(bInd);
        fechasInd.add(cInd);
        //Fechas con horarios Doble
        Fecha aD = new Fecha("27 de Octubre", horariosDoble);
        Fecha bD = new Fecha("01 de Noviembre", horariosDoble);
        Fecha cD = new Fecha("09 de Noviembre", horariosDoble);
        ArrayList<Fecha> fechasD = new ArrayList<>();
        fechasD.add(aD);
        fechasD.add(bD);
        fechasD.add(cD);
        //Fechas con horarios para Triple
        Fecha aT = new Fecha("23 de Octubre", horariosTriple);
        Fecha bT = new Fecha("01 de Noviembre", horariosTriple);
        Fecha cT = new Fecha("07 de Noviembre", horariosTriple);
        ArrayList<Fecha> fechasT = new ArrayList<>();
        fechasT.add(aT);
        fechasT.add(bT);
        fechasT.add(cT);
        //Fechas con horarios para Triple
        Fecha aK = new Fecha("24 de Octubre", horarioKing);
        Fecha bK = new Fecha("05 de Noviembre", horarioKing);
        Fecha cK = new Fecha("12 de Noviembre", horarioKing);
        ArrayList<Fecha> fechasK = new ArrayList<>();
        fechasK.add(aK);
        fechasK.add(bK);
        fechasK.add(cK);

        //Generamos los objetos de las salas
        Sala Individual = new Sala("Habitación individual", fechasInd, "Una habitación asignada a una persona. Puede tener una o más camas.");
        Sala Doble = new Sala("Habitación doble", fechasD, "Una habitación asignada a dos personas. Puede tener una o más camas.");
        Sala Triple = new Sala("Habitación triple", fechasT, "Una habitación asignada a tres personas. Puede tener dos o más camas.");
        Sala King = new Sala("Habitación King", fechasK, "Una habitación con una cama king-size. Puede ser ocupado por una o más personas.");

        boolean exit = false, exit2 = false;
        int option1;
        //Inicio de Sesión
        String passTemp, nickTemp;
        User Usertemp = new User();

        //Registro
        String passR, nickR;

        Scanner sc = new Scanner(System.in);
        ListaUsers usuarios = new ListaUsers();
        do {
            int tries = 1;
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Iniciar Sesión" +
                    "\n2. Registrarse" +
                    "\n3. Salir");
            option1 = sc.nextInt();

            switch (option1) {
                case 1:
                    System.out.println("--------Inicio de sesión--------");
                    do {
                        sc.nextLine();
                        System.out.println("Ingrese su nombre de usuario: ");
                        nickTemp = sc.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        passTemp = sc.nextLine();

                        Usertemp.setNick(nickTemp);
                        Usertemp.setPass(passTemp);

                        if (usuarios.userExists(Usertemp)) {
                            int option2;
                            boolean salida = false;
                            System.out.println("--------Login exitoso-------");
                            do {
                                System.out.println();
                                System.out.println("Ingrese una opción: ");
                                System.out.println("1. Reservar habitación" +
                                        "\n2. Ver habitaciones reservadas" +
                                        "\n3. Cerrar sesión");
                                option2 = sc.nextInt();
                                switch (option2) {
                                    case 1:
                                        System.out.println("----Reservar habitación----");
                                        boolean salida2 = false;
                                        int sala;
                                        do {
                                            System.out.println("¿Qué habitación le interesa ?");
                                            System.out.println("1. Individual" +
                                                    "\n2. Doble" +
                                                    "\n3. Triple" +
                                                    "\n4. King" +
                                                    "\n5. Volver");
                                            sala = sc.nextInt();

                                            switch (sala) {
                                                case 1:
                                                    String fechaInd, horaInd;
                                                    do{
                                                        int fecha;
                                                        System.out.println("Seleccione una fecha: ");
                                                        Individual.mostrarFechas();
                                                        fecha = sc.nextInt();
                                                        switch (fecha){
                                                            //FECHA 1
                                                            case 1:
                                                                fechaInd = Individual.getDates().get(0).getFecha();
                                                                int hora;
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    Individual.mostrarHorarios(aInd);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = aInd.getHorarios().get(0);
                                                                            {
                                                                                FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                                usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                                usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                                System.out.println("Reservó con éxito");
                                                                                aInd.getHorarios().remove(0);
                                                                                salida2 = true;
                                                                            }
                                                                            break;
                                                                            //HORA 2
                                                                        case 2:
                                                                            horaInd = aInd.getHorarios().get(1);
                                                                             {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                                 aInd.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                            }
                                                                             break;
                                                                            //HORA 3
                                                                        case 3:
                                                                            horaInd = aInd.getHorarios().get(3);

                                                                            {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            aInd.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                            }
                                                                            break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;
                                                            case 2:
                                                                fechaInd = Individual.getDates().get(1).getFecha();
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    Individual.mostrarHorarios(bInd);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = bInd.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            System.out.println("Reservó con éxito");
                                                                            bInd.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = bInd.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            bInd.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = bInd.getHorarios().get(2);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            bInd.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;
                                                            case 3:
                                                                fechaInd = Individual.getDates().get(2).getFecha();
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    Individual.mostrarHorarios(cInd);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = cInd.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            System.out.println("Reservó con éxito");
                                                                            cInd.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = cInd.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            cInd.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = cInd.getHorarios().get(2);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            cInd.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;

                                                                default:
                                                                System.out.println("Ingrese un número entre el 1 y el 3");
                                                        }
                                                    }while (!salida2);

                                                    break;
                                                case 2:
                                                    do{
                                                        int fecha;
                                                        System.out.println("Seleccione una fecha: ");
                                                        Doble.mostrarFechas();
                                                        fecha = sc.nextInt();
                                                        switch (fecha){
                                                            //FECHA 1
                                                            case 1:
                                                                fechaInd = Doble.getDates().get(0).getFecha();
                                                                int hora;
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    Doble.mostrarHorarios(aD);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = aD.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            System.out.println("Reservó con éxito");
                                                                            aD.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = aD.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            aD.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = aD.getHorarios().get(3);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            aD.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;
                                                            case 2:
                                                                fechaInd = Doble.getDates().get(1).getFecha();
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    Doble.mostrarHorarios(bD);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = bD.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            System.out.println("Reservó con éxito");
                                                                            bD.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = bD.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            bD.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = bD.getHorarios().get(2);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            bD.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;
                                                            case 3:
                                                                fechaInd = Doble.getDates().get(2).getFecha();
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    Doble.mostrarHorarios(cD);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = cD.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            System.out.println("Reservó con éxito");
                                                                            cD.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = cD.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            cD.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = cD.getHorarios().get(2);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Doble);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            cD.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;

                                                            default:
                                                                System.out.println("Ingrese un número entre el 1 y el 3");
                                                        }
                                                    }while (!salida2);

                                                    break;
                                                case 3:
                                                    do{
                                                    int fecha;
                                                    System.out.println("Seleccione una fecha: ");
                                                    Triple.mostrarFechas();
                                                    fecha = sc.nextInt();
                                                    switch (fecha){
                                                        //FECHA 1
                                                        case 1:
                                                            fechaInd = Triple.getDates().get(0).getFecha();
                                                            int hora;
                                                            do{
                                                                System.out.println("Seleccione una hora: ");
                                                                Triple.mostrarHorarios(aT);
                                                                System.out.println("9. Volver la inicio ");
                                                                hora = sc.nextInt();
                                                                switch (hora){
                                                                    //HORA 1
                                                                    case 1:
                                                                        horaInd = aT.getHorarios().get(0);
                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        System.out.println("Reservó con éxito");
                                                                        aT.getHorarios().remove(0);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    //HORA 2
                                                                    case 2:
                                                                        horaInd = aT.getHorarios().get(1);
                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        System.out.println("Reservó con éxito");
                                                                        aT.getHorarios().remove(1);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    //HORA 3
                                                                    case 3:
                                                                        horaInd = aT.getHorarios().get(3);

                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        System.out.println("Reservó con éxito");
                                                                        aT.getHorarios().remove(2);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    case 9:
                                                                        salida2 = true;
                                                                        break;
                                                                    default:
                                                                        System.out.println("Ingrese un número entre el 1 y el 3");
                                                                }
                                                            }while (!salida2);
                                                            break;
                                                        case 2:
                                                            fechaInd = Triple.getDates().get(1).getFecha();
                                                            do{
                                                                System.out.println("Seleccione una hora: ");
                                                                Triple.mostrarHorarios(bT);
                                                                System.out.println("9. Volver la inicio ");
                                                                hora = sc.nextInt();
                                                                switch (hora){
                                                                    //HORA 1
                                                                    case 1:
                                                                        horaInd = bT.getHorarios().get(0);
                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        System.out.println("Reservó con éxito");
                                                                        bT.getHorarios().remove(0);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    //HORA 2
                                                                    case 2:
                                                                        horaInd = bT.getHorarios().get(1);
                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        System.out.println("Reservó con éxito");
                                                                        bT.getHorarios().remove(1);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    //HORA 3
                                                                    case 3:
                                                                        horaInd = bT.getHorarios().get(2);

                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        System.out.println("Reservó con éxito");
                                                                        bT.getHorarios().remove(2);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    case 9:
                                                                        salida2 = true;
                                                                        break;
                                                                    default:
                                                                        System.out.println("Ingrese un número entre el 1 y el 3");
                                                                }
                                                            }while (!salida2);
                                                            break;
                                                        case 3:
                                                            fechaInd = Triple.getDates().get(2).getFecha();
                                                            do{
                                                                System.out.println("Seleccione una hora: ");
                                                                Triple.mostrarHorarios(cT);
                                                                System.out.println("9. Volver la inicio ");
                                                                hora = sc.nextInt();
                                                                switch (hora){
                                                                    //HORA 1
                                                                    case 1:
                                                                        horaInd = cT.getHorarios().get(0);
                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        System.out.println("Reservó con éxito");
                                                                        cT.getHorarios().remove(0);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    //HORA 2
                                                                    case 2:
                                                                        horaInd = cT.getHorarios().get(1);
                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        System.out.println("Reservó con éxito");
                                                                        cT.getHorarios().remove(1);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    //HORA 3
                                                                    case 3:
                                                                        horaInd = cT.getHorarios().get(2);

                                                                    {
                                                                        FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                        usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Triple);
                                                                        usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                        System.out.println("Reservó con éxito");
                                                                        cT.getHorarios().remove(2);
                                                                        salida2 = true;
                                                                    }
                                                                    break;
                                                                    case 9:
                                                                        salida2 = true;
                                                                        break;
                                                                    default:
                                                                        System.out.println("Ingrese un número entre el 1 y el 3");
                                                                }
                                                            }while (!salida2);
                                                            break;

                                                        default:
                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                    }
                                                }while (!salida2);
                                                    break;
                                                case 4:
                                                    do{
                                                        int fecha;
                                                        System.out.println("Seleccione una fecha: ");
                                                        King.mostrarFechas();
                                                        fecha = sc.nextInt();
                                                        switch (fecha){
                                                            //FECHA 1
                                                            case 1:
                                                                fechaInd = King.getDates().get(0).getFecha();
                                                                int hora;
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    King.mostrarHorarios(aK);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = aK.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            System.out.println("Reservó con éxito");
                                                                            aK.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = aK.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            aK.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = aK.getHorarios().get(3);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            aK.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;
                                                            case 2:
                                                                fechaInd = King.getDates().get(1).getFecha();
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    King.mostrarHorarios(bK);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = bK.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            System.out.println("Reservó con éxito");
                                                                            bK.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = bK.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            bK.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = bK.getHorarios().get(2);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            bK.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;
                                                            case 3:
                                                                fechaInd = King.getDates().get(2).getFecha();
                                                                do{
                                                                    System.out.println("Seleccione una hora: ");
                                                                    King.mostrarHorarios(cK);
                                                                    System.out.println("9. Volver la inicio ");
                                                                    hora = sc.nextInt();
                                                                    switch (hora){
                                                                        //HORA 1
                                                                        case 1:
                                                                            horaInd = cK.getHorarios().get(0);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd,horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            System.out.println("Reservó con éxito");
                                                                            cK.getHorarios().remove(0);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 2
                                                                        case 2:
                                                                            horaInd = cK.getHorarios().get(1);
                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            cK.getHorarios().remove(1);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        //HORA 3
                                                                        case 3:
                                                                            horaInd = cK.getHorarios().get(2);

                                                                        {
                                                                            FechaYHora fechaYhoraInd = new FechaYHora(fechaInd, horaInd);
                                                                            usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(King);
                                                                            usuarios.obtenerUsuario(nickTemp).addFechaYHora(fechaYhoraInd);
                                                                            System.out.println("Reservó con éxito");
                                                                            cK.getHorarios().remove(2);
                                                                            salida2 = true;
                                                                        }
                                                                        break;
                                                                        case 9:
                                                                            salida2 = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese un número entre el 1 y el 3");
                                                                    }
                                                                }while (!salida2);
                                                                break;

                                                            default:
                                                                System.out.println("Ingrese un número entre el 1 y el 3");
                                                        }
                                                    }while (!salida2);
                                                    break;
                                                case 5:
                                                    salida2 = true;
                                                    break;
                                                default:
                                                    System.out.println("Solo números entre 1 y 5");
                                            }
                                        } while (!salida2);
                                        break;
                                    case 2:
                                        System.out.println("-------HABITACIONES RESERVADAS-------");
                                        usuarios.obtenerUsuario(nickTemp).mostrarSalasReservas();
                                        break;
                                    case 3:
                                        salida = true;
                                        break;
                                    default:
                                        System.out.println("Solo números entre 1 y 3");
                                }
                            } while (!salida);
                            break;
                        } else {
                            System.out.println("Datos incorrectos");
                            System.out.println("Le quedan " + (5 - tries) + " intentos");
                            tries++;

                        }
                    } while (tries <= 5);
                    break;
                case 2:
                    System.out.println("---------Registro----------");
                    do {
                        sc.nextLine();
                        System.out.println("Ingrese un nombre de usuario: ");
                        nickR = sc.nextLine();
                        System.out.println("Ingrese una contraseña: ");
                        passR = sc.nextLine();
                        User userR = new User();
                        userR.setNick(nickR);
                        userR.setPass(passR);

                        if (usuarios.userExists(userR) || usuarios.nickExists(userR)) {
                            System.out.println("Ya existe un usuario con esos datos");
                        } else {
                            usuarios.getData().add(userR);
                            System.out.println("Registro Exitoso");
                            exit2 = true;
                        }
                    } while (!exit2);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");
            }
        } while (!exit);
    }
}
