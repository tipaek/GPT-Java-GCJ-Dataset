import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;

        for (int t = 0; t < T; t++) {
            String s = sc.hasNext() ? sc.next() : "";
            char maxChar = findMaxChar(s);
            int maxCharValue = maxChar;

            ArrayList<Character> resultList = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int value = maxCharValue + currentChar - '0' - '0';

                if (currentChar >= '0' && currentChar <= '9') {
                    if (value > 0) {
                        addCharacters(resultList, '(', value);
                        maxCharValue -= value;
                    } else if (value < 0) {
                        addCharacters(resultList, ')', -value);
                        maxCharValue -= value;
                    }
                    resultList.add(currentChar);
                }
            }

            addCharacters(resultList, ')', s.charAt(s.length() - 1) - '0');
            System.out.println("Case #" + (t + 1) + ": " + listToString(resultList));
        }
        sc.close();
    }

    private static char findMaxChar(String s) {
        char maxChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > maxChar) {
                maxChar = s.charAt(i);
            }
        }
        return maxChar;
    }

    private static void addCharacters(ArrayList<Character> list, char ch, int count) {
        for (int i = 0; i < count; i++) {
            list.add(ch);
        }
    }

    private static String listToString(ArrayList<Character> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (Character ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}