

public class Main {

    private static final int COUNT_BAYER = 4;
    private static final int MAKE_CAR_BAYER = 100;

    public static void main(String[] args) throws Exception {
        Store store = new Store();


        BuyerThread buyerThread = new BuyerThread(store);
        buyerThread.start();
        Thread.sleep(MAKE_CAR_BAYER);


        DeveloperThread carDeveloperThread = new DeveloperThread(store);
        carDeveloperThread.setName("Производитель");
        carDeveloperThread.start();
    }
}