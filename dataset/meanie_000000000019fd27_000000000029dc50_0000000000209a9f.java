import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int noOfTests = Integer.parseInt(scanner.nextLine());
        for (int caseNo = 1; caseNo <= noOfTests; caseNo++)
        {
            String s = scanner.nextLine();

            // Substrings with only zeros
            LinkedList<String> zeros = new LinkedList<>();
            StringBuilder zeroSubString = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == '0')
                {
                    zeroSubString.append(s.charAt(i));
                }
                else {
                    String stringWithZeros = zeroSubString.toString();
                    if (!stringWithZeros.equals(""))
                    {
                        zeros.add(stringWithZeros);
                        zeroSubString.delete(0, zeroSubString.length() - 1);
                    }
                }
            }
            String stringWithZeros = zeroSubString.toString();
            if (!stringWithZeros.equals(""))
            {
                zeros.add(stringWithZeros);
            }

            boolean startWithZeros = s.charAt(0) == '0';
            String[] subStrings = s.split("0");
            StringBuilder result = new StringBuilder();
            if (startWithZeros)
            {
                for (int i = 0; i < subStrings.length; i++)
                {
                    if (zeros.size() > 0)
                    {
                        result.append(zeros.pollFirst());
                    }
                    result.append(addParentheses(subStrings[i]));
                }
                if (zeros.size() > 0)
                {
                    result.append(zeros.pollFirst());
                }
            }
            else {
                for (int i = 0; i < subStrings.length; i++)
                {
                    result.append(addParentheses(subStrings[i]));
                    if (zeros.size() > 0)
                    {
                        result.append(zeros.pollFirst());
                    }
                }
            }

            String stringResult = result.toString();
            System.out.println("Case #" + caseNo + ": " + stringResult);
        }
    }

    private static String addParentheses(String s)
    {
        StringBuilder result = new StringBuilder();
        // Add all parentheses
        for (int i = 0; i < s.length(); i++)
        {
            int noOfParentheses = Character.getNumericValue(s.charAt(i));
            result.append(repeatChar('(', noOfParentheses) + s.charAt(i) + repeatChar(')', noOfParentheses));
        }
        String stringWithAllParentheses = result.toString();

        // Remove redundant parentheses
        while (stringWithAllParentheses.contains(")("))
        {
            stringWithAllParentheses = stringWithAllParentheses.replaceAll("\\)\\(", "");
        }

        return stringWithAllParentheses;
    }

    private static String repeatChar(char c, int times)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++)
        {
            result.append(c);
        }

        return result.toString();
    }
}
