/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
    
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cse=0;
		while(t--!=0){
		    cse++;
		    int n = sc.nextInt();
		    String arr[] = new String[n];
		    int max =  0;
		    String biggest = "";
		    for(int i=0;i<n;i++)
		    {arr[i]=sc.next();
		        int len = arr[i].length();
		        if(len>max){
		            max=len;
		            biggest="";
		            biggest += arr[i];
		        }
		        
		    }
		    String ans = "";
		    for(int i=1;i<max;i++)
		    ans+=biggest.charAt(i);
		    int count=0;
		    for(int i=0;i<n;i++){
		        String s = arr[i];
		        if(biggest.contains(s))
		            count++;
		      
		    }
		    if(count==n)
		    System.out.println("Case #"+cse+": "+ans);
		    else
		    System.out.println("Case #"+cse+": *" );
		    
		    
		    
		    }
		    
		}
	}
