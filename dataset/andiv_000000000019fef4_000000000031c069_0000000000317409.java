import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if(!wasPrevNextLine) scanner.nextLine();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String path = scanner.nextLine();
            path = path.trim();
            wasPrevNextLine = true;
            String result = solve(X, Y, path);
            System.out.println("Case #"+i+": "+result);
        }

    }

    public static String solve(int X, int Y, String path){
        if(X== 0 && Y== 0) return "0";
        int step = 1;
        for(char ch : path.toCharArray()){
            if(ch == 'N') Y++;
            else if(ch == 'S') Y--;
            else if(ch == 'E') X++;
            else X--;
            int dist = getDistance(X, Y);
            if(dist <= step) return step +"";
            step ++;
        }

        return "IMPOSSIBLE";
    }

    public static int getDistance(int X, int Y){
        return Math.abs(X) + Math.abs(Y);
    }

}
