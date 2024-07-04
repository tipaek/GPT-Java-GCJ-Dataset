import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        boolean DEBUG = false;
        String fileName = "a";
        InputStream is = DEBUG ? new FileInputStream("/Users/bambi/Desktop/contest/KickStart/input/" + fileName + ".txt") : System.in;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int caseCnt = scanner.nextInt();
        for (int i=1; i<=caseCnt; i++){
            int n = scanner.nextInt();
            List<int[]> intervals = new LinkedList<>();
            for (int j=0; j<n; j++) intervals.add(new int[]{scanner.nextInt(), scanner.nextInt(), j});
            String res= alg(intervals);
            if (res==null) res="IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + res);
        }
        is.close();
    }

    private static String alg(List<int[]> intervals) {
        Collections.sort(intervals, (a,b)-> a[0]-b[0]);
        String[] res= new String[intervals.size()];
        int j=-1, c=-1;
        for (int[] interval: intervals){
            if (j<=interval[0]){
                res[interval[2]]="J";
                j=interval[1];
            }else if (c<=interval[0]){
                res[interval[2]]="C";
                c=interval[1];
            }else return null;
        }
        return String.join("", res);
    }
}