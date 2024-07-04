import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            String check = "";
            for (int j = 0; j < n; j++)
            {
                String s = sc.next();
                arr[j] = s;
                if (s.length() > check.length())
                    check = s;
            }
            check = check.replaceAll("\\*","");
            String str = check;
            for (int j = 0; j < n; j++)
            {
                String test = arr[j].replaceAll("\\*",".*");
                if (!check.matches(test))
                {
                    str = "*";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + str);
        }
    }
}
