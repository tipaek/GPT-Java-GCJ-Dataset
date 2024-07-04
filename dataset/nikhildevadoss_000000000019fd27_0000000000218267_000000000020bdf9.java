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
                for(int j = 0; j < tasks.length; j++){
                    if(j == 0){
                        s += "C";
                    }
                    else{
                        if(s.charAt(j - 1) == 'C'){
                            s += "J";
                        }
                        else{
                            s += "C";
                        }
                    }
                }
                if(impossible(tasks)){
                    s = "IMPOSSIBLE";
                }
                System.out.println("Case #" + i + ": " + s);
            }
        }
        
        public static boolean impossible(int[][] tasks){
            for(int i = 0; i < tasks.length; i++){
                if(i > 1){
                    if(tasks[i][0] > tasks[i - 1][0] && tasks[i][0] < tasks[i - 1][1] && tasks[i][0] > tasks[i - 2][0] && tasks[i][0] < tasks[i -2][1]){
                        return true;
                    }
                }
            }
            return false;
        }

        

    }