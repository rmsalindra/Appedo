import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DOMEdit {

    public static void main(String[] args) throws Throwable{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc1 = db.parse(new FileInputStream(new File("C:\\Appedo\\resource\\scenarios\\floodgates\\temp\\scenarios.xml")));
        Document doc2 = db.parse(new FileInputStream(new File("C:\\Appedo\\resource\\scenarios\\floodgates\\temp\\scenarios.xml")));
        
        System.out.println("Before Copy...");
        prettyPrint(doc2);
        
        NodeList list = doc1.getElementsByTagName("scenario");
        
        Element element = (Element) list.item(0);
        
        Node copiedNode = doc2.importNode(element, true);
        
        doc2.getDocumentElement().appendChild(copiedNode);
        System.out.println("done");
        System.out.println("After Copy...");
        prettyPrint(doc2);
    }
    
    public static final void prettyPrint(Document xml) throws Exception {
    	
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); 
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }
}