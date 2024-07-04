import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for(int i=1;i<=T;i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            printOutput(i,N,K);
        }

    }

    private static void printOutput(int T, int N, int K) {
        int sum=N*(N+1)/2;
        int mul=0;
        for(int i=1;i<=N;i++){
            if(K%(i*N)==0)
                mul=i;
        }
        if(K>N*N||K<N||(mul==0&&K!=sum)) {
            System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
            return;
        }

        boolean isPossible = printPossibleArray(T, K, N, mul);
        if(!isPossible){
            System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
        }
    }

    private static boolean printPossibleArray(int T,int K, int N, int mul){
        int[][] input=new int[N][N];
        input = fillTrace(K, N, mul);
        input=fillArray(K, N, input, mul);
        if(input==null) return false;
        System.out.println("Case #" + T + ": " + "POSSIBLE");
        printArray(N,input);
        return true;
    }

    private static int[][] fillTrace(int K, int N, int mul) {
        int[][] arr = new int[N][N];
        if(mul>0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i==j)
                        arr[i][j] = mul;
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i==j)
                        arr[i][j] = (i+1);
                }
            }
        }
//        isSafeTrace(K, N, arr);
        return arr;
    }

    private static int[][] fillArray(int K, int N, int[][] input, int mul) {
        int v=1,initV=1,max=N;
        boolean backTrack=false;
        for(int i=0; i<N; i++) {
            if(backTrack) v=initV;
            else v=1;
            for(int j=0; j<N; j++) {
                if(i!=j){
                    if(v>N) v=v%N;
                    if(v!=mul) {
                        input[i][j]=v;
                    } else {
                        v++;
                        input[i][j]=v;
                    }
                    v++;
                }
            }
            if(!isSafeNUnique(i, N, input)) {
                for(int j=0; j<N; j++) {
                    if(i!=j) {
                        input[i][j]=0;
                    }
                }
                i=i-1;
                initV++;
                backTrack=true;
                if(initV==max) return null;
            } else {
                initV = 1;
                backTrack = false;
            }
        }
        return input;
    }

    private static boolean isSafeNUnique(int row, int col, int inputs[][]) {
        boolean flag=true;
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            list.add(new HashSet<>());
        }
        for (int i = 0; i <= row; i++) {
            HashSet<Integer> mr = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if(list.get(j).contains(inputs[i][j])) return false;
                if(mr.contains(inputs[i][j])) return false;
                list.get(j).add(inputs[i][j]);
                mr.add(inputs[i][j]);
            }
        }
        return flag;
    }

    private static boolean isSafeTrace(int K, int N, int inputs[][]) {
        int x = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (i == j) x += inputs[i][j];
        }
        if(x==K) return true;
        return false;
    }

    private static void printArray(int N,int[][] input){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(input[i][j]+" ");
            System.out.println();
        }
    }
}
