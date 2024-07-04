/* package codechef; // don't place package name! */

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.math.BigInteger; 
import java.math.*;
	class Solution{
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    int t1=sc.nextInt();
	    for(int t=1;t<=t1;t++){
	        int n=sc.nextInt();
	        String a[]= new String[n];
	        for(int i=0;i<n;i++){
	            a[i]=sc.next();
	        }
	        String res=a[0];
	        int k=res.length();
	       // int pos=-1;
	       int flag=0;
	        for(int i=1;i<n;i++){
	            String s=a[i];
	            //if(s.charAt(0)=='*') pos=0;
	            //else if(s.charAt(s.length()-1)=='*') pos=2;
	            //else pos=3;
	            
	            if(res.charAt(0)=='*' && s.charAt(0)=='*'){
	                     int r=res.length()-1;
	                     int f=s.length()-1;
	                     while(r>=1 && f>=1){
	                         if(res.charAt(r)!= s.charAt(f)){
	                            res="*";
	                            flag=1;break;
	                         }
	                         r--;f--;
	                     }
	                     if(flag==1)break;
	                     res=(Math.max(r,f)==r)?res:s;
	                
	                
	            }
	            
	        }
	        if(res.equals("*")){
	            System.out.println("Case #"+t+": "+res);
	        }
	        else{
	            System.out.println("Case #"+t+": "+res.substring(1));
	        }
	        
	    }
	}
	    
	}