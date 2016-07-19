package common.TCDBOutofSync;

import common.ApplicationControlPattern.TestCase;


/**
 * Created by alex.hernandez on 7/16/16.
 */
public class TCDBWorkflows {

    public TestCase getATestCase() {

        TestCase defaultTestCase = new TestCase();

        defaultTestCase.setId(123);
        defaultTestCase.setTcName("Verify Fax");
        defaultTestCase.setVersion(1);

       return defaultTestCase;

    }

}



