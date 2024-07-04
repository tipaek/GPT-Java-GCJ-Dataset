import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        int[][] arr = new int[testCases][10000];
        Map<Integer, String[]> list = new HashMap<>();

        ArrayList<Integer> unknown = new ArrayList<>();

        String[] ans = new String[testCases + 1];
        long[] Qs = new long[10000];
        for (int i = 1; i <= testCases; i++) {
            int U = reader.nextInt();
            Map<Character, Integer> map = new HashMap<>();
            Set<Character> zero = new HashSet<>();

            boolean neg = true;
            String[] strings = new String[10000];
            for (int j = 0; j < 10000; j++){
                long Q = reader.nextLong();
                String R = reader.next();
                if (R.length() > 1){
                    zero.add(R.charAt(0));
                }

                if (Q != -1){
                    neg = false;
                    Qs[j] = Q;
                    if (String.valueOf(Q).length() == R.length()){
                        for (int k = 0; k < R.length(); k++){
                            char ch = R.charAt(k);
                            int curDigit;
                            if (k == 0)
                                curDigit = Character.getNumericValue(String.valueOf(Q).charAt(k));
                            else
                                curDigit = 9;
                            if (map.containsKey(ch)){
                                int hold = map.get(ch);
                                if(curDigit < hold) {
                                    map.put(ch, curDigit);
                                }else {
                                    break;
                                }
                            }else {
                                map.put(ch, curDigit);
                            }
                        }
                    }
                }else {
                    if (!unknown.contains(i))
                        unknown.add(i);
                    strings[j] = R;
                }
            }
            if (!neg) {
                Set<Character> check = map.keySet();
                Object[] check1 = check.toArray();

                char[] dig = new char[10];
                ArrayList<Character> nine = new ArrayList<>();
                for (int p = 0; p < 10; p++) {
                    dig[map.get((char) check1[p])] = (char) check1[p];
                    if (map.get((char) check1[p]) == 9) {
                        nine.add((char) check1[p]);
                    }
                }
                check.removeAll(zero);
                dig[0] = (char) check.toArray()[0];
                if (nine.contains(dig[0]))
                    nine.remove(nine.indexOf(dig[0]));

                if (dig[9] == dig[0])
                    dig[9] = nine.get(0);

                ans[i] = String.valueOf(dig);
            }else {
                list.put(i, strings);
            }
        }

        while(unknown.size() > 0){
            int t = unknown.get(0);
            unknown.remove(0);

            Map<Character, Integer> map = new HashMap<>();
            Set<Character> zero = new HashSet<>();

            String[] str = list.get(t);

            for (int j = 0; j < 10000; j++) {
                long Q = Qs[j];
                String R = str[j];
                if (R.length() > 1) {
                    zero.add(R.charAt(0));
                }

                if (true) {
                    if (String.valueOf(Q).length() == R.length()) {
                        for (int k = 0; k < R.length(); k++) {
                            char ch = R.charAt(k);
                            int curDigit;
                            if (k == 0)
                                curDigit = Character.getNumericValue(String.valueOf(Q).charAt(k));
                            else
                                curDigit = 9;
                            if (map.containsKey(ch)) {
                                int hold = map.get(ch);
                                if (curDigit < hold) {
                                    map.put(ch, curDigit);
                                } else {
                                    break;
                                }
                            } else {
                                map.put(ch, curDigit);
                            }
                        }
                    }
                }
            }
            Set<Character> check = map.keySet();
            Object[] check1 = check.toArray();

            char[] dig = new char[10];
            ArrayList<Character> nine = new ArrayList<>();
            for (int p = 0; p < 10; p++) {
                dig[map.get((char) check1[p])] = (char) check1[p];
                if (map.get((char) check1[p]) == 9) {
                    nine.add((char) check1[p]);
                }
            }
            check.removeAll(zero);
            dig[0] = (char) check.toArray()[0];
            if (nine.contains(dig[0]))
                nine.remove(nine.indexOf(dig[0]));

            if (dig[9] == dig[0])
                dig[9] = nine.get(0);

            ans[t] = String.valueOf(dig);
        }

        for (int t = 1; t <= testCases; t++){
            System.out.println("Case #" + t + ": " + ans[t]);
        }
    }
}