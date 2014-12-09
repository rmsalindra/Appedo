package com.softsmith.floodgates.tcpserver;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlOperations {

	 public static void main(String[] args) throws Throwable{
		 DocumentBuilderFactory mdbf = DocumentBuilderFactory.newInstance();
		 mdbf.setValidating(false);
		 DocumentBuilder mdb = mdbf.newDocumentBuilder();
		 Document mdoc = mdb.parse(new FileInputStream(new File("C:\\Appedo\\resource\\scenarios\\floodgates\\scenarios.xml"))); // source file path
		 
		 DocumentBuilderFactory mdbf1 = DocumentBuilderFactory.newInstance();
		 mdbf1.setValidating(false);
		 DocumentBuilder mdb1 = mdbf1.newDocumentBuilder();
		 Document mdoc1 = mdb1.parse(new FileInputStream(new File("C:\\Appedo\\resource\\scenarios\\floodgates\\temp\\scenarios.xml")));// uploaded file path
		 
		 NodeList mnode = mdoc.getElementsByTagName("scenarios");
		 NodeList mnode1 = mdoc1.getElementsByTagName("scenario");
		 
		 NodeList scenarios = mdoc.getChildNodes();
		 Node aNode = (Node) mnode.item(0);
		 
		 
		 Node bNode = (Node) mnode1.item(0);
		 Node en=bNode.cloneNode(true);
		 mdoc.adoptNode(en); 
		 Node appendnode = mdoc.getElementsByTagName("scenarios").item(0);
		 appendnode.appendChild(en);
		 
		 saveXmlDoc(mdoc, "C:\\Appedo\\resource\\scenarios\\floodgates\\scenarios.xml");
		 System.out.println("done");
		 
	}
public static  void saveXmlDoc(Document mdoc, String xmlfilePath)throws Throwable {
		
		try {
			// write the content into xml file
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 Transformer transformer = transformerFactory.newTransformer();
			 DOMSource source = new DOMSource(mdoc);
			 StreamResult result = new StreamResult(new File(xmlfilePath));
			 // Output to console for testing
			 // StreamResult result = new StreamResult(System.out);
			 transformer.transform(source, result);
			 System.out.println("File saved!");
		}catch(Throwable t)	{
			
			System.out.println("Exception in savexmldoc() "+t.getMessage());
			throw t;
		}
	}
}
