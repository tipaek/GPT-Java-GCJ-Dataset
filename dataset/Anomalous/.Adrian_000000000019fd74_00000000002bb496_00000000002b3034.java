import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Solution {
    private static final List<String> words = loadWords();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            List<String[]> patterns = new ArrayList<>();

            for (int j = 0; j < patternCount; j++) {
                patterns.add(scanner.nextLine().toLowerCase().split("\\*"));
            }

            processTestCase(i + 1, patterns);
        }
    }

    private static void processTestCase(int testCaseNumber, List<String[]> patterns) {
        String startPattern = null;
        String endPattern = null;

        for (String[] pattern : patterns) {
            if (!pattern[0].isEmpty()) {
                startPattern = updatePattern(startPattern, pattern[0]);
                if (startPattern == null) {
                    System.out.println("Case " + testCaseNumber + ": *");
                    return;
                }
            }
            if (!pattern[pattern.length - 1].isEmpty()) {
                endPattern = updatePattern(endPattern, pattern[pattern.length - 1]);
                if (endPattern == null) {
                    System.out.println("Case " + testCaseNumber + ": *");
                    return;
                }
            }
        }

        Stream<String> filteredWords = words.stream();
        for (String[] pattern : patterns) {
            for (int i = 0; i < pattern.length; i++) {
                if (!pattern[i].isEmpty()) {
                    filteredWords = filterWords(filteredWords, pattern, i);
                }
            }
        }

        filteredWords = filteredWords.filter(word -> matchesPattern(word, pattern));
        Optional<String> resultWord = filteredWords.findAny();

        System.out.println("Case " + testCaseNumber + ": " + resultWord.map(String::toUpperCase).orElse("*"));
    }

    private static String updatePattern(String existingPattern, String newPattern) {
        if (existingPattern == null) {
            return newPattern;
        }
        if (existingPattern.contains(newPattern) || newPattern.contains(existingPattern)) {
            return existingPattern.length() > newPattern.length() ? existingPattern : newPattern;
        }
        return null;
    }

    private static Stream<String> filterWords(Stream<String> words, String[] pattern, int index) {
        Predicate<String> predicate;

        if (index == 0) {
            predicate = word -> word.startsWith(pattern[0]);
        } else if (index == pattern.length - 1) {
            predicate = word -> word.endsWith(pattern[index]);
        } else {
            predicate = word -> word.contains(pattern[index]);
        }

        return words.filter(predicate);
    }

    private static boolean matchesPattern(String word, String[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            String part = pattern[i];
            if (part.isEmpty()) continue;

            if (i == 0) {
                if (!word.startsWith(part)) return false;
                word = word.substring(part.length());
            } else if (i == pattern.length - 1) {
                if (!word.endsWith(part)) return false;
            } else {
                int index = word.indexOf(part);
                if (index == -1) return false;
                word = word.substring(index + part.length());
            }
        }
        return true;
    }

    private static List<String> loadWords() {
        File wordFile = new File("words_alpha.txt");

        if (!wordFile.exists()) {
            try (BufferedInputStream in = new BufferedInputStream(new URL("https://github.com/dwyl/english-words/raw/master/words_alpha.txt").openStream());
                 FileOutputStream out = new FileOutputStream(wordFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            return Files.readAllLines(wordFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}