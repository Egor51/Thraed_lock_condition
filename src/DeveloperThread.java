public class DeveloperThread extends Thread {

    private static final long MAKE_CAR_DEVELOP = 100;
    private static final int COUNT_CAR = 6;

    private Store store;


    DeveloperThread(Store store) {

        this.store = store;
    }

    public void run() {
        for (int i = 1; i < COUNT_CAR; i++) {
            store.put();
            try {
                Thread.sleep(MAKE_CAR_DEVELOP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}