package pl.coderslab.components;

import java.io.File;
import java.util.function.Predicate;

public class FileService {
    public static void printDirectories(String path) {
        Predicate<String> isdir = elem -> new File(elem).isDirectory();

    }
}
