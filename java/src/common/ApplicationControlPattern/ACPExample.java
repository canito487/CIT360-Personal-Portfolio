package common.ApplicationControlPattern;

/**
 * Created by alex on 7/9/2016.
 */
public class ACPExample {

    public static void main(String[] args) {

        // Instantiate default Test Case
        TestCase newTestCase = defaultTestCase();

        //Use Controller to modify test case
        TestCaseController testCaseController = new TestCaseController(newTestCase);

        //Display current info before it is modified
        testCaseController.displayTcInformation();

        //Modify the testcase with the controller
        testCaseController.setTcName("Verify the status of a fax");
        testCaseController.setTcId(911);
        testCaseController.setTcVersion(2);

        //Display information after its been modified
        testCaseController.displayTcInformation();

    }

    private static TestCase defaultTestCase() {
        TestCase testCase = new TestCase();

        testCase.setId(4112);
        testCase.setVersion(1);
        testCase.setTcName("Verify Fax can be sent through API");

        return testCase;
    }


}
