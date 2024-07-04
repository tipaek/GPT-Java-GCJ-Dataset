import java.util.*;
import java.io.*;

class Solution{

    public static int pascal[][];
    public static int k,n;
    public static int deps=0;
    public static Cor cor=new Cor();
    public static boolean flag = false;
    public static boolean used[][];
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner((System.in));
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            toDefault();
            k = in.nextInt();
            n = 0;
            for(int i=0;i<32;i++){
                int pow = (int)Math.pow(2,i);
                if(pow>k){
                    n = i+1;
                    break;
                }
            }
            pascal = getPascal(n);
            rec(new Cor(0,0)); 
        }
        
    //    print(pascal);
    }

    public static void toDefault(){
        used = new boolean[n][n];
        deps = 0;
        cor = new Cor();
        flag = false;                    
    }

    public static void rec(Cor corr){
        int x = corr.x;
        int y = corr.y;
        //System.out.println(x+" "+y);
        deps++;
        cor.depSum = cor.depSum + pascal[x][y];
        cor.parent = corr;
        if(cor.depSum == k){
            printPath(cor);
            System.out.println();
            flag = true;
            return;
        }
        if(deps==500){
            System.out.println("fuck");
            toDefault();
            return;
        }
        if(x-1>=0 && pascal[x-1][y]!=0 && !used[x-1][y]){
            used[x-1][y] = true;
            rec(new Cor(x-1,y,corr));
            used[x-1][y] = false;
        }
        if(y+1<n && pascal[x][y+1]!=0 && !used[x][y+1]){
            used[x][y+1] = true;
            rec(new Cor(x,y+1, corr));
            used[x][y+1] = false;
        }
        if(x+1<n && pascal[x+1][y]!=0 && !used[x+1][y]){
            used[x+1][y] = true;
            rec(new Cor(x+1,y,corr));
            used[x][y] = false;
        }
        if(y-1>=0 && pascal[x][y-1]!=0 && !used[x][y-1]){
            used[x][y-1] = true;
            rec(new Cor(x,y-1,corr));
            used[x][y-1] = false;
        }
        
        
    }

    public static void printPath(Cor cor){
        System.out.println(cor.x+" "+cor.y+"  "+pascal[cor.x][cor.y]);
        if(cor.parent!=null){
            printPath(cor.parent);
        }
    }

    public static void print(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] getPascal(int n){
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                if(j==0 || j==(i)){
                    a[i][j] = 1;
                }
                else{
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                }
            }
        }
        return a;
    }

    static class Cor{
        public Cor parent;
        public int depSum;
        public int x,y;
        public Cor(int x, int y, Cor parent){
            this.parent = parent;
            this.x = x;
            this.y = y;
            depSum = 0;
        }
        public Cor(int x, int y){
            this.x = x;
            this.y = y;
            depSum = 0;
        }
        public Cor(){
            depSum = 0;
        }
    }

}
