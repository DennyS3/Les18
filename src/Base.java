import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name ="name")
@XmlAccessorType(XmlAccessType.FIELD)
public class Base {
    private String company;
    private String value;
    private String location;
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    public Base() {
    }

    public Base(String company, String value, String location) {
        this.company = company;
        this.value = value;
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company: " + company + "\n"
                +" Value: " + value + "\n"
                +" location: "+location + "\n"
                +" Employees: " + employees + "\n";
    }
}
