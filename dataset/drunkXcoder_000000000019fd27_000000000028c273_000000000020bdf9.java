
import java.io.*;
public class Solution {
    public static void main(String args[]) throws IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int t=Integer.parseInt(br.readLine());
    	int c=1;
    	while(c<=t) {
    		int n=Integer.parseInt(br.readLine());
    		int tasks[]=new int[n];
    	   int start[]=new int[n];
    	   int end[]=new int[n];
    		for(int i=0;i<n;i++) {
    			String str[]=(br.readLine()).trim().split("\\s+");
    			start[i]=Integer.parseInt(str[0]);
    			end[i]=Integer.parseInt(str[1]);
    			tasks[i]=i;
    		}
    		String res[]=new String[n];
    		//sorting start
    		for (int i = 0; i < n-1; i++) {
    			
                for (int j = 0; j < n-i-1; j++) 
                    if (start[j] > start[j+1]) 
                    { 
                        // swap arr[j+1] and arr[i] 
                        int temp = start[j]; 
                        start[j] = start[j+1]; 
                        start[j+1] = temp; 
                        int it=tasks[j];
                        tasks[j]=tasks[j+1];
                        tasks[j+1]=it;
                    }
    		}
    	  
    		int Cindex=-1;
    		int Jindex=-1;
    		int flag=0;
    		for(int i=0;i<n;i++) {
    			if(Cindex==-1) {
    				res[tasks[i]]="C";
    				Cindex=0;
    			}
    			else {
    				if(start[i]>start[Cindex] && (start[i]>=end[tasks[Cindex]])) {
    						res[tasks[i]]="C";
    					    Cindex=i;
    					}
    					
    				else {
    					if(Jindex==-1) {
    					res[tasks[i]]="J";
    					Jindex=i;
    				}
    					
    				else if(start[i]>start[Jindex] &&(start[i]>=end[tasks[Jindex]])) {
    						res[tasks[i]]="J";
    					    Jindex=i;
    					}
    			else {
    				System.out.println("Case #"+c+":"+" "+"IMPOSSIBLE");
    				flag=1;
    				break;
    				}
    		} 
    	}
    		}
    		if(flag==0) {
    			String ans="";
    	for(int i=0;i<n;i++)
    		ans+=res[i];
    		System.out.println("Case #"+c+":"+" "+ans);
    		}
    		c++;
    	}
    }
}
