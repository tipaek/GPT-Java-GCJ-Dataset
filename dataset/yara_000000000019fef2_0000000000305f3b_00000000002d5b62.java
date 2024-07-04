import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0; i<t; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            StringBuilder p = new StringBuilder();
            String s2 = steps(0,0,0,x,y,p);
            if("".equals(s2)){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(s2);
            }
        }
    }
    public static String steps(int sx, int sy, int step, int dx, int dy, StringBuilder p){
        if(sx == dx && sy == dy)
            return p.toString();
        if(isSafe(sx, sy+(int)Math.pow(2,step), dx, dy)){
            p.append("N");
            steps(sx, sy+(int)Math.pow(2,step), step+1, dx, dy, p);
            p.deleteCharAt(p.length()-1);
        }
        if(isSafe(sx, sy-(int)Math.pow(2,step), dx, dy)){
            p.append("S");
            steps(sx, sy-(int)Math.pow(2,step), step+1, dx, dy, p);
            p.deleteCharAt(p.length()-1);
        }
        if(isSafe(sx+(int)Math.pow(2,step), sy, dx, dy)){
            p.append("E");
            steps(sx+(int)Math.pow(2,step), sy, step+1, dx, dy, p);
            p.deleteCharAt(p.length()-1);
        }
        if(isSafe(sx-(int)Math.pow(2,step), sy, dx, dy)){
            p.append("W");
            steps(sx-(int)Math.pow(2,step), sy, step+1, dx, dy, p);
            p.deleteCharAt(p.length()-1);
        }
        return p.toString();
    }
    public static boolean isSafe(int sx, int sy, int dx, int dy){
        if(Math.abs(sx) > Math.abs(dx) || Math.abs(sy) > Math.abs(dy)){
            return false;
        }
        return true;
    }
}
