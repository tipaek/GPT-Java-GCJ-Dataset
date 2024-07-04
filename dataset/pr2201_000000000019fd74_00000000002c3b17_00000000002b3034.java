import java.util.*;

public class Solution {
   

    public void soln(int tt, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> arr = new ArrayList<>();
        for (int idx = 0 ; idx < n ; idx++) {
            String str = scanner.next();
            arr.add(str);

        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String mobj1, String mobj2) {
                return mobj1.length() - mobj2.length();
            }
        });

        boolean prt = true;
        String prev = arr.get(0);
        int index = prev.indexOf("*");
        String prevLeft = prev.substring(0, index);
        String prevRight = "" ;
        if (index < prev.length()) {
            prevRight = prev.substring(index+1);
        }


        for (int i = 0 ; i < arr.size() ; i++) {
            String str = arr.get(i);
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
                	prt = false;
                    break;
                }
            }

            if (!prt) {
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            prevChars = prevRight.toCharArray();
            curChars = curRight.toCharArray();
            n1 = prevChars.length ;
            n2 = curChars.length;

            int ind3 = n1-1 , ind4 = n2-1;
            while (ind3 >= 0 && ind4 >= 0) {
                if (prevChars[ind3] == curChars[ind4]) {
                    ind3--;
                    ind4--;
                } else {
                	prt = false;
                    break;
                }
            }

            if (!prt) {
                break;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }


        }

        String result = "*";
        if (prt) {
            result = prevLeft + prevRight ;
        }

        System.out.println("Case #" + tt + ": " + result);
    }
    
    
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int tt = 1; tt <= t; ++tt) {
                new Solution().soln(tt, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
