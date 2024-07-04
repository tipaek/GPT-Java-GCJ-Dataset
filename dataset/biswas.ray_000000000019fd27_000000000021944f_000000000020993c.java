import java.util.*;
public class Solution {
    public static void main(String rpn[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++) {
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int x=0;x<n;x++)
                for(int y=0;y<n;y++)
                    m[x][y]=sc.nextInt();
            int k=0;
            for(int x=0,y=0;x<n&&y<n;x++,y++)
                k+=m[x][y];
            int r,c;
            r=c=0;
            A:for(int x=0;x<n;x++) {
                B:for(int y=0;y<n;y++) {
                    C:for(int z=y+1;z<n;z++) {
                        if(m[x][y]==m[x][z]) {
                            r++;
                            break B;
                        }
                    }
                }
            }
            A:for(int y=0;y<n;y++) {
                B:for(int x=0;x<n;x++) {
                    C:for(int z=x+1;z<n;z++) {
                        if(m[x][y]==m[z][y]) {
                            c++;
                            break B;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i)+": "+k+" "+r+" "+c);
        }
    }
}