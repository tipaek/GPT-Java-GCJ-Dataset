import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testcase = 1; testcase<=T; testcase++)
        {
            boolean success = true;
            int N = sc.nextInt();
            sc.nextLine();
            String[] P = new String[N];
            StringBuilder result = new StringBuilder();
            for (int i = 0; i<N; i++)
            {
                P[i]= sc.nextLine();
            }
            Arrays.sort(P, Comparator.comparingInt(String::length));
            for (int i = 0; i<N-1; i++)
            {
                String small = P[i];
                String large = P[i+1];
                int diff = large.length() - small.length();
                if (!(small.substring(1).equals(large.substring(diff+1))))
                {success=false; break;}

            }
            result = new StringBuilder(P[P.length-1].substring(1));

            if(!success)
                result = new StringBuilder("*");
            System.out.printf("Case #%d: %s\n",testcase,result);
        }
    }
}
