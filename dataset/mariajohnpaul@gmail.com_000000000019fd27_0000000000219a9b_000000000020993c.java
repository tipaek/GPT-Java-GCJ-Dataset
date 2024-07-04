import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N = sc.nextInt();
            int [][] mat = new int[N][N];
            int dig = 0;
            int row = 0;
            int col = 0;
            
            
            for(int r=0;r<N;r++)
            {    
                for(int c=0;c<N;c++)
                {
                    int cur = sc.nextInt();
                    if(r==c)dig+=cur;
                    mat[r][c]=cur;
                }
            }
            
            for(int r=0;r<N;r++)
            {
                Set<Integer> rs = new HashSet<>();
                Set<Integer> cs = new HashSet<>();
                boolean rr = false;
                boolean cr = false;
                for(int c=0;c<N;c++)
                {
                    if(rs.contains(mat[r][c]))rr=true;
                    if(cs.contains(mat[c][r]))cr=true;
                    rs.add(mat[r][c]);
                    cs.add(mat[c][r]);
                }
                if(rr)row++;
                if(cr)col++;
            }
            
            System.out.println("Case #"+t+": "+dig+" "+row+" "+col);
        }
    }
}