
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    List<Employee> expected = new ArrayList<>();
    Employee employee;
    Employee employee1;

    @BeforeEach
    void setup() {
        employee = new Employee(1, "John", "Smith", "USA", 25);
        employee1 = new Employee(2, "Ivan", "Petrov", "RU", 23);
    }

    @Test
    protected void parseXMlTest() throws ParserConfigurationException, IOException, SAXException {
        final String file1 = "data.xml";
        expected.add(employee);
        expected.add(employee1);
        List<Employee> result = Main.parseXMl(file1);
        String string = expected.toString();
        String string1 = result.toString();
        assertThat(string, is(string1));
    }

    @Test
    protected void listToJsonTest() {
        final String expected1 = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        expected.add(employee);
        expected.add(employee1);
        String result = Main.listToJson(expected);
        assertThat(expected1, is(result));
    }

    @Test
    protected void writeString() {

    }
}
