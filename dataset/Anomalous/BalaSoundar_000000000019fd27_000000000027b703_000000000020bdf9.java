import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            int totalActivity = sc.nextInt();
            sc.nextLine();
            int[][] input = new int[totalActivity][2];
            for (int k = 0; k < totalActivity; k++) {
                String[] inputArr = sc.nextLine().split(" ");
                input[k][0] = Integer.parseInt(inputArr[0]);
                input[k][1] = Integer.parseInt(inputArr[1]);
            }
            performCalculation(input, i);
        }
    }

    private static void performCalculation(int[][] input, int testcase) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> CSet = new HashSet<>();
        Set<Integer> JSet = new HashSet<>();
        boolean isCSelected = true;

        for (int[] activity : input) {
            isCSelected = true;
            for (int j = activity[0]; j < activity[1]; j++) {
                if (CSet.contains(j)) {
                    if (JSet.contains(j)) {
                        System.out.println("Case #" + (testcase + 1) + ": IMPOSSIBLE");
                        return;
                    }
                    isCSelected = false;
                }
            }
            for (int j = activity[0]; j < activity[1]; j++) {
                if (isCSelected) {
                    CSet.add(j);
                } else {
                    JSet.add(j);
                }
            }
            sb.append(isCSelected ? "C" : "J");
        }

        System.out.println("Case #" + (testcase + 1) + ": " + sb.toString());
    }
}