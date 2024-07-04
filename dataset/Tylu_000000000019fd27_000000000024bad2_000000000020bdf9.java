import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int ca = 1; ca <= t; ++ca) {
            int availableC = -1;
            int availableJ = -1;

            int tasksSize = in.nextInt();
            List<int[]> tasks = new ArrayList<>();
            String[] output = new String[tasksSize];

            for (int i = 0; i < tasksSize; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                tasks.add(new int[]{start, end, i});
            }

            List<int[]> sorted = tasks.stream()
                    .sorted((o1, o2) -> o1[0] < o2[0] ? -1 : 1)
                    .collect(Collectors.toList());

            print(ca, availableC, availableJ, output, sorted);
        }
    }

    private static void print(int ca, int availableC, int availableJ, String[] output, List<int[]> sorted) {
        for (int[] x : sorted) {
            if (availableC <= x[0]) {
                output[x[2]] = "C";
                availableC = x[1];
            } else if (availableJ <= x[0]) {
                output[x[2]] = "J";
                availableJ = x[1];
            } else {
                System.out.println("Case #" + ca + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + ca + ": " + String.join("", output));
    }


}
  