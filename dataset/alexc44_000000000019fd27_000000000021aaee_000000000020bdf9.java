import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int cases = 0;
        if(scanner.hasNextLine()) {
            cases = Integer.parseInt(scanner.nextLine());
        }
        for(int i = 0; i < cases; i++) {
            int times = Integer.parseInt(scanner.nextLine());
            Integer[][] arr = new Integer[times][3];
            for(int j = 0; j < times; j++) {
                String[] tmp = scanner.nextLine().split(" ", 0);
                arr[j][0] = Integer.parseInt(tmp[0]);
                arr[j][1] = Integer.parseInt(tmp[1]);
                arr[j][2] = j;
            }
            System.out.println("Case #" + Integer.toString(i+1) + ": " + output(arr));
        }
    }

    public static String output(Integer[][] arr) {
        int cstart = 0;
        int cend = 0;
        int jstart = 0;
        int jend = 0;
        Arrays.sort(arr, new Comparator<Integer[]>() { @Override
            public int compare(Integer[] t1, Integer[] t2) {
                Integer time1 = t1[0];
                Integer time2 = t2[0];
                if(t1[0].compareTo(t2[0]) != 0)
                    return t1[0].compareTo(t2[0]);
                else
                    return t1[1].compareTo(t2[1]);
            }
        });
        String[] out = new String[arr.length];

        for(Integer[] curr: arr) {
            if(curr[0] >= cend) {
                cend = curr[1];
                out[curr[2]] = "C";
            }
            else if (curr[0] >= jend) {
                jend = curr[1];
                out[curr[2]] = "J";
            }
            else
                return "IMPOSSIBLE";
        }

        String output = "";
        for(String curr: out)
            output += curr;
        return output;
    }
}