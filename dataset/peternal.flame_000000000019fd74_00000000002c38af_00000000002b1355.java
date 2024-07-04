import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static int[][] area;
    static int r, c;
    static int downN(int rr, int cc){
        for(int i = rr+1; i<r; i++){
            if(area[i][cc]!=0){
                return area[i][cc];
            }
        }
        return 0;
    }
    static int upN(int rr, int cc){
        for(int i = rr-1; i>=0; i--){
            if(area[i][cc]!=0){
                return area[i][cc];
            }
        }
        return 0;
    }
    static int leftN(int rr, int cc){
        for(int i = cc-1; i>=0; i--){
            if(area[rr][i]!=0){
                return area[rr][i];
            }
        }
        return 0;
    }

    static int rightN(int rr, int cc){
        for(int i = cc+1; i<c; i++){
            if(area[rr][i]!=0){
                return area[rr][i];
            }
        }
        return 0;
    }

    static int sum(){
        int s = 0;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                s+=area[i][j];
            }
        }
        return s;
    }

    static void ones(int[][] ar){
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                ar[i][j] = 1;
            }
        }
    }

    static void multiply(int[][] ar){
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                area[i][j] = ar[i][j] * area[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i<= t; i++){
            r = in.nextInt();
            c = in.nextInt();
            area = new int[r][c];
            for(int rr = 0; rr<r; rr++){
                for(int cc = 0; cc<c; cc++){
                    area[rr][cc] = in.nextInt();
                }
            }
            int changed = 1;
            int result = 0;
            while(changed!=0){
                changed = 0;
                result+=sum();
                int[][] newArea= new int[r][c];
                ones(newArea);
                for(int rr = 0; rr<r; rr++){
                    for(int cc = 0; cc<c; cc++){
                        int u = upN(rr, cc);
                        int d = downN(rr, cc);
                        int l = leftN(rr, cc);
                        int ri = rightN(rr, cc);
                        int toM = 0;
                        toM+=((u!=0)?1:0);
                        toM+=((d!=0)?1:0);
                        toM+=((l!=0)?1:0);
                        toM+=((ri!=0)?1:0);
                        toM = Integer.max(1, toM);
                        if(toM * area[rr][cc] < u + d + l + ri){
                            newArea[rr][cc] = 0;
                            changed++;
                        }
                    }
                }
                multiply(newArea);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}
