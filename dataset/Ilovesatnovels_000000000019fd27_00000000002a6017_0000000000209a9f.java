import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < testCases; i++)
        {
            String s = scan.nextLine();
            String sFinal = "";
            int j = 0;
            while(j < s.length())
            {
                if(s.charAt(j) == '1')
                {
                    sFinal += "(";
                    while(j < s.length() && s.charAt(j) == '1')
                    {
                        sFinal += "1";
                        j++;
                    }
                    sFinal += ")" + s.charAt(j);
                }
                else
                {
                    sFinal += 0;
                }
                j++;
            }
            System.out.println("Case #" + (i+1) + ": " + sFinal);
        }
    }
}
