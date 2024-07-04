


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    public static long calc(int d[][],boolean pre[][],int r,int c){
        long ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!pre[i][j]){
                    ans+=d[i][j];
                }
            }
        }
        return ans;
    }
    public static int cr(int dd[][],boolean pre[][],int r ,int c,int x, int y){
        for(int i=y+1;i<c;i++){
            if(!pre[x][i]){
                return dd[x][i];
            }
        }

        return 0;
    }
    public static int cl(int dd[][],boolean pre[][],int r ,int c,int x ,int y){
        for(int i=y-1;i>=0;i--){
            if(!pre[x][i]){
                return dd[x][i];
            }
        }

        return 0;
    }
    public static int cu(int dd[][],boolean pre[][],int r ,int c,int x,int y){
        for(int i=x-1;i>=0;i--){
            if(!pre[i][y]){
                return dd[i][y];
            }
        }
        return 0;
    }
    public static int cd(int dd[][],boolean pre[][],int r ,int c,int x, int y){
        for(int i=x+1;i<r;i++){
            if(!pre[i][y]){
                return dd[i][y];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            int r = in.nextInt();
            int c = in.nextInt();
            boolean pre[][] = new boolean[r][c];
            int d[][] = new int[r][c];
            long sum =0;
            for(int i=0;i<r;i++)for(int j=0;j<c;j++)d[i][j] = in.nextInt();
            for(int q=0;q<=15;q++){
                sum+=calc(d,pre,r,c);
//                System.out.println(sum);
                ArrayList<int[]> res = new ArrayList<>();
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        if(pre[i][j])continue;
                        double up =0;
                        long cou = 0;
                        long x =cr(d,pre,r,c,i,j);
                        if(x>0){
                            up +=x;
                            cou++;
                        }
                        x =cu(d,pre,r,c,i,j);
                        if(x>0){
                            up +=x;
                            cou++;
                        }
                        x =cd(d,pre,r,c,i,j);
                        if(x>0){
                            up +=x;
                            cou++;
                        }
                        x =cl(d,pre,r,c,i,j);
                        if(x>0){
                            up +=x;
                            cou++;
                        }
                        if(cou>0){
                            double avg = ((double)up)/cou;
                            if(d[i][j]<avg){
                                res.add(new int[]{i,j});
                            }
                        }
                    }
                }
                if(res.size()==0){
                    break;
                }
                for(int[] x:res){
                    pre[x[0]][x[1]]=true;
//                    System.out.println(x[0] + " " + x[1]);
                }
//                System.out.println("done");
            }
//            System.out.println(sum);

            System.out.println("Case #" + tt + ": " + sum);
        }
    }
}

