import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Solution {
    private static final List<String> words = loadWords();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<String[]> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scanner.nextLine().toLowerCase().split("\\*"));
            }
            processTestCase(i + 1, patterns);
        }
    }

    private static void processTestCase(int testNumber, List<String[]> patterns) {
        String start = null;
        String end = null;

        for (String[] pattern : patterns) {
            if (!pattern[0].isEmpty()) {
                if (start == null) {
                    start = pattern[0];
                } else if (!start.contains(pattern[0]) && !pattern[0].contains(start)) {
                    System.out.println("Case " + testNumber + ": *");
                    return;
                }
            }
            if (!pattern[pattern.length - 1].isEmpty()) {
                if (end == null) {
                    end = pattern[pattern.length - 1];
                } else if (!end.contains(pattern[pattern.length - 1]) && !pattern[pattern.length - 1].contains(end)) {
                    System.out.println("Case " + testNumber + ": *");
                    return;
                }
            }
        }

        Stream<String> filteredWords = words.stream();
        for (String[] pattern : patterns) {
            for (int i = 0; i < pattern.length; i++) {
                if (!pattern[i].isEmpty()) {
                    final int index = i;
                    filteredWords = applyPatternFilter(filteredWords, pattern, index);
                }
            }
        }

        for (String[] pattern : patterns) {
            filteredWords = filteredWords.filter(word -> matchesPattern(word, pattern));
        }

        Optional<String> resultWord = filteredWords.findAny();
        if (resultWord.isPresent()) {
            System.out.println("Case " + testNumber + ": " + resultWord.get().toUpperCase());
        } else {
            System.out.println("Case " + testNumber + ": *");
        }
    }

    private static Stream<String> applyPatternFilter(Stream<String> words, String[] pattern, int index) {
        if (index == 0) {
            return words.filter(word -> word.startsWith(pattern[0]));
        } else if (index == pattern.length - 1) {
            return words.filter(word -> word.endsWith(pattern[index]));
        } else {
            return words.filter(word -> word.contains(pattern[index]));
        }
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
        File wordsFile = new File("words_alpha.txt");
        if (!wordsFile.exists()) {
            downloadWordsFile(wordsFile);
        }
        try {
            return Files.readAllLines(wordsFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static void downloadWordsFile(File wordsFile) {
        try (BufferedInputStream in = new BufferedInputStream(new URL("https://github.com/dwyl/english-words/raw/master/words_alpha.txt").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(wordsFile)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}