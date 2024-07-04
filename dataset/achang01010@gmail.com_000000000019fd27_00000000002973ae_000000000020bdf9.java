import java.util.Scanner;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); 
        for (int c = 0; c<num; c++) {
            String ret = "";
            boolean impos = false;
            int[] schedule = new int[1440];
            boolean[] schedule1 = new boolean[1440];
            boolean[] schedule2 = new boolean[1440];
            for (int i = 0; i<1440; i++) {
                schedule[i]=0;
                schedule1[i]=false;
                schedule2[i]=false;
            }
            int shifts = sc.nextInt();
            for (int i = 0; i<shifts; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                for (int time = start; time<end; time++) {
                    if (schedule[time]==2) {
                        impos=true;
                        System.out.println("BREAK");
                    }
                    else {
                        schedule[time]++;
                    }
                }
                boolean pos = true;
                for (int time = start; time<end; time++) {
                    if (schedule1[time]) {
                        pos = false;
                    }
                }
                if (pos) {
                    for (int time = start; time<end; time++) {
                        schedule1[time]=true;
                    }
                    ret+="C";
                }
                else {
                    for (int time = start; time<end; time++) {
                        schedule2[time]=true;
                    }
                    ret+="J";
                }
            }
            if (impos) {
                System.out.println("Case #"+(c+1)+": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #"+(c+1)+": "+ret);
            }
        }
    }
}