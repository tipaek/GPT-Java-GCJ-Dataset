import java.util.Scanner;

public class Solution {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= t; c++)
        {
            String str = in.nextLine();
            int terms[] = new int[str.length()];
            for (int i =0 ; i< terms.length; i++)
            {
                terms[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            int count = 0;
            StringBuffer s = new StringBuffer();
            for (int i =0 ; i< terms.length; i++)
            {
                while (count < terms[i])
                {
                    s.append('(');
                    count++;
                }
                while (count > terms[i])
                {
                    s.append(')');
                    count--;
                }
                s.append(terms[i]);
            }
            while (count > 0)
            {
                s.append(')');
                count--;
            }
            System.out.printf("Case #%d: %s\n", c, s.toString());
        }
    }
}
