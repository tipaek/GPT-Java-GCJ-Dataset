import java.io.*;
import java.util.*;
public class Solution {
     public static void main(String args[]) throws IOException{
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 int t=Integer.parseInt(br.readLine());
    	 int c=1;
    	 while(c<=t) {
    		 int n=Integer.parseInt(br.readLine());
    				 int arr[][]=new int[n][n];
    				 //taking the inputs
    				 for(int i=0;i<n;i++) {
    					 String str[]=(br.readLine()).trim().split("\\s+");
    					 for(int j=0;j<n;j++) {
    						 arr[i][j]=Integer.parseInt(str[j]);
    					 }
    				 }
    				 int Tarr[][]=new int[n][n];
    				 for(int i=0;i<n;i++) {
    					 for(int j=0;j<n;j++) {
    						 Tarr[i][j]=arr[j][i];
    				 }
    				 }
    				 
    				 int sum=0;
    				 for(int i=0;i<n;i++)
    					 sum+=arr[i][i];
    				 //finding no rows with common elements
    				 //sorting array row wise
 
    				 for (int i = 0; i < arr.length; i++) 
    			            Arrays.sort(arr[i]); 
    				//now finding common rows
    				 int Rres=0;
    				 for(int i=0;i<n;i++) {
    					 int temp=arr[i][0];
    					 
    					 for(int j=1;j<n;j++) {
    						 if(temp==arr[i][j]) {
    							 Rres++;
    							 break;
    							 }
    						 else
    							 temp=arr[i][j];
    					 }
    				 }
    				 for (int i = 0; i < arr.length; i++) 
 			            Arrays.sort(Tarr[i]); 
    				
    				 int Cres=0;
    				 for(int i=0;i<n;i++) {
    					 int temp=Tarr[i][0];
    					 
    					 for(int j=1;j<n;j++) {
    						 if(temp==Tarr[i][j]) {
    							 Cres++;
    							 break;
    							 }
    						 else
    							 temp=Tarr[i][j];
    					 }
    				 }
    				 System.out.println("Case #"+c+":"+" "+sum+" "+Rres+" "+Cres);
    				 c++;
    	 }
     }
}