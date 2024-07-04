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
            System.out.println("Case #"+(i+1)+": "+solve(time,n));
		    
		}
	}
	
	private static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
          @Override              
          public int compare(final int[] entry1,  
                             final int[] entry2) { 

                return entry1[col] - entry2[col];
          } 
        });
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
        } char ch[] = new char[n];
        
        for(int i=0;i<n;i++){
            ch[time[i][2]] = s.charAt(i);
        }
        
        return new String(ch);
	}
}