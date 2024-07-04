import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    int b = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        String s = "";
	        int q = 1;
	        int index = 1;
	        while(s.length() < b){
	            System.out.println(index);
	            String bit = sc.next();
	            if(q % 10 != 1){
	                s += bit;
	                index++;
	            }
	            q++;
	        }
	        System.out.println(s);
	        char ok = sc.next().charAt(0);
	        if(ok == 'Y'){
	            continue;
	        }
	        else{
	            System.exit(0);
	        }
	    }
	}
}