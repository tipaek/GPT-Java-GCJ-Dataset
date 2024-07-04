/*****************************************************************************
 * Copyright (C) Compart AG, 2020  - Compart confidential
 *
 *****************************************************************************/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution  {

    public static void solve(int[][] arr, int cs) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            k += arr[i][i];
        }

        int rc = 0, cc = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < arr[0].length; j++) {
                if (set.contains(arr[i][j])) {
                    rc++;
                    break;
                } else {
                    set.add(arr[i][j]);
                }
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                //System.out.println(i+":"+j);
                if (set.contains(arr[j][i])) {
                    cc++;
                    break;
                } else {
                    set.add(arr[j][i]);
                }
            }
        }

        System.out.println("Case #" + cs + ": " + k + " " + rc + " " + cc);

    }

    public static void main(String[] args) {
        Scanner sc = null;
        //  try {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int cs = 0; cs < cases; cs++) {
            int n = in.nextInt();
            in.nextLine();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] numstr = in.nextLine().split(" ");
                int[] line = new int[n];
                for (int j = 0; j < numstr.length; j++) {
                    line[j] = Integer.parseInt(numstr[j]);
                    arr[i] = line;
                }
            }

            solve(arr, cs);
        }


        in.close();
        //}

    }
}

