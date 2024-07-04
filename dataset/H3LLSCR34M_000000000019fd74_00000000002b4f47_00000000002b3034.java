import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
    	String res = "";
    	int n = in.nextInt();
    	String[] array = new String[n];
    	for(int i = 0;i<n;i++) {
    		String str = in.next();
    		str = str.substring(1,str.length());
    		array[i]=str;
    	}
    	int max = 0;
    	int index = 0;
    	for(int i = 0;i<array.length;i++) {
    		if(array[i].length()>max) {
    			max = array[i].length();
    			index = i;
    		}
    	}
    	res = array[index];
    	boolean found = false;;
    	for(int i =0;i<array.length;i++) {
    		for(int j = 0;j<array[i].length();j++) {
    			if(res.equals(array[i]))
    				break;
	    		if(res.charAt(res.length()-1-j)!=array[i].charAt(array[i].length()-1-j)) {
	    			res = "*";
	    			found = true;
	    			break;
	    		}
    		}
    		if(found)
    			break;
    	}
    	arr[w] = "Case #"+(w+1)+": "+res;
    }
    in.close();
    for(String s:arr)
    	System.out.println(s);
  }
}