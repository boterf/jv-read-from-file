package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final char MAGIC_NUMBER = 'w';

    public static String[] readFromFile(String fileName) {
        final StringBuilder sb = new StringBuilder();
        List<String> reader;
        Path filePath = Paths.get(fileName);
        String[] split;
        try {
            reader = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Причина в том, что " + e);
        }
        for (String a : reader) {
            split = a.toLowerCase().split(" ");
            for (String s : split) {
                if (s.charAt(0) == MAGIC_NUMBER) {
                    sb.append(s.toLowerCase().replaceAll("\\W", "") + " ");
                }
            }
        }
        if (sb.length() == 0) {
            split = new String[0];
            return split;
        }
        split = sb.toString().split(" ");
        Arrays.sort(split);
        return split;
    }
}
