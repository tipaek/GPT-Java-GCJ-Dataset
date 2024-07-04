import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner sc) throws Exception {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) throws Exception {
        String[] in = sc.nextLine().split(" ");
        double l = Double.parseDouble(in[0]);
        double r = Double.parseDouble(in[1]);

        int i = 1;
        while (Math.max(l, r) >= i) {
            if (l >= r) {
                l -= i;
            } else {
                r -= i;
            }

            i++;
        }

        i--;

        printRes(caseNumber, String.format("%d",(long)i) + " " + String.format("%d",(long)l) + " " + String.format("%d",(long)r));
    }

    private static void printRes(int caseNumber, String res) {
        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + res);
    }
}
