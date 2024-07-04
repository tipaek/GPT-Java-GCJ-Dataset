import java.util.*;

public class Main
{
	public static void main(String[] args) {
		
		Scanner scan;
		scan  = new Scanner (System.in) ;
		int t = scan.nextInt();
		
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
			
			
			System.out.println("Case#"+k+":"+" "+sum+" "+countRow+" "+countCol );
		}
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
	
	