/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution {
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int k =0 ; k < T ; k++ ){
            int N = sc.nextInt();
            int [][]arr = new int[N][N];
            
            //ArrayInput
            for(int i =0 ; i < N; i++){
                for(int j =0; j <N; j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            //trace
            int trace =0;
            for(int i =0; i < N; i++){
                trace += arr[i][i];
            }
            
            //row check
            int row=0;
            Set<Integer> set; 
            for(int i =0; i < N; i++){
                set = new HashSet<Integer>();
                for(int j =0 ; j <N ; j++){
                    if(set.contains(arr[i][j])){
                        row++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }
            
            //column
            int col=0;
            for(int j =0; j < N; j++){
                set = new HashSet<Integer>();
                for(int i =0 ; i <N ; i++){
                    if(set.contains(arr[i][j])){
                        col++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }
            
            int caseValue = k+1;
            System.out.println("Case #"+ caseValue +": " + trace +" "+ row + " " +  col);
        }
	}
}
