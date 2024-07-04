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
	    int t1 =sc.nextInt();
    
   
    for(int t=1;t<=t1;t++){
        int n=sc.nextInt();
        System.out.println("Case #"+t+":");
        int n1=n;
        if(n>=1){
            System.out.println("1 1");
            n--;
        }
        if(n>=1){
            System.out.println("2 1");
            n--;
        }
        if(n>=1){
            System.out.println("2 2");
            n--;
        }
        
        for(int i=3;i<n1;i++){
            System.out.println(i+" "+i);
        }
       
        
        }
    }
	}
	  
	
	    
	