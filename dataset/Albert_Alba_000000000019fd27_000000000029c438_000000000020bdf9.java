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
            Input[] inputs = new Input[size];
            System.out.print("Case #" + (i + 1) + ": ");
            for (int a = 0; a < size; a++) {
                int s = sc.nextInt();
                int f = sc.nextInt();
                lines[a] = new Line(s, f);
                inputs[a] = new Input(lines[a]);
            }
            Arrays.sort(lines);

            Stack<Line> c = new Stack<>();
            Stack<Line> j = new Stack<>();
            boolean flag = false;
            for (int a = 0; a < size; a++) {
                if(c.isEmpty()){
                    c.push(lines[a]);
                    lines[a].who = 'C';
                    continue;
                }else if(lines[a].start >= c.peek().finish){
                    c.push(lines[a]);
                    lines[a].who = 'C';
                    continue;
                }
                if(j.isEmpty()){
                    j.push(lines[a]);
                    lines[a].who = 'J';
                    continue;
                }else if(lines[a].start >= j.peek().finish){
                    j.push(lines[a]);
                    lines[a].who = 'J';
                    continue;
                }
                flag = true;
            }
            if(flag){
                System.out.print("IMPOSSIBLE");
                System.out.println();
                continue;
            }
            for(int a = 0; a < size; a ++){
                if(a == size-1){
                    System.out.println(inputs[a].line.who);
                    break;
                }
                System.out.print(inputs[a].line.who);
            }
        
        }
    }
}

class Line implements Comparable<Line> {
    int start;
    int finish;
    Character who;

    Line(int s, int f) {
        start = s;
        finish = f;
    }

    @Override
    public int compareTo(Line l) {
        return Integer.compare(finish, l.finish);
    }
}

class Input{
    Line line;
    Input(Line line){
        this.line = line;
    }
}