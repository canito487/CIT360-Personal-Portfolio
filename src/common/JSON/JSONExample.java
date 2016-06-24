package common.JSON;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by alex.hernandez on 6/20/16.
 */
public class JSONExample {

    public static void main(String[] args) {
        JSONExample app = new JSONExample();

        app.run();
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();

        Person person = PersonUtil.defaultPerson();

        try {

            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(person);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
