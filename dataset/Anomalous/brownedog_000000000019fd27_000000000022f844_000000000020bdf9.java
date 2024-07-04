import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mat = new int[n][2];
            for (int j = 0; j < n; j++) {
                mat[j][0] = in.nextInt();
                mat[j][1] = in.nextInt();
            }

            String result = assignTasks(n, mat);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int n, int[][] mat) {
        ArrayList<Integer> cam = new ArrayList<>();
        ArrayList<Integer> jam = new ArrayList<>();
        cam.add(0);
        StringBuilder answer = new StringBuilder("C");

        for (int x = 1; x < n; x++) {
            if (!assignToPerson(x, mat, cam, jam, answer, 'C', 'J')) {
                return "IMPOSSIBLE";
            }
        }

        return answer.toString();
    }

    private static boolean assignToPerson(int x, int[][] mat, ArrayList<Integer> cam, ArrayList<Integer> jam, StringBuilder answer, char camChar, char jamChar) {
        for (Integer c : cam) {
            if (overlap(mat[x], mat[c])) {
                if (assignToOtherPerson(x, mat, jam, answer, jamChar)) {
                    return true;
                }
                return false;
            }
        }

        cam.add(x);
        answer.append(camChar);
        return true;
    }

    private static boolean assignToOtherPerson(int x, int[][] mat, ArrayList<Integer> other, StringBuilder answer, char otherChar) {
        for (Integer j : other) {
            if (overlap(mat[x], mat[j])) {
                return false;
            }
        }

        other.add(x);
        answer.append(otherChar);
        return true;
    }

    private static boolean overlap(int[] interval1, int[] interval2) {
        return !(interval1[1] <= interval2[0] || interval1[0] >= interval2[1]);
    }
}