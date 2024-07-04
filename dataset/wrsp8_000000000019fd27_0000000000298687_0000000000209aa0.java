import java.util.*;
public class Solution{
    static Scanner in;
    public static void main(String[] args){
        in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0; i<cases; i++){
            int N = in.nextInt();
            int K = in.nextInt();
            LinkedList<LinkedList<Integer>> diags = findDiags(N,K);
            System.out.print("Case #"+(i+1)+": ");
            solve(diags,N,K);
        }
    }
    
    public static LinkedList<LinkedList<Integer>> findDiags(int N, int K){
        if(N==1){
            LinkedList<LinkedList<Integer>> resp = new LinkedList<LinkedList<Integer>>();
            resp.add(new LinkedList());
            resp.get(0).add(K);
            return resp;
        } else {
            LinkedList<LinkedList<Integer>> resp = new LinkedList<LinkedList<Integer>>();
            for(int c =K-(N-1); c >=1 ; c--){
                LinkedList<LinkedList<Integer>> rec = findDiags(N-1,K-c);
                for (LinkedList<Integer> i: rec){
                    i.add(c);
                }
                resp.addAll(rec);
            }
            return resp;
        }
    }
    public static void solve(LinkedList<LinkedList<Integer>> diags, int N, int K){
        boolean flag = true;
        loop:
        for(LinkedList<Integer> list : diags){
            int[][] m = new int[N][N];
            int d = 0;
            for(int i: list){
                m[d][d]= i;
                d++;
            }
            if(recursive(m)){
                flag = false;
                System.out.println("POSSIBLE");
                for(int[] line: m){
                    for(int val: line){
                        System.out.print(val+" ");
                    }
                    System.out.println();
                }
                break loop;
            }
            
        }
        if(flag){
            System.out.println("IMPOSSIBLE");
        }
    }
    
    public static boolean recursive(int[][] m){
        solution:
        for(int row = 0; row < m.length; row++){
            for(int col = 0; col < m[row].length; col++){
                if(m[row][col]==0){
                    guesses:
                    for(int guess = 1; guess <= m.length; guess++){
                        //check column dist
                        for(int i = 0; i < m.length;i++){
                            if(m[row][i]==guess){
                                continue guesses;
                            }
                        }
                        //check row dist
                        for(int i = 0; i < m.length;i++){
                            if(m[i][col]==guess){
                                continue guesses;
                            }
                        }
                        m[row][col] = guess;
                        if(row==m.length-1&& col==m.length-2){

                            return true;
                        }
                        if(recursive(m)){
                            return true;   
                        }
                        m[row][col] = 0;
                    }
                    return false;
                }
            }
        }
        return false;  
    }
}