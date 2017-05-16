package framework;

/**
 * Created by nika.khaladkar on 06/05/2016.
 */
public class Utilities {

    public static void waitForSomeTime()
    {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
