import java.util.*;
class Solution {
    static int X=-1,Y=-1;
    static int p_2[];
    static Map<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt(),t1=1;
        while(t-->0)
        {
            int x=sc.nextInt(),y = sc.nextInt(),i;
            int n = Math.max(Math.abs(x),Math.abs(y));
            p_2 = new int[n];
            for(i=0;i<n;i++)
                p_2[i] = 1<<i;
            X = x;
            Y = y;
            if(Math.abs(x)==Math.abs(y))
            {
                System.out.println("Case #"+t1+": IMPOSSIBLE");
            }
            else {
                int min = minMoves(0,0,"",0,n);
                if(map.get(min)!=null)
                    System.out.println("Case #"+t1+": "+map.get(min));
                else System.out.println("Case #"+t1+": IMPOSSIBLE");
            }
            t1++;
        }
    }
    static int minMoves(int x,int y,String dir,int i,int n)
    {
        if(x == X && y == Y)
        {
            map.put(i,dir);
            return i;
        }
        if(i>=n)
            return i;
        return Math.min(minMoves(x+p_2[i],y,dir+"E",i+1,n),Math.min(minMoves(x-p_2[i],y,dir+"W",i+1,n),
                Math.min(minMoves(x,y+p_2[i],dir+"N",i+1,n),minMoves(x,y-p_2[i],dir+"S",i+1,n))));
    }
}
