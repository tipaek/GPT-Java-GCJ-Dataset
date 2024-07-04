import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            solve(sc, i);
        }
    }

    private static void solve(Scanner sc, int c) {
        int num = sc.nextInt();
        Todo[] todos = new Todo[num];
        for (int i = 0; i < num; i++) {
            todos[i] = new Todo(sc.nextInt(), sc.nextInt(),i);
        }
        Arrays.sort(todos, Comparator.comparingInt(t -> t.start));
        char[] ans = new char[num];
        int maxC = 0;
        int maxJ = 0;
        for (int i = 0; i <todos.length ; i++) {
            if(todos[i].start>= maxC) {
                maxC = todos[i].end;
                ans[todos[i].index] = 'C';
            } else if (todos[i].start >= maxJ){
                maxJ = todos[i].end;
                ans[todos[i].index] = 'J';
            } else{
                System.out.printf("Case #%d: IMPOSSIBLE\n", c);
                return;
            }
        }
        System.out.printf("Case #%d: %s\n", c, String.valueOf(ans));
    }
}

class Todo {
    int start;
    int end;
    int index;

    Todo(int s, int e, int i) {
        this.start = s;
        this.end = e;
        this.index = i;
    }
}
