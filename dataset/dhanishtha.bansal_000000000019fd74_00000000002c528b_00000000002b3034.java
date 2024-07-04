import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine()); 
  
	    for(int idx = 1; idx <= test; idx++) {
	        int n = Integer.parseInt(br.readLine());
	        String[] p = new String[n];
	        String str = "*";
	        boolean flag = true;
	        for(int i = 0; i < n; i++) {
	            int j = 0;
	            p[i] = br.readLine().trim();
	            if(flag && (i-j) > 0) {
	                str = strMatch(p, p[i], i-j);
	                if(str.equals("*")) {
	                    flag = false;
	                }
	            }
	        }
	        System.out.println("Case #" + idx + ": " + str);
	    }
	 }
	 static String strMatch(String[] p, String ptr, int num) {
	     String str = "";
	     for(int i = 0; i < num; i++) {
	         
	         String res = "";
	         String[] str2 = ptr.split("\\*");
	         String[] str1 = p[i].split("\\*");
	         
	         //test set1 or set 2
	         
	         if(str1.length == 2 && str1.length == str2.length && str1[0].equals("") && str2[0].equals("")) {
	            // System.out.println(str1[0]);
	             
	             if(true) {
	                 //start matching from the last characters
	                 if(str1[1].length() < str2[1].length()) {
	                     // System.out.println("abc");
	                      int k = str2[1].length()-1;
	                     for(int j = str1[1].length() -1; j >= 0; j--) {
	                         if(str1[1].charAt(j) != str2[1].charAt(k)) {
	                             //System.out.println(str1[1].charAt(j));
	                             //System.out.println(str2[1].charAt(j));
	                             return "*";
	                         }
	                         k--;
	                     }
	                    // System.out.println(str);
	                     //System.out.println(str);
	                     if(str.length() < str2[1].length()) {
	                         str = str2[1];
	                        //System.out.println(str);
	                     }
	                 }
	                 else {
	                     int k = str1[1].length() - 1;
	                     for(int j = str2[1].length() -1; j >= 0; j--) {
	                         if(str1[1].charAt(k) != str2[1].charAt(j)) {
	                             return "*";
	                         }
	                         k--;
	                     }
	                     if(str.length() < str1[1].length()) {
	                         str = str1[1];
	                         //System.out.println(str);
	                     }
	                 }
	             }
	         }
	         else {
	             int  j= 0, k = 0;
	             while(k < ptr.length() && j < p[i].length()) {
	                 if(ptr.charAt(k) == '*') {
	                     //System.out.println("str1 " + k);
	                     while(j < p[i].length() && p[i].charAt(j) != '*')
	                     {
	                         res += p[i].charAt(j);
	                         j++;
	                     }
	                     k++;
	                    // System.out.println("str1 : " + res);
	                     //skip all characters till p[i] == *
	                 }
	                 else if(p[i].charAt(j) == '*') {
	                    // System.out.println("str2");
	                     while(k < ptr.length() && ptr.charAt(k) != '*')
	                     {
	                         res += ptr.charAt(k);
	                         k++;
	                     }
	                     j++;
	                     //System.out.println("str2" + res);
	                 }
	                 else if(ptr.charAt(k) == p[i].charAt(j)) {
	                    // System.out.println("str3");
	                     res += ptr.charAt(k);
	                     j++;
	                     k++;
	                    // System.out.println("str3" + res);
	                 }
	                 else {
	                   //  System.out.println("str4");
	                     return "*";
	                 }
	             }
	             if(j != p[i].length()) {
	                 int t = p[i].length()-1;
	                 k--;
	                 while(t >= j) {
	                     if(k >= 0 && p[i].charAt(t) != ptr.charAt(k)) {
	                         return "*";
	                     }
	                     t--;
	                     k--;
	                 }
	             }
	             else if(k != ptr.length()) {
	                 int t = ptr.length()-1;
	                 j--;
	                 while(t >= k) {
	                     if(j >= 0 && p[i].charAt(j) != ptr.charAt(t)) {
	                         return "*";
	                     }
	                     t--;
	                     j--;
	                 }
	             }
	             if(res.length() > str.length()) {
	                 str =res;
	             }
	         }
	         
	     }
	     //System.out.println("num : " +num + " str : " + str);
	     return str;
	 }
 }