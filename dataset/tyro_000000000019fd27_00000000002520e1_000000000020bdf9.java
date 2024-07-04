import java.util.*;
import java.lang.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		 int t,l,i,n,cs,ce,js,j,je;
		 String ans;
		 t=in.nextInt();
		 for(l=1;l<=t;l++)
		 {
		 	n=in.nextInt();
		 	int s[]=new int[n];
		 	int e[]=new int [n];

		 	for(i=0;i<n;i++)
		 	{
		 		s[i]=in.nextInt();
		 		e[i]=in.nextInt();
		 	}
		 	for(i=1;i<n;i++)
		 	{
		 		j=i-1;
		 		js=s[i];
		 		je=e[i];
		 		while(j>=0&&s[j]>js)
		 		{
		 		    s[j+1]=s[j];
		 		    e[j+1]=e[j];
		 		    j--;
		 		}
		 		s[j+1]=js;
		 		e[j+1]=je;
		 	}
		 	cs=s[0];ce=e[0];js=je=0;ans="C";
		 	for(i=1;i<n;i++)
		 	{
		 			if(je<=s[i]||js>=e[i])
		 			{
		 				ans+="J";
		 				je=e[i];js=s[i];
		 			}
		 			else if(ce<=s[i]||cs>=e[i])
		 			{
		 				ans+="C";
		 				ce=e[i];cs=s[i];
		 			}
		 			else if(s[i]<e[i-1]){
		 				ans="IMPOSSIBLE";
		 				break;
		 			}
		 	}

		 	System.out.println("Case #"+l+": "+ans);
	}
}
}