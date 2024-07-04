import java.util.*; 
import java.io.*; 

public class Solution
{ 
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int t, b;
		t = sc.nextInt();
		b = sc.nextInt();
		for (int z = 1; z <= t; z++)
        {
            if (b == 10)
            {
                int[] arr = new int[10];
                for (int m = 1; m <= t; m++)
                {
                    for (int i = 1; i <= 10; i++)
                    {
                        out.print(i);
                        out.newLine();
                        out.flush();
                        arr[i - 1] = Integer.parseInt(sc.nextLine());
                    }
                    for (int i = 0; i < 10; i++)
                    {
                        out.print(arr[i]);
                    }
                    out.newLine();
                    out.flush();
                    sc.nextLine();
                }
            }
        }
	}
}