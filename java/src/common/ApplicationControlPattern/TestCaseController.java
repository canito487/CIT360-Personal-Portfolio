package common.ApplicationControlPattern;

/**
 * Created by alex on 7/9/2016.
 */
public class TestCaseController {

    TestCase model;

    public TestCaseController(TestCase model) {

        this.model = model;

    }

    public void setTcId(Integer id) {

        model.setId(id);

    }

    public void setTcVersion(Integer version) {
        model.setVersion(version);
    }

    public void setTcName(String name) {
        model.setTcName(name);
    }

    public void displayTcInformation() {
        System.out.println("TC Id: " + model.getId());
        System.out.println("TC Version: " + model.getVersion());
        System.out.println("TC Name: " + model.getTcName());

    }

}
