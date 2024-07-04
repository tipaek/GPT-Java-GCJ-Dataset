
//import java.io.*;
import java.util.*;
 class Solution {

	public static void main(String[] args) {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st=new StringTokenizer(br.readLine());
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int Case=0;
		while(t-->0) {
			int n=scn.nextInt();
			int[][]arr=new int[n][n];
			int ans=0,row=0,col=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer>set=new HashSet();
				boolean flag=false;
				for(int j=0;j<n;j++) {
					int num=scn.nextInt();
					if(set.contains(num) && !flag) {
						row++;
						flag=true;
					}
					set.add(num);
					arr[i][j]=num;
					if(i==j)
						ans+=num;
				}
			}
			for(int i=0;i<n;i++) {
				HashSet<Integer>set=new HashSet();
				boolean flag=false;
				for(int j=0;j<n;j++) {
					int num=arr[j][i];
					if(set.contains(num) && !flag) {
						col++;
						flag=true;
					}
					set.add(num);
				}
			}
			Case++;
//			Case #1: 
			System.out.println("Case #"+Case+": "+ans+" "+row+" "+col);
			}
	}

}
