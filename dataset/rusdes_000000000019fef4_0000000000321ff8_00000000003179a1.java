import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int U = reader.nextInt();

            Map<Character, Integer> map = new HashMap<>();
            Set<Character> zero = new HashSet<>();

            boolean neg = true;
            for (int j = 0; j < 10000; j++){
                long Q = reader.nextLong();
                String R = reader.next();
                if (R.length() > 1){
                    zero.add(R.charAt(0));
                }

                if (Q != -1){
                    neg = false;
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

                String ans = String.valueOf(dig);
                System.out.println("Case #" + i + ": " + ans);
            }else {

            }
        }
    }
}