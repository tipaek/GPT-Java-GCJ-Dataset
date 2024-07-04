import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            Set<Pair> taskList = new TreeSet<>();
            for(int j=0; j<n; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                taskList.add(new Pair(start,end));

            }

            boolean cWorking = false;
            int cStart = 0;
            int cEnd = 0;

            boolean jWorking = false;
            int jStart = 0;
            int jEnd = 0;

            StringBuilder output = new StringBuilder("");

            for(Pair task : taskList){
                if(cWorking && cEnd <= task.start){
                    cWorking = false;
                }
                if(jWorking && jEnd <= task.start){
                    jWorking = false;
                }

                if(!cWorking){
                    cWorking = true;
                    cStart = task.start;
                    cEnd = task.end;
                    output.append('C');
                } else if(!jWorking){
                    jWorking = true;
                    jStart = task.start;
                    jEnd = task.end;
                    output.append('J');
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #"+ (i+1) + ": " + output );
        }
    }
}

class Pair implements  Comparable{
    public int start;
    public int end;

    public Pair(int x, int y) {
        this.start = x;
        this.end = y;
    }

    @Override
    public int compareTo(Object o) {
        Pair p = (Pair) o;
        return start - p.start;
    }
}
