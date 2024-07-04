import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static void handleIO(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            String line = inputReader.nextLine();
            String output = solve(line.trim());
            System.out.println(String.format("Case #%d: %s\n", (i + 1), output));
        }
    }

//    private static void handleList(Scanner scanner) {
//        Scanner inputReader = scanner;
//        int numTestCases = Integer.parseInt(inputReader.nextLine());
//        for (int i = 0; i < numTestCases; ++i) {
//            int numLines = Integer.parseInt(inputReader.nextLine());
//            List<String> lines = new ArrayList<>();
//            for (int j=0; j<numLines; ++j) {
//                lines.add(inputReader.nextLine().trim());
//            }
//            int output = 0; //solve(lines);
//            System.out.print(String.format("Case #%d: %d\n", (i + 1), output));
//        }
//    }
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
        handleIO((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "4\n" +
                "0000\n" +
                "101\n" +
                "111000\n" +
                "1";
        handleIO(new Scanner(input));
    }

    public static String solve(String digits) {
        StringBuilder sb = new StringBuilder(digits);
        for (int i=1; i<=9; ++i) {
            for (int j=0; j<sb.length(); ++j) {
                if (sb.charAt(j) - '0' == i) {
                    if (findBoundaries(sb, j)) {
                        i--;
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void insertParens(StringBuilder sb, int si, int ei, int n) {
        for (int i=0; i<n; ++i)
            sb.insert(ei, ")");
        for (int i=0; i<n; ++i)
            sb.insert(si, "(");
    }

    public static int findNumParensAround(StringBuilder sb, int idx) {
        int np = 0;
        for (int i=0; i<idx; ++i) {
            if (sb.charAt(i) == '(') np++;
            else if (sb.charAt(i) == ')') np--;
        }
        return np;
    }

    public static boolean findBoundaries(StringBuilder sb, int charIdx) {
        int numParensToAdd = (sb.charAt(charIdx) - '0') - findNumParensAround(sb, charIdx);
        if (numParensToAdd <= 0) return false;

        int val = sb.charAt(charIdx) - '0';
        int si = charIdx, ei = charIdx;
        while (si >= 0 && (!Character.isDigit(sb.charAt(si)) || sb.charAt(si) - '0' >= val)) {
            si--;
        }
        si++;
        while (sb.charAt(si) == ')') {
            si++;
        }

        while (ei < sb.length() && (!Character.isDigit(sb.charAt(ei)) || sb.charAt(ei) - '0' >= val)) {
            ei++;
        }
        while (sb.charAt(ei - 1) == '(') {
            ei--;
        }

        insertParens(sb, si, ei, numParensToAdd);
        return true;
    }
}
// (1(2))   ((((4))22)1)
// ((((4))22)1)

// ((422)1)
// (1(224))

// (1(2)1)