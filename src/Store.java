import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    private static final int SIZE_CAR_SHOP = 4;
    private int product = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    public void get(int buyer) {
        try {
            lock.lock();
            while (product < 1) {
                System.out.println("Машин нет");
                condition.await();
            }
            product--;
            System.out.println("Покупатель "  + buyer + " уехал на новеньком авто");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void put() {
        try {
            lock.lock();
            while (product == SIZE_CAR_SHOP) {
                condition.wait();
            }

            product++;
            System.out.println("Производитель Toyota выпустил 1 авто");
            System.out.println("Машин на складе: " + product);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}