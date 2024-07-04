

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
 * @auther AaronYu
 * @date 2020/4/4 9:11
 *
 */
public class Solution {
    private static final String left = "(";
    private static final String right = ")";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for(int s = 0; s < T; s++) {
            String str = scanner.next();
            StringBuilder sb = new StringBuilder();
            char[] array = str.toCharArray();
            int i = 0;
            while (i < array.length) {
                int cur = i+1;
                if(array[i] == '1') {
                    sb.append(left+array[i]);
                    for(; cur < array.length; cur++) {
                        if(array[cur] != '1') {
                            break;
                        }
                        sb.append(array[cur]);
                    }
                    sb.append(right);
                    i = cur;
                } else {
                    sb.append(array[i]);
                    i++;
                }
            }

          System.out.println("Case #"+(s+1)+": "+sb.toString());
        }
    }
}
