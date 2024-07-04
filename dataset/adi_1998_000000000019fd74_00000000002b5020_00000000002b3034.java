/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();int n;String ar[];int fl=0;int max;String smax="";int l;
	    for(int t1=0;t1<t;t1++)
	    {
	        n=sc.nextInt();ar=new String[n];for(int i=0;i<n;i++) ar[i]=sc.next();max=0;fl=0;
	        for(int i=0;i<n;i++) if(ar[i].length()>max) {max=ar[i].length();smax=ar[i].substring(1);}
	        max-=1;
	        for(int i=0;i<n;i++) 
	        {
	            l=ar[i].length()-1;//System.out.println(smax.substring(max-l)+i);
	            if(smax.substring(max-l).equals(ar[i].substring(1))) {continue;} 
	            else {fl=1;break;}
	        }
	        if(fl==1) System.out.println("Case #"+(t1+1)+": *");
	        else System.out.println("Case #"+(t1+1)+": "+smax);
	    }
	}
}
