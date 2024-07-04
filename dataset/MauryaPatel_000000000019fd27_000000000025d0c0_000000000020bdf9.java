import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t,k;
        t=in.nextInt();
        for(k=1;k<=t;k++)
        {
          int i,n;
          n=in.nextInt();
          int input [][]= new int[n][2];
          for(i=0;i<n;i++)
          {
            input[i][0]=in.nextInt();
            input[i][1]=in.nextInt();
          }

//        int input [][]= {{1,3},{0,1440},{2,4}};
        System.out.println("Case #"+k+": "+getAssignments(input));
      }
    }

    public static String getAssignments(int[][] input) {
        StringBuilder builder = new StringBuilder();
        HashMap<int[],Character> assignments = new HashMap<>();
        int[][] intervals = Arrays.copyOf(input,input.length);

//        Arrays.sort(intervals,(x,y)-> (x[0]==y[0]? x[1]-y[1] : x[0]-y[0]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });

//        System.out.println(Arrays.stream(input).map(x-> Arrays.toString(x)).collect(Collectors.joining(" :: ")));
        //System.out.println(Arrays.stream(intervals).map(x-> Arrays.toString(x)).collect(Collectors.joining(" :: ")));

        int [] jJob = null;
        int [] cJob = null;

        for(int i=0;i<intervals.length;i++) {
            int[] job = intervals[i];
            if(jJob == null || jJob[1] <=job[0]) {
                jJob = job;
                assignments.put(job,'J');
            }else if (cJob ==null || cJob[1] <= job[0]) {
                cJob = job;
                assignments.put(job,'C');
            }else {
                return "IMPOSSIBLE";
            }
        }
        for (int[]arr : input) {
            builder.append(assignments.get(arr));
        }

        return builder.toString();
    }
}
