
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
            str = str.substring(1);
            list.add(str);

        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        String max = list.get(list.size() - 1);
        boolean canMax = true;
        for (int i = 0 ; i < list.size() ; i++) {
            if (!max.contains(list.get(i))) {
                canMax = false;
                break;
            }
        }

        String result = "*";
        if (canMax) {
            result = max;
        }

        System.out.println(String.format(output1, caseNum, result));
    }

}
