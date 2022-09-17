public class Main {

    private static final int COUNT_BAYER = 4;
    private static final int MAKE_CAR_BAYER = 45;

    public static void main(String[] args) throws Exception {
        //создаём склад
        Store store = new Store();

        //генерируем покупателей
        for (int i = 1; i <= COUNT_BAYER; i++) {
            BuyerThread carBuyerThread = new BuyerThread(store, i);
            System.out.println("Покупатель " + i + " зашел в автосалон");
            carBuyerThread.start();
            Thread.sleep(MAKE_CAR_BAYER);
        }

        DeveloperThread carDeveloperThread = new DeveloperThread(store);
        carDeveloperThread.setName("Производитель");
        carDeveloperThread.start();

    }
}