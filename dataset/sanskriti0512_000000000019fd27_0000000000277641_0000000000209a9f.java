import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
   
   public static String parentheses(String s){
      String answer="";
      	int o=0,c=0;
    	int n=s.length();int a=0;
    	for(int i=0;i<n;i++)
    	{
    		int temp=(s.charAt(i)-'0')-o;
    		if(temp>0)
    			o+=temp;
    		int temp2=(-temp);
    		c=Math.max(a,temp2);
    		while(temp2>0)
    		{
    			answer+=')';
    			temp2--;
    		}
    		while(temp>0)
    		{
    			answer+='(';
    			temp--;
    		}
    		o-=c;
    		answer+=s.charAt(i);
    	}
    	c=o;
    	while(c>0)
    	{
    		answer+=')';
    		c--;
    	}
    	return answer;
   }
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
                
                int t = Integer.parseInt(br.readLine());
                for(int i=0;i<t;i++){
                    String s=br.readLine();
                    String answer=parentheses (s);
                    System.out.println("Case #"+(i+1)+": "+answer);
                    
                }
                
                     
    }
    }