import java.util.*;

public class Solution {
    private static String output = "Case #%d: %s";
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int line = scanner.nextInt();
            for (int i = 1; i <= line; ++i) {
                new Solution().getAnswer(i, scanner);
            }
    }

    private void getAnswer(int line, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String str = scanner.next();
            list.add(str);

        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        boolean matched = true;
        String prev = list.get(0);
        int index = prev.indexOf("*");
        String prevLeft = prev.substring(0, index);
        String prevRight = "" ;
        if (index < prev.length()) {
            prevRight = prev.substring(index+1);
        }


        for (String str : list) {
            index = str.indexOf("*");
            String curLeft = str.substring(0, index);
            String curRight = "";
            if (index < str.length()) {
                curRight = str.substring(index + 1);
            }

            char[] prevChars = prevLeft.toCharArray();
            char[] curChars = curLeft.toCharArray();


            int n1 = prevChars.length, n2 = curChars.length;
            int i1 = 0, i2 = 0;
            while (i1 < n1 && i2 < n2) {
                if (prevChars[i1] == curChars[i2]) {
                    i1++;
                    i2++;
                } else {
                    matched = false;
                    break;
                }
            }

            if (!matched) {
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            prevChars = prevRight.toCharArray();
            curChars = curRight.toCharArray();
            int n3 = prevChars.length;
            int n4 = curChars.length;

            int i3 = n3 - 1, i4 = n4 - 1;
            while (i3 >= 0 && i4 >= 0) {
                if (prevChars[i3] == curChars[i4]) {
                    i3--;
                    i4--;
                } else {
                    matched = false;
                    break;
                }
            }

            if (!matched) {
                break;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

        }

        String result = "*";
        if (matched) {
            result = prevLeft + prevRight ;
        }

        System.out.println(String.format(output, line, result));
    }

}
