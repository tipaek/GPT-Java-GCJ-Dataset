import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws FileNotFoundException {
        //in = new Scanner(Vestigium.class.getResourceAsStream("file.in"));
        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            in.nextLine();;

            int trace = 0;
            int[] sumR = new int[N];
            int[] sumC = new int[N];
            int[] multR = new int[N];
            int[] multC = new int[N];

            Arrays.fill(multR, 1);
            Arrays.fill(multC, 1);

            int totalSum = 0;
            int totalMult = 1;
            for (int i = 1; i <= N; i++) {
                totalSum += i;
                totalMult *= i;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = in.nextInt();
                    sumR[i] += value;
                    sumC[j] += value;
                    multR[i] *= value;
                    multC[j] *= value;
                    if (i == j) {
                        trace += value;
                    }
                }
                if (in.hasNextLine()) {
                    in.nextLine();
                }
            }

            int r = 0, c = 0;
            for (int i = 0; i < N; i++) {
                if (sumR[i] != totalSum || multR[i] != totalMult) {
                    r++;
                }
                if (sumC[i] != totalSum || multC[i] != totalMult) {
                    c++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
        }
    }

}
