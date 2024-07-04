import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            char[] s = new char[N];//result string
            boolean impossible = false;
            Map<Integer, Vector<Integer>> activities = new HashMap<>(); // map[start] = [end, n]
            int start; Vector<Integer> cur;
            for (int n = 0; n < N; n++) {
                cur = new Vector<>();
                start = scanner.nextInt();
                cur.add(scanner.nextInt());//end
                cur.add(n);
                activities.put(start, cur);
            }
            TreeMap<Integer, Vector<Integer>> sortedAct = new TreeMap<>(activities);
            int endC = 0, endJ = 0;
            for (Map.Entry<Integer, Vector<Integer>> entry: sortedAct.entrySet()) {
                if (endC <= entry.getKey()) {
                    s[entry.getValue().get(1)] = 'C';
                    endC = entry.getValue().get(0);//end
                }else if (endJ <= entry.getKey()) {
                    s[entry.getValue().get(1)] = 'J';
                    endJ = entry.getValue().get(0);//end
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
