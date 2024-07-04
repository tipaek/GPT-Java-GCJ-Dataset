import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int counter = 1; counter <= n; counter++){
		    String finalString = "";
		    st = new StringTokenizer(br.readLine());
    		int currentNum = 0;
         int currentChar = 0;
         String nums = st.nextToken();
		    try{
    		    while(true){
               int c = nums.charAt(currentChar)-'0';
       		    while(currentNum < c){
       		        finalString=finalString+"(";
       		        currentNum++;
       		    }
       		    while(currentNum > c){
       		        finalString=finalString+")";
       		        currentNum--;
       		    }
                finalString = finalString + c;
                currentChar++;
             }
		    }catch(Exception e){
		        while(currentNum > 0){
    		        finalString=finalString+")";
    		        currentNum--;
    		    }
		        System.out.println("Case #"+counter+": "+finalString);
		    }
		}
	}
}
		