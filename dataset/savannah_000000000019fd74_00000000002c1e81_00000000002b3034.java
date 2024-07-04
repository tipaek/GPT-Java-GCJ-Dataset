import java.util.*;
import java.io.*;
public class Solution{
    private static String output1 = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int casee = 1; casee <= t; ++casee) {
                new Solution().getAnswer(casee, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int casee, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String str = scanner.next();
            list.add(str);

        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String l1, String l2) {
                return l1.length() - l2.length();
            }
        });
        boolean pat = true;
        String prev = list.get(0);
        int index = prev.indexOf("*");
        String prevL = prev.substring(0, index);
        String prevR = "" ;
        if (index < prev.length()) {
            prevR = prev.substring(index+1);
        }
        for (int i = 0 ; i < list.size() ; i++) {
            String str = list.get(i);
            index = str.indexOf("*");
            String curLeft = str.substring(0, index);
            String curRight = "" ;
            if (index < str.length()) {
                curRight = str.substring(index+1);
            }

            char[] prevChars = prevL.toCharArray();
            char[] curChars = curLeft.toCharArray();
            int n1 = prevChars.length , n2 = curChars.length;
            int i1 = 0 , i2 = 0;
            while (i1 < n1 && i2 < n2) {
                if (prevChars[i1] == curChars[i2]) {
                    i1++;
                    i2++;
                } else {
                    pat = false;
                    break;
                }
            }
            if (!pat) {
                break;
            }

            if (curLeft.length() > prevL.length()) {
                prevL = curLeft;
            }
            prevChars = prevR.toCharArray();
            curChars = curRight.toCharArray();
            n1 = prevChars.length ;
            n2 = curChars.length;

            int i3 = n1-1 , i4 = n2-1;
            while (i3 >= 0 && i4 >= 0) {
                if (prevChars[i3] == curChars[i4]) {
                    i3--;
                    i4--;
                } else {
                    pat = false;
                    break;
                }
            }
            if (!pat) {
                break;
            }

            if (curRight.length() > prevR.length()) {
                prevR = curRight;
            }
        }
        String result = "*";
        if (pat) {
            result = prevL + prevR ;
        }

        System.out.println(String.format(output1, casee, result));
    }

}