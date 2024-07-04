import java.util.*;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        int i, j, t;
        final int d = 0;
        final int e = 1;
        final int f = 2;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int res[][] = new int[t][3];
        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            sc.nextLine();
            int a[][] = new int[n][n];
            for (i = 0; i < n; i++) {
                String input = sc.nextLine();
                for (j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(String.valueOf(input.charAt(j*2)));
                    if (i == j) {
                        res[x][d]+=a[i][j];
                    }
                }
            }
            for (i = 0; i < n; i++) {
                int flag = 0;
                for (j = 0; j < n - 1; j++) {
                    if (a[i][0] == a[i][j + 1])
                        flag++;
                }if(flag!=0)
                    res[t][f]++;
            }
            for (i = 0; i < n; i++) {
                int flag = 0;
                for (j = 0; j < n - 1; j++) {
                    if (a[0][i] == a[j + 1][0])
                        flag++;
                }if(flag!=0)
                {
                    res[t][f]++;
                }
            }
        }
        for(int x=0;x<t;x++)
        {
            System.out.println("case #"+(x+1)+": "+res[x][d]+" "+res[x][e]+" "+res[x][f]);
        }
    }
}