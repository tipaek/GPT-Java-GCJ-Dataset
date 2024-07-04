import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = scanner.nextInt();
        String buff = scanner.nextLine();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String in = scanner.nextLine();
            StringBuilder res = new StringBuilder();
            int left = 0;
            for (String a : in.split("")) {
                int val = Integer.parseInt(a);
                if (val > left) {
                    for(int j=0;j<val-left;j++) {
                        res.append("(");
                    }
                }
                if (val < left) {
                    for(int j=0;j<left-val;j++) {
                        res.append(")");
                    }
                }
                left=val;
                res.append(val);
            }
            for(int j=0;j<left;j++) {
                res.append(")");
            }

            out.append("Case #").append(i+1).append(": ").append(res).append("\n");
        }
        System.out.print(out);
    }
}
