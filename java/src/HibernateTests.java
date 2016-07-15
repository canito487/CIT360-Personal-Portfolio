import common.HibernateConfig;
import common.HibernateUtil;
import common.TestCase;
import joptsimple.internal.Strings;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Created by alex.hernandez on 6/1/16.
 */
public class HibernateTests {

    private HibernateConfig hibernateConfig = new HibernateConfig();

    /**
     * JUnit Test used to verify the Addition of a test case to the db
     */
    @Test
    public void verifyAddTestCase() {

        // Instantiate a new HibernateUtil Object
        HibernateUtil hibernateExample = new HibernateUtil();
        Session session = hibernateConfig.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // sampleTestCase name used to verify insert of test case
        String tcName = "test6";
        String dbTestCaseName = "'test6'";

        // Step1: Add a new test case
        hibernateExample.addnewTestCase(tcName, 0);

        //Step 2: Verify test case has been added

        //Query the db and save the result in tc1
        String stringQuery = "from TestCase u where u.tcname=" + dbTestCaseName;
        Query singleUserQuery = session.createQuery(stringQuery);
        TestCase tc1 = (TestCase) singleUserQuery.uniqueResult();

        transaction.commit();

        //Verify testcase has been updated with correct name
        Assert.assertEquals(tcName, tc1.getTcname());
    }

    /**
     * JUnit Test used to verify the retrieval of a test case from the db
     */
    @Test
    public void verifyGetATestCase() {

        // Instantiate a new HibernateUtil Object
        HibernateUtil hibernateExample = new HibernateUtil();

        // sampleTestCase name used to verify insert of test case
        String dbTcName = "'test1'";
        String verifiableTcName = "test1";

        // Step 1: Get the test case
        TestCase testCase = hibernateExample.getATestCase(dbTcName);

        //Step 2: Verify the returned TestCase name is the same as the one inputted
        Assert.assertEquals(verifiableTcName, testCase.getTcname());

    }

    /**
     * Junit test used to verify the removal of a test case from the db
     */
    @Test
    public void verifyRemoveTestCase() {

        // Instantiate a new HibernateUtil Object
        HibernateUtil hibernateExample = new HibernateUtil();
        Session session = hibernateConfig.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Sample name used to verify deletion of tc
        String dbTestCaseName = "'test1'";

        // Step 1: Remove the test case
        hibernateExample.removeTestCase(dbTestCaseName);

        // Step 2: Query the db and verify the test case has been deleted
        String stringQuery = "from TestCase u where u.tcname=" + dbTestCaseName;
        Query singleUserQuery = session.createQuery(stringQuery);

        TestCase tc1 = (TestCase) singleUserQuery.uniqueResult();

        transaction.commit();

        // Verification: Assert tc object returned is null
        Assert.assertNull(tc1);

    }

    /**
     * JUnit Test showing an example of deleting all test cases from the db using a ThreadPool
     */
    @Test
    public void deleteAllTestCasesUsingThreadPool() {

        // Create a new fixed thread pool
        ExecutorService pool = newFixedThreadPool(4);

        // List of test cases that will be deleted from the DB
        List<String> deletedTestCases = new ArrayList<>();

        // Instantiate a new HibernateUtil Object
        final Session session = hibernateConfig.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        String stringQuery = "from TestCase";

        // Query the database selecting all from the test case table and it.
        List<TestCase> testCases = (List<TestCase>) session.createQuery(stringQuery).list();

        // Run through every testCase and delete it using multiple threads in a runnable task
        testCases.forEach(testCase -> pool.execute(() -> {
            session.delete(testCase);
            deletedTestCases.add(testCase.getTcname());
        }));

        // Shutdown the thread pool
        try {
            pool.shutdown();
            pool.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Threads were not shutdown gracefully: " + e);
        }

        // Output the information of deleted Test Cases
        System.out.println("Number of Test Cases Deleted: " + deletedTestCases.size());
        System.out.println("Test Cases that were deleted: " + Strings.join(deletedTestCases, "\n"));

        transaction.commit();

    }

}
