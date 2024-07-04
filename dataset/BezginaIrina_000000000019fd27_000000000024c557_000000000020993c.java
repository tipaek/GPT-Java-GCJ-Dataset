import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());
        int N;
        String[][] M;
        int k = 0;
        int r = 0;
        int c = 0;

        for(int a=0; a < T; a++) {
            N = Integer.parseInt(scanner.nextLine());
            M = new String[N][N];

            for(int b=0; b < N; b++) {
                M[b] = scanner.nextLine().split(" ");
                k +=Integer.parseInt(M[b][b]);
                HashSet<String> Mhsc = new HashSet<>(Arrays.asList(M[b]));
                if(Mhsc.size() != M[b].length) {
                    r += 1;
                }
            }

            for(int i=0; i < N; i++) {
                HashSet<String> Mhsr = new HashSet<String>();
                for(int j=0; j < N; j++) {
                    if(Mhsr.add(M[j][i]) == false) {
                        c += 1;
                        break;
                    }
                }
            }

            System.out.println("Case #"+(a+1)+": "+k+" "+r+" "+c);
            k = 0;
            r = 0;
            c = 0;
        }
    }
}
