
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
				String s = in.next();
				String para = "";
				for(int i=0; i<10; i++){
					para = ""+i;
					for(int j=0; j<i; j++){ para = "("+para+")"; }
					s = s.replaceAll(Integer.toString(i), para);
				}
		    	//System.out.println(s);
				for(int i=0; i<10; i++){
					para = "";
					for(int j=0; j<i; j++){ para = ")"+para+"("; }
					para = "\\\\" + para;
					//System.out.println(para);
					
					if(s.contains(para)) s = s.replaceAll(para, "");
				}
				
				String res = "";
				
				int left=0,right=0;
				String p = "";
				int st = 0, end=s.length()-1;
				for(int i=0; i<s.length(); i++){
					if(s.charAt(i)!='(') {st=i;break;} }
				for(int i=end; i>=0; i--){
					if(s.charAt(i)!=')') {end=i;break;}}
				
				for(int i=st; i<=end; i++){
					if(s.charAt(i)==')') right++;
					else if(s.charAt(i)=='(') left++;
					else {
						if(right>=left) { right = right-left; left=0; }
						else{ left = left-right; right=0; }
						for(int k=0;k<right;k++) p+=")";
						for(int k=0;k<left;k++) p+="(";
						res += p+s.charAt(i); left=0; right=0; p="";
					}
				}
				res = s.substring(0,st)+res+s.substring(end+1,s.length());
		    	
		    	System.out.println("Case #"+t+ ": " +res);
		      
		    }

	}

	
	
	
}
