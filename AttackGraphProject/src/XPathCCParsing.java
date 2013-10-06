import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class XPathCCParsing {
    public static void main(String[] args) {
 
        try {
        	//Write results into outpust file
        	PrintWriter writer = new PrintWriter("C:\\Users\\Neethu\\Desktop\\CC\\parseOutputFile.txt", "UTF-8");
				
			//Parse XML File        	
            FileInputStream file = new FileInputStream(new File("C:\\Users\\Neethu\\Desktop\\CC\\DependencyCheckReport.xml"));
                 
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
             
            DocumentBuilder builder =  builderFactory.newDocumentBuilder();
             
            Document xmlDocument = builder.parse(file);
 
            XPath xPath =  XPathFactory.newInstance().newXPath();
 
            System.out.println("*************************");
            //String expression1 = "//dependencies/dependency/fileName";
            //String expression = "//dependency/vulnerabilities/vulnerability/*";
            String expression = "//dependencies/dependency/vulnerabilities/vulnerability/*";
            //System.out.println(expression);
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                //System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            	System.out.println("Write into output file");
                //bw.write(nodeList.item(i).getFirstChild().getNodeValue());
            	writer.println(nodeList.item(i).getFirstChild().getNodeValue());    		
            	
            	
            }
            writer.close();
            System.out.println("*************************");
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }       
    }

}