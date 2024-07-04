import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
    	String res = "";
    	String r = "";
    	int n = in.nextInt();
    	List<String> suff = new ArrayList<>();
    	List<String> pre = new ArrayList<>();
    	for(int i = 0;i<n;i++) {
    		String str = in.next();
    		if(str.indexOf("*")!=str.length()-1)
    			suff.add(str.substring(str.indexOf("*")+1,str.length()));
    		if(str.indexOf("*")!=0)
    			pre.add(str.substring(0,str.indexOf("*")));
    	}
    	int max = 0;
    	int index = 0;
    	int m = 0;
    	int ind = 0;
    	for(int i = 0;i<suff.size();i++) {
    		if(suff.get(i).length()>max) {
    			max = suff.get(i).length();
    			index = i;
    		}
    	}
    	for(int i = 0;i<pre.size();i++) {
    		if(pre.get(i).length()>m) {
    			m = pre.get(i).length();
    			ind = i;
    		}
    	}
    	boolean found = false;;
    	for(int i =0;i<suff.size();i++) {
        	res = suff.get(index);
    		for(int j = 0;j<suff.get(i).length();j++) {
    			if(res.equals(suff.get(i)))
    				break;
	    		if(res.charAt(res.length()-1-j)!=suff.get(i).charAt(suff.get(i).length()-1-j)) {
	    			res = "*";
	    			found = true;
	    			break;
	    		}
    		}
    		if(found)
    			break;
    	}
    	boolean f = false;
    	for(int i =0;i<pre.size();i++) {
        	r = pre.get(ind);
    		for(int j = 0;j<pre.get(i).length();j++) {
    			if(r.equals(pre.get(i)))
    				break;
	    		if(r.charAt(j)!=pre.get(i).charAt(j)) {
	    			r = "*";
	    			f = true;
	    			break;
	    		}
    		}
    		if(f)
    			break;
    	}
    	if(f||found)
    		arr[w] = "Case #"+(w+1)+": "+"*";
    	else {
    		
    		arr[w] = "Case #"+(w+1)+": "+r+res;
    		
    	}
    }
    in.close();
    for(String s:arr)
    	System.out.println(s);
  }
}