import java.util.*;

public class Solution {
    
    public static int left(int a[][],int i,int j) {
        
        for(int k=i-1;k>=0;k--)
            if(a[k][j] > 0) return a[k][j];
        return 0;
    }
    public static int right(int a[][],int i,int j) {
        for(int k=i+1;k<a.length;k++)
            if(a[k][j] > 0) return a[k][j];
        return 0;
    }
    public static int top(int a[][],int i,int j) {
        for(int k=j-1;k>=0;k--)
            if(a[i][k] > 0) return a[i][k];
        return 0;
    }
    public static int bot(int a[][],int i,int j) {
        for(int k=j+1;k<a[0].length;k++)
            if(a[i][k] > 0) return a[i][k];
        return 0;
    }
    public static void main(String[] args ){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int q=1;q<=t;q++) {
            int r = scn.nextInt();
            int c = scn.nextInt();
            int a[][] = new int[r][c];
            
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    a[i][j] = scn.nextInt();
            
            
            long ans = 0;
            int elim = 0;
            do {
                for(int i=0;i<r;i++)
                {
                    for(int j=0;j<c;j++)
                    {
                        ans += a[i][j];
                        int avg = 0;
                        int count = 0;
                        int rg = right(a,i,j);
                        int top = top(a,i,j);
                        int bot = bot(a,i,j);
                        int left = left(a,i,j);
                        if(rg > 0) {
                            count++;
                            avg += rg;
                        }
                        if(left > 0) {
                            count++;
                            avg += left;
                        }
                        if(top > 0) {
                            count++;
                            avg += top;
                        }
                        if(bot > 0) {
                            count++;
                            avg += bot;
                        }
                        if(count > 0) avg/=count;
                        if(avg > a[i][j]) {
                            elim++;
                            a[i][j] = 0;
                        }
                    }
                }
            }while(elim > 0);
        }
        System.out.println("Case #" + q + ": " + ans);
    }
}