import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        for(int i = 0; i < S; i++)
        {
            int s = sc.nextInt();
            String[] word = "";
            for(int j = 0; j < s; j++)
            {
                word.add(sc.next());
                
            }
        }
        System.out.println("Case #" + i + ": " + word);
    }
}