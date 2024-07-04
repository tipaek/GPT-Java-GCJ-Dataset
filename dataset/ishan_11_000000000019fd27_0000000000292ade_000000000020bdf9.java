
import java.util.*;



public class Solution {
	
	public static String check(int[][] arr, int l) {
		if (l==1) {
			return "C";
		}
		String updated = "";
		updated = updated + "C";
		int[] c = new int[2];
		c= arr[0];
		int[] j = new int[2];
		j[0]= 0;
		j[1] = 0;
		int i=1;
		while (i<l) {
			if (arr[i][0] >= c[1]) {
				c=arr[i];
				updated = updated + "C";
			}
			else {
				if (j[1] <= arr[i][0]) {
					j=arr[i];
					updated = updated + "J";
				}
				else {
					return "IMPOSSIBLE";
				}
			}
			
			
			/*if (arr[i][0] <c[1] && arr[i][0] < j[1] )
				return "IMPOSSIBLE";
			else if (arr[i][0] >= c[1]) {
				c=arr[i];
				updated = updated + "C";
			}
			else if (arr[i][0] >= j[1]) {
				j=arr[i];
				updated = updated + "J";
			}*/
			i++;
		}
		return updated;
		
		
	}
	
	public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
   
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });   
    } 
	
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		int n = m.nextInt();
		for (int i=0; i<n;i++) {
			int a = m.nextInt();
			int[][] arr = new int[a][3];
			for (int j=0; j<a;j++) {
				arr[j][0] = m.nextInt();
				arr[j][1] = m.nextInt();
				arr[j][2] = j;
			}
			sortbyColumn(arr,0);
			String ans = check(arr,a);
			if (ans == "IMPOSSIBLE")
				System.out.println(("Case #" + (i+1) + ": " + check(arr,a)));
			else {
				char[] ar = new char[a];
				for (int j=0; j<a; j++) {
					int ind = arr[j][2];
					ar[ind] = ans.charAt(j);
				}
				String an = "";
				for (int j=0; j<a;j++) {
					an = an + ar[j];
				}
				System.out.println(("Case #" + (i+1) + ": " + an));
			}
		}
	}

}
