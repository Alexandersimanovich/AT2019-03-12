package by.it.medvedeva.at15;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class SitesValidator {

    public static void main(String[] args) {
        String schemaNsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(schemaNsUri);
        String xsd=System.getProperty("user.dir")+"/src/by/it/medvedeva/at15/sites.xsd";
        String xml=System.getProperty("user.dir")+"/src/by/it/medvedeva/at15/sites+xsd.xml";
        try {
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            System.out.println(xml+" valid");
        } catch (SAXException e) {
            System.err.println(xml+" non valid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
