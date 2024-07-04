
import java.util.Scanner;

public class Solution {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            long x = sc.nextInt(), y = sc.nextInt(), move = 1;
            boolean possible = true;

            char[] arr = new char [3];
            if(resultReq(arr, 0, x, y, 1)){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < arr.length; i++){
                    switch(arr[i]){
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

                    sb.append(arr[i]);
                    move *= 2;

                    if(x == y && x == 0) break;
                }
                System.out.println("Case #" + t + ": " + sb.toString());
            }else{
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        }
    }
    private static boolean resultReq(char[] arr, int depth, long x, long y, int move){
        if(x == y && x == 0) return true;
        if(depth >= arr.length) return false;

        arr[depth] = 'N';
        if(resultReq(arr, depth + 1, x, y - move, move * 2)) return true;
        arr[depth] = 'S';
        if(resultReq(arr, depth + 1, x, y + move, move * 2)) return true;
        arr[depth] = 'E';
        if(resultReq(arr, depth + 1, x - move, y, move * 2)) return true;
        arr[depth] = 'W';
        if(resultReq(arr, depth + 1, x + move, y, move * 2)) return true;

        return false;
    }
}
