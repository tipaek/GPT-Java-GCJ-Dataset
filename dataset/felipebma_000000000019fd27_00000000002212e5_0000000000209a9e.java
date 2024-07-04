import java.util.*;

class Solution{


    static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int nCases = in.nextInt(), b = in.nextInt();
        for(int i=0;i<nCases;i++){
            solve(i, b);
            String str = in.next();
        } 
    }

    static void solve(int nCase, int size){
        int[] ans = new int[size];
        for(int i=0;i<10;i++){
            ans[i] = ask(i);
        }
        StringBuilder aux = new StringBuilder();
        for(int i:ans) aux.append(i);
        System.out.println(aux.toString());
    }

    static int ask(int pos){
        System.out.println(pos+1);
        return in.nextInt();
    }
}