
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int k = 1; k <= T; k++) {
            int N=sc.nextInt();
            int CameronLatest=0;
            int JamieLatest=0;
            String res="";
            int[][] activities= new int[N][2];
            for (int i = 0; i <N; i++) {
                activities[i][0]=sc.nextInt();
                activities[i][1]=sc.nextInt();
            }
            sortbyColumn(activities,0);
            for (int i = 0; i <N; i++) {
                if(CameronLatest<= activities[i][0]){
                    CameronLatest=activities[i][1];
                    res= res+ 'C';
                }else if(JamieLatest<= activities[i][0]){
                    JamieLatest=activities[i][1];
                    res= res+ 'J';
                }else {
                    res= "IMPOSSIBLE";
                    i=N+1;
                }
            }
            System.out.println("Case #"+ k + ": " +res );
        }
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  
    }
}
