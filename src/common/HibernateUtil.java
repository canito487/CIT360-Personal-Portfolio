package common;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by alex.hernandez on 6/1/16.
 */
public class HibernateUtil {

    private HibernateConfig hibernateConfig;

    public HibernateUtil() {
        hibernateConfig = new HibernateConfig();
    }

    /**
     * This method adds a new test case object to the MYSQL db
     *
     * @param tcName
     * @param version
     * @return
     */
    public String addnewTestCase(String tcName, Integer version) {
        Session session = hibernateConfig.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        TestCase testCase1 = new TestCase();
        testCase1.setTcname(tcName);
        testCase1.setTcversion(version);
        testCase1.setFsnumber(1234);

        //Save
        session.save(testCase1);
        transaction.commit();

        System.out.println("testCase id in DB is: " + testCase1.getTcname());

        return testCase1.getTcname();
    }

    /**
     * This Method removes a test case from the db
     *
     * @param name
     */
    public void removeTestCase(String name) {
        Session session = hibernateConfig.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //Get a test case using query
        String stringQuery = "from TestCase u where u.tcname=" + name;

        Query singleUserQuery = session.createQuery(stringQuery);
        TestCase tc1 = (TestCase) singleUserQuery.uniqueResult();

        // Object of the row we want to delete
        session.delete(tc1);

        transaction.commit();

    }

    /**
     * This Method gets a test case from the db
     *
     * @param name
     * @return
     */
    public TestCase getATestCase(String name) {
        Session session = hibernateConfig.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //Get a test case using query
        String stringQuery = "from TestCase u where u.tcname=" + name;

        Query singleUserQuery = session.createQuery(stringQuery);
        TestCase tc1 = (TestCase) singleUserQuery.uniqueResult();

        transaction.commit();

        System.out.println("Test Case retrieved is: " + tc1.getTcname());

        return tc1;

    }

}
