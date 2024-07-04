import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i=1; i<=t; i++){
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            for(int j=0; j<n; j++){
                activities[j][0]=scanner.nextInt();
                activities[j][1]=scanner.nextInt();
            }
            int[][] sortedActivities = Arrays.copyOf(activities,activities.length);
            int[] sort = sortArray(sortedActivities);
            char[] out = new char[n];
            int cameron = 0;
            int jamie = 0;
            for(int j=0; j<n; j++){
                if(cameron<=sortedActivities[j][0]){
                    cameron=sortedActivities[j][1];
                    out[sort[j]]='C';
                }else if(jamie<=sortedActivities[j][0]){
                    jamie=sortedActivities[j][1];
                    out[sort[j]]='J';
                }else {
                    out = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            System.out.println("Case #"+i+": "+ new String(out));
        }
    }

    private static int[] sortArray(int[][]activities) {
        int[] sort = new int[activities.length];
        for(int i=0;i<sort.length;i++){
            sort[i]=i;
        }
        for(int i=1; i<activities.length;i++){
            for(int j=0; j<activities.length-i;j++){
                if(activities[j][0]>activities[j+1][0]){
                    int[] tmp = activities[j];
                    activities[j]=activities[j+1];
                    activities[j+1]=tmp;
                    int tmp2 = sort[j];
                    sort[j]=sort[j+1];
                    sort[j+1]=tmp2;
                }
            }
        }
        return sort;
    }
}
