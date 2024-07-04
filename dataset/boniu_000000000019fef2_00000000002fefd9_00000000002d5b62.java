
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = path(x, y, 1);
            if (result == "0")
                result = "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }

    public static String path(int x, int y, int step) {
        //impossible
        if (x%step != 0 | y%step != 0)
            return "0";
        x/=step;
        y/=step;
        step/=step;

        if(x == 1 && y==1 && step==1) return "0";


        if (x == step && y==0)
            return "E";
        else if (x == -step && y == 0)
            return "W";
        else if (y == step && x == 0)
            return "N";
        else if (y == -step && x == 0)
            return "S";

        //e w n s
        String[] results = {"","","",""};
        results[0] = "E" + path(x-1,y,step*2);
        results[1] = "W" + path(x+1,y,step*2);
        results[2] = "N" + path(x,y-1,step*2);
        results[3] = "S" + path(x,y+1,step*2);

        int minLen = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < results.length; i++) {
            if (results[i].indexOf("0")!=-1){
                continue;
            }else {
                if (results[i].length()<minLen){
                    minLen = results[i].length();
                    minIdx = i;
                }
            }
        }

        if (minIdx == -1)
            return "0";
        else
            return results[minIdx];
    }


}
