import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOFTestCases = Integer.parseInt(in.nextLine());
        for (int caseNumber = 1; caseNumber <= numberOFTestCases; caseNumber++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(in.nextLine());
            boolean[] ctask = new boolean[n];
            // stat, end, index
            Queue<int[]> pq= new PriorityQueue<>(
                (a,b)->{
                 int diff = a[0]-b[0];
                 return diff ==0 ?a[1]-b[1]:diff;
            }
            );

            for (int index = 0; index < n; index++) {
                String[] timeline = in.nextLine().split(" ");
                pq.add(new int[]{Integer.parseInt(timeline[0]), Integer.parseInt(timeline[1]),index});
            }

            int[] c = null;
            int[] j =null;
            boolean notPossible= false;
            while (!pq.isEmpty())
            {
                int[] time = pq.remove();

                if(c== null)
                {
                    c =time;
                    ctask[time[2]] =true;
                }else if(j==null)
                {
                    j = time;
                }else if(time[0]>=c[1]){
                    c =time;
                    ctask[time[2]] =true;
                }else if(time[0]>=j[1])
                {
                    j =time;
                }else{
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    notPossible =true;
                    break;
                }

            }

            if(!notPossible){
                for(boolean task:ctask)
                    sb.append(task?'C':'J');

                System.out.println("Case #" + caseNumber + ": " + sb.toString() );
            }

        }

        in.close();
    }
}
