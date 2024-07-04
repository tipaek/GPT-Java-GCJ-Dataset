
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Rahul Ajit on 4/4/2020.
 */
public class Solution implements Comparable<Solution> {

    public int t;
    public boolean isStart;
    public static final String C = "C";
    public static final String J = "J";

    public Solution(int t,boolean isStart) {
        this.t = t;
        this.isStart = isStart;
    }

    public static String swap(String s) {
        if(s.equals(C))
            return J;
        return C;
    }

    public int compareTo(Solution s) {
        if(t == s.t) {
            if(isStart && !s.isStart) {
                return 1;
            }
            if(!isStart && s.isStart) {
                return -1;
            }
            return 0;
        }
        if(t > s.t) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for(int i=1; i<=testCases; i++) {
            String output = "Case #" + i + ": ";
            int n = scanner.nextInt();
            List<Solution> list = new ArrayList<>();
            String result = "";
            for(int j=0; j<n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if(start > end) {
                    result = "IMPOSSIBLE";
                    break;
                }
                list.add(new Solution(start, true));
                list.add(new Solution(end, false));
            }
            if(!result.equals("IMPOSSIBLE")) {
                Collections.sort(list);
                Queue<String> q = new LinkedList<>();
                for(Solution s: list) {
                    if(s.isStart) {
                        if(q.isEmpty()) {
                            q.add(C);
                            result = result + C;
                        } else {
                            if(q.size() == 2) {
                                result = "IMPOSSIBLE";
                                break;
                            } else {
                                String str = swap(q.peek());
                                q.add(str);
                                result = result + str;
                            }
                        }
                    } else {
                        q.poll();
                    }
                }    
            }
            output = output + result;
            System.out.println(output);
        }
        scanner.close();
    }
}
