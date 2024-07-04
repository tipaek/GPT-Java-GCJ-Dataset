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
                boolean pos1 = true;
                for (int time = start; time<end; time++) {
                    if (schedule1[time]) {
                        pos1 = false;
                    }
                }
                if (pos1) {
                    for (int time = start; time<end; time++) {
                        schedule1[time]=true;
                    }
                    ret+="C";
                }
                if (!pos1) {
                    boolean pos2 = true;
                    for (int time = start; time<end; time++) {
                        if (schedule2[time]) {
                            pos2 = false;
                        }
                    }
                    if (pos2) {
                        for (int time = start; time<end; time++) {
                            schedule2[time]=true;
                        }
                        ret+="J";
                    }
                    if (!pos2) {
                        impos=true;
                    }
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