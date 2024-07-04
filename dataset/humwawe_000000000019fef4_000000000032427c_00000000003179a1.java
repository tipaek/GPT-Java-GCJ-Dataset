
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\hum\\IdeaProjects\\online-judge\\src\\main\\java\\template\\in.txt"));
        int n = sc.nextInt();
        String result = "Case #%d: %s";
        for (int cas = 1; cas <= n; cas++) {
            String u = sc.next();
            boolean[] al = new boolean[26];
            boolean[] vis = new boolean[26];
            int[] count = new int[26];
            for (int i = 0; i < 10000; i++) {
                String ignore = sc.next();
                String s = sc.next();
                for (int j = 0; j < s.length(); j++) {
                    if (j == 0) {
                        count[s.charAt(j) - 'A']++;
                        al[s.charAt(j) - 'A'] = true;
                    }
                    vis[s.charAt(j) - 'A'] = true;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (vis[i] && !al[i]) {
                    stringBuilder.append((char) (i + 'A'));
                    break;
                }
            }
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    list.add(new int[]{i, count[i]});
                }
            }
            System.out.println(Arrays.toString(count));
            list.sort((a, b) -> b[1] - a[1]);

            for (int[] aList : list) {
                stringBuilder.append((char) (aList[0] + 'A'));
            }
            System.out.println(String.format(result, cas, stringBuilder.toString()));
        }
    }
}
