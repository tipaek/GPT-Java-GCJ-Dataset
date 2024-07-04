import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
	
	public static void sortbyColumn(int arr[][], int col) 
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			if(n<2 || n>10){
			    break;
			}
			int rc[][] = new int[n][4];
			for(int j=0; j<n; j++) {
				for(int k=0; k<2; k++) {
					rc[j][k] = sc.nextInt();
				}
			}
			for(int j=0; j<n; j++) {
				rc[j][2] = j;
			}

			 
			 
			sortbyColumn(rc, 0);
			
			int curr =0;
			int flag=0;
			rc[0][3]=curr;
			for(int j=1;j<n;j++) {
				flag=0;
				int pre = j-1;
				if(rc[j][0]<rc[pre][1]) {
					if(curr==1) {
						curr=0;
					}
					else {
						curr=1;
					}
					rc[j][3]=curr;
				}
				else {
					rc[j][3]=curr;
				}
				if(j==2) {
					int pre1,pre2;
					pre1=j-1;
					pre2=j-2;
					if(rc[j][0]<rc[pre1][1] && rc[pre1][0]<rc[pre2][1]) {
						flag=1;
						break;
					}
					
				}
			}
			sortbyColumn(rc, 2);
			
			if(flag==0) {
				System.out.print("Case #"+(i+1)+": ");
				for(int j=0; j<n; j++) {
					if(rc[j][3]==0) {
						System.out.print("C");
					}
					else {
						System.out.print("J");
					}
				}
				System.out.println();
			}
			else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
					
		}
	}

}
