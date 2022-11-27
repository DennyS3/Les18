import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "lesson18")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    private String name;
    private String familia;
    private String professia;

    public Employee() {
    }

    public Employee(String name, String familia, String professia) {
        this.name = name;
        this.familia = familia;
        this.professia = professia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getProfessia() {
        return professia;
    }

    public void setProfessia(String professia) {
        this.professia = professia;
    }

    @Override
    public String toString() {
        return "Name: "+name
                +" familia " + familia
                +" professia " + professia + "\n";
    }
}

