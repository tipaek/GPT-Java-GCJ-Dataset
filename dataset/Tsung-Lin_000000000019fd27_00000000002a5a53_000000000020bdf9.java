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
            ans(cs, events);
        }
    }
    private static void ans(int cs, int[][] events){
        boolean impossible = false;
        char[] task = new char[events.length];
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < events.length; i++) {
            int[] event = events[i];
            list.add(new int[] { event[0], 1, i });
            list.add(new int[] { event[1], -1, i });
        }
        Collections.sort(list, (a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int cam = -1, jam = -1;
        for(int[] e : list) {
            if(e[1] == 1) {
                if(cam != -1 && jam != -1) {
                    impossible = true;
                    break;
                }
                else if(jam == -1) { 
                    jam = e[2]; 
                    task[e[2]] = 'J';
                }
                else if(cam == -1) { 
                    cam = e[2]; 
                    task[e[2]] = 'C';
                }
            }
            else if(e[1] == -1){
                if(cam == -1 && jam == -1) {
                    impossible = true;
                    break;
                }
                else if(jam == e[2]) {
                    jam = -1;
                }
                else if(cam == e[2]) {
                    cam = -1;
                }
            }
        }
        if(impossible){
            System.out.println("Case #" + cs + ": IMPOSSIBLE");   
        }
        else{
            System.out.println("Case #" + cs + ": " + new String(task));
        }
    }
}