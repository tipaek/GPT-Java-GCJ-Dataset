import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = a(br);
            System.out.format("Case #%d: ", j);
            System.out.println(str);
        }
    }

    public static String b(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int R = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);

        int ranks = R;
        int temp = R*S-R-1;

        String res = "";
        int steps = 0;
        for(int i=0; temp>=1; temp--) {
            int af = ranks - (i/(S-1));
            int ag = temp;

            if(af == 1)
                break;
            res+="\n" + af + " " + ag;
            i++;
            steps++;
        }
        return steps + res;
    }



    public static String a(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int goalX = Integer.parseInt(line[0]);
        int goalY = Integer.parseInt(line[1]);

        return jump(goalX, goalY);
    }

    public static String jump(int x, int y) {
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
        if(!isEven(x)){
            boolean getOdd = isEven(y/2);
            if(getOdd == !isEven((x+1)/2)) {
                x = x+1;
                dir = 'W';
            }
            else {
                x = x-1;
                dir = 'E';
            }
        }
        if(!isEven(y)){
            boolean getOdd = isEven(x/2);
            if(getOdd == !isEven((y+1)/2)){
                y = y+1;
                dir = 'N';
            }
            else {
                y = y-1;
                dir = 'S';
            }
        }

        String result = jump(x/2, y/2);
        if(result.equals("IMPOSSIBLE"))
            return result;
        return result + dir;
    }

    private static boolean isEven(int i){
        return i%2 == 0;
    }
}
