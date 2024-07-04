 import java.util .*;
    import java.io .*;

    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            //number of test cases
            int t = in.nextInt(); 
            for(int i = 1; i <= t; i++){
                int num = in.nextInt();
                int [][] tasks = new int[num][2];
                int max = 0;
                for(int j = 0; j < num; j++){
                    tasks[j][0] = in.nextInt();
                    tasks[j][1] = in.nextInt();
                    if(tasks[j][0] > max){
                        max = tasks[j][0];
                    }
                    if(tasks[j][1] > max){
                        max = tasks[j][1];
                    }
                }
                String s = "";
                String [] schedule = new String[tasks.length];
                    int[][] cTasks = new int[tasks.length][2];
                    int cIndex = 0;
                    int[][] jTasks = new int[tasks.length][2];
                    int jIndex = 0;
                    for(int z = 0; z < tasks.length; z++){
                        cTasks[z][0] = -1;
                        cTasks[z][1] = -1;
                        jTasks[z][0] = -1;
                        jTasks[z][1] = -1;
                    }
                    for(int j = 0; j < tasks.length; j++){
                        if(isAvailable(tasks[j][0], tasks[j][1], jTasks)){
                            schedule[j] = "J";
                            jTasks[cIndex][0] = tasks[j][0];
                            jTasks[cIndex][1] = tasks[j][1];
                            jIndex++;
                        }
                        else if (isAvailable(tasks[j][0], tasks[j][1], cTasks)){
                            schedule[j] = "C";
                            cTasks[jIndex][0] = tasks[j][0];
                            cTasks[jIndex][1] = tasks[j][1];
                            cIndex++;
                        }
                        else{
                            s = "IMPOSSIBLE";
                            break;
                        }
                    }
                    if(!s.equals("IMPOSSIBLE")){
                        for(int j = 0; j < schedule.length; j++){
                            s += schedule[j];
                        }
                    }
                System.out.println("Case #" + i + ": " + s);
            }
        }
        
        // public static void assign(String [] schedule, int [][] tasks, int max){
        //     for(int i = 0 ; i < max; i++){
                
        //     }
        // }
        public static boolean isAvailable(int x, int y, int [][] tasks){
            for(int i = 0; i < tasks.length; i++){
                if(tasks[i][0] != -1){
                    if(tasks[i][0] > x && tasks[i][0] < y){
                        return false;
                    }
                }
                if(tasks[i][1] != -1){
                    if(tasks[i][1] > x && tasks[i][1] < y){
                        return false;
                    }
                }
                if(tasks[i][0] == x){
                    return false;
                }
                if(tasks[i][0] < x && tasks[i][1] > y){
                    return false;
                }
                if(tasks[i][0] > x && tasks[i][1] < y){
                    return false;
                }
            }
            return true;
        }
    }
        