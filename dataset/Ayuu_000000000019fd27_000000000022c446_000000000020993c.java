import java.util.Scanner;
import java.lang.System;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int check1 = 0,check2 = 0,sum = 0;
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
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    for(int k = 1; k <= n; k++) {
                        if (arr[i][j] == arr[k][j]) {
                            check1++;
                            break;
                        }
                    }
                    for (int k = 1; k <= n; k++) { 
                        if (arr[i][j] == arr[i][k]) {
                            check2++;
                            break;
                        }
                    }
                    break;
                }
                System.out.println("Case #"+i+": "+sum+" "+check1+" "+check2);
                check1=0;
                check2=0;
            }
        }
        System.exit(0);
    }
}