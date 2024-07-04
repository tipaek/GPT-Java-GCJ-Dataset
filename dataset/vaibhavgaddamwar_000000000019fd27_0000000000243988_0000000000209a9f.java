/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{ 
    static void add(int a,String s,ArrayList<String> ar){
	    for(int i=0;i<a;i++){
	        ar.add(s);
	    }
	   
	}
    
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=0;x<t;x++){
		   String S=sc.next();
		    int c=0;
		    ArrayList<String> ar=new ArrayList<String>();
		    int a=Integer.parseInt(Character.toString(S.charAt(0)));
		    String s1="(";
		    String s2=")";
		    add(a,s1,ar);
		     ar.add(Integer.toString(a));
		   // System.out.println(ar);
		    for(int i=1;i<S.length();i++){
		        int k=Integer.parseInt(Character.toString(S.charAt(i-1)));
		        int l=Integer.parseInt(Character.toString(S.charAt(i)));
		        if(k>=l){
		            int d=k-l;
		            add(d,s2,ar);
		             ar.add(Integer.toString(l));
		        }
		        else{
		            add(k,s2,ar);
		            add(l,s1,ar);
		             ar.add(Integer.toString(l));
		        }
		       // System.out.println(ar);
		    }
		    add(Integer.parseInt(Character.toString(S.charAt(S.length()-1))),s2,ar);
		    for(int i=0;i<ar.size();i++){
		        System.out.print(ar.get(i));
		    }
		    System.out.println();
		}
		    
	}
}
