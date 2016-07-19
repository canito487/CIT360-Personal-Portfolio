package common.TCDBOutofSync;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alex.hernandez on 7/16/16.
 */
public class TestCaseMatcher {

    /**
     * Walks the File Structure and returns a filtered list of test cases containing @TestCaseId Annotation
     *
     * @param startingPath
     * @return
     * @throws IOException
     */
    public List<String> walkFileTree(Path startingPath) throws IOException {

        List<String> filteredTestCases = new ArrayList<>();

        FileWalker walker = new FileWalker();

        // Grab all Test Class files that end with .java
        Files.walkFileTree(startingPath, walker);

        // Run through each file and check if it contains TCDBD Definition and stores them in a List
        for (Path filePath : walker.getJavaList()) {

            File file = filePath.toFile();

            List<String> filteredText = containsTCDBDefinition(file);

            for (String line : filteredText) {
                filteredTestCases.add(line);
            }

        }
        return filteredTestCases;
    }

    /**
     * Runs through every java class file and returns a list of filteredText with @TestCaseId annotation
     *
     * @param fileAbsolutePath
     * @return
     */
    public static List<String> containsTCDBDefinition(File fileAbsolutePath) throws IOException {

        String line;
        List<String> fileText = new ArrayList<>();
        List<String> filteredText = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAbsolutePath));

        while ((line = bufferedReader.readLine()) != null) {
            fileText.add(line);
        }

        // Stream each line and if it matches @TestCaseId add it to list
        fileText.stream()
                .filter(line1 -> line1.contains("@TestCaseId"))
                .forEach(line1 -> filteredText.add(line1));

        return filteredText;

    }

    /**
     * Runs through a List of Filtered Test Cases and Extracts TC Id and Version
     *
     * @param filteredTestCases
     * @return
     */
    public HashMap<String, String> getMatchedTestCases(List<String> filteredTestCases) {

        HashMap<String, String> testCases = new HashMap<>();

        for (String testCase : filteredTestCases) {

            String re1 = ".*?";
            String re2 = "\\d+";
            String re3 = ".*?";
            String re4 = "(\\d+)";

            String line = testCase;
            Pattern p = Pattern.compile("[0-9]{5}");
            Pattern p2 = Pattern.compile(re1 + re2 + re3 + re4, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

            Matcher matcher = p.matcher(line);
            Matcher matcher1 = p2.matcher(line);

            while (matcher.find() && matcher1.find()) {
                testCases.put(matcher.group(), matcher1.group(1));
            }
        }

        return testCases;
    }

}
