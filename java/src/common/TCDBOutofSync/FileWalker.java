package common.TCDBOutofSync;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex.hernandez on 7/16/16.
 */
public class FileWalker extends SimpleFileVisitor<Path> {

    /**
     * This Test Case is designed to provide capability to walk a file structure and store java test classes.
     */

    private List<Path> javaList = new ArrayList<>();
    public List<Path> getJavaList() {
        return javaList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile() && file.getFileName().toString().contains(".java")) {
            javaList.add(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

}
