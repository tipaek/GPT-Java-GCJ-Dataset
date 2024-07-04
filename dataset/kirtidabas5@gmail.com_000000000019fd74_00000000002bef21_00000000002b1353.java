import java.util.*;
 class Solution {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int Case=1;
		while(t-->0) {
			int n=scn.nextInt();
			int count=0;
			int[][]ans=new int[500][2];
			ans[0][0]=1;ans[0][1]=1;
			n--;count++;
			if(n>0)
			{ans[1][0]=2;ans[1][1]=1;count++;}
			n--;
			int r=3,i=2;
			while(n>0 && count<=n) {
				ans[i][0]=r;ans[i][1]=2;
				n-=count;
				r++;
				i++;
				count++;
				
			}
			while(n>0) {
				ans[i][0]=r;ans[i][1]=1;
				n--;
				r++;
				i++;
				count++;
			}
			System.out.println("Case #"+(Case)+":");
			for(int p=0;p<count;p++) {
				System.out.println(ans[p][0]+" "+ans[p][1]);
			}
			
			Case++;
		}
	}
}
