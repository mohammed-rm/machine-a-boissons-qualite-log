package launcher;
public class Run {

    public static void main(String[] args){
        System.out.println("Hello world");
        ConnectionDB dbManager = new ConnectionDB("Boissons.db");
        dbManager.createBoissonsTables();
        dbManager.fillBoissonsTables();
    }
}