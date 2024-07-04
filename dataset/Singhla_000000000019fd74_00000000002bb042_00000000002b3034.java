import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=0;x<t;x++){
            int n=sc.nextInt();
            String pat[]=new String[n];
            for(int i=0;i<n;i++){
                pat[i]=sc.next();
            }
			//for(int i =0;i<pat.length;i++){
				//System.out.print(pat[i]+" ");
			
            //boolean flag=false;
            //for(int i=0;i<pat.length;i++){
              //  if(pat[i].charAt(0)!='*')
                //flag=true;
            //}
            int len=0;
            String large="";
            for(int i=0;i<pat.length;i++){
            if(pat[i].length()>len){
                len=pat[i].length();
                large=pat[i];
            }
			}
            // System.out.println(large);
            large=large.substring(1);
		//	 System.out.println(large);
            
            String res=large;
           
            for(int i=0;i<pat.length;i++){
                if(large.contains(pat[i].substring(1))==false){
                    res="*";
                }
            }
            
            
			int ans=x+1;
            System.out.println("Case #"+ans+": "+res);
            
            
        }
        
    }
}
