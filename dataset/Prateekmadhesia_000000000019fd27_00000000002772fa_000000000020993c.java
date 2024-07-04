

import java.util.*;
import java.lang.*;
import java.io.*;


public class Main{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int x=1;x<=t;x++){
		 int d=0,r=0,c=0,r1=0,c1=0;   
		int n=sc.nextInt();
		int [][]a=new int[n][n];
		for (int i=0;i<n ;i++ ){
		    for (int j=0;j<n ;j++ )
		    {
		        a[i][j]=sc.nextInt();
		        
		    } 
		}
		for (int i=0;i<n ;i++ ){
		    for (int j=0;j<n ;j++ )
		    {
		        if(i==j){
		            d+=a[i][j];
		        }
		        
		    }
		}
		for (int i=0;i<n ;i++ ){
		    for (int j=0;j<n ;j++ ){
		        for (int k= j+1;k<n ;k++ ){
		            if (a[i][j]==a[i][k]){
		                r+=1;
		                j=n-1;
		                break;
		            }
		            
		        } 
		        
		    }
		   // if
		
		}
		for (int i=0;i<n ;i++ ){
		    for (int j=0;j<n ;j++ ){
		        for (int k= j+1;k<n ;k++ ){
		            if (a[j][i]==a[k][i]){
		                c+=1;
		                j=n-1;
		                break;
		                
		            } 
		        } 
		        
		    }
		
		}
		System.out.println("Case #"+x+": "+d+" "+r+" "+c);
		}
	}
}
