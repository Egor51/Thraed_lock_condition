public class BuyerThread extends Thread {

    private final int idBayer;

    private Store store;

    BuyerThread(Store store, int idBayer) {
        this.store = store;
        this.idBayer = idBayer;
    }

    public void run() {
        store.get(idBayer);
    }
}