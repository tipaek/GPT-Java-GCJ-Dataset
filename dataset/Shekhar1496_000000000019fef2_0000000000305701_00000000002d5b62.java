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
    static List<String> solutions;
    static Set<Coordinate> set = new HashSet<>();
    static boolean isReachable(long x, long y, long a, long b, long moveCount, String directions, int c) {
        if(!set.add(new Coordinate(x,y, moveCount)))
            return false;

        long d;
        if(moveCount == 0)
            d =1;
        else
            d = moveCount * 2;

        if (Math.abs(x)>Math.abs(a)||Math.abs(y)>Math.abs(b))
            return false;

        if (x == a && y == b) {
            solutions.add(directions);
            return true;
        }

        // check for other 2 possibilities
       // Coordinates coordinates = new Coordinates(x,y);
        //if(map.get(coordinates)!=null)

        boolean north = isReachable(x, y+d, a, b,d, directions + "N",c);
        boolean east = isReachable(x+d, y, a, b,d, directions + "E",c);
        boolean south = isReachable(x, y-d, a, b,d, directions+"S",c);
        boolean west = isReachable(x-d, y, a, b,d, directions+"W",c);


        return (north || east || south || east || west);
    }

    public static void main(String[] args) {
        FastReader fastReader =new FastReader();
        int t = fastReader.nextInt();
        for (int i = 1; i <=t ; i++) {
            set=new HashSet<>();
            solutions = new ArrayList<>();
            long x= fastReader.nextLong();
            long y = fastReader.nextLong();
            boolean isReachable= isReachable(0L,0L,x,y,0L,"", i);
            if(!isReachable)
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            else{
                String minString = solutions.get(0);
                int minL = minString.length();
                for(String sol : solutions){
                    if(sol.length() < minL){
                        minL = sol.length();
                        minString = sol;
                    }
                }
                System.out.println("Case #"+i+": "+minString);
            }
        }

    }
}
class Coordinate{
    long x;
    long y;
    long moveCount;

    public Coordinate(long x, long y, long moveCount) {
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