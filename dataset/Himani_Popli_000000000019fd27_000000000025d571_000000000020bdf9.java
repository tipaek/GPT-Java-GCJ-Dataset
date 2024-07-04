/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int k=1;k<=t;k++){
		    int n=scan.nextInt();
		    int[] s=new int[n];
		    int[] e=new int[n];
		    for(int i=0;i<n;i++){
		        s[i]=scan.nextInt();
		        e[i]=scan.nextInt();
		    }
		    boolean[] vis=new boolean[n];
		    char[] ch=new char[n];
		    String ans="";
		    while(true){
		        Set<Integer> set1=new HashSet<>();
		        Set<Integer> set2=new HashSet<>();
		        boolean temp=divide(s,e,vis,set1,set2,n);
		      //  System.out.println(set1);
		      //  System.out.println(set2);
		        if(temp){
		            if(set1.isEmpty()&&set2.isEmpty()){
		                break;
		            }else{
		                for(int in:set1){
		                    ch[in]='C';
		                }
		                for(int in:set2){
		                    ch[in]='J';
		                }
		            }
		        }else{
		            ans="IMPOSSIBLE";
		            break;
		        }
		    }
		    if(ans=="IMPOSSIBLE"){
		        System.out.println("Case #"+k+": "+ans);
		    }else{
		        ans=new String(ch);
		        System.out.println("Case #"+k+": "+ans);
		    }
		}
	}
	public static boolean divide(int[] s,int[] e,boolean[] vis,Set<Integer> set1,Set<Integer> set2,int n){
	    boolean flag=false;
	    for(int i=0;i<n;i++){
	        if(!vis[i]){
    	        for(int j=i+1;j<n;j++){
    	            if(!vis[j]&&isOverlapping(s[i],e[i],s[j],e[j])){
    	                set1.add(i);
    	                set2.add(j);
    	                vis[i]=true;
    	                vis[j]=true;
    	                flag=true;
    	                break;
    	            }
    	        }
    	        if(flag){
    	            break;
    	        }
	        }
	    }
	    if(flag){
	        boolean change=true;
	        while(change){
	            change=false;
	            for(int i=0;i<n;i++){
	                if(!vis[i]){
	                    boolean added1=true,added2=true;
	                    for(int in:set1){
	                        if(isOverlapping(s[i],e[i],s[in],e[in])){
	                            added1=false;
	                            break;
	                        }
	                    }
	                    for(int in:set2){
	                        if(isOverlapping(s[i],e[i],s[in],e[in])){
	                            added2=false;
	                            break;
	                        }
	                    }
	                    if(added1==false&&added2==false){
	                        return false;
	                    }
	                    else if(!(added1==true&&added2==true)){
	                        if(added1){
	                            set1.add(i);
	                        }else{
	                            set2.add(i);
	                        }
	                        vis[i]=true;
	                        change=true;
	                    }
	                }
	            }
	        }
	    }else{
	        for(int i=0;i<n;i++){
	            if(!vis[i]){
	                set1.add(i);
	                vis[i]=true;
	            }
	        }
	    }
	    return true;
	}
	public static boolean isOverlapping(int s1,int e1,int s2,int e2){
	    if((s2<s1&&e2<=s1)||(s2>=e1&&e2>e1)){
	        return false;
	    }
	    return true;
	}
}
