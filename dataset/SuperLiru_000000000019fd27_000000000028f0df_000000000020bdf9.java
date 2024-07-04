import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int cases = 1; cases <= tests; cases++){
            int intervals = scanner.nextInt();
            TreeMap<Integer, List> map = new TreeMap<>();
            for (int i = 0; i < intervals; i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if(map.containsKey(start)){
                    map.get(start).add(end);
                    map.get(start).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(end);
                    list.add(i);
                    map.put(start, list);
                }
            }

            char[] ret = new char[intervals];
            int camLast = -1;
            int jackLast = -1;
            boolean impossible = false;
            for(Integer start : map.keySet()){
                List<Integer> pairs = map.get(start);
                for(int i = 0; i < pairs.size(); i = i + 2){
                    if(start >= camLast){
                        ret[pairs.get(i + 1)] = 'C';
                        camLast = pairs.get(i);
                    } else if (start >= jackLast){
                        ret[pairs.get(i + 1)] = 'J';
                        jackLast = pairs.get(i);
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible){
                System.out.println("Case #" + cases + ":" + " " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + cases + ":" + " " + String.valueOf(ret));
            }
        }
    }
}