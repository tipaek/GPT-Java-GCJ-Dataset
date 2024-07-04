import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    private static int T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i=0; i<T; i++) {
            String N = sc.next();

            String sol = "";
            int cur = Integer.parseInt(N.substring(0,1));
            for (int j=0; j<cur; j++)
                sol += "(";
            sol += Integer.toString(cur);

            for (int j=1; j<N.length(); j++) {
                int temp = Integer.parseInt(N.substring(j,j+1));

                for (int k=0; k<temp-cur; k++)
                    sol += "(";
                for (int k=0; k<cur-temp; k++)
                    sol += ")";
                cur = temp;
                sol += Integer.toString(cur);
            }

            for (int j=0; j<cur; j++)
                sol += ")";

            System.out.println("Case #" + (i+1) + ": " + sol);
        }
    }
}
