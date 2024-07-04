import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static ArrayList<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int test = 1; test <=t; test++){
            int[][] visited = new int[1000][1000];
            int s = scan.nextInt();
            recurs(1,1,s,visited);
            System.out.printf("Case #%d:%n",test);
            for(Pair p : list){
                System.out.printf("%d %d%n",p.r,p.k);
            }
            list.clear();
        }
        //System.out.println(get(334,1)+" "+get(335,2));
    }
    public static boolean recurs(int r, int k, int s,int[][] c){
        if(c[r][k] == 1) return false;
        int v = get(r,k);
        Pair p = new Pair(r,k);
        if(v>s) return false;
        else if(v==s){
            list.add(p);
            return true;
        }
        else{
            s = s-v;
            list.add(p);
            c[r][k] = 1;
            boolean flag = false;

            if(!flag && valid(r,k+1)){
                flag = recurs(r,k+1,s,c);
            }
            if(!flag && valid(r,k-1)){
                flag = recurs(r,k-1,s,c);
            }
            if(!flag && valid(r+1,k)){
                flag = recurs(r+1,k,s,c);
            }
            if(!flag && valid(r-1,k)){
                flag = recurs(r-1,k,s,c);
            }
            if(!flag && valid(r-1,k-1)){
                flag = recurs(r-1,k-1,s,c);
            }
            if(!flag && valid(r+1,k+1)){
                flag = recurs(r+1,k+1,s,c);
            }
            
            if(flag) return true;
            else{
                list.remove(p);
                c[r][k] = 0;
                return false;
            }
        }
    }

    public static boolean valid(int r, int k){
        if(k==0|| r==0 || r<k || r>500 || k>500) return false;
        else return true;
    }

    public static int get(int n,int k){
        n--;
        k--;
        int res = 1;
        if(k>n-k) k = n-k;
        for(int l=0;l<k;++l){
            res *= (n - l);
            res /= (l + 1);
        }
        return res;
    }
    static class Pair{
        int r, k;
        Pair(int i, int j){
            r = i;
            k = j;
        }
    }
}
