
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            String path = sc.next();

            solutions[i] = fan(x, y, path);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String fan(int X, int Y, String path) {
        StringBuilder sb = new StringBuilder();
        int x = X, y = Y;
        int T = path.length();
        int t = T;
        int x2=0,y2=0;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch(c){
                case 'N':y2++;break;
                case 'S': y2--;break;
                case 'W': x2--;break;
                case 'E': x2++;break;
            }
        }
        //x,y is the distance between the two

        if(Math.abs(x+x2)+ Math.abs(y+y2) > path.length() )return "IMPOSSIBLE";

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
//            System.out.println(x + " " +y+" "+c);

            switch(c){
                case 'N':{ y2--;y++;break;}
                case 'S': {y2++;y--;break;}
                case 'W': {x2++;x--;break;}
                case 'E': {x2--;x++;break;}
            }
            //x2 distance pepurr has left to move in X direction
            //y2 distance pepurr has left to move in Y direction
            if (x == 0 && y == 0) return String.valueOf(i+1);

            if((y>0 && y+y2 <= 0)||(y<0 && y+y2>=0)){
                if(x> 0){
                    x--;
                }
                else if (x < 0){
                    x++;
                }
                else {
                    if(y>0)y--;
                    else if(y<0)y++;
                }
            }

            else if((x>0 && x+x2 >= 0)||(x<0 && x+x2<=0)){
                if(y> 0){
                    y--;
                }
                else if (y < 0){
                    y++;
                }
                else {
                    if(x>0)x--;
                    else if(x<0)x++;
                }
            }

            if (x == 0 && y == 0) return String.valueOf(i+1);

        }
        if (x == 0 && y == 0) return String.valueOf(path.length());

        return "IMPOSSIBLE";
    }
}
