
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private final static int SIZE = 500;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int x = in.nextInt()+SIZE/2, y = in.nextInt()+SIZE/2;
            String[][] arr = new String[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++)
                Arrays.fill(arr[i], null);
            arr[SIZE/2][SIZE/2]="";
            Set<Integer[]> queue = new HashSet<>();
            String ans = null;
            queue.add(new Integer[]{SIZE/2, SIZE/2});
            int exponent = 1;
            for (int i = 0; i < 10; i++) {
                Set<Integer[]> queue1 = new HashSet<>();
                while (!queue.isEmpty()) {
                    Integer[] point = queue.stream().findAny().get();
                    queue.remove(point);
                    if (point[0].equals(x) && point[1].equals(y)) {
                        ans = arr[point[0]][point[1]];
                        break;
                    }
                    //try 1,0
                    trythis(point, arr, x,y,exponent,0,queue1, arr[point[0]][point[1]]+'E');
                    //try -1,0
                    trythis(point, arr, x,y,-exponent,0,queue1, arr[point[0]][point[1]]+'W');
                    //try 0,1
                    trythis(point, arr, x,y,0,exponent,queue1,arr[point[0]][point[1]]+'N');
                    //try 0,-1
                    trythis(point, arr, x,y,0,-exponent,queue1,arr[point[0]][point[1]]+'S');
                }
                if (ans!=null)break;
                exponent*=2;
                queue = queue1;
            }
            System.out.println("Case #"+(i11+1)+": " + (ans==null?"IMPOSSIBLE":ans));
        }
        in.close();
    }

    private static void trythis(Integer[] point, String[][] arr, int x, int y, int i1, int i2, Set<Integer[]> exponent, String suffix) {
        //System.out.println(suffix);
        if (point[0]+i1<arr.length && point[1]+i2<arr[0].length && point[0]+i1>=0 && point[1]+i2>=0) {
            if (arr[point[0]+i1][point[1]+i2]==null) {
                exponent.add(new Integer[]{point[0] + i1, point[1] + i2});
                arr[point[0]+i1][point[1]+i2]=suffix;
            }
        }
    }
}
