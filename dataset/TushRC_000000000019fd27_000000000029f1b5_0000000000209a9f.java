import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution
{
    public static void main(String[] args)
    {
        List<int[]> digitStrings = readInputFromConsole(System.in);
        AtomicInteger counter = new AtomicInteger(0);
        digitStrings.forEach(intArray ->
                System.out.println(String.format("Case #%d: %s",
                        counter.addAndGet(1),
                        getBalancedString(intArray))));
    }

    private static String getBalancedString (int[] unbalanced)
    {
        final String openParentheses = "(";
        final String closeParentheses = ")";
        List<String> resultList = new ArrayList<>();

        for (int i = 1; i <= unbalanced[0]; i++)
        {
            resultList.add(openParentheses);
        }
        resultList.add(String.valueOf(unbalanced[0]));

        for (int i = 1; i < unbalanced.length; i++)
        {
            int deltaPrevious = unbalanced[i] - unbalanced[i-1];
            if (deltaPrevious >= 0)
            {
                for (int j = 1; j <= deltaPrevious; j++)
                {
                    resultList.add(openParentheses);
                }
            }
            else
            {
                for (int j = 1; j <= Math.abs(deltaPrevious); j++)
                {
                    resultList.add(closeParentheses);
                }
            }
            resultList.add(String.valueOf(unbalanced[i]));
        }

        for (int i = 1; i <= unbalanced[unbalanced.length - 1]; i++)
        {
            resultList.add(closeParentheses);
        }

        return String.join("", resultList);
    }

    private static List<int[]> readInputFromConsole (InputStream inputStream)
    {
        List<int[]> inputStrings;
        try (Scanner console = new Scanner(new BufferedReader(new InputStreamReader(inputStream))))
        {
            int numberOfCases = 0;
            if (console.hasNextLine())
            {
                Scanner firstLine = new Scanner(console.nextLine());
                if (firstLine.hasNextInt())
                {
                    numberOfCases = firstLine.nextInt();
                }
                if (numberOfCases == 0)
                {
                    return Collections.emptyList();
                }
            }

            inputStrings = new ArrayList<>(numberOfCases);
            for (int i = 1; i <= numberOfCases; i++)
            {
                if (console.hasNextLine())
                {
                    inputStrings.add(console.nextLine()
                            .chars()
                            .map(Character::getNumericValue)
                            .toArray());
                }
            }
        }
        return inputStrings;
    }
}
