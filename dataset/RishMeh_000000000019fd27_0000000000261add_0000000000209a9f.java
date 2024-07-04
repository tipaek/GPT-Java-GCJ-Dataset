import java.io.*;
import java.util.*;
class Solution{

	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    int i = 1;
	    while(i<=t){
	        String ss = s.next();
	        int k = 0; int curr = 0,z = 0; String res = "";
	        while(k<ss.length()){
	            int l = Integer.parseInt(String.valueOf(ss.charAt(k)));
	            if (l< curr){
	                z = curr;
	                while(z> l){
	                    res = res+")";
	                    z--;
	                }
	            }
	            else if (l>curr) {
	             z = curr;
	            while(z< l){
	                res= res + "(";
	                
	                z++;
	            }
	            }
	            curr = l;
	            res = res + l;
	            k++;
	        }
	        z = curr;
	         while(z> 0){
	                    res = res+")";
	                    z--;
	                }
	        System.out.println("Case #"+i+": "+ res);
	        i++;
	    }
	}
}