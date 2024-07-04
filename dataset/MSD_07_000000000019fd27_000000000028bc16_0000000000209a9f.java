import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    int t=Integer.parseInt(br.readLine());
	    int x=1;
	    while(t-->0){
	        String s=br.readLine();
	        String ans="";
	        int c=0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='0'){
	                if(c>0){
	                    for(int j=0;j<c;j++)
	                    ans+=")";
	                    c=0;
	                }
	                ans+=s.charAt(i);
	            }
	            else if(c<(s.charAt(i)-'0')){
	                int temp=c;
	                for(int j=0;j<(s.charAt(i)-'0'-c);j++){
	                    ans+="(";
	                    temp++;
	                }
	                ans+=s.charAt(i);
	                c=temp;
	            }
	            else if(c>(s.charAt(i)-'0')){
	                int temp=c;
	                for(int j=0;j<(c-(s.charAt(i)-'0'));j++){
	                    ans+=")";
	                    temp--;
	                }
	                c=temp;
	                ans+=s.charAt(i);
	            }
	            else
	            ans+=s.charAt(i);
	        }
	        for(int j=0;j<c;j++)
	        ans+=")";
	        System.out.println("Case #"+x+": "+ans);
	        x++;
	    }
	    }
}