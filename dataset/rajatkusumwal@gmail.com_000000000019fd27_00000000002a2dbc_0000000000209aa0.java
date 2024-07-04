import java.util.*;
import java.io.*;


public class Solution {

    public static Boolean isTrace(ArrayList<ArrayList<Integer>> board,int k,int n){

        int sum=0;
        for(int x=0;x<n;x++){
            sum=sum+board.get(x).get(x);
        }
        if(sum==k)
                return true;
        else
                return false;
    }

    public static Boolean isValid(ArrayList<ArrayList<Integer>> board, int i,int n,int val){
        int r=i/n;
        int c=i%n;
        for(int x=0;x<n;x++){
            if(val==board.get(r).get(x)){
                return false;
            }
            if(val==board.get(x).get(c)){
                return false;
            }
        }
        return true;
    }

    public static Boolean solve(ArrayList<ArrayList<Integer>> board,int i,int k,int n){
        if(i==(n*n)){
                return true;
        }
        int r=i/n;
        int c=i%n;
        for(int x=1;x<=n;x++){
            if(!isValid(board,i,n,x))
                continue;
            board.get(r).set(c,x);
            if(solve(board,i+1,k,n) && isTrace(board, k, n)){
                return true;
            } else {
                board.get(r).set(c,-1);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n=in.nextInt();
            int k=in.nextInt();
            ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
            for(int x=0;x<n;x++){
                ArrayList<Integer> temp= new ArrayList<Integer>();
                for(int y=0;y<n;y++){
                    temp.add(-1);
                }
                board.add(temp);
            }
                if(solve(board,0,k,n)){
                    System.out.print("Case #" + i + ": POSSIBLE");
                    System.out.println("");
                    for(int r=0;r<n;r++){
                        for(int c=0;c<n;c++){
                            if(c!=n-1)
                                System.out.print(board.get(r).get(c)+" ");
                            else
                                System.out.print(board.get(r).get(c)+"");
                        }
                        System.out.println("");
                    }
                } else{
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }

        }
    }

}