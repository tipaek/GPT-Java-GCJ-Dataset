import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int U = in.nextInt();
            int flag = 0;
            int[][] digit = new int[10][26];
            for (int i=0; i<10000; i++) {
                String MS = in.next();
                String R = in.next();
//                if (MS.charAt(0) != '-') {
                    flag = 1;
                    if (R.length() > 1) digit[1][R.charAt(0) - 'A']++;
                    digit[0][R.charAt(R.length() - 1) - 'A']++;
                    continue;
//                }
//                if (R.length() == MS.length()) {
//                    int M = Integer.valueOf(MS.substring(0,1));
//                    while (M>9) M/=10;
//                    digit[M][R.charAt(0) - 'A']++;
//                }
//                if (R.length() > 1) digit[0][R.charAt(R.length() - 1) - 'A']++;
            }

            char[] result = new char[10];
            if (flag == 1) {
                boolean[] visit = new boolean[30];
                for (int i=0; i<9; i++) {
                    int min = 0;
                    int index = -1;
                    for (int j=0; j<26; j++) {
                        if (visit[j]) continue;
                        if (min < digit[1][j]) {
                            index = j;
                            min = digit[1][j];
                        }
                    }
                    result[i+1] = (char)(index + 'A');
                    visit[index] = true;
                }

                for (int j=0; j<26; j++) {
                    if (visit[j]) continue;
                    if (0 < digit[0][j]) {
                        result[0] = (char)(j + 'A');
                        break;
                    }
                }
                System.out.println("Case #" + tc + ": " + new String(result));
                continue;

            }


            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i=0; i<10; i++) {
                for (int j=0; j<26; j++) {
                    if (digit[i][j] != 0) {
                        int num = map.getOrDefault(j,0);
                        map.put(j, num+1);
                    }
                }
            }


            Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();

            while(itr.hasNext())
            {
                Map.Entry<Integer, Integer> entry = itr.next();
                if (entry.getValue() == 1) {
                    result[0] = (char)(entry.getKey() + 'A');
                } else {
                    result[11 - entry.getValue()] = (char)(entry.getKey() + 'A');
                }
            }

            System.out.println("Case #" + tc + ": " + new String(result));
        }
    }
}