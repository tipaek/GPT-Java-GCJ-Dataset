import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++){
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    int b[]=new int[n];
		    int diffrow[]=new int[n];
		    int diffcol[]=new int[n];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            a[i][j]=sc.nextInt();
		        }
		    }
		    for(int i=0;i<n;i++){
		        int k=0;
		        for(int j=0;j<n;j++){
		            if(a[k][i]==a[k][j]){
		                diffrow[i]++;
		            }
		            if(a[i][k]==a[j][k]){
		                diffcol[i]++;
		            }
		        }
		        k++;
		    }
		    int diffrowcount=0,diffcolcount=0;
		    for(int i=0;i<n;i++){
		        if(diffrow[i]!=1)
		        diffrowcount++;
		        if(diffcol[i]!=1)
		        diffcolcount++;
		    }
		    int sum=0;
		    for(int i=0;i<n;i++){
		        int j=i;
		        b[a[i][j]-1]++;
		        sum+=a[i][j];
		        j++;
		    }
		    int c=0;
		    for(int i=0;i<n;i++){
		        if(b[i]!=0){
		            c++;
		        }
		    }
		    System.out.println("Case #"+t+": "+sum+" "+diffrowcount+" "+diffcolcount);
		}
    }
}