import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Timing implements Comparable<Timing> {
    int    startTime;
    int    endTime;
    int    index;
    String parent;

    // sort by start time
    @Override
    public int compareTo(Timing o) {
        return this.startTime - o.startTime;
    }
}

class IndexSorter implements Comparator<Timing> {

    @Override
    public int compare(Timing o1, Timing o2) {
        // TODO Auto-generated method stub
        return o1.index - o2.index;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.print("Case #"+(i+1)+": ");
            Timing t[] = new Timing[n];
            for (int j = 0; j < n; j++) {
                t[j] = new Timing();
                String[] tmp = br.readLine().split(" ");
                t[j].startTime = Integer.parseInt(tmp[0]);
                t[j].endTime = Integer.parseInt(tmp[1]);
                t[j].index = j;
            }
            findParenting(t);
        }
    }

    private static void findParenting(Timing[] t) {

        Arrays.sort(t);

        int c = 0, j = 0;
        for (int i = 0; i < t.length; i++) {
            if (i == 0 && c == 0) {
                c = t[i].endTime;
                t[i].parent = "C";
            } else {
                if (t[i].startTime >= c) {
                    c = t[i].endTime;
                    t[i].parent = "C";
                } else if (t[i].startTime >= j) {
                    j = t[i].endTime;
                    t[i].parent = "J";
                } else {
                    t[i].parent = "IMPOSSIBLE";
                    break;
                }
            }

        }
        Arrays.sort(t, new IndexSorter());
        String result="";
        for (int i = 0; i < t.length; i++) {
            result=result+t[i].parent;
            
        }
        if(result.contains("IMPOSSIBLE"))
            result="IMPOSSIBLE";
        System.out.println(result);
    }

}
