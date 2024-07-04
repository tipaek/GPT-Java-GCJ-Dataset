
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        String res = "";
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            res += "Case #" + i + ":" + depth(s) + "\n";
        }
        System.out.println(res);
    }

    public static String depth(String s) {
        char[] data = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < data.length; ++i)
            list.add(data[i]);


        for (int i = 0; i < list.size(); ++i) {

            int cur = list.get(i) - 48;

            if (list.size() == 1) {
                for (int j = 0; j < cur; ++j) {
                    list.add(0, '(');
                    list.add(list.size(), ')');
                }
                break;
            }

            else if (i == 0) {
                for (int j = 0; j < cur; ++j) {
                    list.add(0, '(');
                    ++i;
                }
            }
            else {

                int ex = list.get(i - 1) - 48;
                cur = list.get(i) - 48;
                if (ex > cur) {
                    int dif = ex - cur;
                    for (int j = 0; j < dif; ++j) {
                        list.add(i , ')');
                        ++i;
                    }
                }
                else if (ex < cur) {
                    int dif = cur - ex;
                    for (int j = 0; j < dif; ++j) {
                        list.add(i , '(');
                        ++i;
                    }
                }
                else if (i == list.size()) {
                    for (int j = 0; j < cur; ++j) {
                        list.add(i, ')');
                        ++i;
                    }
                }
            }

            if (i == list.size() - 1) {
                for (int j = 0; j < cur; ++j) {
                    list.add(list.size() , ')');
                    ++i;
                }
            }
        }
        String s1 = "";
        for (int i = 0; i < list.size(); ++i) {
            s1 += list.get(i);
        }
        return s1;
    }
}
