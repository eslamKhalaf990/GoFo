import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static public void main(String [] args){
        int id = 0;
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1- Register Using Email and password\n2- Log In\n3- Exit");
            int choice;
            choice = in.nextInt();
            if (choice == 1){
                id++;
                System.out.println("1- Playground Owner Account\n2- Player Account");
                in = new Scanner(System.in);
                choice = in.nextInt();
                if (choice == 1){
                    System.out.println("Enter Name.");
                    in = new Scanner(System.in);
                    String name;
                    name = in.nextLine();
                    System.out.println("Enter Email.");
                    String email;
                    email = in.nextLine();
                    System.out.println("Enter Password.");
                    String password;
                    password = in.nextLine();
                    System.out.println("Enter location.");
                    String location;
                    location = in.nextLine();
                    System.out.println("Enter phone number.");
                    String phone;
                    phone = in.nextLine();
                    System.out.println("Create Your new eWallet.");
                    double balance;
                    in = new Scanner(System.in);
                    balance = in.nextDouble();
                    EWallet eWallet = new EWallet(balance);
                    PlaygroundOwner owner = new PlaygroundOwner(email, password, name, phone,
                            location, Integer.toString(id), eWallet);
                    Register register = new Register(owner);
                    System.out.println("1- Add playground\n2- Skip");
                    choice = in.nextInt();
                    if (choice == 1){
                        in = new Scanner(System.in);
                        System.out.println("How many Playgrounds you would like to add.");
                        int numberOfPlaygrounds;
                        numberOfPlaygrounds = in.nextInt();
                        for(int i=0; i<numberOfPlaygrounds; i++){
                            in = new Scanner(System.in);
                            System.out.println("Enter Name Of Your Playground.");
                            String nameOfPlayground;
                            nameOfPlayground = in.nextLine();
                            System.out.println("Enter Location Of Your Playground.");
                            String locationOfPlayground;
                            locationOfPlayground = in.nextLine();
                            System.out.println("How Many Hours you would like to add?");
                            int numberOfHoursAvailable;
                            in = new Scanner(System.in);
                            numberOfHoursAvailable = in.nextInt();
                            System.out.println("what is its price per hour?");
                            int pricePerHour;
                            in = new Scanner(System.in);
                            pricePerHour = in.nextInt();
                            ArrayList <Integer> availableHours = new ArrayList<>();
                            for (int j=0; j<numberOfHoursAvailable; j++){
                                int hour;
                                System.out.print("hour number "+j + 1+": ");
                                hour = in.nextInt();
                                availableHours.add(hour);
                            }
                            Playground playground = new Playground(email,nameOfPlayground,
                                    locationOfPlayground, availableHours, pricePerHour);
                            owner.addPlayground(playground);
                        }
                    }
                }
                else if (choice == 2){
                    System.out.println("Enter Name.");
                    in = new Scanner(System.in);
                    String name;
                    name = in.nextLine();
                    System.out.println("Enter Email.");
                    String email;
                    email = in.nextLine();
                    System.out.println("Enter Password.");
                    String password;
                    password = in.nextLine();
                    System.out.println("Enter location.");
                    String location;
                    location = in.nextLine();
                    System.out.println("Enter phone number.");
                    String phone;
                    phone = in.nextLine();
                    System.out.println("Create Your new eWallet.");
                    double balance;
                    in = new Scanner(System.in);
                    balance = in.nextDouble();
                    EWallet eWallet = new EWallet(balance);
                    Player player = new Player(email, password, name, phone,
                            location, Integer.toString(id), eWallet);
                    Register register = new Register(player);

                }
            }
            else if (choice == 2){
                in = new Scanner(System.in);
                System.out.print("Enter Email.");
                String email;
                email = in.nextLine();
                System.out.print("Enter Password.");
                String password;
                password = in.nextLine();
                LogIn logIn = new LogIn(email, password);
                if (logIn.isPlayerAccount()){
                    boolean stop = false;
                    while (!stop){
                        System.out.println(
                                "1- book A Playground\n"+
                                "2- Show Money\n" +
                                "3- Show Booked Playgrounds\n"+
                                "4- continue"
                        );
                        in = new Scanner(System.in);
                        choice = in.nextInt();
                        if (choice == 1){
                            System.out.print(PlaygroundOwner.getPlaygroundList());
                            System.out.println("Which playground do you want to book?" +
                                    "(choose the number (index) of the playground)");
                            int playground;
                            playground = in.nextInt();
                            System.out.println("How many hours do you want to book?");
                            int numberOfHours;
                            numberOfHours = in.nextInt();
                            for (int i=0; i<numberOfHours; i++){
                                System.out.println("What hour you want to book?");
                                int hour = in.nextInt();
                                if(logIn.getPlayer().bookAPlayground(hour, playground, logIn.getPlayer().eWallet,
                                        PlaygroundOwner.getPlaygroundList(playground).getOwner())){
                                    System.out.println("Done");
                                }
                                else {
                                    System.out.println("You Don't Have Enough balance on your eWallet!");
                                }
                            }
                        }
                        else if (choice == 2){
                            System.out.println(logIn.getPlayer().getEWallet());
                        }
                        else if (choice == 3){
                            System.out.println(logIn.getPlayer().getBooked());
                        }
                        else {
                            stop = true;
                        }
                    }
                }
                else if (logIn.isPlaygroundAccount()){
                    boolean stop = false;
                    while (!stop){
                        System.out.println("" +
                                "1- Add playground\n" +
                                "2-show money\n" +
                                "3- show your playgrounds\n" +
                                "4- continue"
                        );
                        in = new Scanner(System.in);
                        int option;
                        option = in.nextInt();
                        if (option == 1){
                            in = new Scanner(System.in);
                            System.out.println("How many Playgrounds you would like to add.");
                            int numberOfPlaygrounds;
                            numberOfPlaygrounds = in.nextInt();
                            for(int i=0; i<numberOfPlaygrounds; i++){
                                in = new Scanner(System.in);
                                System.out.println("Enter Name Of Your Playground.");
                                String nameOfPlayground;
                                nameOfPlayground = in.nextLine();
                                System.out.println("Enter Location Of Your Playground.");
                                String locationOfPlayground;
                                locationOfPlayground = in.nextLine();
                                System.out.println("How Many Hours you would like to add?");
                                int numberOfHoursAvailable;
                                in = new Scanner(System.in);
                                numberOfHoursAvailable = in.nextInt();
                                System.out.println("what is its price per hour?");
                                int pricePerHour;
                                in = new Scanner(System.in);
                                pricePerHour = in.nextInt();
                                ArrayList <Integer> availableHours = new ArrayList<Integer>();
                                for (int j=0; j<numberOfHoursAvailable; j++){
                                    int hour;
                                    System.out.print("hour number "+j+1+": ");
                                    hour = in.nextInt();
                                    availableHours.add(hour);
                                }
                                Playground playground = new Playground(email,nameOfPlayground,
                                        locationOfPlayground, availableHours, pricePerHour);
                                logIn.getPlaygroundOwner().addPlayground(playground);
                            }
                        }
                        else if (option == 2){
                            System.out.println(logIn.getPlaygroundOwner().eWallet.toString());
                        }
                        else if (option == 3){
                            System.out.println(logIn.getPlaygroundOwner().viewHisPlaygroundList());
                        }
                        else {
                            stop = true;
                        }

                    }
                }
            }
            else {
                break;
            }
        }


    }
}
