import java.util.*;
import java.io.*;

/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            List<int[]> list = new ArrayList<>();
            for(int x = 0;x < n;x++){
                int []arr = new int[3];
                arr[0] = in.nextInt();
                arr[1] = in.nextInt();
                arr[2] = x;

                list.add(arr);
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] < o2[0]){
                        return -1;
                    }
                    else if(o1[0] > o2[0]){
                        return 1;
                    }
                    else{
                        if(o1[1] < o2[1]){
                            return -1;
                        }
                        else if(o1[1] > o2[1]){
                            return 1;
                        }
                        return 0;
                    }
                }
            });
            String result = getResult(list);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String getResult(List<int[]> list) {
        String result = "";
        int cEndTime = -1;
        int jEndTime = -1;
        for(int x = 0;x < list.size();x++){
            int[] currActivity = list.get(x);
            if(cEndTime <= currActivity[0]){
                result += "C";
                cEndTime = currActivity[1];
            }
            else if(jEndTime <= currActivity[0]){
                result += "J";
                jEndTime = currActivity[1];
            }
            else{
                return "IMPOSSIBLE";
            }
        }

        return result;
    }
}
