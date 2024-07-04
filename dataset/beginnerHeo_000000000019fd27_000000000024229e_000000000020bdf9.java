import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution
 *
 * @author dongyoung
 * @since 2020-04-04
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }

            System.out.println("Case #" + i + ": " + solution(arr, n));
        }
    }

    public static String solution(int[][] arr, int n) {
        Comparator<Subject> comp = Comparator.comparing(s -> s.start);
        List<Subject> subjectList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subjectList.add(new Subject(arr[i][0], arr[i][1]));
        }
        List<Subject> copyList = new ArrayList<>(subjectList);
        copyList.sort(comp);

        int lastC = 0;
        int lastJ = 0;

        Map<Subject, String> map = new HashMap<>();
        for (Subject subject : copyList) {
            if (subject.start >= lastC) {
                map.put(subject, "C");
                lastC = subject.end;
                continue;
            }

            if (subject.start >= lastJ) {
                map.put(subject, "J");
                lastJ = subject.end;
                continue;
            }
            return "IMPOSSIBLE";
        }
        StringBuilder builder = new StringBuilder();
        for (Subject subject : subjectList) {
            builder.append(map.get(subject));
        }

        return builder.toString();
    }

    public static class Subject {
        int start;
        int end;

        public Subject(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
