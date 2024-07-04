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
	    int t1 =sc.nextInt();
    
   
    for(int t=1;t<=t1;t++){
        int n=sc.nextInt();
        //cin>>n;
        String arr[]= new String[n];
        String ans="";
        HashMap<String,Integer> mp= new HashMap<>();
        HashMap<String,Integer> mp1= new HashMap<>();
        for(int i=0;i<n;i++){
        arr[i]=sc.next();
        if(!mp.containsKey(arr[i])){
        mp.put(arr[i],1);
        mp1.put(arr[i],1);
        //mp1[arr[i]]=1;
        }
        else{
         mp.put(arr[i],mp.get(arr[i])+1);
        mp1.put(arr[i],mp1.get(arr[i])+1);
        }
        }
        int p=0;
        int breaker=0;
        int countstar=0;
       while(countstar<n){
            char l='#';
            for(int i=0;i<n;i++){
               if(mp.get(arr[i])!=0){
                if(arr[i].charAt(p)=='*'){
                countstar++;
                mp.put(arr[i],mp.get(arr[i])-1);
                }
                else{
                    if(l=='#' || l==arr[i].charAt(p))
                    l=arr[i].charAt(p);
                    else{
                        breaker=1;
                        break;
                    }
                }
               }
            }
            if(l!='#')
            ans+=l;
            p++;
            if(breaker==1)
            break;
        }
        if(breaker==1){
            System.out.println("Case #"+t+": *");
        }else{
            countstar=0;
            p=1;
            String ans1="";
            while(countstar<n){
            char l='#';
            for(int i=0;i<n;i++){
               if(mp1.get(arr[i])!=0){
                if(arr[i].charAt(arr[i].length()-p)=='*'){
                countstar++;
                 mp1.put(arr[i],mp1.get(arr[i])-1);
                }
                else{
                    if(l=='#' || l==arr[i].charAt(arr[i].length()-p))
                    l=arr[i].charAt(arr[i].length()-p);
                    else{
                        breaker=1;
                        break;
                    }
                }
               }
            }
            if(l!='#')
            ans1+=l;
            p++;
            if(breaker==1)
            break;
        }
        String ans2="";
        for(int i=ans1.length()-1;i>=0;i--){
          ans2+=ans1.charAt(i);
        }
        if(breaker==1){
            System.out.println("Case #"+t+": *");
        }else
            System.out.println("Case #"+t+": "+ans+""+ans2);
        }
    }
	}
	  
	}
	    
	