package by.issoft.store.xmlReader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLReader {
    private static String configFile = "config.xml";

    public static void setConfigFile(String configFile) {
        XMLReader.configFile = configFile;
    }

    public static String getConfigFile() {
        return configFile;
    }

    public static Map<String, String> getSortingRulesFromXML() {
        Map<String, String> sortingRules = new LinkedHashMap<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            URL url = XMLReader.class.getClassLoader().getResource(configFile);
            if (url == null) {
                return sortingRules;
            }
            Document document = documentBuilder.parse(url.getPath());
            Node root = document.getDocumentElement();
            NodeList elements = root.getChildNodes();
            for (int i = 0; i < elements.getLength(); i++) {
                Node element = elements.item(i);
                if (element.getNodeType() == Node.ELEMENT_NODE) {
                    sortingRules.put(element.getNodeName(), element.getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return sortingRules;
    }

}
