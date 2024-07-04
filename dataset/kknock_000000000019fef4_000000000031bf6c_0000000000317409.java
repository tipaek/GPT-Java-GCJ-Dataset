import java.util.Scanner;

class Point {
    public int x;
    public int y;
    public Point(){
        this.x = 0;
        this.y = 0;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []res = new String[cases];
        for (int i = 1; i <= cases; i++) {
            Point awayPos = new Point();
            awayPos.x = in.nextInt();
            awayPos.y = in.nextInt();
            String moves = in.nextLine();
            String resI = getRes(awayPos, moves);
            res[i-1] = "Case #"+i+": "+resI;
        }
        in.close();
        for (String s: res) {
            System.out.println(s);
        }

    }

    public static String getRes(Point awayPos, String moves) {
        int result = Integer.MAX_VALUE;
        Point myPos = new Point();
        for(int i = 0; i < moves.length(); i++) {
            Character move = moves.charAt(i);
            Point updatedPos = updatesPos(awayPos, move);
            int away = getSum(updatedPos);
            if(away < i+1) {
                if(i+1 < result) {
                    result = i;
                }
            }
        }
        if(result == Integer.MAX_VALUE) {
            return "IMPOSSIBLE";
        }
        return String.valueOf(result);
    }

    public static Point updatesPos(Point pos, Character move) {
        if(move.equals('N')){
            pos.y++;
        } else if(move.equals('S')){
            pos.y--;
        } else if(move.equals('E')){
            pos.x++;
        }else if(move.equals('W')){
            pos.x--;
        }
        return pos;
    }

    public static Integer getSum(Point p) {
        return Math.abs(p.x)+Math.abs(p.y);
    }
}
