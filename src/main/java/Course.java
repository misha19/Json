import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {

    @XmlAttribute
    private int id;
    @XmlElement(namespace = "http://packt.jee.eclipse.jaxb")
    private String name;

    private int credits;
    @XmlElement(name = "course_teacher")
    private Teacher teacher;


    public Course() {}

    public Course (int id, String name, int credits) {
        this.id =id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
