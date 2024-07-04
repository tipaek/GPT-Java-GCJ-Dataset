import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int [][] mat = new int[N][N];
            int dig = 0;
            int row = 0;
            int col = 0;
            
            HashMap<Integer,HashSet<Integer>> mapr = new HashMap<>();
            HashMap<Integer,HashSet<Integer>> mapc = new HashMap<>();
            for(int i=0;i<N;i++)
            {
                mapr.put(i,new HashSet<Integer>());
                mapc.put(i,new HashSet<Integer>());
            }
            
            boolean ans = solve(mat,0,0,N,D,D,mapr,mapc);
            
            if(ans)
            {
                System.out.println("Case #"+t+": "+"POSSIBLE");
                for(int i=0;i<N;i++)
                {
                for(int j=0;j<N;j++)
                {
                 System.out.printf("%d ",mat[i][j]);   
                }
                System.out.println();
                }
            }else{
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }
        }
    }
    
    public static boolean solve(int [][] mat, int r, int c, int N, int D, int OD,
    HashMap<Integer,HashSet<Integer>> mapr, HashMap<Integer,HashSet<Integer>> mapc)
    {
         if(r==mat.length)
         {
            if(D==0)return true;
            return false;
            //return check(mat, OD);
         }
         if(D<0)return false;
                 
                 for(int num=1;num<=N;num++)
                 {
                    if(mapr.get(r).contains(num))continue;
                    if(mapc.get(c).contains(num))continue;
                    mat[r][c]=num;
                    HashSet<Integer> rs = mapr.get(r);
                    rs.add(num);
                    mapr.put(r,rs);
                    HashSet<Integer> cs = mapc.get(c);
                    cs.add(num);
                    mapc.put(c,cs);
                    boolean correct = true;
                    {
                        int nr = (c==N-1)?r+1:r;
                        int nc = (c==N-1)?0:c+1;
                        correct = solve(mat,nr,nc,N,(r==c)?D-mat[r][c]:D,OD,mapr,mapc);
                    }
                    if(correct)return true;
                    rs.remove(num);
                    cs.remove(num);
                    mapr.put(r,rs);
                    mapc.put(c,cs);
                 }  

        return false;
    }
    
    public static boolean check(int [][] mat, int D)
    {
        for(int r=0;r<mat.length;r++)
        {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for(int c=0;c<mat[0].length;c++)
            {
                if(row.contains(mat[r][c]))return false;
                if(col.contains(mat[c][r]))return false;
                row.add(mat[r][c]);
                col.add(mat[c][r]);
                if(r==c)D=D-mat[r][c];
                if(D<0)return false;
            }
        }
        if(D!=0)return false;
        return true;
    }
}