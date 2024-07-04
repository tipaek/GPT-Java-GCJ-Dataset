/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays; 

/* Name of the class has to be "Main" only if the class is public. */
//class Ideone{
public class Solution {
    public static void swap(int a[][], int i, int j){
        int temp;
    
        temp = a[i][0];
        a[i][0] = a[j][0];
        a[j][0] = temp;

        temp = a[i][1];
        a[i][1] = a[j][1];
        a[j][1] = temp;
        temp = a[i][2];
        a[i][2] = a[j][2];
        a[j][2] = temp;
        return;
    }
    
    
    public static int partition_n_lomuto(int a[][], int p, int r){
        int i, j, x;
        
        i = p - 1;
        x = r;
        for(j = p;j <= r;j++){
            if(a[x][0] >= a[j][0]){
                i++;
                swap(a, j, i);
            }
        }
        return(i);
    }
    
    
    public static void quick_sort(int a[][], int p, int r){
        int q, i;
        
        if(p < r){
            q = partition_n_lomuto(a, p, r);
            quick_sort(a, p, q - 1);
            quick_sort(a, q + 1, r);
        }
        
        return;
    }
    public static String checkPossible(int arr[][], int C, int J, int cur,int n, String s){
        if(cur > n){
            return(s);
        }
        String temp = "";
        if(arr[cur][0] >= C){
            temp = checkPossible(arr, arr[cur][1], J, cur+1, n, s+"C");
            if(!"-1".equals(temp)){
                return(temp);
            }
        }
        if(arr[cur][0] >= J){
            temp = checkPossible(arr, C, arr[cur][1], cur+1, n, s+"J");
            if(!"-1".equals(temp)){
                return(temp);
            }
        }
        s = "-1";
        return(s);
    }
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n+1][3];
            for(int j = 1;j <= n;j++){
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
                arr[j][2] = j;
            }
            for(int j = 1;j <= n;j++){
                ///System.out.println(arr[j][0]+" "+arr[j][1]);
            }
            quick_sort(arr, 1, n);
            for(int j = 1;j <= n;j++){
               // System.out.println(arr[j][0]+" "+arr[j][1]);
            }
            int C = 0;
            int J = 0;
            String s = "";
            s = checkPossible(arr, C, J, 1, n, s);
            if("-1".equals(s)){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }else{
                String ans = "";
                char[] c = new char[n+1];
                for(int j=0;j <n;j++){
                    c[arr[j+1][2]] = s.charAt(j);
                }
                System.out.print("Case #" + i + ": ");
                for(int j=1;j <= n;j++){
                    System.out.print(c[j]);
                }
                System.out.println();
            }
            
        }
    }
}