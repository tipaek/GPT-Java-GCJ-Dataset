import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        int[][] inputCollector = new int[t][2];
        for (int i = 0; i < t; i++) {
            String[] lineParsed = scanner.nextLine().split(" ");
            inputCollector[i] = Arrays.stream(lineParsed).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < t; i++) {
            int r = inputCollector[i][0];
            int s = inputCollector[i][1];
            int counter = 0;
            List<String> out = new ArrayList<>();

            int rConv = r * (s - 1) - 1;
            for (int k = r - 1; k > 0; k--) {
                for (int p = s - 1; p > 0; p--) {
                    out.add(r + " " + rConv);
                    rConv--;
                    counter++;
                }
                r--;
            }

            System.out.println("Case #" + (i + 1) + ": " + counter);
            for (String str : out) {
                System.out.println(str);
            }
        }
    }
}