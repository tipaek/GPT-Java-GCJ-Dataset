
import java.util.*;
class Solution {
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int n = sc.nextInt();
	int d=0;
	while(d++<n){
		int	b=sc.nextInt();
		int[][] a=new int[b][4];
		for (int i=0;i<b ;i++ ) {
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
			a[i][2]=n;
			a[i][3]=0;
		}
		System.out.println("Case #"+d+": "+nested_fun(a));
}
}
	public static String nested_fun(int[][] ar){
			Arrays.sort(ar,(a,b) -> a[0]-b[0]);
			int c=0,q=0;
			StringBuilder sb =new StringBuilder();
			
			for(int i=0;i<ar.length;i++){
				int t = ar[i][0];
				int l = ar[i][1];
				if(t>=c)
				{
					ar[i][3]=1;
					c=l;
				}else
				if(t>=q){
					ar[i][3]=2;
					q=l;
				}else{
					return "IMPOSSIBLE";
				}
			}
				Arrays.sort(ar,(a,b) -> a[2] - b[2]);
				for(int i=0;i<ar.length;i++){
				if(ar[i][3]==1){
					sb.append("C");
				}
				else{
				sb.append("J");
			}
			}
			
			return sb.toString();
			}
	}

	
