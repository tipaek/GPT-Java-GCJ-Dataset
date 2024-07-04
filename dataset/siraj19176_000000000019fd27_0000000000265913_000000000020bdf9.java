import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
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
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();
			int arr[][]=new int[n][4];
			for(int j=0;j<n;j++) {
				arr[j][0]=sc.nextInt();
				arr[j][1]=sc.nextInt();
				arr[j][2]=j;
			}
			sortbyColumn(arr,0);
			String s="";
			int a[]=new int[2];
			for(int j=0;j<n;j++) {
				int starttime=arr[j][0];
				int endtime=arr[j][1];
				if(starttime>=a[0]) {
					s+="C";
					arr[j][3]=0;
					a[0]=endtime;
				}
				else if(starttime>=a[1]) {
					s+="J";
					arr[j][3]=1;
					a[1]=endtime;
				}
				else {
					s="IMPOSSIBLE";
					break;
				}
			}
			if(s.equals("IMPOSSIBLE"))
				System.out.println("Case #"+(i+1)+": "+s);
			else {
				sortbyColumn(arr,2);
				String s1="";
				for(int t1=0;t1<n;t1++) {
					if(arr[t1][3]==0)
						s1+="C";
					else
						s1+="J";
				}
				System.out.println("Case #"+(i+1)+": "+s1);
			}
	}

}
}
