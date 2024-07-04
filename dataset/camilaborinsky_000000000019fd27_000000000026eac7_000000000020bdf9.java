import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scr.nextInt();
        String[] out = new String[t];
        for(int i = 0 ; i < t ; i++ ){
            int n = scr.nextInt();
            int[][] tasks = new int[n][2];
            for(int j = 0 ; j < n ; j++ ){
                for(int k = 0 ; k < 2 ; k++){
                    tasks[j][k] = scr.nextInt();
                }
            }
            out[i] = organizeTasks(tasks, n);
            System.out.println("Case #"+(i+1)+": "+out[i]);
        }
    }

    public static String organizeTasks(int[][] tasks, int n){

        String toRet="";
        boolean slotTaken;
        boolean impossible = false;
        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();
        for(int i = 0 ; i < n && !impossible ; i++){
            slotTaken = false;
            for(int[] task : cameron){
                if(!(tasks[i][0] >= task[1] || tasks[i][1] <= task[0])){
                    slotTaken = true;
                }
            }
            if(!slotTaken){
                cameron.add(tasks[i]);
                toRet = toRet.concat("C");
            }else{
                for(int[] task : jamie){
                    if(!(tasks[i][0] >= task[1] || tasks[i][1] <= task[0])){
                        impossible = true;
                    }
                    if (impossible){
                        break;
                    }
                }
                if(!impossible){
                    jamie.add(tasks[i]);
                    toRet = toRet.concat("J");
                }else{
                    toRet="IMPOSSIBLE";
                }

            }
        }

        return toRet;
    }
}
