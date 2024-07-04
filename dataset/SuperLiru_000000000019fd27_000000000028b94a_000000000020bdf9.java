import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int cases = 1; cases <= tests; cases++){
            int intervals = scanner.nextInt();
            TreeMap<Integer, int[]> map = new TreeMap<>();
            for (int i = 0; i < intervals; i++){
                map.put(scanner.nextInt(), new int[]{scanner.nextInt(), i});
            }

            char[] ret = new char[intervals];
            int camLast = -1;
            int jackLast = -1;
            boolean impossible = false;
            for(Integer start : map.keySet()){
                int[] pair = map.get(start);
                if (start >= camLast && start >= jackLast){
                    if (camLast > jackLast){
                        ret[pair[1]] = 'C';
                        camLast = pair[0];
                    } else {
                        ret[pair[1]] = 'J';
                        jackLast = pair[0];
                    }
                }
                else if(start >= camLast){
                    ret[pair[1]] = 'C';
                    camLast = pair[0];
                } else if (start >= jackLast){
                    ret[pair[1]] = 'J';
                    jackLast = pair[0];
                } else {
                    impossible = true;
                    break;
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