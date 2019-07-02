package pl.coderslab.components;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

@Component
public class FileService {
    public static void main(String[] args) {
        FileService.printDirectories("/home/marek/Pulpit/java_gits/jeeexam5");
    }
//1. Utwórz komponent `FileService`.
//2. Utwórz w nim metodę `printDirectories(String path)`, która wyświetli na konsoli wszystkie katalogi ze ścieżki zadanej w parametrze `path`.
//3. Wykorzystaj wyrażenia lambda w celu sprawdzania czy element jest katalogiem - możesz skorzystać z metody `isDirectory()` klasy `File`.


    @SuppressWarnings("SameParameterValue")
    private static void printDirectories(String path) {
        File[] directories = new File(path).listFiles(File::isDirectory);

        if (directories != null) {
            for (File myFile : directories) {
                System.out.println(myFile.toString());
            }
        } else {
            System.out.println("Lista może być pusta.");
        }
    }
}
