import java.util.*;
class Solution{
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt(),t1=0;
	    while(t1++<t){
	        int n=sc.nextInt(),k=sc.nextInt();
	        int[][] a=new int[n][n];
	        System.out.print("Case #"+t1+": ");
	        if(k%n==0){
	            System.out.println("POSSIBLE");
	            for(int i=0;i<n;i++){
	                int d=k/n;
	                a[i][i]=d;
	                for(int j=i-1;j>=0;j--){
	                    d--;
	                    if(d<=0)
	                        d=n;
	                    a[i][j]=d;
	                }
	                d=a[i][i];
	                for(int j=i+1;j<n;j++){
	                    d++;
	                    if(d>n)
	                        d=1;
	                    a[i][j]=d;
	                }
	            }
	            for(int i=0;i<n;i++){
	                for(int j=0;j<n;j++)
	                    System.out.print(a[i][j]+" ");
	                System.out.println();
	            }
	        }
	        else{
	            System.out.println("IMPOSSIBLE");
	        }
	    }
	}
}
