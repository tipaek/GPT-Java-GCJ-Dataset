import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by mohan on 05, Apr, 2020
 */
public class Solution {
    public static void main(String[] args) throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < testCase; t++)
        {
            String str = scanner.nextLine();
            int bracketPosition=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++)
            {
                char ch = str.charAt(i);
                int charValue = ch-48;
                if(charValue==bracketPosition)
                {
                    sb.append(ch);
                }
                else if(charValue>bracketPosition)
                {
                    int difference = charValue-bracketPosition;
                    sb.append(getBraces(difference,"(")).append(ch);
                    bracketPosition = bracketPosition+difference;
                }
                else
                {
                    int difference = bracketPosition-charValue;
                    sb.append(getBraces(difference,")")).append(ch);
                    bracketPosition=bracketPosition-difference;
                }
            }
            if(bracketPosition>0)
            {
                sb.append(getBraces(bracketPosition,")"));
            }
            System.out.println(sb.toString());
        }
    }

    public static String getBraces(int n,String bracketType){
        return String.join("", Collections.nCopies(n, bracketType));
    }
}
