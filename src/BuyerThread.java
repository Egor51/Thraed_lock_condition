public class BuyerThread extends Thread {
    private Store store;

    BuyerThread(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Покупатель " +  i + " зашел в автосалон");
            int buyer = i;
            store.get(buyer);
        }
    }
}