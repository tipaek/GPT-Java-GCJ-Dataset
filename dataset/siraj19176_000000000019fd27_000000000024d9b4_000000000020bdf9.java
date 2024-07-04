import java.util.*;

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
			int arr[][]=new int[n][2];
			for(int j=0;j<n;j++) {
				arr[j][0]=sc.nextInt();
				arr[j][1]=sc.nextInt();
			}
			sortbyColumn(arr,0);
			String s="";
			int endJ=0;
			int endC=0;
			for(int j=0;j<n;j++) {
				if(j==0) {
					endC=arr[j][1];
					s=s+"C";
				}
				else {
					boolean notoverlap=(arr[j][0]>=arr[j-1][1]);
					int l=s.length();
					if(notoverlap) {
						s=s+s.charAt(l-1);
						l=s.length();
						if(s.charAt(l-1)=='C')
							endC=arr[j][1];
						else
							endJ=arr[j][1];
					}
					else {
						l=s.length();
						if(s.charAt(l-1)=='C') {
							if(arr[j][0]<endJ) {
								s="IMPOSSIBLE";
								break;
							}
							else {
								s=s+'J';
								endJ=arr[j][1];
							}
						}
						else {
							if(arr[j][0]<endC) {
								s="IMPOSSIBLE";
								break;
							}
							else {
								s=s+'C';
								endC=arr[j][1];
							}
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+s);

	}

}
}
