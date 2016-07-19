package common.TCDBOutofSync;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by alex.hernandez on 7/16/16.
 */
public class OutOfSync {


    @Test
    public void checkVersionOutOfSync_CMS() throws IOException {

        // This is the starting path for the directory / package you would like to check
        Path startingPath = Paths.get(System.getProperty("user.dir"));

        // Verifying that test cases are in sync
        new TestCaseVerifier().inSync(startingPath);

    }

}
