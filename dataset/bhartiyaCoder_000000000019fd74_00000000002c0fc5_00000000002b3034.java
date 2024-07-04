/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c = 1; c <= t; c++) {
		    int n = sc.nextInt();
		    String[] arr = new String[n];
		    HashMap<Integer, Integer> map = new HashMap<>();
		    int maxLength = -1;
		    for(int i = 0; i < n; i++) {
		        arr[i] = sc.next();
		        map.put(i, arr[i].length() - 1);
		        if(arr[i].length() > maxLength) {
		            maxLength = arr[i].length();
		        }
		    }
		    String result = "";
		    int flag = 0;
		    for(int i = maxLength - 1; i >= 0; i--) {
		        int done = 0;
		        for(int j = 1; j < n; j++) {
		            char c1 = arr[j - 1].charAt(map.get(j - 1));
		            char c2 = arr[j].charAt(map.get(j));
		            if(c1 != c2 && (c1 != '*' && c2 != '*')){
		                flag = 1;
		                break;
		            }
		            if(c2 != '*' && c1 == '*') {
		                if(map.get(j - 1) != 0){
    		                if(arr[j - 1].charAt(map.get(j - 1) - 1) == c1) {
    		                    map.put(j - 1, map.get(j - 1) - 1);
    		                }
		                }
		                if(done == 0){
		                    done = 1;
		                    result = c2 + result;
		                }
		            }
		            if(c1 != '*' && c2 == '*') {
		                if(map.get(j) != 0){
    		                if(arr[j].charAt(map.get(j) - 1) == c1) {
    		                    map.put(j, map.get(j) - 1);
    		                }
		                }
		                if(done == 0){
		                    done = 1;
		                    result = c1 + result;
		                }
		                int tmp = map.get(j - 1);
		                if(tmp != 0) {
		                    map.put(j - 1,tmp - 1);
		                }
		            }
		            if(c1 == c2) {
		                if(done == 0 && c1 != '*'){
		                    done = 1;
		                    result = c1 + result;
		                }
		                int tmp = map.get(j - 1);
		                if(tmp != 0) {
		                    map.put(j - 1,tmp - 1);
		                }
		                if(j == n - 1 && c2 != '*') {
		                    map.put(j,map.get(j) - 1);
		                }
		            }
		        }
		        if(flag == 1) {
		            break;
		        }
		        
		        
		    }
		    if(flag == 1) {
		        System.out.println("Case #" + c + ": *" );
		    }
		    else {
		        System.out.println("Case #" + c + ": " + result);
		    }
		    
		    
		}
	}
}
