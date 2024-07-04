import java.io.*;
import java.util.*;
public class Solution{
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int tot = t;
    while(t-->0) {
    	int n = sc.nextInt();
    	int count = 0;
    	boolean a[] = new boolean[n];
    	Arrays.fill(a, false);
    	int[][] times = new int[n][3];
    	String[] person = new String[n];
    	for(int i=0; i<n; i++) {
    		times[i][0] = sc.nextInt();
    		times[i][1] = sc.nextInt();
    		times[i][2] = i;
    	}
    	int end = 0;
    	ColumnSort(times,0);
    	for(int i=0; i<n; i++) {
    		if(times[i][0]>=end) {
    			count++;
    			person[i] = "C";
    			end = times[i][1];
    			a[i] = true;
    		}
    	}
    	end = 0;
    	for(int i=0; i<n; i++) {
    		if(times[i][0]>=end&&!a[i]) {
    			count++;
    			person[i] = "J";
    			end = times[i][1];
    		}
    	}
    	System.out.print("Case #"+(tot-t)+": " );
    	if(count!=n) {
    		System.out.print("IMPOSSIBLE");
    	}else {
    		for(int i=0; i<n; i++) {
    			System.out.print(person[times[i][2]]);
    		}
    	}
    	System.out.print("\n");
    }
    sc.close();
  }
  public static void ColumnSort(int arr[][], int col) { 
      Arrays.sort(arr, new Comparator<int[]>() { 
          @Override 
        public int compare(int[] entry1,  
                           int[] entry2) { 
          	Integer a = entry1[col];
          	Integer b = entry2[col];
          	return a.compareTo(b);
        } 
      }); 
  } 
}