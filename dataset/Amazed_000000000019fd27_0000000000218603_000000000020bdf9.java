
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static class ListComparator implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
            for (int i = 0; i < l1.size(); ++i) {
                if (l1.get(i).compareTo(l2.get(i)) != 0) {
                    return l1.get(i).compareTo(l2.get(i));
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in);
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            in = sc.nextLine();
            StringTokenizer ab = new StringTokenizer(in);
            int N = Integer.parseInt(ab.nextToken());
            List<List<Integer>> times = new ArrayList<>(N);
            for (int index = 0; index < N; index++) {
                in = sc.nextLine();
                StringTokenizer cd = new StringTokenizer(in);
                List<Integer> temp = new ArrayList<>();
                int a = Integer.parseInt(cd.nextToken());
                int b = Integer.parseInt(cd.nextToken());
                temp.add(a);
                temp.add(b);
                times.add(temp);
            }
            List<List<Integer>> sorted = new ArrayList<>();
            sorted.addAll(times);
            sorted.sort(new ListComparator());
            int C = 0;
            int J = 0;
            boolean check = true;
            List<String> peeps = new ArrayList<>(N);
            for (int index = 0; index < sorted.size(); index++) {
                int start = sorted.get(index).get(0);
                int end = sorted.get(index).get(1);
                if (C <= start) {
                    C = end;
                    peeps.add("C");
                } else if (J <= start) {
                    J = end;
                    peeps.add("J");

                } else {
                    check = false;
                    break;
                }
            }
            if (check == false) {
                out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                String[] sched = new String[N];
                for (int index = 0; index < N; index++) {
                    List<Integer> curr = new ArrayList<>();
                    curr = sorted.get(index);
                    for (int count = 0; count < N; count++) {
                        if (times.get(count).equals(curr)) {
                            times.get(count).set(0, -1);
                            times.get(count).set(1, -1);
                            String put = peeps.get(index);
                            sched[count] = put;
                            break;
                        }
                    }
                }
                String output = "";
                for (int index = 0; index < N; index++) {
                    output += sched[index];
                }
                out.println("Case #" + (i + 1) + ": " + output);
            }
        }
        out.close();

    }
}
