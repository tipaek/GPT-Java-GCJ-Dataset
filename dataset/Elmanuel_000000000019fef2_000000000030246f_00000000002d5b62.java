import java.util.Scanner;

public class Solution {
    public static String result;
    public static void main(String [] args){
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        while(cases > 0){
            result = "";
            int x = read.nextInt();
            int y = read.nextInt();
            solveExpogo(x, y, 0, 0, 1, "");
            System.out.println(result);
            cases--;
        }
    }
    public static void solveExpogo(int x, int y, int i, int j,int moves,String actS){
        if(i == x && j == y){
            if(actS.length() < result.length() || result.length() == 0){
                result = actS;
            }
            return;
        }
        if(Math.abs(i) > 4 || Math.abs(j) > 4)return;
        char coords[] = {'E','N','W','S'};
        for(int c = 0; c < 4; c++){
            actS += coords[c];
            if(c == 0){
                i += Math.pow(2,moves-1);
            }else if(c == 2){
                i -= Math.pow(2,moves-1);
            }else if(c == 1){
                j += Math.pow(2,moves-1);
            }else if(c == 3){
                j -= Math.pow(2,moves-1);
            }
            solveExpogo(x, y, i, j, moves+1, actS);
            actS = actS.substring(0, actS.length()-1);
            if(c == 0){
                i -= Math.pow(2,moves-1);
            }else if(c == 2){
                i += Math.pow(2,moves-1);
            }else if(c == 1){
                j -= Math.pow(2,moves-1);
            }else{
                j += Math.pow(2,moves-1);
            }
        }
        if(result.equals(""))result = "IMPOSSIBLE";
    }
}