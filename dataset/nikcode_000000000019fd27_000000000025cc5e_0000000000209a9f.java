
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 4/4/2020 AD
 * Time: 19:47
 */
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int x = 0;
        while (x < t) {
            String s = scanner.next();

            int prev_l = Integer.parseInt(s.substring(0, 1));
            List<Character> ans = new ArrayList<>();
            int i = 0;
            while (i++ < prev_l)
                ans.add('(');
            ans.add(s.charAt(0));
            i = 0;
            while (i++ < prev_l)
                ans.add(')');
            int ans_l = ans.size();

            for (int j = 1; j < s.length(); j++) {
                int curr_l = Integer.parseInt(s.substring(j, j + 1));
                if (curr_l > prev_l) {
                    int diff = curr_l - prev_l;
                    int insert_point = ans_l - prev_l;
                    int temp = diff;
                    while (temp > 0) {
                        ans.add(insert_point, '(');
                        insert_point += 1;
                        temp -= 1;
                    }
                    ans.add(insert_point, s.charAt(j));
                    insert_point += 1;
                    temp = diff;
                    while (temp > 0) {
                        ans.add(insert_point, ')');
                        insert_point += 1;
                        temp -= 1;
                    }
                } else {
                    int insert_point = ans_l - curr_l;
                    ans.add(insert_point, s.charAt(j));
                }
                ans_l = ans.size();
                prev_l = curr_l;
            }

            StringBuilder sb = new StringBuilder("");
            for (int index = 0; index < ans.size(); index++) {
                sb.append(ans.get(index));
            }
            String result = sb.toString();

            System.out.println("Case #" + (x + 1) + ": " + result);
            x++;
        }
    }
}
