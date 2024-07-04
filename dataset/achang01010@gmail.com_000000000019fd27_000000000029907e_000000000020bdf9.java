import java.util.Scanner;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); 
        for (int c = 0; c<num; c++) {
            boolean pos = true;
            String ret = "";
            boolean[] sche1 = new boolean[1440];
            boolean[] sche2 = new boolean[1440];
            for (int i = 0; i<1440; i++) {
                sche1[i]=false;
                sche2[i]=false;
            }
            int events = sc.nextInt();
            for (int i = 0; i<events; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean pos1=true;
                boolean pos2=true;
                for (int time = start; time<end; time++) {
                    if (sche1[time]=true) {
                        pos1=false;
                    }
                }
                if (pos1) {
                    ret+="C";
                    for (int time = start; time<end; time++) {
                        sche1[time]=true;
                    }
                }
                else {
                    for (int time = start; time<end; time++) {
                        if (sche2[time]=true) {
                            pos2=false;
                        }
                    }
                    if (pos2) {
                        ret+="J";
                        for (int time = start; time<end; time++) {
                            sche2[time]=true;
                        }
                    }
                    else {
                        pos=false;
                    }
                }
            }
            if (!pos) {
                System.out.println("Case #"+(c+1)+": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #"+(c+1)+": "+ret);
            }
        }
    }
}