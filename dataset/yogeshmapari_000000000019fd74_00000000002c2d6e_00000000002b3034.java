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

        for (int i = 0 ; i < n ; i++) {
            
        }

        boolean pattern = true;
        String prev = list.get(0);
        int index = prev.indexOf("*");
        String prevLeft = prev.substring(0, index);
        String prevRight = "" ;
        if (index < prev.length()) {
            prevRight = prev.substring(index+1);
        }

       

        for (int i = 0 ; i < list.size() ; i++) {
            String str = list.get(i);
            index = str.indexOf("*");
            String curLeft = str.substring(0, index);
            String curRight = "" ;
            if (index < str.length()) {
                curRight = str.substring(index+1);
            }

            char[] prevChars = prevLeft.toCharArray();
            char[] curChars = curLeft.toCharArray();


            int n1 = prevChars.length , n2 = curChars.length;
            int i1 = 0 , i2 = 0;
 
            while (i1 < n1 && i2 < n2) {
                if (prevChars[i1] == curChars[i2]) {
                    i1++;
                    i2++;
                } else {
                    pattern = false;
                    break;
                }
            }
            

            if (!pattern) {
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

 
            prevChars = prevRight.toCharArray();
            curChars = curRight.toCharArray();
            n1 = prevChars.length ;
            n2 = curChars.length;

            int i3 = n1-1 , i4 = n2-1;
            while (i3 >= 0 && i4 >= 0) {
                if (prevChars[i3] == curChars[i4]) {
                    i3--;
                    i4--;
                } else {
                    pattern = false;
                    break;
                }
            }
            

            if (!pattern) {
                break;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

            

        }

        String result = "*";
        if (pattern) {
            result = prevLeft + prevRight ;
        }

        System.out.println(String.format(output1, caseNum, result));
    }

}