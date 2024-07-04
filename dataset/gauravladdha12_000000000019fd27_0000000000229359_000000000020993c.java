import java.util.*;
class v{
	 public static void main(String[] args) {
	 	Scanner sc=new Scanner(System.in);
	 	int t=sc.nextInt();
	 	int u=1;
	 	while(t-->0){
	 		int i ,co=0,r=0,ans=0,j;
	 		int n=sc.nextInt();
	 		int a[][]=new int[n][n];
	 		for(i=0;i<n;i++){
	 			for(j=0;j<n;j++){
	 				a[i][j]=sc.nextInt();
	 			}
	 		}
	 		for(i=0;i<n;i++){
	 			int c[]=new int[(int)1e6];
	 			for(j=0;j<n;j++){
	 				c[a[i][j]]++;
	 				if(c[a[i][j]]>1){
	 					r++;
	 					break;
	 				}
	 			}
	 		}
	 		for(j=0;j<n;j++){
	 			int c[]=new int[(int)1e6];
	 			for(i=0;i<n;i++){
	 				c[a[i][j]]++;
	 				if(c[a[i][j]]>1){
	 					co++;
	 					break;
	 				}
	 			}
	 		}
	 		for(i=0;i<n;i++){
	 			ans=ans+a[i][i];
	 		}
	 		System.out.println("Case #"+u+": "+ans+" "+r+" "+co);
	 		u++;
	 	}
	 }
}