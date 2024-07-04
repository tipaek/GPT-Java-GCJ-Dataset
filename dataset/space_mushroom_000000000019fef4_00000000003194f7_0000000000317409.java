import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(int X, int Y, String path){
        int eastDistance = X;
        int northDistance = Y;
        int moves = 0;

        for(int i=0; i<path.length(); i++){
            char c = path.charAt(i);
            switch (c){
                case 'N':
                    northDistance++;
                    break;
                case 'S':
                    northDistance--;
                    break;
                case 'E':
                    eastDistance++;
                    break;
                case 'W':
                    eastDistance--;
                    break;
            }
            moves++;
            if(Math.abs(northDistance) + Math.abs(eastDistance) <= moves)
                return "" + moves;
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            String s = input.nextLine();
            String[] split = s.split(" ");
            int X = Integer.parseInt(split[0]);
            int Y = Integer.parseInt(split[1]);
            String path = split[2];
            System.out.println("Case #" + (i + 1) + ": " + solve(X, Y, path));
        }
    }
}