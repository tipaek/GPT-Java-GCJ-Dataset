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
    private static List<String> words = getWords();

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
            solve(i + 1, patterns);
        }
    }

    private static void solve(int test, List<String[]> patterns) {
        String start = null;
        String end = null;
        for (String[] pattern : patterns) {
            if (!pattern[0].equals("")) {
                if (start == null) {
                    start = pattern[0];
                } else {
                    if (!(start.contains(pattern[0]) || pattern[0].contains(start))) {
                        System.out.println("Case " + test + ": *");
                        return;
                    }
                }
            }
            if (!pattern[pattern.length - 1].equals("")) {
                if (end == null) {
                    end = pattern[0];
                } else {
                    if (!(end.contains(pattern[pattern.length - 1]) || pattern[pattern.length - 1].contains(end))) {
                        System.out.println("Case " + test + ": *");
                        return;
                    }
                }
            }
        }

        Stream<String> words = Solution.words.stream();
        for (String[] pattern : patterns) {
            for (int i = 0; i < pattern.length; i++) {
                if (!pattern[i].equals("")) {
                    int ii = i;
                    if (i == 0) {
                        words = words.filter(new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                return s.startsWith(pattern[0]);
                            }
                        });
                    } else if (i == pattern.length - 1) {
                        words = words.filter(new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                return s.endsWith(pattern[ii]);
                            }
                        });
                    } else {
                        words = words.filter(new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                return s.contains(pattern[ii]);
                            }
                        });
                    }
                }
            }
        }
        for (String[] pattern : patterns) {
            words = words.filter(new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return matches(s, pattern);
                }
            });
        }

        Optional<String> word = words.findAny();
        if (word.isPresent()) {
            System.out.println("Case " + test + ": *");
        } else {
            System.out.println("Case " + test + ": " + word.get().toUpperCase());
        }
    }

    private static boolean matches(String word, String[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            String part = pattern[i];
            if (part.equals("")) continue;
            if (i == 0) {
                if (!word.startsWith(part)) return false;
                word = word.substring(part.length());
            } else if (i == pattern.length - 1) {
                if (!word.endsWith(part)) return false;
            } else {
                int j = word.indexOf(part);
                if (j == -1) return false;
                word = word.substring(j + part.length());
            }
        }
        return true;
    }

    private static List<String> getWords() {
        if (!new File("words_alpha.txt").exists()) {
            try (BufferedInputStream in = new BufferedInputStream(new URL("https://github.com/dwyl/english-words/raw/master/words_alpha.txt").openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream("words_alpha.txt")) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            return Files.readAllLines(new File("words_alpha.txt").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
