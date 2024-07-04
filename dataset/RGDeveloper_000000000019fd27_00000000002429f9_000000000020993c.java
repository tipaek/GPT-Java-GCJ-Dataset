import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String args[])
    {	
        try{
            // Input the number of test cases you want to run
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int caseN0 = 1;
            
            while (t > 0)
            {
                // variables declarations
                int n = sc.nextInt();
                
                int[][] matrix = new int[n][n];
                int trace = 0;
                int r = 0, c = 0;
                Set<Integer> hash_Set = new HashSet<Integer>(); 
                
                // create matrix using user's inpur
                for(int row=0; row < n; row++){
                    for(int col=0; col < n; col++){
                        matrix[row][col] = sc.nextInt();
                        // used to calculate number of repeated element in row
                        hash_Set.add(matrix[row][col]);
                    }
                    if(hash_Set.size() != n)
                        r++;   
                    hash_Set.clear();
                }
                
                // calculate trace
                for(int count=0; count < n; count++){
                    trace += matrix[count][count];
                }
                
                // calculate number of columns of repeated element
                 hash_Set.clear();
                 
                for(int row=0; row < n; row++){
                    for(int col=0; col < n; col++){
                         hash_Set.add(matrix[col][row]);
                    }
                    if(hash_Set.size() != n)
                        c++;   
                    hash_Set.clear();
                }
                
                // display output
                System.out.println("Case #" + caseN0 + ": " + trace + " " + r + " " + c);
                t--;
                caseN0++;
            }
        }
        catch(Exception e) {
            System.out.println("Error" + e);
        }
    }  
}
