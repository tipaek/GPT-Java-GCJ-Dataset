import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            char[] s = new char[N];//result string
            boolean impossible = false;
            List<Vector<Integer>> act = new LinkedList<>(); // [start, end, index]

            for (int n = 0; n < N; n++) {
                Vector<Integer> cur = new Vector<>();
                cur.add(scanner.nextInt());
                cur.add(scanner.nextInt());
                cur.add(n);
                act.add(cur);
            }
            Collections.sort(act, new Comparator<Vector<Integer>>() {
                @Override
                public int compare(Vector<Integer> o1, Vector<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });

            int endC = 0, endJ = 0;
            for (int i = 0; i < act.size(); i++) {
                if (endC <= act.get(i).get(0)) {
                    s[act.get(i).get(2)] = 'C';//index
                    endC = act.get(i).get(1);//end
                }else if(endJ <= act.get(i).get(0)) {
                    s[act.get(i).get(2)] = 'J';//index
                    endJ = act.get(i).get(1);//end
                }else {
                    impossible = true;
                    break;
                }
            }

            String result;
            if (impossible) {
                result = "IMPOSSIBLE";
            }else {
                result = new String(s);
            }

            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }
}
