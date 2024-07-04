import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine().trim());
        for(int t=1;t<=test;t++){
            String s=br.readLine().trim();
            int length=s.length();
            int point=0;
            String ans = "";
            int front=0;
            do {	                    
	            int now=s.charAt(point)-'0';
	            String add ="";
	            if(now>front) {
		            for(int i=0;i<now-front;i++) {
		            	add+="(";
		            }
		            ans+=add;
	            }else if(now<front) {
	            	for(int i=0;i<front-now;i++) {
		            	add+=")";
		            }
	            	ans+=add;
	            }
	            
	            ans+=s.charAt(point);
	            point++;
	            front = now;
            }while(point<length);
            
            if((s.charAt(length-1)-'0')>0) {
            	 String add ="";
            	 for(int i=0;i<s.charAt(length-1)-'0';i++) {
		            	add+=")";
		            }
            	 ans+=add;
            }
            
            
            System.out.println("Case #"+t+": "+ans);
        }
	}
}