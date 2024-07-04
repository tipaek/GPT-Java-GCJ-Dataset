import java.util.*; 

public class Solution
{ 
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int t, b;
		t = nextInt();
		b = nextInt();
		sc.nextLine();
		for (int z = 1; z <= t; z++)
        {
            if (b == 10)
            {
                int[] arr = new int[10];
                for (int m = 1; m <= t; m++)
                {
                    for (int i = 1; i <= 10; i++)
                    {
                        System.out.println(i);
                        System.out.flush();
                        arr[i - 1] = Integer.parseInt(sc.nextLine());
                    }
                    for (int i = 0; i < 10; i++)
                    {
                        System.out.println(arr[i]);
                    }
                    System.out.println();
                    System.out.flush();
                    sc.nextLine();
                }
            }
        }
	}
}