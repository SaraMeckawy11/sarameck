package Assi6;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LAB6 {
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Enter input file like this : java LAB6 <nameoffile.arxml>");
            return;
        }
        String input = args[0];
        String output = getNameOfFile(input);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            if (input.endsWith(".arxml") == false){
                throw new NotVaildAutosarFileException("Wrong extention");
            }
            File inputFile = new File(input);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document a = builder.parse(inputFile);
            a.getDocumentElement().normalize();
            if (a.getDocumentElement().getChildNodes().getLength() == 0 ){
                throw new EmptyAutosarFileException("This file is Empty");
            }
            NodeList containerList = a.getElementsByTagName("CONTAINER");
            ArrayList<Element> containers = new ArrayList<Element>();
            for (int i = 0; i < containerList.getLength(); i++) {
                containers.add((Element) containerList.item(i));
            }
            Collections.sort(containers, new Comparator<Element>() {
                public int compare(Element o1, Element o2) {
                    return o1.getAttribute("SHORT-NAME").compareTo(
                            o2.getAttribute("SHORT-NAME"));
                }
            });
            Element b = a.getDocumentElement();
            for (Element container : containers) {
                b.appendChild(container);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(a);
            StreamResult result = new StreamResult(new File(output));
            transformer.transform(source, result);
            System.out.println("SORTING COMPLETED SUCCESSFULLY : " + output);



        }catch (EmptyAutosarFileException e){
            System.out.println("Error : " + e.getMessage());
        }
        catch (NotVaildAutosarFileException e){
            System.out.println("Error : " + e.getMessage());
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error: Input file does not have any content" );
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    public static String getNameOfFile(String i) {
        int index = i.lastIndexOf(".");
        String withoutextention = i.substring(0,index);
        String extention = i.substring(index);
        String output = withoutextention + "_mod" + extention;
        return output;
    }


}
class NotVaildAutosarFileException extends Exception {
    NotVaildAutosarFileException(String x){
        super(x);
    }
}
class EmptyAutosarFileException extends Exception{
    EmptyAutosarFileException(String x){
        super(x);
    }
}
