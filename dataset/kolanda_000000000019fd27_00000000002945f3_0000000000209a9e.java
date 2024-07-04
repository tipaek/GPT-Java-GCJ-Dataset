import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int tc,b;
		tc=sc.nextInt();
		b=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
			String jubitr;
			String res="";
			int counter=1;
			int i=1;
			while(counter<=b)
			{
				System.out.println(counter);

				jubitr = sc.next();
				if(i%10 !=1)
				{
					res =res + jubitr;
					counter=counter + 1;
				}
				i = i  + 1;
			}
			System.out.println(res);
			jubitr=sc.next();
			if(jubitr.contains("Y"))
			{
				continue;
			}
	}
}
}