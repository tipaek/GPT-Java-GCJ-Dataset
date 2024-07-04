import java.util.*; 

public class Solution
{ 
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int t;
		t = Integer.parseInt(sc.nextLine());
		
		for (int z = 1; z <= t; z++)
        {
            String s = sc.nextLine();
            int[] digits = new int[s.length()];
            int[] digitsCopy = new int[s.length()];
            
            int[] start = new int[s.length()];
            for (int i = 0; i < digits.length; i++)
                start[i] = 0;
            int[] end = new int[s.length()];
            for (int i = 0; i < digits.length; i++)
                end[i] = 0;
            
            for (int i = 0; i < digits.length; i++)
            {
                digits[i] = Integer.parseInt(s.charAt(i) + "");
            }
            for (int i = 0; i < digits.length; i++)
                digitsCopy[i] = digits[i];
            
            int ptr = 0;
            while (ptr < digits.length)
            {
                while (digits[ptr] > 0)
                {
                    int last = ptr + 1;
                    while (last < digits.length && digits[last] != 0)
                    {
                        last++;
                    }
                        
                    start[ptr]++;
                    end[last - 1]++;
                    
                    for (int i = ptr; i < last; i++)
                        digits[i]--;
                }
                
                boolean seenNon0 = false;
                for (int i = 0; i < digits.length; i++)
                {
                    if (digits[i] != 0)
                    {
                        seenNon0 = true;
                        break;
                    }
                }
                if (!seenNon0)
                    break;
                    
                ptr++;
            }
            
            System.out.print("Case #" + z + ": ");
            
            for (int i = 0; i < digits.length; i++)
            {
                for (int j = 0; j < start[i]; j++)
                    System.out.print("(");
                System.out.print(digitsCopy[i]);
                for (int j = 0; j < end[i]; j++)
                    System.out.print(")");
            }
            System.out.println();
        }
	}
}