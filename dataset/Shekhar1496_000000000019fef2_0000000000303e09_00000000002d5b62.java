import java.util.*;
import java.io.*;
public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static Map<Coordinate,String> map =new HashMap<>();
    static Set<Coordinate> set = new HashSet<>();
    static boolean isReachable(int x, int y, int a, int b, int moveCount, String directions, int c) {
        if(!set.add(new Coordinate(x,y, moveCount)))
            return false;

        int d;
        if(moveCount == 0)
            d =1;
        else
            d = moveCount * 2;

        if (Math.abs(x)>Math.abs(a)||Math.abs(y)>Math.abs(b))
            return false;

        if (x == a && y == b) {
            System.out.println("Case #"+c+": "+directions);
            return true;
        }

        // check for other 2 possibilities
       // Coordinates coordinates = new Coordinates(x,y);
        //if(map.get(coordinates)!=null)


        return (isReachable(x, y+d, a, b,d, directions + "N",c)
                || isReachable(x+d, y, a, b,d, directions + "E",c)
                || isReachable(x, y-d, a, b,d, directions+"S",c)
                || isReachable(x-d, y, a, b,d, directions+"W",c));
    }

    public static void main(String[] args) {
        FastReader fastReader =new FastReader();
        int t = fastReader.nextInt();
        for (int i = 1; i <=t ; i++) {
            set=new HashSet<>();
            int x= fastReader.nextInt();
            int y = fastReader.nextInt();
            boolean isReachable= isReachable(0,0,x,y,0,"", i);
            if(!isReachable)
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
        }

    }
}
class Coordinate{
    int x;
    int y;
    int moveCount;

    public Coordinate(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y &&
                moveCount == that.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, moveCount);
    }
}