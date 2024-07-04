import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader("/home/dev/projects/codejam20/src/round1a/input.txt")));

        //# of test cases
        int T = in.nextInt();

        //iterate test cases
        for (int t = 1; t <= T; t++) {
            // # of patterns
            int N = in.nextInt();
            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = in.next();
            }
            solvePatterns(t, patterns);
        }
    }

    private static void solvePatterns(int testCase, String[] patterns) {
        System.out.print("Case #" + testCase + ": ");
        String output = "";

        //sort by length
        Arrays.sort(patterns, (a, b)->Integer.compare(a.length(), b.length()));

        String keyWord = patterns[0];
        String keyParts[] = keyWord.split("\\*", 2);
        for (int i = 1; i < patterns.length; i++) {

            String nameParts[] = patterns[i].split("\\*", 2);

            if ((nameParts[0].isEmpty() || keyParts[0].isEmpty() || nameParts[0].startsWith(keyParts[0]))
                    && ((nameParts[1].isEmpty() || keyParts[1].isEmpty() || nameParts[1].endsWith(keyParts[1])))) {
                output = nameParts[0] + nameParts[1];
            } else {
                output = "*";
                break;
            }
        }

        System.out.println(output);

    }
}