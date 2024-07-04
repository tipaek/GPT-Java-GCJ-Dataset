import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            ++cnt;
            StringBuilder str = new StringBuilder();
            System.out.print("Case #" + cnt + ": ");
            int U = scanner.nextInt();
            long[] query = new long[10000];
            String[] response = new String[10000];
            for (int i = 0; i < 10000; ++i) {
                query[i] = scanner.nextLong();
                response[i] = scanner.next();
            }
            HashSet<Character> read = new HashSet<>(10);
            char[] output = new char[10];
            int[] freq = new int[26];
            for (int i = 0; i < 10000; ++i) {
                if (response[i].length() == U) {
                    char temp = response[i].charAt(0);
                    freq[temp - 'A']++;
                }
            }
            for (int i = 1; i <= 9; ++i) {
                int max = 0;
                int max_pos = 0;
                for (int j = 0; j < 26; ++j) {
                    if (freq[j] > max) {
                        if (!(read.contains((char) (j + 'A')))) {
                            max = freq[j];
                            max_pos = j;
                        }
                    }
                }
                read.add((char) (max_pos + 'A'));
                output[i] = (char) (max_pos + 'A');
            }

//
//            int check = 1;
//            for (int i = 0; i < 10000 && check < 10; ++i) {
//                if (query[i] == check) {
//                    if (!(read.contains(response[i].charAt(0)))) {
//                        read.add(response[i].charAt(0));
//                        output[check] = response[i].charAt(0);
//                        check++;
//                    }
//                }
//            }
            boolean flag = true;
            for (int i = 0; i < 10000 && flag; ++i) {
                for (int j = 0; j < response[i].length(); ++j) {
                    if (!(read.contains(response[i].charAt(j)))) {
                        output[0] = response[i].charAt(j);
                        flag = false;
                        break;
                    }
                }
            }
            for (char c : output) str.append(c);
            System.out.println(str.toString());
        }
    }
}
