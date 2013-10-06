import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XPathCCParsing {

  public static void main(String[] args) 
   throws ParserConfigurationException, SAXException, 
          IOException, XPathExpressionException {
	  
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    domFactory.setNamespaceAware(true); // never forget this!
    DocumentBuilder builder = domFactory.newDocumentBuilder();
    try{
    Document doc = builder.parse("C:\\Users\\Neethu\\Desktop\\CC\\books.xml");
    //Document doc = builder.parse("C:\\Users\\Neethu\\Desktop\\CC\\DependencyCheckReport.xml");

    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();
    XPathExpression expr 
    // = xpath.compile("//vulnerabilities/vulnerability/name/text()");
    = xpath.compile("//book/text()");

    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;
    for (int i = 0; i < nodes.getLength(); i++) {
        System.out.println(nodes.item(i).getNodeValue()); 
    }
  }catch(Exception e)
  {
	  e.printStackTrace();
  }
  }
}
