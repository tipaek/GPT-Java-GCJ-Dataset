import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int ca = 1; ca <= t; ++ca) {
            int opened = 0;
            StringBuilder output = new StringBuilder();
            List<Integer> list = Arrays.stream(in.next().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int d = 0; d < list.size(); d++) {
                int n = list.get(d);
                for (int i = 0; i < n - opened; i++) {
                    output.append("(");
                }
                for (int i = 0; i < opened - n; i++) {
                    output.append(")");
                }
                opened = n;
                output.append(n);
            }
            for (int i = 0; i < opened; i++) {
                output.append(")");
            }

            System.out.println("Case #" + ca + ": " + output.toString());
        }
    }


}
  