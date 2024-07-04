package CodeJam;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cases = 1;

        while(cases<=T){
            Integer N = scanner.nextInt();
            Integer[][] arr = new Integer[N][N];
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++)
                    arr[i][j] = scanner.nextInt();
            }
            Pair<Integer,Integer> pair = checkLatinSquare(N,arr);
            System.out.println("Case #"+cases+" "+calculateTrace(N,arr)+" "+pair.getKey()+" "+pair.getValue());
            cases++;
        }
    }

    public static Integer calculateTrace(Integer N, Integer[][] arr){
        int sum = 0;
        for(int i=0;i<N;i++)
            sum+=arr[i][i];
        return sum;
    }

    public static Pair<Integer,Integer> checkLatinSquare(Integer N, Integer[][] arr){
        int rows = 0;
        int cols = 0;
        for(int i=0;i<N;i++){
            HashSet<Integer> rowHashSet = new HashSet<>();
            HashSet<Integer> colHashSet = new HashSet<>();
            for (int j=0;j<N;j++) {
                rowHashSet.add(arr[i][j]);
                colHashSet.add(arr[j][i]);
            }
            if(rowHashSet.size() != N)
                rows++;
            if(colHashSet.size() != N)
                cols++;
        }

        return new Pair<>(rows,cols);
    }
}
