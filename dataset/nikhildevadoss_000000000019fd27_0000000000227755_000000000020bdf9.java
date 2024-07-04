 import java.util .*;
    import java.io .*;

    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            //number of test cases
            int t = in.nextInt(); 
            for(int j = 1; j <= t; j++){
                int num = in.nextInt();
                int [][] tasks = new int[num][2];
                for(int i = 0; i < tasks.length; i++){
                    tasks[i][0] = in.nextInt();
                    tasks[i][1] = in.nextInt();
               }
            String [] schedule = new String[tasks.length];
            boolean impossible = false;
            boolean jFree = true;
            int [][] jTasks = new int[tasks.length][2];
            int jIndex = 0;
            boolean cFree = false;
            int [][] cTasks = new int[tasks.length][2];
            int cIndex = 0;
            String s = "";
            for(int i = 0; i < tasks.length; i++){
                jTasks[i][0] = -1;
                jTasks[i][1] = -1;
                cTasks[i][0] = -1;
                cTasks[i][1] = -1;
            }
            for(int i = 0; i < tasks.length; i++){
                if(isAvailable(jTasks, tasks[i][0], tasks[i][1])){
                    jTasks[jIndex][0] = tasks[i][0];
                    jTasks[jIndex][1] = tasks[i][1];
                    jIndex++;
                    jFree = false;
                    schedule[i] = "J";
                }
                else if(isAvailable(cTasks, tasks[i][0], tasks[i][1])){
                    cTasks[cIndex][0] = tasks[i][0];
                    cTasks[cIndex][1] = tasks[i][1];
                    cIndex++;
                    cFree = false;
                    schedule[i] = "C";
                }
                else{
                    impossible = true;
                }
            }
            if(impossible){
                s = "IMPOSSIBLE";
            }
            else{
                for(int i = 0; i < tasks.length; i++){
                    s += schedule[i];
                }
            }
            
            System.out.println("Case #" + j + ": " + s);
            }
            
        }
        
        
        // public static boolean isAvailable(int [][] tasks, int x,int y){
        //     for(int i = 0; i < tasks.length; i++){
        //         if(tasks[i][0] != -1){
        //             if(tasks[i][0] >= x && tasks[i][0] <= y){
        //                 return false;
        //             }
        //             if(tasks[i][0] < x && tasks[i][0] > y){
        //                 return false;
        //             }
        //         }
        //         if(tasks[i][1] != -1){
        //             if(tasks[i][1] > x && tasks[i][1] < y){
        //                 return false;
        //             }
        //         }
        //         if(tasks[i][0] == x){
        //             return false;
        //         }
        //         if(tasks[i][0] < x && tasks[i][1] > y){
        //             return false;
        //         }
        //         if(tasks[i][0] > x && tasks[i][1] < y){
        //             return false;
        //         }
        //     }
        //     return true;
        // }
        public static boolean isAvailable(int [][] tasks, int x,int y){
            for(int i = x; i <= y; i++){
                for(int j = 0; j < tasks.length; j++){
                    if(tasks[j][0] < i && tasks[j][1] > i){
                        return false;
                    }
                }
            }
            return true;
        }
        
        
        
        
        
    }