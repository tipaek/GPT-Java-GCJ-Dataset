import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int len = input.nextInt();
            int trace = input.nextInt();

            int a = -1, b = -1, c = -1;
            loop: {
                for (a = 1; a <= len; a++)
                    for (b = 1; b <= len; b++)
                        for (c = 1; c <= len; c++)
                            if (((b != a) == (c != a)) && (len - 2) * a + b + c == trace) {
                                if (len >= 4)
                                    break loop;
                                if (len == 3 && trace % 3 == 0)
                                    break loop;
                                if (len == 2 && trace % 2 == 0 && a == b)
                                    break loop;
                            }

                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                continue;
            }
//            System.out.println(a + " " + b + " " + c);

            int[][] raw = new int[len][len];
            Map<Integer, Integer> map = new HashMap<>();
            if (b != a && b == c) {
                for (int i = 0; i < len - 3; i++)
                    for (int j = 0; j < len; j++)
                        raw[i][j] = (j - i + len) % len + 1;
                for (int j = 0; j < len - 4; j++)
                    if (j % 2 == 0) {
                        raw[len - 3][j] = j + 2;
                        raw[len - 2][j] = j + 3;
                        raw[len - 1][j] = j + 4;
                    } else {
                        raw[len - 3][j] = j + 4;
                        raw[len - 2][j] = j + 3;
                        raw[len - 1][j] = j + 2;
                    }
                if (len % 2 == 0) {
                    raw[len - 3][len - 4] = len - 2;
                    raw[len - 2][len - 4] = len - 1;
                    raw[len - 1][len - 4] = len;
                    raw[len - 3][len - 3] = 1;
                    raw[len - 2][len - 3] = len;
                    raw[len - 1][len - 3] = len - 1;
                } else {
                    raw[len - 3][len - 4] = len - 1;
                    raw[len - 2][len - 4] = len;
                    raw[len - 1][len - 4] = len - 2;
                    raw[len - 3][len - 3] = 1;
                    raw[len - 2][len - 3] = len - 1;
                    raw[len - 1][len - 3] = len;
                }

                raw[len - 3][len - 2] = len;
                raw[len - 2][len - 2] = 2;
                raw[len - 1][len - 2] = 1;
                raw[len - 3][len - 1] = 3;
                raw[len - 2][len - 1] = 1;
                raw[len - 1][len - 1] = 2;

                map.put(1, a);
                map.put(2, b);
            } else {
                for (int i = 0; i < len; i++)
                    for (int j = 0; j < len; j++)
                        raw[i][j] = (j - i + len) % len + 1;

                map.put(1, a);

                if (b != a) {
                    for (int i = 0; i < len; i++) {
                        int temp = raw[len - 2][i];
                        raw[len - 2][i] = raw[len - 1][i];
                        raw[len - 1][i] = temp;
                    }
                    for (int i = 0; i < len; i++) {
                        int temp = raw[i][len - 2];
                        raw[i][len - 2] = raw[i][len - 1];
                        raw[i][len - 2] = temp;
                    }

                    map.put(2, b);
                    map.put(len, c);
                }
            }

            for (int num = 1; num <= len; num++)
                if (!map.containsKey(num))
                    for (int val = 1; val <= len; val++)
                        if (!map.containsValue(val)) {
                            map.put(num, val);
                            break;
                        }
//            System.out.println(map);

            long[][] grid = new long[len][len];
            for (int i = 0; i < len; i++)
                for (int j = 0; j < len; j++)
                    grid[i][j] = map.get(raw[i][j]);

            System.out.printf("Case #%d: POSSIBLE\n", caseNum);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++)
                    System.out.printf("%d ", grid[i][j]);
                System.out.println();
            }
        }
    }
}
