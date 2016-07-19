package common.TCDBOutofSync;

import common.ApplicationControlPattern.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by alex.hernandez on 7/10/16.
 */
public class TestCaseComparator implements Runnable {

    /**
     * TestCaseComparator is a class that is designed to take a HashMap of MatchedTestCases and generates data that
     * can be used to verify if a test case is out of sync
     */
    private TreeMap<Integer, Integer> testCasesOutOfDate = new TreeMap<>();
    private TreeMap<Integer, Integer> updatedTestCases = new TreeMap<>();
    private TreeMap<String, String> combinedTestCases = new TreeMap<>();
    private HashMap<String, String> matchedTestCases = new HashMap<>();
    private List<String> testCaseNames = new ArrayList<>();
    private Integer localVersion;
    private Integer localTcId;
    private String localTestCase;
    private Integer tcdbVersion;
    private Integer tcdbId;
    private String tcdbTestCase;
    private String testCaseName;

    public TestCaseComparator(HashMap<String, String> matchedTestCases) {
        this.matchedTestCases = matchedTestCases;
    }

    public TreeMap<Integer, Integer> getTestCasesOutOfDate() {
        return testCasesOutOfDate;
    }

    public TreeMap<Integer, Integer> getUpdatedTestCases() {
        return updatedTestCases;
    }

    public TreeMap<String, String> getCombinedTestCases() {
        return combinedTestCases;
    }

    public List<String> getTestCaseNames() {
        return testCaseNames;
    }

    public void run() {

        // Set all data
        for (final String localTcId : matchedTestCases.keySet()) {

            // Make the request to TCDB to get the current Test Case
            TestCase response = new TCDBWorkflows().getATestCase();

            // Local TC Id
            this.localTcId = Integer.parseInt(localTcId);

            // Local TC Version
            this.localVersion = Integer.parseInt(matchedTestCases.get(localTcId));

            // Local TC
            this.localTestCase = "TC: " + localTcId + " version: " + localVersion;

            // TCDB Version
            this.tcdbVersion = response.getVersion();

            // TCDB Id
            this.tcdbId = response.getId();

            // TCDB TC
            this.tcdbTestCase = "TC: " + tcdbId + " version: " + tcdbVersion;


            if (tcdbVersion != localVersion) {
                // Stores out of date test cases
                testCasesOutOfDate.put(this.localTcId, localVersion);
                // Stores test cases from TCDB
                updatedTestCases.put(tcdbId, tcdbVersion);
                // Stores a combination of local test cases and TCDB test cases
                combinedTestCases.put(localTestCase, tcdbTestCase);
                // Stores a list outdated test cases names
                testCaseNames.add(testCaseName);

            }

        }

    }


}
