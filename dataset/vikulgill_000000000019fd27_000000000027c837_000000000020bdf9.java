import java.util.*;
import java.lang.*;
public class Solution {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int x=1;
		while(t>0)  {
       int n=s.nextInt();
       int arr[][]=new int[n][2];
       for(int i=0;i<n;i++) {
    	  for(int j=0;j<2;j++) {
    	arr[i][j]=s.nextInt();
    	  }
       }
       StringBuilder sb=new StringBuilder();
       sb.append("J");
       int startJ=arr[0][0]; int endJ=arr[0][1];
       int startC=0;int endC=0;
       for(int i=1;i<n;i++) {   	  
    		if(endJ>arr[i][0]&&endC<=arr[i][0])  {
    			sb.append("C");
    			startC=arr[i][0];endC=arr[i][1];
    		}
    		else if(endJ>arr[i][0]&&startJ>=arr[i][1]){
    			sb.append("J");
    			
    		}
    		else if(endC>arr[i][0]&&startC>=arr[i][1]){
    			sb.append("J");
    			
    		}
    		else if(endJ<=arr[i][0]){
    			sb.append("J");
    			startJ=arr[i][0];endJ=arr[i][1];
    		}
    		else {
    			sb.delete(0, sb.capacity());
    			sb.append("IMPOSSIBLE");
    		}
    		}
       System.out.println("Case #"+x+":"+sb.toString());
       t--;x++;
       }
	}
}
