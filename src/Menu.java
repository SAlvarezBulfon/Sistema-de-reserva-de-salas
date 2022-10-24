import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String args[]) {
        //GENERAMOS LAS SALAS Y SUS RESPECTIVOS HORARIOS

        //Le agregamos los horarios disponibles
        ArrayList<String> horariosIndividual = new ArrayList<>();
        {
            horariosIndividual.add("9:00 AM");
            horariosIndividual.add("10:00 AM");
            horariosIndividual.add("11:00 AM");
            horariosIndividual.add("12:00 PM");
        }
        ArrayList<String> horariosDoble = new ArrayList<>();
        {
            horariosDoble.add("8:00 AM");
            horariosDoble.add("12:00 PM");
            horariosDoble.add("13:00 PM");
            horariosDoble.add("18:00 PM");
        }
        ArrayList<String> horariosTriple = new ArrayList<>();
        {
            horariosTriple.add("6:00 AM");
            horariosTriple.add("14:00 PM");
            horariosTriple.add("16:00 PM");
            horariosTriple.add("20:00 PM");
        }
        ArrayList<String> horarioKing = new ArrayList<>();
        {
            horarioKing.add("18:00 PM");
            horarioKing.add("20:00 PM");
            horarioKing.add("22:00 PM");
            horarioKing.add("00:00 AM");
        }
        //Generamos las fechas disponibles
        ArrayList<String> fechas = new ArrayList<>();
        {
            fechas.add("25 de Octubre");
            fechas.add("02 de Noviembre");
            fechas.add("10 de Noviembre");
            fechas.add("17 de Noviembre");
            fechas.add("21 de Noviembre");
            fechas.add("01 de Diciembre");
        }
        //Generamos los objetos de las salas
        Sala Individual = new Sala("Habitación individual", fechas, "Una habitación asignada a una persona. Puede tener una o más camas.", horariosIndividual);
        Sala Doble = new Sala("Habitación doble", fechas, "Una habitación asignada a dos personas. Puede tener una o más camas.", horariosDoble);
        Sala Triple = new Sala("Habitación triple", fechas, "Una habitación asignada a tres personas. Puede tener dos o más camas.", horariosTriple);
        Sala King = new Sala("Habitación King", fechas, "Una habitación con una cama king-size. Puede ser ocupado por una o más personas.", horarioKing);

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
                                                    usuarios.obtenerUsuario(nickTemp).getSalasReservadas().add(Individual);
                                                    Individual.mostrarSala();
                                                    int fechaIndi;
                                                    boolean atrasIndi = false;
                                                    do{
                                                        Individual.mostrarFechas();
                                                        System.out.println("7. Atrás");
                                                        fechaIndi = sc.nextInt();
                                                        switch (fechaIndi){
                                                            case 1:
                                                                usuarios.obtenerUsuario(nickTemp).addFechaReservada(Individual.getDates().get(0));
                                                                int horaInd;
                                                                boolean atrasHoraInd = false;
                                                                do {
                                                                    Individual.mostrarHorarios();
                                                                    System.out.println("5. Atrás");
                                                                    horaInd = sc.nextInt();
                                                                    switch (horaInd){
                                                                        case 1:
                                                                            usuarios.obtenerUsuario(nickTemp).getHoraReservada().add(Individual.getHorarios().get(0));
                                                                            System.out.println("Reservó a las: " + Individual.getHorarios().get(0));
                                                                            Individual.getHorarios().remove(0);
                                                                            atrasIndi = true;
                                                                            break;
                                                                        case 2:
                                                                            usuarios.obtenerUsuario(nickTemp).getHoraReservada().add(Individual.getHorarios().get(1));
                                                                            System.out.println("Reservó a las: " + Individual.getHorarios().get(1));
                                                                            Individual.getHorarios().remove(1);
                                                                            atrasIndi = true;
                                                                            break;
                                                                        case 3:
                                                                            usuarios.obtenerUsuario(nickTemp).getHoraReservada().add(Individual.getHorarios().get(2));
                                                                            System.out.println("Reservó a las: " + Individual.getHorarios().get(2));
                                                                            Individual.getHorarios().remove(2);
                                                                            atrasIndi = true;
                                                                            break;
                                                                        case 4:
                                                                            usuarios.obtenerUsuario(nickTemp).getHoraReservada().add(Individual.getHorarios().get(3));
                                                                            System.out.println("Reservó a las: " + Individual.getHorarios().get(3));
                                                                            Individual.getHorarios().remove(3);
                                                                            atrasIndi = true;
                                                                            break;
                                                                        case 5:
                                                                            atrasHoraInd = true;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Solo números entre 1 y 5");
                                                                    }
                                                                }while (!atrasHoraInd);
                                                                break;
                                                            case 2:

                                                                break;
                                                            case 3:

                                                                break;
                                                            case 4:

                                                                break;
                                                            case 5:

                                                                break;
                                                            case 6:

                                                                break;
                                                            case 7:
                                                                atrasIndi = true;
                                                                break;
                                                            default:
                                                                System.out.println("Solo números entre 1 y 7");
                                                        }
                                                    }while(!atrasIndi);
                                                    break;
                                                case 2:
                                                    Doble.mostrarSala();
                                                    break;
                                                case 3:
                                                    Triple.mostrarSala();
                                                    break;
                                                case 4:
                                                    King.mostrarSala();
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

                        if (usuarios.userExists(userR)) {
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
