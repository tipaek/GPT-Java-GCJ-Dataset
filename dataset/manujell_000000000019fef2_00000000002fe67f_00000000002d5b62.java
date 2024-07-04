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

        long goalX = Long.parseLong(line[0]);
        long goalY = Long.parseLong(line[1]);

        return jump(goalX, goalY);
    }

    public static String jump(long x, long y) {
        if(isEven(x) == isEven(y)){
            return "IMPOSSIBLE";
        }
        char dir = ' ';

        if (x == 0 && y == 1){
            return "S";
        } else if(x == 0 && y == -1){
            return "N";
        } else if(y == 0 && x == 1){
            return "E";
        } else if(y == 0 && x == -1){
            return "W";
        }
        
        if (x % 2 != 0){
            if ((y/2)%2 == 0){
                if (((x+1)/2)%2 != 0){
                    return jump((x+1)/2, y/2) + "W";
                } else {
                    return jump((x-1)/2, y/2) + "E";
                }
            } else {
                if (((x+1)/2)%2 == 0){
                    return jump((x+1)/2, y/2) + "W";
                } else {
                    return jump((x-1)/2, y/2) + "E";
                }
            }

        } else {
            if ((x / 2) % 2 == 0) {
                if (((y + 1) / 2) % 2 != 0) {
                    return jump(x / 2, (y + 1) / 2) + "N";
                } else {
                    return jump(x / 2, (y - 1) / 2) + "S";
                }
            } else {
                if (((y + 1) / 2) % 2 == 0) {
                    return jump(x / 2, (y + 1) / 2) + "N";
                } else {
                    return jump(x / 2, (y - 1) / 2) + "S";
                }
            }
        }
    }

    private static boolean isEven(long i){
        return i%2 == 0;
    }
}
