package by.issoft.store.xmlReader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLReaderTest {
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String RATE = "rate";
    private static final String DESCENDING = "desc";
    private static final String ASCENDING = "asc";

    private static final String DEFAULT_CONFIG_FILE = "config.xml";
    private static final String TEST_FILE_1 = "configFileTest1.xml";
    private static final String TEST_FILE_2 = "configFileTest2.xml";
    private static final String TEST_FILE_3 = "configFileTest3.xml";

    @AfterEach
    private void setDefaultConfigFile(){
        XMLReader.setConfigFile(DEFAULT_CONFIG_FILE);
    }

    @Test
    void getConfigFile() {
        assertEquals(DEFAULT_CONFIG_FILE, XMLReader.getConfigFile());
    }

    @Test
    void setConfigFile() {
        String newConfigFile = "new_config.xml";
        XMLReader.setConfigFile(newConfigFile);
        assertEquals(newConfigFile, XMLReader.getConfigFile());
    }

    @Test
    void getSortingRulesFromXML() {
        Map<String, String> sortingRules1 = new LinkedHashMap<>();
        sortingRules1.put(RATE, DESCENDING);
        sortingRules1.put(PRICE, ASCENDING);
        sortingRules1.put(NAME, DESCENDING);
        XMLReader.setConfigFile(TEST_FILE_1);
        assertEquals(sortingRules1, XMLReader.getSortingRulesFromXML());

        Map<String, String> sortingRules2 = new LinkedHashMap<>();
        sortingRules2.put(NAME, ASCENDING);
        sortingRules2.put(RATE, ASCENDING);
        sortingRules2.put(PRICE, ASCENDING);
        XMLReader.setConfigFile(TEST_FILE_2);
        assertEquals(sortingRules2, XMLReader.getSortingRulesFromXML());

        Map<String, String> sortingRules3 = new LinkedHashMap<>();
        sortingRules3.put(NAME, DESCENDING);
        sortingRules3.put(RATE, DESCENDING);
        XMLReader.setConfigFile(TEST_FILE_3);
        assertEquals(sortingRules3, XMLReader.getSortingRulesFromXML());
    }

    @Test
    void emptyMap_when_url_wrong() {
        Map<String, String> emptyMap = new LinkedHashMap<>();
        XMLReader.setConfigFile("Wrong config file");
        assertEquals(emptyMap, XMLReader.getSortingRulesFromXML());
    }
}