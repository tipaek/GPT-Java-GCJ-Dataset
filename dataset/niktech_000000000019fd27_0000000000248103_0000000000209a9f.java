
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i=1; i<= t; i++) {
            System.out.print("Case #" + i + ": ");
            int open = 0;
            String s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                int si = Integer.parseInt(String.valueOf(s.charAt(j)));
                while (open < si) {
                    System.out.print("(");
                    open++;
                }
                while (open > si) {
                    System.out.print(")");
                    open--;
                }
                System.out.print(si);
            }
            while(open > 0) {
                open--;
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
