import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int t = 1; t <= times; t++) {
            String s = scanner.nextLine();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i));
            }
            int cur = 0, level = 0;
            list.add('0');
            for (int i = 0; i < s.length() + 1; i++) {
                int temp = list.get(cur) - '0';
                while (level < temp) {
                    list.add(cur,'(');
                    level++;
                    cur++;
                }
                while (level > temp) {
                    list.add(cur, ')');
                    level--;
                    cur++;
                }
                cur++;
            }

            list.remove(list.size()-1);
            StringBuffer sb = new StringBuffer();
            for (Character c : list) {
                sb.append(c);
            }
            String ans = sb.toString();
            
            System.out.println(String.format("Case #%d: %s", t, ans));
        }
    }

}