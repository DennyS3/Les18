import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        Employee pers1 = new Employee("Denny", "Somov", "Doc");
        Employee pers2 = new Employee("Gregoriy", "Winner", "SupMent");
        Employee pers3 = new Employee("Roman", "Rich", null);
        Employee pers4 = new Employee("Grisha", null, "manager");
        List<Employee> all = new ArrayList<>();
        all.add(pers1);
        all.add(pers2);
        all.add(pers3);
        all.add(pers4);
        Base base = new Base("TMS", "The First", "belarus");
        base.setEmployees(all);
        toXML(base);
        toTXT();
    }

    public static void toXML(Base base) throws JAXBException, FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(Base.class);
            Marshaller toXML = context.createMarshaller();
            toXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            toXML.marshal(base, System.out);
            File outFile = new File("XML_les18.xml");
            toXML.marshal(base, outFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void toTXT() throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(Base.class);
            Unmarshaller toTXT = context.createUnmarshaller();
            Base base = (Base) toTXT.unmarshal(new FileReader("XML_les18.xml"));
            System.out.println(base);
            BufferedReader br = new BufferedReader(new FileReader("XML_les18.xml"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("XMLtoTXT.txt"));
            String read = null;
            while((read = br.readLine()) !=null){
                bw.write("\n" + read +"\n");
            }
            bw.close();
            br.close();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}