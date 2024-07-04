import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int z = 1; z <= t; z++)
        {
            String input = scan.next();
            String output="";
            int k = 0, value = 0;
            for (int i = 0; i < input.length(); i++)
            {
                value = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (k == value)
                {
                    output=output+value;
                }
                else if (k < value)
                {
                    for (int j = 0; j < value-k; j++){
                        output=output+"(";
                    }

                    output=output+value;
                    k=value;
                }
                else
                {
                    for (int j = 0; j < k-value; j++)
                    {
                        output = output + ")";
                    }
                    output=output+value;
                    k=value;
                }
            }
            for(int j=0;j<k;j++)
                output=output+")";
            System.out.println("Case #" + z + ": "+output);
        }

    }
}