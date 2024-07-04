import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for(int cs = 1; cs <= cases; cs++) {
            int length = Integer.parseInt(sc.nextLine());
            int[][] events = new int[length][2];
            for(int i = 0; i < length; i++) {
                String[] s = sc.nextLine().split(" ");
                int[] event = new int[] { 
                    Integer.parseInt(s[0]), 
                    Integer.parseInt(s[1]) 
                };
                events[i] = event;
            }
            for(int[] e : events) System.out.println(Arrays.toString(e));
            ans(cs, events);
        }
    }
    private static void ans(int cs, int[][] events){
        StringBuilder sb = new StringBuilder();
        List<int[]> list = new ArrayList<>();
        for(int[] e : events) {
            list.add(new int[] { e[0], 1 });
            list.add(new int[] { e[1], -1 });
        }
        Collections.sort(list, (a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        Queue<Character> busy = new LinkedList<>();
        Queue<Character> idle = new LinkedList<>();
        idle.add('J');
        idle.add('C');
        for(int[] e : list) {
            if(e[1] == 1) {
                if(idle.isEmpty()) {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                char c = idle.poll();
                busy.add(c);
                sb.append(c);
            }
            else {
                idle.add(busy.poll());
            }
        }
        System.out.println("Case #" + cs + ": " + sb.toString());
    }
}
