/*package whatever //do not write package name here */

//import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	for(int q=1;q<=t;q++){
	    int n=sc.nextInt();
	    String a[]=new String[n];
	    for(int i=0;i<n;i++){
	        a[i]=sc.next();
	    }
	    int flag=0;
	    String s=a[0].substring(0,a[0].indexOf('*'));
	    String e=a[0].substring(a[0].lastIndexOf('*')+1);
	    //System.out.println(s+" "+e);
	    String s1="",e1="";
	    String mid="";
	    for(int i=1;i<n;i++){
	        String str[]=a[i].split("\\*");
	        int w=str.length;
	        for(int c=1;c<w-1;c++){
	            mid=mid+str[c];
	        }
	        s1=a[i].substring(0,a[i].indexOf('*'));
	        e1=a[i].substring(a[i].lastIndexOf('*')+1);
	       // System.out.println(s1+" "+e1);
	        if(!s1.equals("")){
	        if(s1.length()>s.length()){
	            int l=s.length();
	            if(s1.substring(0,l).equals(s)){
	                s=s1;
	            }else{
	                flag=1;
	                break;
	            }}
	       else{
	           int l=s1.length();
	            if(!s.substring(0,l).equals(s1)){
	                flag=1;
	                break;
	            }
	       }}
	       if(!e1.equals("")){
	        if(e1.length()>e.length())
	        {
	            int elen1=e1.length();
	            int e2=e.length();
	            int x=elen1-e2;
	            if(e1.substring(x).equals(e)){
	                e=e1;
	            }
	            else{
	                flag=1;
	                break;
	            }
	        }
	        else{
	            int elen=e1.length();
	            int e2=e.length();
	            int x=e2-elen;
	            if(!e.substring(x).equals(e1)){
	                flag=1;
	                break;
	            }
	        }}
	            
	        }
	        
	        if(flag==1){
	        System.out.println("Case #"+q+": "+"*");
	        continue;
	    }
	    //System.out.println("mid is"+mid);
	     String res=s+mid+e;
	     System.out.println("Case #"+q+": "+res);
	        
	    }
	    
	}
}
