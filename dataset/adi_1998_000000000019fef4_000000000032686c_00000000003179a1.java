/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);int t=sc.nextInt();int n;String s;int a[][];int max;String res;int u;
		int c1,c2;int in;int ct;
		for(int t1=1;t1<=t;t1++)
		{
		    int ar[][]=new int[11][26];ct=0;String ten[]=new String[500];u=sc.nextInt();
		    for(int i=1;i<=10000;i++)
		    {
		        n=sc.nextInt();s=sc.next();if(n<10) ar[n][(int)(s.charAt(0)-'A')]++;
		        if(n==10) {ten[ct]=s;ct++;}
		    }
		  
		    /*a=new int[10][26];int c[]=new int[10001];res="";u=sc.nextInt();int ct=0;
		    //for(int i=0;i<10;i++){for(int j=0;j<26;j++) System.out.print(a[i][j]+" ");System.out.println();}
		    for(int i=0;i<10000;i++)
		    {
		        n=sc.nextInt();s=sc.next();c[n]++;
		        if(s.length()==1) 
		        {
		            if(n>9) n=9;c1=(int)(s.charAt(0)-'A');for(int j=1;j<=n;j++) a[j][c1]++;
		        }
		        else
		        {
		            c1=(int)(s.charAt(0)-'A');c2=(int)(s.charAt(1)-'A');
		            for(int j=10;j<=n;j++){a[j/10][c1]++;a[j%10][c2]++;}
		        }
		    }*/
		    /*for(int i=0;i<10;i++)
		    {
		        max=a[i][0];in=0;for(int j=1;j<26;j++) {if(a[i][j]>max){max=a[i][j];in=j;}}
		        res+=(char)('A'+in);
		    }*/
		    res="";
		    for(int i=1;i<10;i++)
		    {
		        max=ar[i][0];in=0;for(int j=1;j<26;j++){if(ar[i][j]>max){max=ar[i][j];in=j;}}
		        for(int j=1;j<10;j++) ar[j][in]=0;
		        res+=(char)('A'+in);
		    }
		    for(int i=0;i<ct;i++) 
		    {
		        if(ten[i].length()>1) {res=ten[i].charAt(1)+res;break;}
		    }
		    System.out.println("Case #"+t1+": "+res);
		    //for(int i=1;i<=99;i++) System.out.print(c[i]+" ");
		}
	}
}
