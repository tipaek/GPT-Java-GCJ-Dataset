import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws FileNotFoundException {

        //in = new Scanner(OverexcitedFan.class.getResourceAsStream("file.in"));

        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            char[] M = in.nextLine().trim().toCharArray();
            boolean found = false;
            for (int i = 1; i <= M.length; i++) {
                switch (M[i - 1]) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }

                if (Math.abs(X) + Math.abs(Y) <= i) {
                    System.out.println("Case #" + t + ": " + i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

}
