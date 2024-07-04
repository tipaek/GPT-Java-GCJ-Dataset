import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #" + t + ": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] now = new int[R][C];
        int[][] bef = new int[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                bef[r][c] = sc.nextInt();
            }
        }
        boolean isChanged = true;
        int sum = 0;
        while(isChanged){
            isChanged = false;
            int nowRnd=0;
            for(int r=0;r<R;r++){
                for(int c=0;c<C;c++){
                    nowRnd += bef[r][c];
                    if(bef[r][c]==0){continue;}
                    if(iseliminate(bef, r, c)){
                        isChanged = true;
                        now[r][c]= 0;
                    }else{
                        now[r][c]=bef[r][c];
                    }
                }
            }
            sum += nowRnd;
            copy(bef, now);
        }
        System.out.println(sum);
    }
    private static void printMat(int[][] cl){
        for(int i=0;i<cl.length;i++){
            for(int j=0;j<cl[0].length;j++){
                System.out.print(cl[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean iseliminate(int[][] cl, int r, int c){
        int ri;
        int ci;
        int sum=0;
        int mysum = 0;
        ri = r-1;
        while(ri>=0 && cl[ri][c] == 0){ri--;}
        if(ri >= 0) {
            sum += cl[ri][c];
            mysum += cl[r][c];
        }
        ri=r+1;
        while(ri<cl.length && cl[ri][c] == 0){ri++;}
        if(ri < cl.length){
            sum += cl[ri][c];
            mysum+= cl[r][c];
        }
        ci=c-1;
        while(ci>=0&& cl[r][ci] == 0){ci--;}
        if(ci >= 0){
            sum += cl[r][ci];
            mysum += cl[r][c];
        }
        ci = c+1;
        while(ci < cl[0].length && cl[r][ci] == 0){ci++;}
        if(ci < cl[0].length){
            sum += cl[r][ci];
            mysum += cl[r][c];
        }
        return sum > mysum;
    }

    private static void copy(int[][] target, int[][] src){
        for(int i=0;i<src.length;i++){
            for(int j=0;j<src[0].length;j++){
                target[i][j]=src[i][j];
            }
        }
    }
}
