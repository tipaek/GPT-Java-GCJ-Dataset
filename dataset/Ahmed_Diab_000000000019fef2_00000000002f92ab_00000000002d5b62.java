import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc  =new Scanner();
        PrintWriter out = new PrintWriter(System.out) ;
        int t = sc.nextInt() ;
        for(int i = 1 ; i <= t ; i++)
        {
            out.printf("Case #%d: " , i);
            int X = sc.nextInt() , Y = sc.nextInt() ;
            TreeSet<Node> set = new TreeSet<>() ;
            Queue<Node> queue = new LinkedList<>() ;
            queue.add(new Node(0 , 0 , 0 , null , "")) ;
            StringBuilder ans = new StringBuilder();
            ans.append("IMPOSSIBLE") ;
            outer :
            while (!queue.isEmpty())
            {
                Node node = queue.poll() ;
                if(node.level > 8) continue; ;
                int [] dx = {-(1 << node.level) , (1 << node.level) , 0 , 0} ;
                int [] dy = {0 , 0 , -(1 << node.level) , (1 << node.level)} ;
                String [] type = {"W" , "E" , "S" , "N"} ;
                int x = node.x , y = node.y ;
                for(int j = 0 ; j < 4 ; j++)
                {
                    Node next = new Node(node.level + 1 , x + dx[j] , y + dy[j] , node , type[j]) ;
                    if(next.x == X && next.y == Y)
                    {
                        Node curr = next ;
                        ans = new StringBuilder() ;
                        while(curr != null)
                        {
                            ans.append(curr.s) ;
                            curr = curr.parent ;
                        }
                        ans = ans.reverse();
                        break outer;
                    }
                    if(!set.contains(next))
                    {
                        queue.add(next) ;
                        set.add(next) ;
                    }
                }
            }
            out.println(ans);
        }
        out.flush();
        out.close();
    }
    static class Node implements Comparable<Node>
    {
        int level ;
        int x  ,y ;
        String s ;
        Node parent ;
        Node(int l , int a , int b , Node p , String k)
        {
            level = l ;
            x = a ; y = b ;
            parent = p ;
            s = k ;
        }

        @Override
        public int compareTo(Node o)
        {
            if(x != o.x)return x - o.x ;
            if(y != o.y)return y - o.y ;
            if(level != o.level)return level - o.level ;

            return 0;
        }
    }
    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st ;

        String next() throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }
        int nextInt() throws Exception { return Integer.parseInt(next()) ; }

        long nextLong() throws Exception { return Long.parseLong(next()) ; }

        double nextDouble() throws Exception { return Double.parseDouble(next()) ; }
    }
}