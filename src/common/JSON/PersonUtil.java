package common.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex.hernandez on 6/20/16.
 */
public class PersonUtil {
    public PersonUtil() {
    }

    public static Person defaultPerson() {
        Person alex = new Person();

        alex.setAge(28);
        alex.setEmployment("Software Engineer");
        alex.setName("Alex");
        alex.setRace("Hispanic");

        List<String> hobbies = new ArrayList<>();

        hobbies.add("Reading");
        hobbies.add("Dancing");

        alex.setHobbies(hobbies);

        return alex;
    }
}
