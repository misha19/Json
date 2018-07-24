import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;


public class JaxBJson {


    public static void main(String[] args) throws Exception{

        doJAXBJson();

    }

    private static void doJAXBJson() throws Exception{

        Course course = new Course(1, "Chemistry",5);
        course.setTeacher(new Teacher(1, "Mrs. Johansson"));

        JAXBContext context = JAXBContext.newInstance(Course.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.setProperty(MarshallerProperties.Media_TYPE, "application/json");

        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT,true);

        StringWriter stringWriter = new StringWriter();

        marshaller.marshal(course, stringWriter);

        String courseJson = stringWriter.getBuffer().toString();
        stringWriter.close();
        System.out.println(courseJson);

        //Now unmarshall courseJson to create Course object
        Unmarshaller unmarshaller= context.createUnmarshaller();
        unmarshaller.setProperty(MarshallerProperties.Media_Type,"application/json");
        unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);


        //Create String Reader
        StringReader stringReader = new StringReader(courseJson);

        StreamSource streamSource = new StreamSource(stringReader);
        Course unmarshalledCourse = unmarshaller.unmarshal(streamSource,Course.class).getValue();
        System.out.printf("------------------\nUnmarshalled course name - " + unmarshalledCourse.getName());
        stringReader.close();
    }
}
