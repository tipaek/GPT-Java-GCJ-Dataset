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
    static ArrayList<Integer> arr=new ArrayList<>();
    static int x;
    static int y;
    static boolean evaluate()
    {
        int h=0,v=0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)==0)
                continue;
            if(arr.get(i)==1)
                h+=(1<<i);
            if(arr.get(i)==2)
                h-=(1<<i);
            if(arr.get(i)==3)
                v+=(1<<i);
            if(arr.get(i)==4)
                v-=(1<<i);
        }
        if(h==x && v==y)
            return true;
        return false;
    }
    static boolean solve(int pos)
    {
        if(pos==8 || (arr.size()>0 && arr.get(arr.size()-1)==0))
        {
            if(evaluate()==true)
                return true;
            return false;
        }


        arr.add(0);
        if(solve(pos+1)==true)
            return true;
        arr.remove(pos);

        arr.add(1);
        if(solve(pos+1)==true)
            return true;
        arr.remove(pos);

        arr.add(2);
        if(solve(pos+1)==true)
            return true;
        arr.remove(pos);

        arr.add(3);
        if(solve(pos+1)==true)
            return true;
        arr.remove(pos);

        arr.add(4);
        if(solve(pos+1)==true)
            return true;
        arr.remove(pos);

        return false;
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
            x=in.nextInt();
            y=in.nextInt();
            if(((x%2)==0 && (y%2)==0) || ((x%2)==1 && (y%2)==1))
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            if(solve(0)==false)
                System.out.println("IMPOSSIBLE");
            else
            {
                StringBuffer ans=new StringBuffer("");
                for(int i=0;i<arr.size();i++)
                {
                    if(arr.get(i)==1)
                        ans.append("E");
                    else if(arr.get(i)==2)
                        ans.append("W");
                    else if(arr.get(i)==3)
                        ans.append("N");
                    else if(arr.get(i)==1)
                        ans.append("S");
                }
                System.out.println(ans.toString());
            }

            
        } 
        
    }
}
