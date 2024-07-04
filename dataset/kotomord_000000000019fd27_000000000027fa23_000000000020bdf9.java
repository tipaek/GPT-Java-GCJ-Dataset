import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static char[] names = {'C', 'J'};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int tst = 0; tst<t; ++tst){
              runTest(scan, tst+1);

        }

    }

    static  List<List<Integer>> neibours;
    static  int[] solution;
    static boolean err;


    private static void runTest(Scanner scan, int t) {
        int ac = scan.nextInt();
        err = false;
        solution = new int[ac];
        int[][] tasks = new int[ac][2];
        neibours = new ArrayList<>();

        for(int i = 0; i<ac; ++i){
            tasks[i][0] = scan.nextInt();
            tasks[i][1] = scan.nextInt();
            neibours.add(new ArrayList<>());
        }

        for(int i = 0; i<ac; ++i)
            for(int j = i+1; j<ac; ++j) {
                if (tasks[i][1] <= tasks[j][0]) continue;
                if (tasks[j][1] <= tasks[i][0]) continue;
                neibours.get(i).add(j);
                neibours.get(j).add(i);
            }
        for(int i = 0; i<ac; ++i){
            if (err) break;
            if (solution[i] == 0) {
                go(i, 1);
            }
        }

        if(err) {
            System.out.println("Case #"+t + ": IMPOSSIBLE");
            return;
        }

        System.out.print("Case #"+t + ": ");
        for(int i = 0; i<ac;++i) System.out.print(names[solution[i]-1]);
        System.out.println();
    }

    private static void go(int i, int v) {
        if (solution[i] == v) {
            return;
        }
        if (solution[i]!=0) {
            err = true;
            return;
        }
        solution[i]=v;
        for(int j: neibours.get(i)) go(j, 3-v);
    }

}
