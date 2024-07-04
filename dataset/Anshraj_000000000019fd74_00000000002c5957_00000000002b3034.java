import java.util.*;
//khuidbauicbs chjvuidbasc  uigauisc


public class fun {
    private static String anshweroindd = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int testtestcasenum = 1; testcasenum <= t; ++testcasenum) {
                new fun().funeksdffj3(testcasenum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//khuidbauicbs chjvuidbasc  uigauisc

    public void funeksdffj3(int testcasenum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String str = scanner.next();
            list.add(str);

        }
//khuidbauicbs chjvuidbasc  uigauisc

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0 ; i < n ; i++) {
            System.out.println(list.get(i));
        }

        boolean papapapapa = true;
        String prev = list.get(0);
        int index = prev.indexOf("*");
        String prevLeft = prev.substring(0, index);
        String abcdefg = "" ;
        if (index < prev.length()) {
            abcdefg = prev.substring(index+1);
        }
//khuidbauicbs chjvuidbasc  uigauisc

        System.out.println(String.format("11 prevLeft =%s , abcdefg = %s" , prevLeft, abcdefg));

        for (int i = 0 ; i < list.size() ; i++) {
            String str = list.get(i);
            index = str.indexOf("*");
            String curLeft = str.substring(0, index);
            String rightexper = "" ;
            if (index < str.length()) {
                rightexper = str.substring(index+1);
            }

            char[] prevChars = prevLeft.toCharArray();
            char[] curChars = curLeft.toCharArray();

//            char[] prevChars = prev.toCharArray();
//            char[] curChars = str.toCharArray();
            int n1 = prevChars.length , n2 = curChars.length;
            int i1 = 0 , i2 = 0;
            // test case 1 & 2 before *
            while (i1 < n1 && i2 < n2) {
                if (prevChars[i1] == curChars[i2]) {
                    i1++;
                    i2++;
                } else {
                    papapapapa = false;
                    break;
                }
            }
            System.out.println(String.format("11 i1 =%d , i2 = %d , papapapapa = %s" , i1, i2, papapapapa));

            if (!papapapapa) {
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            // test case 1 & 2 after *
            prevChars = abcdefg.toCharArray();
            curChars = rightexper.toCharArray();
            n1 = prevChars.length ;
            n2 = curChars.length;

            int i3 = n1-1 , i4 = n2-1;
            while (i3 >= 0 && i4 >= 0) {
                if (prevChars[i3] == curChars[i4]) {
                    i3--;
                    i4--;
                } else {
                    papapapapa = false;
                    break;
                }
            }
            System.out.println(String.format("22 i3 =%d , i4 = %d , papapapapa = %s" , i3, i4, papapapapa));

            if (!papapapapa) {
                break;
            }

            if (rightexper.length() > abcdefg.length()) {
                abcdefg = rightexper;
            }

            System.out.println(String.format("22 prevLeft =%s , abcdefg = %s" , prevLeft, abcdefg));

        }

        String result = "*";
        if (papapapapa) {
            result = prevLeft + abcdefg ;
        }

        System.out.println(String.format(anshweroindd, testcasenum, result));
    }

}


//khuidbauicbs chjvuidbasc  uigauisc