package common.TCDBOutofSync;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by alex.hernandez on 7/16/16.
 */
public class TestCaseVerifier {

    private HashMap<String, String> matchedTestCases = new HashMap<>();
    private TreeMap<String, String> testCasesOutOfDate = new TreeMap<>();
    private List<String> filteredTestCases = new ArrayList<>();
    private String testCaseList = "";

    /**
     * Default TestCaseVerifier that outputs test cases that need to be updated
     * NOTE: A custom (Verifier) class like this can be created to output whatever info you would like to see generated
     * by the TestCaseComparator Class.
     *
     * @param startingPath
     * @return
     * @throws IOException
     */
    public void inSync(Path startingPath) throws IOException {

        // Used to verify if in sync
        Boolean inSync = true;

        // Walks the FilePath and returns a list of filteredTestCases that contain a TCDBDefinition
        filteredTestCases = new TestCaseMatcher().walkFileTree(startingPath);

        // Create a new Instance of Test Matcher and extract TC id and TC version
        matchedTestCases = new TestCaseMatcher().getMatchedTestCases(filteredTestCases);

        // Create a new instance of TestCaseComparator that will be initialized with the set of matched TC's
        TestCaseComparator testCaseComparator = new TestCaseComparator(matchedTestCases);

        // Initialize TestCaseComparator for data generation
        testCaseComparator.run();

        // Gets the a combined Test Cases hashmap of test cases that are out of date from Generated Data
        testCasesOutOfDate = testCaseComparator.getCombinedTestCases();

        if (testCasesOutOfDate.size() > 0) {
            inSync = false;
        }

        for (String testCase : testCasesOutOfDate.keySet()) {
            testCaseList += ("\n" + testCase + " -> " + testCasesOutOfDate.get(testCase) + "\n");

        }

        // Verify there are that there are not test cases out of sync
        assertThat((String.format(testCasesOutOfDate.size() + " test cases are out of sync and need to be upated\n\n" +
                " Current Version           TCDB Version\n" + testCaseList)), inSync);

    }

}
