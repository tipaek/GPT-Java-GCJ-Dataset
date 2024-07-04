import java.util.*;

public class Solution
{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {        
        int T = in.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            solveCase(testCase);
        }
    }

    public static void solveCase(int testCase)
    {        
		int U = in.nextInt();

		String D = "";
		
		//long Q[] = new long[10000];
		//String R[] = new String[10000];

		char pool[] = new char[10];
		char poolFirst[] = new char[9];

		long[] count = new long[10];

		for (int i = 0; i < 10; i++)
		{
			count[i] = 0;
			pool[i] = '#';
			if (i < 9)	poolFirst[i] = '#';
		}

		for (int i = 0; i < 10000; i++)
		{
			/*int inQ = in.nextLong();
			int inR = in.next();
			Q[i] = inQ;
			R[i] = in.next();

			int j = i - 1; 

            while (j >= 0 && Q[j] > inQ) { 
				Q[j + 1] = Q[j]; 
				R[j + 1] = R[j];
                j = j - 1; 
            } 
            Q[j + 1] = inQ; 
			R[j + 1] = inR; */
			
			long inQ = in.nextLong();
			String inR = in.next();

			for (int j = 0; j < inR.length(); j++)
			{
				char temp = inR.charAt(j);

				for (int k = 0; k < 10; k++)
				{
					if (pool[k] == temp)	
					{
						count[k]++;
						break;
					}
					if (pool[k] == '#')
					{
						pool[k] = temp;
						if (j == 0)	
							poolFirst[k] = temp;
						
						count[k]++;
						break;
					}
				}
			}

		}

		//sort
		sort(count, pool);

	//	printCharArray(pool);
	//	printLongArray(count);

		char poolCheck[] = new char[10];
		for (int i = 0; i < 10; i++)
		{
			poolCheck[i] = '#';
		}


		//find zero
		for (int i = 0; i < poolFirst.length; i++)
		{
			for (int j = 0; j < pool.length; j++)
			{
				if (poolFirst[i] == pool[j])	
				{
					poolCheck[j] = pool[j];
					break;
				}
			}
		}

		int indexOfZero = 0;

		for (int i = 0; i < poolCheck.length; i++)
		{
			if (poolCheck[i] == '#')
			{
				indexOfZero = i;
				break;
			}
		}

		D += pool[indexOfZero];

		for (int i = 9; i >= 0; i--)
		{
			if (i != indexOfZero)	D+= pool[i];
		}

		char eight = D.charAt(9);

		char nine = D.charAt(8);

		D = D.substring(0, 8);

		D = D + eight + nine;

        //print output
        printCase(testCase, D);
	}

	static void printLongArray(long arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
	} 
	
	static void printCharArray(char arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
	
	/*Function to sort array using insertion sort*/
    static void sort(long arr[], char with[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
			long key = arr[i]; 
			char keyWith = with[i];
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
				arr[j + 1] = arr[j]; 
				with[j + 1] = with[j];
                j = j - 1; 
            } 
			arr[j + 1] = key; 
			with[j + 1] = keyWith;
        } 
    } 

    public static void printCase(int testCase, String out)
    {
        System.out.print("Case #" + testCase + ": ");
        System.out.print(out);
        System.out.println();
    }
}