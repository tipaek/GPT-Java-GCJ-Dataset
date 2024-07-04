import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
    public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override
          public int compare(final int[] entry1,  
                             final int[] entry2) {
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
    }
    public static void sortbyColumnString(String arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<String[]>() { 
            
          @Override
          public int compare(final String[] entry1,  
                             final String[] entry2) {
            if (Integer.parseInt(entry1[col]) > Integer.parseInt(entry2[col])) 
                return 1; 
            else
                return -1; 
          } 
        });
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt();
        for(int l = 1; l<=T;l++) {
            int N = sc.nextInt();
            int i;
            int[][] values = new int[N][3];
            for (i = 0; i<N;i++) {
                values[i][0] = sc.nextInt();
                values[i][1] = sc.nextInt();
                values[i][2] = i + 1;
            }
            sortbyColumn(values,0);
            String[][] ans = new String[N][2];
            int C = 0,J = 0,anss=0;
            int cTime = 0, jTime = 0;
            for(i = 0; i<N; i++) {
                ans[i][0] = values[i][2] + "";
                if(values[i][0]>=cTime) {
                    C = 0;
                }
                if(values[i][0]>= jTime) {
                    J = 0;
                }
                if  (C == 0) {
                    ans[i][1] = "C";
                    C = 1;
                    cTime = values[i][1];
                }
                else if (J == 0) {
                    ans[i][1] = "J";
                    J = 1;
                    jTime = values[i][1];
                }
                else{
                    System.out.println("Case #"+l+": IMPOSSIBLE");
                    anss = 1;
                    break;
                }
            }
            if(anss != 1) {
                sortbyColumnString(ans,0);
                String S = "";
                for(i = 0;i<N;i++){
                    S += ans[i][1];
                }
                System.out.println("Case #"+l+": "+S);
            }
        }
	}
}
