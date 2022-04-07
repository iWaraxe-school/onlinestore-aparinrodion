package by.issoft.store.threadsCreatorUtil;

import by.issoft.domain.Product;
import by.issoft.store.Store;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadCreatorUtil {
    private final static Integer POOL_SIZE = 3;
    private final static Integer PERIOD_TIME = 2;
    private final ScheduledExecutorService delayExecutor;
    private final ScheduledExecutorService periodExecutor;
    private final Store store;
    private final Random random;
    private static ThreadCreatorUtil instance;

    private ThreadCreatorUtil(Store store) {
        periodExecutor = Executors.newSingleThreadScheduledExecutor();
        delayExecutor = Executors.newScheduledThreadPool(POOL_SIZE);
        this.store = store;
        random = new Random();
    }

    public static ThreadCreatorUtil getInstance(Store store) {
        if (instance == null) {
            instance = new ThreadCreatorUtil(store);
        }
        return instance;
    }

    public void createAddingProductThread(Product purchasedProduct) {
        int delay = random.nextInt(29) + 1;
        log.info(String.format("Adding product %s, delay: %d", purchasedProduct.getName(), delay));
        Runnable addProduct = () -> {
            store.addPurchasedItem(purchasedProduct);
            log.info("Added product " + purchasedProduct.getName());
        };
        delayExecutor.schedule(addProduct, delay, TimeUnit.SECONDS);
    }

    public void createClearingPurchasedGoodsThread() {
        Runnable purchasedGoodsCleared = () -> {
            log.info("Purchased goods size: " + store.getPurchasedGoods().size());
            Store.clearPurchasedGoods();
            log.info("Purchased goods cleared, size: " + store.getPurchasedGoods().size());
        };
        periodExecutor.scheduleAtFixedRate(purchasedGoodsCleared, PERIOD_TIME, PERIOD_TIME, TimeUnit.MINUTES);
    }
}
