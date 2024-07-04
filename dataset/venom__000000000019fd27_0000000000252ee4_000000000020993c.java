import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int inc = 0;
        while(t-- !=0){
            inc++;
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int k = 0;
            int r = 0;
            int c = 0;
            int co = 0;
            int ro = 0;
            while(co != n && ro!=n){
                k+=arr[ro][co];
                co+=1;
                ro+=1;
            }
            for(int row= 0;row<n;row++){
                TreeSet<Integer> ts = new TreeSet<>();
                for(int col =0;col<n;col++){
                    ts.add(arr[row][col]);
                }
                if(ts.size() < n)
                    r++;
            }
            for(int col= 0;col<n;col++){
                TreeSet<Integer> tss = new TreeSet<>();
                for(int row =0;row<n;row++){
                        tss.add(arr[row][col]);
                }
                if(tss.size() < n)
                    c++;
            }
            System.out.println("Case #"+inc+":"+" "+k +" "+r+" "+c);
            
        }
    }
}