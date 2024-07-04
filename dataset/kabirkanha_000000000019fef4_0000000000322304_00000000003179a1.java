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
            System.out.print("Case #" + cnt + ": ");
            int U = scanner.nextInt();
            int[] query = new int[10000];
            String[] response = new String[10000];
            for (int i = 0; i < 10000; ++i) {
                query[i] = scanner.nextInt();
                response[i] = scanner.next();
            }
            HashSet<Character> read = new HashSet<>(10);
            char[] output = new char[10];
            int check = 1;
            for (int i = 0; i < 10000 && check < 10; ++i) {
                if (query[i] == check) {
                    if (!(read.contains(response[i].charAt(0)))) {
                        read.add(response[i].charAt(0));
                        output[check] = response[i].charAt(0);
                        check++;
                    }
                }
            }
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
            StringBuilder str = new StringBuilder();
            for (int i=0;i<output.length;++i)
                str.append(output[i]);
            System.out.println(str.toString());
        }
    }
}
