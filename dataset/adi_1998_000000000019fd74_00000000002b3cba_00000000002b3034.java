import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();int n;String ar[];int fl=0;int max;String smax="";
	    for(int t1=0;t1<t;t1++)
	    {
	        n=sc.nextInt();ar=new String[n];for(int i=0;i<n;i++) ar[i]=sc.next();max=0;fl=0;
	        for(int i=0;i<n;i++) if(ar[i].length()>max) {max=ar[i].length();smax=ar[i].substring(1);}
	        for(int i=0;i<n;i++) if(smax.indexOf(ar[i].substring(1))<0) {fl=1;break;}
	        if(fl==1) System.out.println("Case #"+(t1+1)+": *");
	        else System.out.println("Case #"+(t1+1)+": "+smax);
	    }
	}
}
