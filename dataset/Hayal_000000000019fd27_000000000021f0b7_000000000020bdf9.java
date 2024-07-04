
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static class Pair implements Comparable<Pair> {
        public final int index;
        public final int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            //multiplied to -1 as the author need descending sort order
            return Integer.compare(this.value, other.value);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tt = scan.nextInt();
        for (int t = 0; t < tt; t++) {
            int size = scan.nextInt();
            scan.nextLine();
            Point[] act = new Point[size];
            Pair[] sort = new Pair[size];
            boolean flag = false;
            char[] ans = new char[size];
            for (int i = 0; i < size; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                act[i] = new Point(x, y);
                sort[i] = new Pair(i, x);
            }
            Arrays.sort(sort);
            int c = act[sort[0].index].y;
            int j = -1;
            ans[sort[0].index]='C';
            for (int i = 1; i < act.length ; i++) {
                if(act[sort[i].index].getX()>=c){
                    c = act[sort[i].index].y;
                    ans[sort[i].index]='C';
                }
                else if(act[sort[i].index].getX()>=j)
                {
                    j = act[sort[i].index].y;
                    ans[sort[i].index]='J';
                }
                else{
                    flag = true;
                    System.out.println("Case #"+(t+1)+": " + "IMPOSSIBLE");
                    break;
                }
            }
            if(!flag) {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i <size ; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
            }
        }

        }
    }

