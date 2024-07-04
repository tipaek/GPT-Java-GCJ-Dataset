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
            int r=in.nextInt();
            int s=in.nextInt();
            ArrayList<Pair<Integer,Integer>> arr=new ArrayList<>();
            ArrayList<Pair<Integer,Integer>> moves=new ArrayList<>();
            for(int i=1;i<=s;i++)
            {
                for(int j=1;j<=r;j++)
                    arr.add(Pair.of(j,i));
            }
            int n=s*r-1;

            while(n>0)
            {
                int i=n-1;
                for(i=n-1;i>=0;i--)
                {
                    Pair<Integer,Integer> p=arr.get(i);
                    if(p.first==(arr.get(n)).first)
                        break;
                }
                if(i==n-1 || i==-1)
                {
                    n--;
                    continue;
                }
                moves.add(Pair.of(i+1,n-i-1));
                ArrayList<Pair<Integer,Integer>> tmp=new ArrayList<>();
                for(int j=i+1;j<=n-1;j++)
                    tmp.add(arr.get(j));
                for(int j=0;j<=i;j++)
                    tmp.add(arr.get(j));
                for(int j=n;j<=r*s-1;j++)
                    tmp.add(arr.get(j));
                arr.clear();
                for(int j=0;j<tmp.size();j++)
                    arr.add(tmp.get(j));
                n--;


            }
            System.out.println(moves.size());
            for(int i=0;i<moves.size();i++)
                System.out.println((moves.get(i)).first+" "+(moves.get(i)).second);

            
        } 
        
    }
}
