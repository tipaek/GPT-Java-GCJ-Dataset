
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int size = sc.nextInt();
            Line[] lines = new Line[size];
            System.out.print("Case #" + (i + 1) + ": ");
            for (int a = 0; a < size; a++) {
                int s = sc.nextInt();
                int f = sc.nextInt();
                lines[a] = new Line(s, f);
            }
            Arrays.sort(lines);

            Stack<Line> c = new Stack<>();
            Stack<Line> j = new Stack<>();
            boolean flag = false;
            for (int a = 0; a < size; a++) {
                if(c.empty()){
                    c.push(lines[a]);
                    continue;
                }else if(j.empty()){
                    j.push(lines[a]);
                    continue;
                }
                if(lines[a].start >= c.peek().finish){
                    c.push(lines[a]);
                    continue;
                }else if(lines[a].start >= j.peek().finish){
                    j.push(lines[a]);
                    continue;
                }
                flag = true;
            }
            if(flag){
                System.out.print("IMPOSSIBLE");
                System.out.println();
                continue;
            }
            c = new Stack<>();
            j = new Stack<>();
            for (int a = 0; a < size; a++) {
                if(c.empty()){
                    System.out.print("C");
                    c.push(lines[a]);
                    continue;
                }else if(j.empty()){
                    System.out.print("J");
                    j.push(lines[a]);
                    continue;
                }
                if(lines[a].start >= c.peek().finish){
                    System.out.print("C");
                    c.push(lines[a]);
                }else if(lines[a].start >= j.peek().finish){
                    System.out.print("J");
                    j.push(lines[a]);
                }
            }
            System.out.println();
        }
    }
}

class Line implements Comparable<Line> {
    int start;
    int finish;

    Line(int s, int f) {
        start = s;
        finish = f;
    }

    @Override
    public int compareTo(Line l) {
        return Integer.compare(finish, l.finish);
    }
}