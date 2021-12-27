import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static ArrayList<Device> devicesList = new ArrayList<>();
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<Boolean> state = new ArrayList<>();
    static int n;
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the number of WI-FI Connections?");
        n = scanner.nextInt();
        System.out.println("What is the number of devices Clients want to connect?");
        int numDevices = scanner.nextInt();
        for(int i=0; i<numDevices;i++){
            Device device = new Device();

            String nameOfDevice = scanner.next();
            device.setName(nameOfDevice);

            String typeOfDevice = scanner.next();
            device.setType(typeOfDevice);

            devicesList.add(device);
        }
        for (int j = 0; j < n; j++) {
            names.add("");
            state.add(false);
        }
        Router router = new Router();
        router.connect();
    }
    public synchronized static int connectionNumber(String name, int x) {

        int connectionNum = 0;
        int flag = 0;

        if (x == 1) {
            for (int k = 0; k < n; k++) {
                if (names.get(k).equals(name)) {
                    names.set(k, "");
                    state.set(k, false);
                    connectionNum = k + 1;
                }
            }
        } else {

            for (int i = 0; i < n; i++) {

                if (name.equals(names.get(i))) {
                    connectionNum = i + 1;
                    flag++;
                }
            }
            if (flag == 0) {

                for (int j = 0; j < n; j++) {
                    if (!state.get(j)) {
                        state.set(j, true);
                        connectionNum = j + 1;
                        names.set(j, name);
                        break;
                    }
                }
            }
        }

        return connectionNum;
    }

}
