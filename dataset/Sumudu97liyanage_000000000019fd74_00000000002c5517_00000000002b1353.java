import java.util.*;
import java.io.*;


    public class Solution {
        
         static void printPascal(int n,int tot) 
    { 
          
    // Iterate through every line 
    // and print entries in it 
        for (int line = 0; line < n; line++) 
        { 
            // Every line has number of  
            // integers equal to line number 
            for (int i = 0; i <= line; i++){ 
                int n1 = binomialCoeff (line, i);
                tot = tot-n1;
                if (tot>=0){
					 System.out.println((line+1)+" "+(i+1));                  
				}
				else{
					tot=tot+n1;
				}
				

                
                if (tot==0){
                    break;
                }
               
            }
            if (tot==0){
                break;
            }
            n=n+1;
        } 
    } 
      
    // Link for details of this function 
    // https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/ 
    static int binomialCoeff(int n, int k) 
    { 
        int res = 1; 
          
        if (k > n - k) 
        k = n - k; 
              
        for (int i = 0; i < k; ++i) 
        { 
            res *= (n - i); 
            res /= (i + 1); 
        } 
        return res; 
    } 
		
	public static void solve(int n,int t){
	    
	     //for the output
	     System.out.println("Case #" + t + ": ");
	     
	     printPascal(2,n);
	}
		
		
    public static void main(String[] args) {
		  
		  
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int j = 1; j <= t; ++j) {
			
			
          int n = in.nextInt();
         
          
          solve(n,j);
         
        }
      }
    }
