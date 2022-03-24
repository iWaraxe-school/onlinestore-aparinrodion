package by.issoft.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomStorePopulatorTest {

    @Test
    void Fill_store() {
        Store store = Store.getInstance();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        randomStorePopulator.fillStore(store);
        assertFalse(store.getCategoryList().isEmpty());
    }
}