import java.util.*;
import java.io.*;

	public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scan.nextInt();
		String ans = new String () ;
		
		for (int k=1 ;k<=t ;k++)
		{
			int n=scan.nextInt();
			int [][] arr = new int [n][n] ;
			String  s = new String ();
			int  sum=0,countRow=0 , countCol=0 ;
			
			for ( int i=0 ; i<n ;i++)
			{
				for ( int j=0 ;j<n ;j++)
				{
					arr[i][j] = scan.nextInt();
					if (i==j)
						sum+=arr[i][j];
				}
			}
			
			 for ( int i=0 ;i<n ;i++)
			 {
				 for (int j=0 ;j<n ;j++)
				 {
					 s+=arr[i][j];
				 }
				 if ( !distinct(s) ) countRow++;
				 s=new String();
			 }
			 for ( int i=0 ;i<n ;i++)
			 {
				 for (int j=0 ;j<n ;j++)
				 {
					 s+=arr[j][i];
				 }
				 if ( !distinct(s) ) countCol++;
				 s=new String();
			 }
			
			ans+="Case#"+k+":"+" "+sum+" "+countRow+" "+countCol ;
			if (k!=t) ans+="\n";
		}
		System.out.print(ans);
	}
	
	public static boolean distinct ( String str)
	{
		for (int i = 0; i < str.length(); i++) 
            for (int j = i + 1; j < str.length(); j++) 
                if (str.charAt(i) == str.charAt(j)) 
                    return false;
		return true;
	}
}