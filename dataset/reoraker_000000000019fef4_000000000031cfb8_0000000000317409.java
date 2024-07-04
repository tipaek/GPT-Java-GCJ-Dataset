import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    static class Pair<U, V>
    {
        public final U first;        // first field of a Pair
        public final V second;     // second field of a Pair

        // Constructs a new Pair with specified values
        private Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        // Checks specified object is "equal to" current object or not
        public boolean equals(Object o)
        {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            // call equals() method of the underlying objects
            if (!first.equals(pair.first))
                return false;
            return second.equals(pair.second);
        }

        @Override
        // Computes hash code for an object to support hash tables
        public int hashCode()
        {
            // use hash codes of the underlying objects
            return 31 * first.hashCode() + second.hashCode();
        }

        @Override
        public String toString()
        {
            return "(" + first + ", " + second + ")";
        }

        // Factory method for creating a Typed Pair instance
        public static <U, V> Pair <U, V> of(U a, V b)
        {
            // calls private constructor
            return new Pair<>(a, b);
        }
    }
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            int X=in.nextInt();
            int Y=in.nextInt();
            String m=in.next();
            HashMap<Pair<Integer,Integer>,TreeSet<Integer>> map=new HashMap<>();
            HashSet<Pair<Integer,Integer>> visited=new HashSet<>(); 
            int x=X;
            int y=Y;
            TreeSet<Integer> sett=new TreeSet<>();
            sett.add(0);
            map.put(Pair.of(x,y),sett);
            for(int i=0;i<m.length();i++)
            {
                char c=m.charAt(i);
                if(c=='N')
                {
                    visited.add(Pair.of(x,y+1));
                    if(!map.containsKey(Pair.of(x,y+1)))
                    {
                        TreeSet<Integer> set=new TreeSet<>();
                        set.add(i+1);
                        map.put(Pair.of(x,y+1),set);
                    }
                    else
                    {
                        TreeSet<Integer> set=map.get(Pair.of(x,y+1));
                        set.add(i+1);
                        map.put(Pair.of(x,y+1),set);
                    }
                    y++;
                }
                else if(c=='E')
                {
                    visited.add(Pair.of(x+1,y));
                    if(!map.containsKey(Pair.of(x+1,y)))
                    {
                        TreeSet<Integer> set=new TreeSet<>();
                        set.add(i+1);
                        map.put(Pair.of(x+1,y),set);
                    }
                    else
                    {
                        TreeSet<Integer> set=map.get(Pair.of(x+1,y));
                        set.add(i+1);
                        map.put(Pair.of(x+1,y),set);
                    }
                    x++;
                }
                else if(c=='W')
                {
                    visited.add(Pair.of(x-1,y));
                    if(!map.containsKey(Pair.of(x-1,y)))
                    {
                        TreeSet<Integer> set=new TreeSet<>();
                        set.add(i+1);
                        map.put(Pair.of(x-1,y),set);
                    }
                    else
                    {
                        TreeSet<Integer> set=map.get(Pair.of(x-1,y));
                        set.add(i+1);
                        map.put(Pair.of(x-1,y),set);
                    }
                    x--;
                }
                else if(c=='S')
                {
                    visited.add(Pair.of(x,y-1));
                    if(!map.containsKey(Pair.of(x,y-1)))
                    {
                        TreeSet<Integer> set=new TreeSet<>();
                        set.add(i+1);
                        map.put(Pair.of(x,y-1),set);
                    }
                    else
                    {
                        TreeSet<Integer> set=map.get(Pair.of(x,y-1));
                        set.add(i+1);
                        map.put(Pair.of(x,y-1),set);
                    }
                    y--;
                }
            } 
            int ans=Integer.MAX_VALUE;
            for(Pair<Integer,Integer> p: visited)
            {
                //System.out.print(p.first+" "+p.second+":  ");
                int time=Math.abs(p.first)+Math.abs(p.second);
                int tmp=Integer.MAX_VALUE;
                TreeSet<Integer> set=map.get(p);
                /*for(int q: set)
                    System.out.print(q+" ");
                System.out.println();*/
                if(set.contains(time))
                    tmp=time;
                else
                {
                    if(set.higher(time)!=null)
                        tmp=set.higher(time);
                }
                ans=Math.min(ans,tmp);
            }
            if(ans==Integer.MAX_VALUE)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(ans);
        }
    }
}
                

            
