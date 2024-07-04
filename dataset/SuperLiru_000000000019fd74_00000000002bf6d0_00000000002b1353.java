import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int cases = 1; cases <= tests; cases++) {
            int N = scanner.nextInt();
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{1, 1});
            N--;

            int sum = 1;
            while(N - sum > 0) {
                list.add(new int[]{sum + 1, sum});
                N = N - sum;
                sum++;
            }

            while(N > 0) {
                list.add(new int[]{sum , sum});
                sum++;
                N--;
            }

            System.out.println("Case #" + cases + ":");
            for(int index = 0; index < list.size(); index++){
                System.out.println(list.get(index)[0] + " " + list.get(index)[1]);
            }
        }
    }
}

