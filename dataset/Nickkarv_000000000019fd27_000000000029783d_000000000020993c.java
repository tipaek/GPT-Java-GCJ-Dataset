import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        int sum = 0;

        for (int caso = 0; caso < T; caso++) {
            int N = Integer.parseInt(in.nextLine());
            int M[][] = new int[N][N];
            int countc = 0;
            int countf = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int f = 0; f < N; f++) {
                String s[] = in.nextLine().split(" ");
                for (int c = 0; c < N; c++) {
                    M[f][c] = Integer.parseInt(s[c]);
                }
            }
            for (int i = 0; i < N; i++) {
                sum = sum + M[i][i];
            }
            for(int f=0; f<N; f++){
                map.clear();
                for(int c=0;c<N;c++){
                    if(map.get(M[f][c])!= null) {
                        countc++;
                        break;
                    }
                    map.put(M[f][c], c);
                }
            }
            map.clear();
            for(int c=0; c<N; c++){
                map.clear();
                for(int f=0;f<N;f++){
                    if(map.get(M[f][c])!= null) {
                        countf++;
                        break;
                    }
                    map.put(M[f][c], c);
                }
            }
            map.clear();
            int t=caso+1;
            System.out.println("Case #"+t+": "+sum+" "+countc+" "+countf);
            map.clear();
            sum=0;
        }

    }
}