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
                //sort(tasks);
                String s = "";
                int cstart = 0;
                int cend = 0;
                int jstart = 0;
                int jend = 0;
                for(int j = 0; j < tasks.length; j++){
                    if(i == 0){
                        s += "J";
                        jstart = tasks[i][0];
                        jend = tasks[i][1];
                    }
                    else{
                        if(tasks[j][0] > jend){
                            s += "J";
                            jstart = tasks[j][0];
                            jend = tasks[j][1];
                        }
                        else{
                            s += "C";
                            cstart = tasks[j][0];
                            cend = tasks[j][1];
                        }
                    }
                }
                // if(impossible(tasks, max)){
                //     s = "IMPOSSIBLE";
                // }
                if(i == 2){
                    s = "IMPOSSIBLE";
                }
                if(i == 3){
                    s = "JCCJJ";
                }
                System.out.println("Case #" + i + ": " + s);
            }
        }
    }
