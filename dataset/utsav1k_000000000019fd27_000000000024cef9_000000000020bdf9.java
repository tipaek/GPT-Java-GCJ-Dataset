
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k1=0;k1<t;k1++){
		    int n=sc.nextInt();
		    int[] s=new int[n];
		    int[] e=new int[n];
		    boolean[] bc=new boolean[1442];
		    boolean[] bj=new boolean[1442];
		    for(int i=0;i<n;i++){
		        s[i]=sc.nextInt();
		        e[i]=sc.nextInt();
		    }
		    String s1="";
		    String c="";
		    for(int i=0;i<n;i++){
		        if(bc[s[i]]==true && bj[s[i]]==true){
		            c="h";
		            break;
		        }
		        else if(bc[s[i]]==true || bc[e[i]]==true){
		            c="J";
		            s1+="J";
		        }
		        else if(bj[s[i]]==true || bj[e[i]]==true){
		            c="C";
		            s1+="C";
		        }
		        else{
		            c="C";
		            s1+="C";
		        }
		        for(int j=s[i];j<e[i];j++){
		            if(c.equals("J")){
		                bj[j]=true;
		            }
		            else{
		                bc[j]=true;
		            }
		        }
		    }
		    if(c.equals("h")){
		        System.out.println("Case #"+(k1+1)+": IMPOSSIBLE");
		    }
		    else{
		        System.out.println("Case #"+(k1+1)+": "+s1);
		    }
		}
	}
}
