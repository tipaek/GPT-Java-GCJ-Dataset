
import java.util.Scanner;

public class Solution {
    private static int bestLength;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            long x = sc.nextInt(), y = sc.nextInt(), move = 1;
            boolean possible = true;

            char[] arr = new char [5];
            bestLength = 10;
            char[] betterSolution = new char [bestLength];
            if(resultReq(arr, 0, betterSolution, x, y, 1)){
                arr = betterSolution;
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < bestLength; i++){
                    switch(betterSolution[i]){
                        case 'N':
                            y -= move;
                        break;
                        case 'S':
                            y += move;
                        break;
                        case 'E':
                            x -= move;
                        break;
                        case 'W':
                            x += move;
                        break;
                    }

                    sb.append(betterSolution[i]);
                    move *= 2;

                    if(x == y && x == 0) break;
                }
                System.out.println("Case #" + t + ": " + sb.toString());
            }else{
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        }
    }
    private static boolean resultReq(char[] arr, int depth, char[] betterSolution, long x, long y, int move){
        if(x == y && x == 0){
            if(depth < bestLength){
                bestLength = depth;
                for(int i = 0; i < bestLength; i++)betterSolution[i] = arr[i];
            }
            return true;
        }
        if(depth >= arr.length) return false;

        boolean possible = false;

        arr[depth] = 'N';
        if(resultReq(arr, depth + 1, betterSolution, x, y - move, move * 2)) possible = true;
        arr[depth] = 'S';
        if(resultReq(arr, depth + 1, betterSolution, x, y + move, move * 2)) possible = true;
        arr[depth] = 'E';
        if(resultReq(arr, depth + 1, betterSolution, x - move, y, move * 2)) possible = true;
        arr[depth] = 'W';
        if(resultReq(arr, depth + 1, betterSolution, x + move, y, move * 2)) possible = true;

        return possible;
    }
}
