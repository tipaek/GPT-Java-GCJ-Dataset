/*package whatever //do not write package name here */

import java.util.*;

public class Solution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int tt=1;tt<=t;tt++){
		    String st=s.next();
		    int len=st.length();
		    String output="";
		    int pth=0;
		    for(int i=0;i<len;i++){
		        int temp=st.charAt(i)-48;
		        if(temp==pth){
		            output+=st.charAt(i);
		            continue;
		        }
		        else if(temp>pth){
		            int temp1=temp-pth;
		            while(temp1-->0){
		                output+="(";
		            }
		            output+=st.charAt(i);
		            pth+=temp-pth;
		        }
		        else{
		            int temp1=pth-temp;
		            while(temp1-->0){
		                output+=")";
		            }
		            pth=temp;
		            output+=st.charAt(i);
		        }
		    }
		    while(pth-->0){
		        output+=")";
		    }
		    System.out.println("Case #"+tt+": "+output);
		}
	}
}