import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine();
            int[][] times = new int[n][4];
            for (int j = 0; j < n; j++) {
                times[j][0] = in.nextInt();
                times[j][1] = in.nextInt();
                times[j][2] = j;
                times[j][3] = 0;
                in.nextLine();
            }
            
            Arrays.sort(times, (o1, o2) -> {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            });
            
            times[0][3] = 1;
            int currentTime = times[0][1];
            
            for (int j = 1; j < n; j++) {
                if (times[j][0] >= currentTime) {
                    times[j][3] = 1;
                    currentTime = times[j][1];
                }
            }
            
            currentTime = -1;
            boolean possible = true;
            for (int j = 1; j < n; j++) {
                if (times[j][3] == 0) {
                    if (currentTime > times[j][0]) {
                        possible = false;
                        break;
                    }
                    currentTime = times[j][1];
                }
            }
            
            Arrays.sort(times, Comparator.comparingInt(o -> o[2]));
            
            System.out.print("Case #" + (i + 1) + ": ");
            if (possible) {
                for (int j = 0; j < n; j++) {
                    System.out.print(times[j][3] == 0 ? "J" : "C");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}