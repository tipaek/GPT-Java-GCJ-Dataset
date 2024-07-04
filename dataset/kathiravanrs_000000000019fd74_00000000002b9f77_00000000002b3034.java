import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        String out = "";
        for (int i = 0; i < t; i++) {
            String ans = "";
            String regAns = "";
            int n = scanner.nextInt();
            String waste = scanner.nextLine();
            String first = "";
            String last = "";
            boolean val = false;
            for (int j = 0; j < n; j++) {
                String reg = scanner.nextLine();
                if (reg.indexOf("*") == 0) {
                    first = reg.substring(1);

                }
                if (reg.indexOf("*") == reg.length() - 1) {
                    last = reg.substring(0, reg.length() - 1);
                }
                String[] cases = reg.split("\\*");
                for (String case1 : cases) {
                    if (j == 0) regAns = case1;
                    else {
                        if (case1.contains(regAns)) {
                            regAns = case1;
                            val = true;
                        } else if (regAns.contains(case1)) {

                        } else {
                            regAns = "*";
                            break;
                        }
                    }
                }
            }
            if (!val&&(!first.equals(""))&&(!last.equals(""))) {
                regAns = last+first;
            }
            out = out + ("Case #" + (i + 1) + ": " + regAns + "\n");
        }
        System.out.print(out);
        scanner.close();
    }
}
