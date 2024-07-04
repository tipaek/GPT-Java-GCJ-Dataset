
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; i++) {
            int[][] input = readPairs(in);
            String[] answer = solve(input);

            System.out.println("Case #" + i + ": " + (String.join(" ", answer)));
        }
    }

    static String[] solve(int[][] a) {
        int startTimeInd = 0;
        int endTimeInd = 1;
        int indexInd = 2;
        int personInd = 3;

        List<String> result = new ArrayList<>(a.length);

        // sort by start time
        Arrays.sort(a, Comparator.comparing(i -> i[startTimeInd]));

        int previousTimeC = -1;
        int previousTimeJ = -1;
        for (int[] aa : a) {
            if (previousTimeC == -1 || previousTimeC <= aa[0]) {
                previousTimeC = aa[endTimeInd];
                aa[personInd] = 0;
            } else if (previousTimeJ == -1 || previousTimeJ <= aa[0]) {
                previousTimeJ = aa[endTimeInd];
                aa[personInd] = 1;
            } else {
                // impossible
                return new String[] { "IMPOSSIBLE" } ;
            }
        }

        Arrays.sort(a, Comparator.comparing( i -> i[indexInd]));

        for(int[] aa: a) {
            result.add(aa[personInd] == 0  ?  "C" : "J");
        }

        return new String[] { String.join("", result) };
    }

    private static int[][] readPairs(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            String line = in.nextLine();
            int[] l = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            a[i] = new int[] {l[0], l[1], i, 0}; // start, end, index, person
        }
        return a;
    }

    private static String[] convertIntArrayToString(int[] a) {
        return new String[] { String.join("", Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining())) };
    }

    private static int[] toIntArray(String line) {
        String[] a = line.split("");
        return Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
    }
}

