import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		String x=sc.nextLine();
		for(int i=0;i<t;i++)
		{
		    String s=sc.nextLine();
		    s=s+"0";
		    int l=s.length();
		    for(int j=0;j<l-1;j++)
		    {
		        int temp=Math.abs('0'-s.charAt(j));
		        for(int k=0;k<temp;k++)
		        {
		            System.out.print("(");
		        }
		        System.out.print(temp);
		        for(int k=0;k<temp;k++)
		        {
		            System.out.print(")");
		        }
		    }
		}
	}
}
