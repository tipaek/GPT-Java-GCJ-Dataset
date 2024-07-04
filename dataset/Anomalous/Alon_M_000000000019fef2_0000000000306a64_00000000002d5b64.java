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
            int a = r - 1;
            int b = s - 1;

            int rConv = r * (s - 2) + r - 1;
            List<String> out = new ArrayList<>();
            
            for (int k = a; k > 0; k--) {
                for (int p = b; p > 0; p--) {
                    out.add(r + " " + rConv);
                    rConv--;
                }
                r--;
            }

            System.out.println("Case #" + (i + 1) + ": " + out.size());
            for (String str : out) {
                System.out.println(str);
            }
        }
    }
}