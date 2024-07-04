import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int param = 2;
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int N = in.nextInt();
        in.nextInt(); // C
        List<Integer>[] lists = new List[T];
        for (int t=0; t<T; t++) {
            lists[t] = new ArrayList<>();
        }
        for (int x=0; x<N*param; x++) {
            int n = (x/param) + 1;
            StringBuilder query = new StringBuilder();
            boolean usefulQuery = false;
            for (int t=0; t<T; t++) {
                int q = 0;
                if (lists[t].size() < param && !lists[t].contains(n)) {
                    q = n;
                    usefulQuery = true;
                }
                query.append(q).append(' ');
            }
            if (!usefulQuery) continue;
            System.out.println(query);
            System.out.flush();
            for (int t=0; t<T; t++) {
                int ink = in.nextInt();
                if (ink == 0 && lists[t].size() < param && !lists[t].contains(n)) {
                    lists[t].add(n);
                }
            }
        }
        StringBuilder end = new StringBuilder();
        for (int t=0; t<T; t++) {
            end.append("0 ");
        }
        System.out.println(end);
        System.out.flush();
        StringBuilder output = new StringBuilder();
        for (int t=0; t<T; t++) {
            List<Integer> list = lists[t];
            int idx1 = N;
            while (list.contains(idx1)) idx1--;
            int idx2 = idx1-1;
            while (list.contains(idx2)) idx2--;
            output.append(idx2).append(' ').append(idx1).append(' ');
        }
        System.out.println(output);
    }

}
