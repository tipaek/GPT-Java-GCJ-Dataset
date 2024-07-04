
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet; 

public class Solution {
	
	 
    
    
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();//take n
            
            int[][] arr = new int[n][n];
            int trace = 0;
            int rows = 0;
            int cols = 0;
            
            for (int i=0;i<n;i++){
                HashSet<Integer> set = new HashSet<Integer>();
                for (int j=0;j<n;j++){
                    
                    int a = in.nextInt();
                    arr[i][j]=a;
                    
                    if (i==j){
                        trace=trace+a;
                    }
                    set.add(a);
                }
                
                if ((set.size())!=n){
                    rows++;
                }
            }
            
            for (int j=0;j<n;j++){
                
                 HashSet<Integer> setc = new HashSet<Integer>();
                
                for (int i=0;i<n;i++){
                    int num = arr[i][j];
                    setc.add(num);
                }
                
                if ((setc.size())!=n){
                    cols++;
                }
            }
            
            
            System.out.println("Case #" + k + ": " + trace+" "+rows+" "+cols);
        	
          
        }
      }
      
      
    }