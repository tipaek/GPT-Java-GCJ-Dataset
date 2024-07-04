

import java.util.*;

public class Solution {
    private static String output1 = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
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

        // for (int i = 0 ; i < n ; i++) {
        //     System.out.println(list.get(i));
        // }

        boolean pattern = true;
        String prev = list.get(0);
        for (int i = 0 ; i < list.size() ; i++) {
            String str = list.get(i);
            char[] prevChars = prev.toCharArray();
            char[] curChars = str.toCharArray();
            int n1 = prevChars.length , n2 = curChars.length;
            int i1 = 0 , i2 = 0;
            // test case 1 & 2 before *
            while (i1 < n1 && i2 < n2) {
                if (prevChars[i1] == '*' && curChars[i2] == '*') {
                    i1++;
                    i2++;
                    break;
                }
                if (prevChars[i1] == '*') {
                    i2++;
                } else if (prevChars[i1] == curChars[i2]) {
                    i1++;
                    i2++;
                } else {
                    pattern = false;
                    break;
                }
            }
            // System.out.println(String.format("11 i1 =%d , i2 = %d , pattern = %s" , i1, i2, pattern));

            if (!pattern) {
                break;
            }

            // test case 1 & 2 after *
            int i3 = n1-1 , i4 = n2-1;
            while (i3 >= i1 && i4 >= i2) {
//                if (prevChars[i1] == '*' && curChars[i2] == '*') {
//                    i1++;
//                    i2++;
//                    break;
//                }
                if (prevChars[i3] == curChars[i4]) {
                    i3--;
                    i4--;
                } else {
                    pattern = false;
                    break;
                }
            }
            // System.out.println(String.format("22 i3 =%d , i4 = %d , pattern = %s" , i3, i4, pattern));

            if (!pattern) {
                break;
            }
            prev = str;
        }

        String result = "*";
        if (pattern) {
            result = prev.replace("*", "");
        }

        System.out.println(String.format(output1, caseNum, result));
    }

}
