import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T;
            T = in.nextInt();
            for (int t = 1; t <= T; ++t) {
                System.out.print("Case #" + t + ": ");
                int N = in.nextInt();
                boolean[] C = new boolean[1440], J = new boolean[1440];
                boolean impossible = false;
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    int start = in.nextInt(), end = in.nextInt();
                    if (impossible){
                        continue;
                    }
                    boolean validC = true, validJ = true;
                    for (int j = start; j < end; j++) {
                        if (C[j]) {
                            validC = false;
                            break;
                        }
                    }
                    if (!validC){
                        for (int j = start; j < end; j++) {
                            if (J[j]) {
                                validJ = false;
                                break;
                            }
                        }
                    }
                    if(validC){
                        for (int j = start; j < end; j++) {
                            C[j] = true;
                        }
                        str.append("C");
                    }else if(validJ){
                        for (int j = start; j < end; j++) {
                            J[j] = true;
                        }
                        str.append("J");
                    }else{
                        impossible = true;
                    }
                }
                if (impossible){
                    System.out.println("IMPOSSIBLE");
                }else{
                    System.out.println(str);
                }
            }
        }
    }
}