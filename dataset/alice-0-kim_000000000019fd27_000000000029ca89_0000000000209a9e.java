import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt(); in.nextLine();
        for (int t = 1; t <= T; t++) {
            char[] A = new char[B];
            int cnt = 0;
            for (int i = 1; i <= B; i++) {
                if (i % 10 == 1) cnt++;
                System.out.println(i);
                A[i-1] = in.nextInt() == 0 ? '0' : '1';
            }
            in.nextLine();
            // Case 1: No change
            System.out.println(new String(A));
            if (in.nextLine().contains("Y")) continue;
            // Case 2: Complementary
            char[] C = A.clone();
            for (int i = 0; i < C.length; i++)
                C[i] = C[i] == '0' ? '1' : '0';
            System.out.println(new String(C));
            if (in.nextLine().contains("Y")) continue;
            // Case 3: Reverse
            char[] R = A.clone();
            for (int l = 0, r = R.length - 1; l < r; l++, r--) {
                char tmp = R[l];
                R[l] = R[r];
                R[r] = tmp;
            }
            System.out.println(new String(R));
            if (in.nextLine().contains("Y")) continue;
            // Case 4: Complementary & Reverse
            for (int i = 0; i < R.length; i++)
                R[i] = R[i] == '0' ? '1' : '0';
            System.out.println(new String(R));
            if (in.nextLine().contains("Y")) continue;

            ///
            
            char[] Z = new char[10];
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                Z[i-1] = in.nextInt() == 0 ? '0' : '1';
            }
            in.nextLine();

            // Case 1: No change
            char[] O = A.clone();
            for (int i = 0; i < 10; i++) O[i] = Z[i];
            System.out.println(new String(O));
            if (in.nextLine().contains("Y")) continue;
            // Case 2: Complementary
            C = O.clone();
            for (int i = 0; i < C.length; i++)
                C[i] = C[i] == '0' ? '1' : '0';
            System.out.println(new String(C));
            if (in.nextLine().contains("Y")) continue;
            // Case 3: Reverse
            R = O.clone();
            for (int l = 0, r = R.length - 1; l < r; l++, r--) {
                char tmp = R[l];
                R[l] = R[r];
                R[r] = tmp;
            }
            System.out.println(new String(R));
            if (in.nextLine().contains("Y")) continue;
            // Case 4: Complementary & Reverse
            for (int i = 0; i < R.length; i++)
                R[i] = R[i] == '0' ? '1' : '0';
            System.out.println(new String(R));
            if (in.nextLine().contains("Y")) continue;
        }
    }
}