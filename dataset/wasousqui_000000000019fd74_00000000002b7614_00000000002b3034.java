import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            int patternSize = scan.nextInt();
            String[] patterns = new String[patternSize];
            for (int j = 0; j < patternSize; j++)
                patterns[j] = scan.nextLine();
            System.out.println("Case #" + (i+1) + ": " + getName(patterns));
        }
    }


    public static String getName(String[] patterns)
    {
        String res = getStart(patterns);
        String end = getEnd(patterns);
        if (res == null || end == null)
            return ("*");
        for (String str: patterns)
        {
            int startIndex = 1;
            String[] tab = str.split("\\*");
            int endIndex = tab.length - 2;
            while (startIndex <= endIndex)
                res += tab[startIndex++];
        }
        return (res + end);
    }

    public static String getStart(String[] patterns)
    {
        String pattern = "";
        for (String str: patterns)
        {
            if (str.charAt(0) != '*') {
                String[] tab = str.split("\\*");
                if (pattern.length() == 0)
                    pattern = tab[0];
                else if (tab[0].startsWith(pattern))
                    pattern = tab[0];
                else if (!pattern.startsWith(tab[0]))
                    return (null);
            }
        }
        return (pattern);
    }

    public static String getEnd(String[] patterns)
    {
        String pattern = "";
        for (String str: patterns)
        {
            if (str.charAt(str.length() - 1) != '*') {
                String[] tab = str.split("\\*");
                int tablen = tab.length;
                if (pattern.length() == 0)
                    pattern = tab[tablen - 1];
                else if (tab[tablen - 1].endsWith(pattern))
                    pattern = tab[tablen - 1];
                else if (!pattern.endsWith(tab[tablen - 1]))
                    return (null);
            }
        }
        return (pattern);
    }
}
