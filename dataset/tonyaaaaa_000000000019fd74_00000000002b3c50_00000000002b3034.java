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
            for (int i = 0; i < n; i++) {
                words.add(scan.next().replaceAll("\\*", ""));
            }
            Collections.sort(words, Comparator.comparingInt(String::length));

            boolean possible = true;
            for (int i = words.size() - 2; i >= 0; i--) {
                if (!words.get(i + 1).endsWith(words.get(i))) {
                    possible = false;
                }
            }

            System.out.println("Case #" + test + ": " + (possible ? words.get(words.size() - 1) : "*"));
        }
    }
}
