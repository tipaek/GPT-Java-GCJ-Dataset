
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
            str = str.replace("*" , "");
            list.add(str);

        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        boolean canMax = true;
        String prev = list.get(0);
        for (int i = 0 ; i < list.size() ; i++) {
            String str = list.get(i);
            if (!str.contains(prev)) {
                canMax = false;
                break;
            }
            prev = str;
        }

        String result = "*";
        if (canMax) {
            result = prev;
        }

        System.out.println(String.format(output1, caseNum, result));
    }

}
