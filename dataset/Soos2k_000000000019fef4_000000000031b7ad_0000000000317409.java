import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        String[] results = new String[cases];
        for (int i = 0; i < cases; i++){
            String[] inputs = sc.nextLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            String directions = inputs[2];
            results[i] = "Case #" + (i+1) + ": " + meetIdol(x,y,directions);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String meetIdol(int x, int y, String directions){
        int len = directions.length();
        for (int i = 0; i < len; i++){
            char c = directions.charAt(i);
            if (c == 'N'){
                y++;
            }
            else if (c == 'E'){
                x++;
            }
            else if (c == 'W'){
                x--;
            }
            else {
                y--;
            }
            if ((Math.abs(x) + Math.abs(y)) <= (i+1)){
                return "" + (i+1);
            }
        }
        return "IMPOSSIBLE";
    }
    
}