import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = a(br);
            System.out.format("Case #%d: %s\n", j, str);
        }
    }

    public static String a(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int goalX = Integer.parseInt(line[0]);
        int goalY = Integer.parseInt(line[1]);

        return jump(goalX, goalY);
    }

    public static String jump(int x, int y) {
        if (x == 0 && y == 0)
            return "";
        if(Math.abs(x)%2 == Math.abs(y)%2){
            return "IMPOSSIBLE";
        }
        String result = "IMPOSSIBLE";
        char dir = ' ';

        if(x%2 != 0){
            if(x != -1 || y != 0) {
                result = jump((x - 1) / 2, y / 2);
                dir = 'E';
            }
            if(result.equals("IMPOSSIBLE")) {
                if(x != -1 || y != 0) {
                    result = jump((x + 1) / 2, y / 2);
                    dir = 'W';
                }
            }
        }
        if(y%2 != 0){
            if(y != -1 || x != 0) {
                dir = 'S';
                result = jump(x / 2, (y - 1) / 2);
            }
            if(result.equals("IMPOSSIBLE")) {
                if(y != 1 || x != 0) {
                    dir = 'N';
                    result = jump(x / 2, (y + 1) / 2);
                }
            }
        }

        return result + dir;
    }
}
