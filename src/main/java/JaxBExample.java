import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxBExample {

    public static void main(String[] args) throws Exception{

        doJAXBXml();

    }

    public static void doJAXBXml() throws Exception {
        Course course = new Course(1, "Course-1", 5);
        course.setTeacher(new Teacher(1,"Teacher no. 1"));

        JAXBContext context = JAXBContext.newInstance(Course.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter stringWriter = new StringWriter();

        //Marchal Course object and write to the StringWriter

        marshaller.marshal(course, stringWriter);

        String courseXml = stringWriter.getBuffer().toString();
        stringWriter.close();

        System.out.println(courseXml);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader stringReader = new StringReader(courseXml);

        StreamSource streamSource = new StreamSource(stringReader);
        Course unmarshaledCourse = unmarshaller.unmarshal(streamSource , Course.class).getValue();

        System.out.printf("-----------------\nunmarshaled course name - " + unmarshaledCourse.getName());
        stringReader.close();




    }
}
