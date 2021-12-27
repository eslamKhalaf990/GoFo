import java.util.ArrayList;

public class Router implements Runnable{
    private final semaphore sema;

    public Router() {
        sema = new semaphore(Network.n);
    }

    public void connect(){

        for (int i = 0; i < Network.devicesList.size(); i++) {
            Thread t = new Thread(this, Network.devicesList.get(i).getName());
            t.start();
        }

    }


    @Override
    public void run() {
        try {


            String name = Thread.currentThread().getName();
            sema.reserve();

            String outF1 = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " Arrived";
            System.out.println(outF1);
            Thread.sleep(1000);

            String outF2 = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " Log in";
            System.out.println(outF2);
            Thread.sleep(1000);

            String outF3 = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " Occupied";
            System.out.println(outF3);
            Thread.sleep(1000);

            String outF4 = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " Performs online activity";
            System.out.println(outF4);
            Thread.sleep(1000);

            String outF5 = "- Connection " + Network.connectionNumber(name, 1) + ": "
                    + Thread.currentThread().getName() + " Logged Out";
            System.out.println(outF5);

            sema.release();

            Thread.currentThread().stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
