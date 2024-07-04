import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    //changes cam so i can assign it to the original cam
    public boolean isParentFree(int s, int e, List<Integer> parent) {
        for (int k = s; k < e; k++) {
            if (!parent.contains(k)) {
                return false;
            } else {
                parent.remove(new Integer(k));
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String result = "";
        Solution instance = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases Scanner has functions to read ints, longs, strings, chars, etc.
        int s; //start
        int e; //end
        int[] hours = IntStream.range(0, 1440).toArray();
        List<Integer> cam;// = Arrays.stream(hours).boxed().collect(Collectors.toList());
        List<Integer> jamie;// = Arrays.stream(hours).boxed().collect(Collectors.toList());
        for (int i = 1; i <= t; ++i) {
            result = "";
            int n = in.nextInt(); //number of activities per test case
            cam = Arrays.stream(hours).boxed().collect(Collectors.toList());
            jamie = Arrays.stream(hours).boxed().collect(Collectors.toList());

            for (int j = 0; j < n; j++) {
               List<Integer> camCopy = new ArrayList<Integer>(cam.size());
                List<Integer> jamieCopy = new ArrayList<Integer>(jamie.size());
                for (Integer inte : cam) {camCopy.add(inte);}
                for (Integer inte : jamie) {jamieCopy.add(inte);}
                s = in.nextInt();
                e = in.nextInt();
                if (instance.isParentFree(s, e, camCopy)) {
                    cam = camCopy;
                    result += "C";
                } else if (instance.isParentFree(s, e, jamieCopy)) {
                    jamie = jamieCopy;
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }

                //if (cam.contains(s) && cam.contains())
            }
            //int n = in.nextInt();
            //int m = in.nextInt();
            System.out.println("Case #" + i + ": " + result);
        }
    }
}