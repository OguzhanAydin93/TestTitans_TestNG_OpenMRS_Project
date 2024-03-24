package Utility;

public class MyFunc {

    public static void bekle(int sn){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
