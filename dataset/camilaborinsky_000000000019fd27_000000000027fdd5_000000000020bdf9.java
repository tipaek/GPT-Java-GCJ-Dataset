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
            int[][] tasks = new int[n][3];
            for(int j = 0 ; j < n ; j++ ){
                tasks[j][0] = j;
                for(int k = 1 ; k < 3 ; k++){
                    tasks[j][k] = scr.nextInt();
                }
            }
            out[i] = organizeTasks(tasks, n);
            System.out.println("Case #"+(i+1)+": "+out[i]);
        }
    }

    public static String organizeTasks(int[][] tasks, int n){

        char[] toRet= new char[n];
        boolean slotTaken;
        boolean impossible = false;
        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();
        if(n >= 1){
            tasks = sortTasks(tasks, n);
        }

        for(int i = 0 ; i < n && !impossible ; i++){
            slotTaken = false;
            for(int[] task : cameron){
                if(!(tasks[i][1] >= task[2] || tasks[i][2] <= task[1])){
                    slotTaken = true;
                }
                if(slotTaken){
                    break;
                }
            }
            if(!slotTaken){
                cameron.add(tasks[i]);
                toRet[tasks[i][0]] = 'C';
            }else{
                for(int[] task : jamie){
                    if(!(tasks[i][1] >= task[2] || tasks[i][2] <= task[1])){
                        impossible = true;
                    }
                    if (impossible){
                        break;
                    }
                }
                if(!impossible){
                    jamie.add(tasks[i]);
                    toRet[tasks[i][0]]='J';
                }else{
                    return "IMPOSSIBLE";
                }

            }
        }

        return String.valueOf(toRet);
    }

    public static int[][] sortTasks(int[][] mat, int rows){

        int[] aux;
        for(int i = 0 ; i < rows-1 ; i++){
            if(!(mat[i][1] < mat[i+1][1] || (mat[i][1] == mat[i+1][1] && mat[i][2]< mat[i+1][2]))){
                aux = mat[i];
                mat[i] = mat[i+1];
                mat[i+1] = aux;
                int j = 0;
                while(j < i){
                    if(!(mat[i][1] < mat[i+1][1] || (mat[i][1] == mat[i+1][1] && mat[i][2]< mat[i+1][2]))) {
                        aux = mat[i];
                        mat[i] = mat[i + 1];
                        mat[i + 1] = aux;
                    }
                    j++;
                }
            }
        }
        return mat;
    }
}
