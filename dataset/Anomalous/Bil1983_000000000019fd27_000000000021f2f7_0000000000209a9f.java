import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/input.txt")))));

        int t = sc.nextInt();
        sc.nextLine();
        for (int test = 1; test <= t; test++) {
            String s = sc.nextLine();
            List<String> segments = splitString(s);
            StringBuilder result = new StringBuilder();

            for (String segment : segments) {
                if (segment.charAt(0) == '0') {
                    result.append(segment);
                } else {
                    result.append("(").append(segment).append(")");
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }

    static List<String> splitString(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i));
            if (i == s.length() - 1 || buffer.charAt(0) != s.charAt(i + 1)) {
                result.add(buffer.toString());
                buffer.setLength(0);
            }
        }

        return result;
    }
}