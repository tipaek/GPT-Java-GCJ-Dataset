
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
	
	
	public static void main(String[] args) throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		for(int ie=0;ie<t;ie++) {
			StringBuilder sb=new StringBuilder();
	        char[] arr=s.next().toCharArray();
	        int n=arr.length;
	        int min=Integer.valueOf(arr[0]+"");
	        for(int j=0;j<Integer.valueOf(arr[0]+"");j++) {
    			sb.append('(');
    		}
	        sb.append(arr[0]);
	        for(int i=1;i<n;i++) {
	        	if(Integer.valueOf(arr[i]+"")<=min) {
	        		for(int j=0;j<min-Integer.valueOf(arr[i]+"");j++) {
	        			sb.append(')');
	        		}
	        		sb.append(arr[i]);
	        		min=Integer.valueOf(arr[i]+"");
	        	}else {
	        		for(int j=0;j<Integer.valueOf(arr[i]+"")-min;j++) {
	        			sb.append('(');
	        		}
	        		
	        		min=Integer.valueOf(arr[i]+"");
	        		
	        		sb.append(arr[i]);
	        	}
	        }
			
	        for(int j=0;j<min;j++) {
    			sb.append(')');
    		}
	        
	        
			System.out.println("Case "+"#"+(ie+1)+": "+sb);
			
			
			
		}
		
	}
	
}