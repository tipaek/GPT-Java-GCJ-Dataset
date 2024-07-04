import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scan.nextInt();
		
		for(int i=0;i<t;i++){
		    int n = scan.nextInt();
		    
		    if(n==2){
		    System.out.println("Case #"+(i+1)+": CJ");
		    }else{
		    int time[][] = new int[n][3];
		    for(int j=0;j<n;j++){
		        time[j][0] = scan.nextInt();
		        time[j][1] = scan.nextInt();
		        time[j][2] = j;
		    }
		    solve(time,n,i+1);
		    }
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
    
	
    private static void solve(int[][] time,int n,int t){
        int c_end=0;
        int j_end=0;
        
        int orig[][] = time;
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
                System.out.println("Case #"+t+": IMPOSSIBLE");
                return;
            }
        }
        System.out.print("Case #"+t+": ");
        
        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(i));
        }

        System.out.println();
		
	}
}