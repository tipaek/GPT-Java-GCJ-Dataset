import java.util.*;
import java.io.*;

public class Solution
{
    public static void prarray(char ar[])
    {
        for(int i=0;i<ar.length;i++)
            System.out.print(ar[i]);
        System.out.println();
    }
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,i,b;
        char bitstring[],result;

		p=t=sc.nextInt();
        b=sc.nextInt();

		while(t-->0)
		{
            bitstring=new char[b];
			for(i=0;i<b;i++)
            {
                System.out.println(i+1);
                bitstring[i]=sc.next().charAt(0);
            }

            prarray(bitstring);
            result=sc.next().charAt(0);
            if(result=='N')
                System.exit(0);
            // System.out.println("Case #"+(p-t)+": "+sb);
		}
	}
}