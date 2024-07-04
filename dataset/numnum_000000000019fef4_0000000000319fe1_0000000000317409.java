import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int ks = input.nextInt();
        for (int i = 0; i < ks; i++)
        {
            int x = input.nextInt();
            int y = input.nextInt();
            int result = 0;
            
            String dir = input.nextLine();
            
            for (int j = 1; j < dir.length(); j++)
            {
                if (dir.charAt(j) == 'N')
                {
                    y++;
                }
                else if (dir.charAt(j) == 'S')
                {
                    y--;
                }
                else if (dir.charAt(j) == 'E')
                {
                    x++;
                }
                else if (dir.charAt(j) == 'W')
                {
                    x--;
                }
                
                if (Math.abs(x)+Math.abs(y) <= j)
                {
                    result = j;
                    j = dir.length();
                    break;
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            if (result > 0)
            {
                System.out.println(result);
            }
            else
            {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}