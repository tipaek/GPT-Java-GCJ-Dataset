import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static List<Character> path;
    public static Scanner scanner;
    public static void main(String[] args){
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int i=1; i<=T; i++){
            System.out.print("Case #"+ i +": ");
            testcase();
        }
    }

    public static void testcase() {
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        path = new ArrayList();
        if (x == 0 && y == 0){
            System.out.print("");
            return;
        }
        if ((Math.abs(x)+ Math.abs(y)) % 2 == 1){
            buildPath(x, y, 0, 0, 0,new ArrayList<>());
            for (char c : path)
                System.out.print(c);
        }
        else{
            System.out.print("IMPOSSIBLE");
            return;
        }
        System.out.print("\n");
    }

    private static void buildPath(long x, long y, long i, long j, long jump, List<Character> curr) {
        if (x == i && y == j){
            if (path.size() < 1 || path.size() > curr.size())
                path = new ArrayList<>(curr);
            //System.out.print(path);
            return;
        }
        if ( Math.abs(i) >= Math.abs(x+1)*20 || Math.abs(j+1) >= Math.abs(y+1)*20)
            return;
        long newPosition = (long) Math.pow(2,jump);
        String dir = "NEWS";
        for (char c : dir.toCharArray()){
            curr.add(c);
            if (c == 'N')
                buildPath(x, y, i,j +newPosition, jump+1, curr);
            else if (c == 'E')
                buildPath(x, y, i+newPosition, j, jump+1, curr);
            else if (c == 'W')
                buildPath(x, y, i - newPosition, j, jump+1, curr);
            else if (c == 'S')
                buildPath(x, y, i,j -newPosition, jump+1, curr);
            curr.remove(curr.size() -1);
        }
    }
}
/*
4
2 3
-2 -3
3 0
-1 1

1
3 0
 */