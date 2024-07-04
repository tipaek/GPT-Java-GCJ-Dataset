import java.util.Scanner;
import java.lang.System;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int check1 = 0,check2 = 0,count1 = 0,count2 = 0,sum = 0;
        for(int m = 1; m <= t; m++) {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    arr[i][j]=sc.nextInt();
                    if(i==j) {
                        sum=sum+arr[i][j];
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < n; k++) {
                        if (arr[i][j] == arr[k][j]) {
                            check1++;
                        }
                    }
                    if(check1>0) {
                        count1++;
                    }
                    for (int k = 0; k < m; k++) { 
                        if (arr[i][j] == arr[i][k]) {
                            check2++;
                        }
                    }
                    if(check2>0) {
                        count2++;
                    }
                }
                check1=0;
                check2=0;
            }
            System.out.println("Case #"+m+": "+sum+" "+count1+" "+count2);
        }
        System.exit(0);
    }
}