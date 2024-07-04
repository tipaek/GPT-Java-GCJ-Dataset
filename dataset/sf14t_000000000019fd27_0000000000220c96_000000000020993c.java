import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String arsg[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int n=input.nextInt();
            int arr[][]=new int[n][n];
            int trace=0,col=0,row=0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    arr[i][j]=input.nextInt();
                    if(i==j) {
                        trace+=arr[i][j];
                    }
                }
            }
            boolean check_arr[];
            for(int i=0;i<n;i++) {
                check_arr=new boolean[n+1];
                for(int j=0;j<n;j++) {
                    if(!check_arr[arr[i][j]]) {
                        check_arr[arr[i][j]]=true;
                    }
                    else {
                        row++;
                        break;
                    }
                }
                check_arr=new boolean[n+1];
                for(int j=0;j<n;j++) {
                    if(!check_arr[arr[j][i]]) {
                        check_arr[arr[j][i]]=true;
                    }
                    else {
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
        }
    }
}
