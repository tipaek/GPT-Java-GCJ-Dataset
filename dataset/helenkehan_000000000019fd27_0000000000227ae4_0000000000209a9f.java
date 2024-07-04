import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by HelenHan on 3/6/20.
 */
public class Solution {

    public static String solve(String s) {
        if(s==null || s.length()==0) return "";
        int n = s.length();
        int[] input = new int[n];
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = Character.getNumericValue(s.charAt(i));
            res[i] = Character.toString(s.charAt(i));
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(input[i])) {
                map.put(input[i], new LinkedList<>());
            }
            map.get(input[i]).add(i);
            set.add(input[i]);
        }
        for (int key : set) {
            if (key == 0) break;
            List<Integer> list = map.get(key);
            Collections.sort(list);
//            System.out.println("list: "+list+" key: "+key);
            int next = (set.ceiling(key - 1) == null) ? 0 : set.ceiling(key - 1);

            String start = "";
            String end = "";
            for (int i = 0; i < key - next; i++) {
                start += "(";
                end += ")";
            }
            int begin = 0;
            int index = 0;
            while (begin < list.size()) {
                while (index < list.size() - 1 && list.get(begin) + 1 + index - begin ==
                        list.get(index + 1)) {
                    index++;
                }
                res[list.get(begin)] = start + res[list.get(begin)];
                res[list.get(index)] = res[list.get(index)] + end;
//                System.out.println("range: "+list.get(begin)+" "+list.get(index));
                index++;
                begin = index;
            }
            map.getOrDefault(next, new LinkedList<>()).addAll(list);
//            System.out.println("map: "+map);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int T = Integer.parseInt(t[0]);

        for (int j = 1; j <= T; j++) {
            String s = bufferedReader.readLine().trim();
            String answer = solve(s);
            System.out.println("Case #" + j + ": " + answer);
        }

        bufferedReader.close();
    }
}
