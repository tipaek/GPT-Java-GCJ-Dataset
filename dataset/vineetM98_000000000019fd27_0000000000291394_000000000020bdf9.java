import java.util.*;

class Solution {
	public static void sort(int arr[][], int c) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
          @Override               
          public int compare(final int[] t1,final int[] t2) {
            if (t1[c] > t2[c]) 
                return 1; 
            else
                return -1; 
          } 
        });
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int cnt=0;
		while(t-->0) {
			cnt++;
			int n=sc.nextInt();
			int[][] time=new int[n][3];
			for(int i=0;i<n;i++) {
				for(int j=0;j<2;j++) {
					time[i][j]=sc.nextInt();
				}
				time[i][2]=i;
			}
			sort(time,0);
			int per1=time[0][1],per2=0,f=0;
			char[] sol=new char[n];
			sol[time[0][2]]='C';
			for(int i=1;i<n;i++) {
				if(per1<=time[i][0]) {
					sol[time[i][2]]='C';
					per1=time[i][1];
				}
				else if(per2<=time[i][0]) {
					sol[time[i][2]]='J';
					per2=time[i][1];
				}
				else {
					f=1;
					break;
				}
			}
			String res="";
			if(f==1)
				res="IMPOSSIBLE";
			else {
				for(int i=0;i<n;i++)
					res+=sol[i];
			}
			System.out.println("Case #"+cnt+": "+res);
		}
	}
}
