import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= t; c++) {
            int U = in.nextInt();
            in.nextLine();
            HashSet<Character> set = new HashSet<Character>();
            HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
            for (int line = 0; line < (int) Math.pow(10, 4); line++) {
                String[] QR = in.nextLine().split("\\s+");
                int Q = Integer.parseInt(QR[0]);
                String R = QR[1];

                for (int i = 0; i < R.length(); i++) {
                    set.add(R.charAt(i));
                }

                if (Q <= 9) {
                    char digitChar = R.charAt(0);
                    ArrayList<Integer> list = map.getOrDefault(digitChar, new ArrayList<Integer>());
                    list.add(Q);
                    map.put(digitChar, list);
                }
            }
            HashMap<Integer, Character> digitMap = new HashMap<Integer, Character>();
            for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
                ArrayList<Integer> list = entry.getValue();
                Collections.sort(list);

                digitMap.put(list.get(0), entry.getKey());
            }

            String result = "";
            Character zero = '-';
            for (int i = 1; i < 10; i++) {
                result += digitMap.get(i);
                set.remove(digitMap.get(i));
            }

            for (Character el : set) {
                zero = el;
            }

            System.out.println("Case #" + c + ": " + zero + result);
        }

    }

}
