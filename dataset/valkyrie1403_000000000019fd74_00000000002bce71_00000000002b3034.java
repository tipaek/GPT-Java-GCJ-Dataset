import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= t; i++)
        {
            int n = Integer.parseInt(in.nextLine());
            String [] patterns = new String[n];
            for (int j=0; j<n; j++)
                patterns[j] = in.nextLine();

            String s1 = match(patterns);

            System.out.println("Case #" + i + ": " + s1);
        }
    }

    private static String match(String [] patterns)
    {
        String [] reverse = new String[patterns.length];
        for (int i = 0; i < patterns.length; i++)
        {
            patterns[i] = patterns[i].replaceAll("\\*+", "*");
            reverse[i] = reverseString(patterns[i]);
        }

        Arrays.sort(patterns);
        Arrays.sort(reverse);

        String forwardPrefix = getPrefix(patterns);
        String reversePrefix = getPrefix(reverse);

        if ((forwardPrefix == null) || (reversePrefix == null))
            return "*";

        if (forwardPrefix.length() + reversePrefix.length() == 0)
            return "A";

        return forwardPrefix + reverseString(reversePrefix);
    }

    private static String reverseString(String pattern) {
        char [] chars = pattern.toCharArray();
        int len = pattern.length();
        for (int i = 0; i < len / 2; i++)
        {
            char tmp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = tmp;
        }

        return new String(chars);
    }

    private static String getPrefix(String[] patterns)
    {
        String forwardPattern = "";
        for (int i = 0; i < patterns.length; i++)
        {
            String prefix = patterns[i].substring(0, patterns[i].indexOf('*'));
            if (prefix.length() == 0)
                continue;
            if (!prefix.startsWith(forwardPattern))
                return null;

            forwardPattern = prefix;
        }
        return forwardPattern;
    }

}
