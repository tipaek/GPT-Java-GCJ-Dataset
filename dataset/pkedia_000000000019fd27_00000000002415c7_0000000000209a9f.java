
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String data = in.nextLine();
        int numberOFTestCases = Integer.parseInt(data);

        for (int caseNumber = 1; caseNumber <= numberOFTestCases; caseNumber++) {
            StringBuilder sb = new StringBuilder();
            String input = in.nextLine();


            int open =0;

            for(int index=0;index<input.length();index++)
            {
                int num = input.charAt(index) - 48;

                if(num>open)
                {
                    int diff = num -open;
                    append(sb, diff, '(');
                    open += diff;
                }else {
                     int diff = open - num;
                     append(sb, diff,')');
                     open -= diff;
                }
                sb.append(num);
            }

            append(sb, open,')');



            System.out.println("Case #" + caseNumber + ": " + sb.toString() );
        }

        in.close();



    }

   private static void append(StringBuilder stringBuilder, int num , char b)
    {
        while (num-->0)
        {
            stringBuilder.append(b);
        }
    }
}
