import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scan.nextInt();
		
		for(int i=0;i<t;i++){
		    int n = scan.nextInt();
		    
		    int time[][] = new int[n][3];
		    for(int j=0;j<n;j++){
		        time[j][0] = scan.nextInt();
		        time[j][1] = scan.nextInt();
		        time[j][2] = j;
		    }
		    String ans = solve(time,n);
            System.out.println("Case #"+(i+1)+": "+ans);
		    
		}

	}
	
	private static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
    
	
    private static String solve(int[][] time,int n){
        int c_end=0;
        int j_end=0;
        
        sortbyColumn(time,0); 
        
        c_end = time[0][1];
        String s = "C";
        
        for(int i=1;i<n;i++){
            if(time[i][0]>=c_end){
                s = s + "C";
                c_end = time[i][1];
            }else if(time[i][0]>=j_end){
                s = s+ "J";
                j_end = time[i][1];
            }else{
                String a = "IMPOSSIBLE";
               return a;
            }
        }
        String ans = "";
        for(int i=0;i<n;i++){
            ans=ans +s.charAt(time[i][2]);
        }
        return ans;
	}
}