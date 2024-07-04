import java.util.*;
public class Solution
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            String s = sc.next();
            ArrayList <String> ar = new ArrayList<>();
            for (int j = 0;j < s.length(); j++)
                ar.add(s.substring(j,j+1));
            for (int k = ar.size()-1 ; k>=0; k--)
            {
                int a = Integer.parseInt(ar.get(k));
                for (int l = 0; l < a; l++)
                {
                    ar.add(k+1,")");
                }
                for (int l = 0; l < a; l++)
                {
                    ar.add(k,"(");
                }
            }
            String test = ar.toString().replaceAll("[,\\[\\]]","").replaceAll(" ","");
            while (test.contains(")("))
                test = test.replaceAll("\\)\\(","");
            System.out.println("Case #" + i + ": " + test);
        }
    }
}