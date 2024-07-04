import java.util.*;
import java.io.*;

public class Solution{
    
    // public static final int DEF = Integer.MAX_VALUE;
    public static final int DEF = -1;
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            System.out.print("Case #" + (i + 1) + ": ");
            solve(in);
        }
        in.close();
    }
    
    public static void solve(Scanner in){
        
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] mat = new int[r][c];
        long sum = 0;
        //input mat
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                mat[i][j] = in.nextInt();
                sum += mat[i][j];
            }
        }
        
        //init row flag
        boolean[] rf = new boolean[r];
        for(int i=0;i<r;i++){
            rf[i]=true;
        }
        //column row flag
        boolean[] cf = new boolean[c];
        for(int i=0;i<c;i++){
            cf[i]=true;
        }
        
        //init dps
        int[][] left = new int[r][c];
        int[][] right = new int[r][c];
        int[][] top = new int[r][c];
        int[][] down = new int[r][c];
        
        long res = 0;
        boolean ur = true;
        // int temp = 5;
        // while(ur && temp>0){
        //     temp--;
        while(ur){
            ur =false;
            res += sum;
            //update row dps
            for(int i=0;i<r;i++){
                if(rf[i]){
                    left[i][0] = DEF;
                    for(int j=1;j<c;j++){
                        if(mat[i][j-1] != DEF){
                            left[i][j] = mat[i][j-1];    
                        }else{
                            left[i][j] = left[i][j-1];
                        }
                    }
                    right[i][c-1] = DEF;
                    for(int j=c-2; j>=0; j--){
                        if(mat[i][j+1] != DEF){
                            right[i][j] = mat[i][j+1];    
                        }else{
                            right[i][j] = right[i][j+1];
                        }
                    }
                }
            }
            //update column dps
            for(int j=0;j<c;j++){
                if(cf[j]){
                    top[0][j] = DEF;
                    for(int i=1;i<r;i++){
                        if(mat[i-1][j] != DEF){
                            top[i][j] = mat[i-1][j];    
                        }else{
                            top[i][j] = top[i-1][j];
                        }
                    }
                    down[r-1][j] = DEF;
                    for(int i=r-2; i>=0; i--){
                        if(mat[i+1][j] != DEF){
                            down[i][j] = mat[i+1][j];    
                        }else{
                            down[i][j] = down[i+1][j];
                        }
                    }
                }
            }
            //new row flag
            boolean[] rfn = new boolean[r];
            for(int i=0;i<r;i++){
                rfn[i]=false;
            }
            //column row flag
            boolean[] cfn = new boolean[c];
            for(int i=0;i<c;i++){
                cfn[i]=false;
            }
            //update rows
            for(int i=0;i<r;i++){
                if(rf[i]){
                    for(int j=0;j<c;j++){
                        if(mat[i][j]!=DEF){
                            double ave = average(left[i][j],right[i][j],top[i][j],down[i][j]);
                            if(mat[i][j]<ave){
                                rfn[i]=true;
                                cfn[j]=true;
                                sum -= mat[i][j];
                                mat[i][j] = DEF;
                                ur = true;
                            }
                        }
                    }
                }
            }
            //update columns
            for(int j=0;j<c;j++){
                if(cf[j]){
                    for(int i=0;i<r;i++){
                        if(!rf[i] && mat[i][j] != DEF){
                            double ave = average(left[i][j],right[i][j],top[i][j],down[i][j]);
                            if(mat[i][j]<ave){
                                rfn[i]=true;
                                cfn[j]=true;
                                sum -= mat[i][j];
                                mat[i][j] = DEF;
                                ur = true;
                            }
                        }
                    }
                }
            }
            
            //print
            // System.out.println("left :");
            // for(int i=0;i<r;i++){
            //     for(int j=0;j<c;j++){
            //         System.out.print(left[i][j] + " ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("right :");
            // for(int i=0;i<r;i++){
            //     for(int j=0;j<c;j++){
            //         System.out.print(right[i][j] + " ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("top :");
            // for(int i=0;i<r;i++){
            //     for(int j=0;j<c;j++){
            //         System.out.print(top[i][j] + " ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("down :");
            // for(int i=0;i<r;i++){
            //     for(int j=0;j<c;j++){
            //         System.out.print(down[i][j] + " ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("mat :");
            // for(int i=0;i<r;i++){
            //     for(int j=0;j<c;j++){
            //         System.out.print(mat[i][j] + " ");
            //     }
            //     System.out.println("");
            // }
            //reset row/coulmn flags
            rf = rfn;
            cf = cfn;
        }
        System.out.println(res);
    }
    
    public static double average(int a, int b, int c, int d){
        int count =0;
        double sum =0.0;
        if(a!= DEF){
            count++;
            sum+=a;
        }
        if(b!= DEF){
            count++;
            sum+=b;
        }
        if(c!= DEF){
            count++;
            sum+=c;
        }
        if(d!= DEF){
            count++;
            sum+=d;
        }
        return sum/count;
    }
    
}