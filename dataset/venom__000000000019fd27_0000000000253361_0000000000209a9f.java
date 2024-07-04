import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int inc = 0 ;
		while(t-- !=0){
		    inc++;
		    String s = sc.next();
		    StringBuilder res = new StringBuilder();
		    for(int i=0;i<s.length();i++){
		        if(s.charAt(i)!=0){
		            int par = Character.getNumericValue(s.charAt(i));
		            int enthe = par;
		            while(par-- !=0){
		                if(i!=0 && res.charAt(res.length()-1) == ')')
		                    res.deleteCharAt(res.length()-1);
	                    else
	                        res.append('(');
		            }
		            res.append(s.charAt(i));
		            while(enthe-- !=0){
		                res.append(')');
		            }
		        }
		    }
		    System.out.println("Case #"+inc+":"+" "+res);
		}
	}
}