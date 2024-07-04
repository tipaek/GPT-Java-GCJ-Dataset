import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

//    private static void handleIO(Scanner inputReader) {
//        int numTestCases = Integer.parseInt(inputReader.nextLine());
//        for (int i = 0; i < numTestCases; ++i) {
//            String line = inputReader.nextLine();
//            String output = solve(line.trim());
//            System.out.println(String.format("Case #%d: %s\n", (i + 1), output));
//        }
//    }

    private static void handleList(Scanner scanner) {
        Scanner inputReader = scanner;
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            int numLines = Integer.parseInt(inputReader.nextLine());
            List<Activity> lines = new ArrayList<>();
            for (int j=0; j<numLines; ++j) {
                String[] s = inputReader.nextLine().trim().split(" ");
                Activity a = new Activity(Integer.parseInt(s[0]), Integer.parseInt(s[1]), j);
                lines.add(a);
            }
            String output = solve(lines);
            System.out.print(String.format("Case #%d: %s\n", (i + 1), output));
        }
    }
//
//    public static void handleMatrix(Scanner inputReader) {
//        int numTestCases = Integer.parseInt(inputReader.nextLine());
//        for (int i = 0; i < numTestCases; ++i) {
//            int numLines = Integer.parseInt(inputReader.nextLine());
//            int[][] matrix = new int[numLines][numLines];
//            for (int j=0; j<numLines; ++j) {
//                matrix[j] = Arrays.stream(inputReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            }
//            String output = solve(matrix);
//            System.out.print(String.format("Case #%d: %s\n", (i + 1), output));
//        }
//    }

    public static void main(String[] args) {
        handleList((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "4\n" +
                "3\n" +
                "360 480\n" +
                "420 540\n" +
                "600 660\n" +
                "3\n" +
                "0 1440\n" +
                "1 3\n" +
                "2 4\n" +
                "5\n" +
                "99 150\n" +
                "1 100\n" +
                "100 301\n" +
                "2 5\n" +
                "150 250\n" +
                "2\n" +
                "0 720\n" +
                "720 1440";
        handleList(new Scanner(input));
    }

    public static String solve(List<Activity> activities) {
        Collections.sort(activities);
        int clt = 0, jlt = 0;
        char[] ret = new char[activities.size()];
        for (Activity a : activities) {
            if (a.st >= clt) {
                clt = a.et;
                ret[a.id] = 'C';
            }
            else if (a.st >= jlt) {
                jlt = a.et;
                ret[a.id] = 'J';
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return new String(ret);
    }
}

class Activity implements Comparable<Activity> {
    int st;
    int et;
    int id;

    public Activity(int st, int et, int id) {
        this.st = st;
        this.et = et;
        this.id = id;
    }

    @Override
    public int compareTo(Activity a) {
        int stc = Integer.compare(this.st, a.st);
        return stc == 0 ? Integer.compare(this.et, a.et) : stc;
    }
}