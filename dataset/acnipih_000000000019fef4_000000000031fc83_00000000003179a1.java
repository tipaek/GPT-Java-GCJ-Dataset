import java.io.FileInputStream;
import java.util.*;

public class Solution {
    static class Pair {
        String value;
        String str;

        public Pair(String value, String str) {
            this.value = value;
            this.str = str;
        }
    }
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("/Users/myroslav.lisniak/projects/coding_challenges/codejam/2020/roundC/02.in"));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int u = in.nextInt();
            Pair [] logs  = new Pair[10000];
            for(int j = 0; j < 10000; j++){
                logs[j] = new Pair(in.next(), in.next());

            }
            String res = solve(logs);

            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

    private static String solve(Pair[] logs) {
        char [] dStr = new char[10];
        Set<Character> used = new HashSet<>();
        Set<Character> set = new HashSet<>();
//        Arrays.sort(logs, Comparator.comparingInt(p -> p.value));
        for(int i = 1; i <= 9; i++){
            for(int j = 0; j < 10000; j++){
                Pair pair = logs[j];
                String str = String.valueOf(pair.value);
                if(set.size() < 10) {
                    for (int k = 0; k < pair.str.length(); k++){
                        set.add(pair.str.charAt(k));
                    }
                }
                int digits = str.length();
                if(pair.value.charAt(0) - '0' == i && pair.str.length() == digits){
                    if(!used.contains(pair.str.charAt(0))) {
                        dStr[i] = pair.str.charAt(0);
                        used.add(pair.str.charAt(0));
                        break;
                    }
                }
            }
        }
        for(Character c: set){
            if(!used.contains(c)) {
                dStr[0] = c;
                break;
            }

        }


        return new String(dStr);
    }
}
