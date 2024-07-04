import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = scan.nextInt();
            List<String> words = new ArrayList<>();
            List<String> left = new ArrayList<>();
            List<String> right = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                words.add(scan.next());
            }
            words.sort(Comparator.comparingInt(String::length).reversed());
            List<String[]> splitwords = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                splitwords.add(words.get(i).split("\\*"));
                left.add(splitwords.get(i)[0]);
                right.add(splitwords.get(i).length == 1 ? "" : splitwords.get(i)[1]);
            }
            left.sort(Comparator.comparingInt(String::length).reversed());
            right.sort(Comparator.comparingInt(String::length).reversed());


            boolean possible = true;
            for (int i = 0; i < n - 1; i++) {
                if (!left.get(i).startsWith(left.get(i + 1)) ||
                    !right.get(i).endsWith(right.get(i + 1))
                ) {
                    possible = false;
                }
            }

            if (possible) {
                String leftW = left.get(0);
                String rightW = right.get(0);
                if (leftW.isEmpty() || rightW.isEmpty()) {
                    System.out.println("Case #" + test + ": " + leftW + rightW);
                } else {
                    int j = 0;
                    while (j < rightW.length()) {
                        String candidate = leftW + rightW.substring(j);
                        boolean found = true;
                        for (String word : words) {
                            if (!candidate.matches(word.replaceAll("\\*", ".*"))) {
                                found = false;
                                break;
                            }
                        }
                        if (found) {
                            System.out.println("Case #" + test + ": " + candidate);
                            break;
                        }
                        j++;
                    }
                }
            } else {
                System.out.println("Case #" + test + ": *");
            }
        }
    }
}
