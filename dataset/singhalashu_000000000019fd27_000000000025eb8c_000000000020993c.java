import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int rem = 0;
        
        for(int test_case = 0; test_case < t; test_case++){
            rem++;
            int n = scan.nextInt();
            long k = 0; 
            int r = 0, c = 0;
            int ar[][] = new int[n][n];
            
            for(int i = 0; i < n; i++){
                HashSet<Integer> h = new HashSet<Integer>();
                boolean flg = true;
                for(int j = 0;j < n; j++){
                    ar[i][j] = scan.nextInt();
                    if(h.contains(ar[i][j]) && flg){
                        r++;
                        flg =  false;
                    }
                    h.add(ar[i][j]);
                }
            }
            
            for(int i=0;i<n;i++){
                HashSet<Integer> h = new HashSet<Integer>();
                boolean flg = true;
                for(int j=0;j<n;j++){
                    if(h.contains(ar[j][i]) && flg){
                        c++;
                        flg =  false;
                    }
                    h.add(ar[j][i]);
                    if(i == j){
                        k += ar[j][i];
                    }
                }
            }
            
            System.out.println("Case #"+rem+": "+k+" "+r+" "+c);
        }
    }
}