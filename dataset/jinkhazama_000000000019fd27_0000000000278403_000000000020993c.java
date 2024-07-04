/*package whatever //do not write package name here */


import java.util.*;
class Solution {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=1;q<=t;q++){
		    int n=sc.nextInt();
		    int arr[][]=new int[n][n];
		    int tr=0;
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            arr[i][j]=sc.nextInt();
		            if(i==j){
		                tr+=arr[i][j];
		            }
		        }
		    }
		    int r=0;
		    int x[]=new int[n+1];
		    Arrays.fill(x,0);
		    for(int i=0;i<n;i++){
		        Arrays.fill(x,0);
		        for(int j=0;j<n;j++){
		            int p=arr[i][j];
		            x[p]=x[p]+1;
		            if(x[p]>1){
		                r=r+1;
		                break;
		            }
		        }
		    }
		    int c=0;
		    for(int i=0;i<n;i++){
		        Arrays.fill(x,0);
		        for(int j=0;j<n;j++){
		            int p=arr[j][i];
		            x[p]=x[p]+1;
		            if(x[p]>1){
		                c=c+1;
		                break;
		            }
		        }
		    }
		    System.out.println("Case #"+q+":"+" "+tr+" "+r+" "+c);
		}
	}
}