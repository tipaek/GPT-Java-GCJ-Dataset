
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
		    int n=scn.nextInt();
		    int [][]arr=new int[n][n];
		    int [][]row=new int[n][n];
		    int [][]col=new int[n][n];
		    int rc=0,cc=0,ans=0;
		    int []a=new int[n];
		    for(int j=0;j<n;j++){
		        int flag=0;
		        for(int k=0;k<n;k++){
		            arr[j][k]=scn.nextInt();
		             if(row[j][arr[j][k]-1]!=1){
		                row[j][arr[j][k]-1]=1;
		             }else {
		                  flag=1;
		             }
		             if(col[arr[j][k]-1][k]!=1){
		                  col[arr[j][k]-1][k]=1;
		             }else{
		                 a[k]=1;
		             }
		            if(j==k)
		                ans+=arr[j][k];
		        }
		        
		        if(flag==1){
		            rc++;
		        }
		    }
		    for(int j=0;j<n;j++)
		        cc+=a[j];
		    System.out.println("Case #"+(i+1)+": "+ans+" "+rc+" "+cc);
		}
	}

}
