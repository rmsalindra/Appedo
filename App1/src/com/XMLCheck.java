package com;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLCheck {

//	public static void main(String[] args) throws Exception {
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		dbf.setValidating(false);
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		//Document xmlDocument = db.parse(new FileInputStream(new File(strPath+prop.getProperty("Variablepath")+"variables.xml")));
//		Document xmlDocument = db.parse(new FileInputStream(new File("C:\\Appedo\\resource\\scenarios\\jmeter\\3_scenarios.xml")));
//		
//		XPath varxPath =  XPathFactory.newInstance().newXPath();
//		String expression = "/root/scenarios/scenario[@name='veeruscript_1']";
//		NodeList recfiletypeList = (NodeList) varxPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
//		System.out.println("size="+recfiletypeList.getLength());
//		
//		int mnum = recfiletypeList.getLength();
//		if(mnum>0){
//			Element mnode = (Element) recfiletypeList.item(0);
//			mnode.getParentNode().removeChild(mnode);
//			saveXmlDoc(xmlDocument, "C:\\Appedo\\resource\\scenarios\\jmeter\\3_scenarios.xml");
//			System.out.println(mnode.getNodeName());
//			//Element element = (Element) xmlDocument.getElementsByTagName("scenario").item(0);
//			 // remove the specific node
//			 //element.getParentNode().removeChild(element);
//		}
//		
//		 
//	}
	public static void saveXmlDoc(Document mdoc, String xmlfilePath){
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
		}
	}
	
	public static void main(String[] args) throws Throwable {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		//Document xmlDocument = db.parse(new FileInputStream(new File(strPath+prop.getProperty("Variablepath")+"variables.xml")));
		Document doc = db.parse(new FileInputStream(new File("C:\\Appedo\\resource\\vuscripts\\3_vuscripts.xml")));
		
		String xmlpath = "C:\\Appedo\\resource\\vuscripts\\floodgates\\3_vuscripts.xml";
		
		NodeList entries = doc.getElementsByTagName("vuscript");
		int num = entries.getLength();
		for (int i=0; i<num; i++) 
		 {
			 //Node node = (Node) entries.item(i);
			Node aNode = (Node) entries.item(i);
		 	NamedNodeMap attributes = aNode.getAttributes();
		 	String strNodeId = null;
		 	String strNodeName = null;
		 	for (int a = 0; a < attributes.getLength(); a++) 
		 	{
		 		Node theAttribute = attributes.item(a);
		 		if(theAttribute.getNodeName().equals("id")) 
		 		{
		 			strNodeId = theAttribute.getNodeValue();
		 			//System.out.println(theAttribute.getNodeName() + "=" + theAttribute.getNodeValue());
		 			//System.out.println("id:"+aNode.getNodeName());
		 			//issamenodeExist(theAttribute.getNodeValue(),aNode);
				}
		 		if(theAttribute.getNodeName().equals("name")){
		 			strNodeName = theAttribute.getNodeValue();
		 		}
			}
		 	System.out.println("from: "+strNodeId+" and "+strNodeName);
		 	issamenodeExist(strNodeId, strNodeName, aNode);
		}
		doc.normalize();
		 
	}
	public static int issamenodeExist(String nodeid, String strNodeName, Node en1)throws Throwable	{
		 
		// RunManager runManager = new RunManager();
		String xmlfilePath = "C:\\Appedo\\resource\\vuscripts\\floodgates\\3_vuscripts.xml";
		 try	{
			 
			 //System.out.println("xml:"+xmlfilePath);
			 Boolean nodeexist=false;
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 //get current date time with Date()
			 Date date = new Date();
			 
			 DocumentBuilderFactory mdbf = DocumentBuilderFactory.newInstance();
			 mdbf.setValidating(false);
			 DocumentBuilder mdb = mdbf.newDocumentBuilder();
			 Document mdoc = mdb.parse(new FileInputStream(new File("C:\\Appedo\\resource\\vuscripts\\floodgates\\3_vuscripts.xml")));
			 
			 NodeList mentries = mdoc.getElementsByTagName("vuscript");
			 int mnum = mentries.getLength();
			 
			 for (int i=0; i<mnum; i++)	{
				 
				 Element mnode = (Element) mentries.item(i);
				 NamedNodeMap mattributes = mnode.getAttributes();
				 
				 String strSourceNodeId = null;
				 String strSourceNodeName = null;
				 for (int a = 0; a < mattributes.getLength(); a++)	{
					 
					 Node themAttribute = mattributes.item(a);
					 
					 if(themAttribute.getNodeName().equals("id"))	{
						 
						 strSourceNodeId = themAttribute.getNodeValue();
					}
					 if(themAttribute.getNodeName().equals("name"))	{
						 strSourceNodeName = themAttribute.getNodeValue();
					 }
				}
				System.out.println(strSourceNodeId+" and "+ strSourceNodeName); 
				if(strSourceNodeId.equals(nodeid)&&strSourceNodeName.equalsIgnoreCase(strNodeName)){
					 // remove the specific node
					System.out.println("updating:"+strSourceNodeId+" and "+strSourceNodeName);
					 Element element = (Element) mdoc.getElementsByTagName("vuscript").item(i);
					 // remove the specific node
					 element.getParentNode().removeChild(element);
					 Node en=en1.cloneNode(true);
					// add a attribute receivedon attribute to received node
					 Element ve=(Element)en;
					 ve.setAttribute("receivedon", dateFormat.format(date));
					 en =(Node)ve;
					 mdoc.adoptNode(en); 
					
					 Node appendnode = mdoc.getElementsByTagName("vuscripts").item(0);
					 appendnode.appendChild(en);
					 saveXmlDoc(mdoc, xmlfilePath);
					 
					 nodeexist=true;
					 break;
				}
				if(strSourceNodeId.equals(nodeid)||strSourceNodeName.equalsIgnoreCase(strNodeName)){
					System.out.println("Exception giving for :"+strSourceNodeId+" and "+strSourceNodeName);
					throw new Exception(strSourceNodeId+""+strSourceNodeName);
					 // remove the specific node
					// Element element = (Element) mdoc.getElementsByTagName("vuscript").item(i);
					 // remove the specific node
					// element.getParentNode().removeChild(element);
					// Node en=en1.cloneNode(true);
					// add a attribute receivedon attribute to received node
					// Element ve=(Element)en;
					// ve.setAttribute("receivedon", dateFormat.format(date));
					// en =(Node)ve;
					// mdoc.adoptNode(en); 
					
					// Node appendnode = mdoc.getElementsByTagName("vuscripts").item(0);
					// appendnode.appendChild(en);
					 //saveXmlDoc(mdoc, xmlfilePath);
					 
					// nodeexist=true;
					// break;
				}
			}
			 if(nodeexist==false)	{			 
				 Node en=en1.cloneNode(true);
				 // add a attribute receivedon attribute to received node 
				 Element ve=(Element)en;
				 ve.setAttribute("receivedon", dateFormat.format(date));
				 en =(Node)ve;				 
				 mdoc.adoptNode(en);		 
				 Node appendnode = mdoc.getElementsByTagName("vuscripts").item(0);
				 appendnode.appendChild(en);				 
				 saveXmlDoc(mdoc, xmlfilePath);
			}
		}catch(Throwable t)	{
			System.out.println("Exception in issamenodeExist() "+ t.getMessage());
			throw t;
		}
		 return 1;
	}
}
