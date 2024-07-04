import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N=sc.nextInt();
            ArrayList<Pair>cameron=new ArrayList<Pair>();
            ArrayList<Pair>jamie=new ArrayList<Pair>();
            String output="";
            for (int j = 0; j <N ; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                boolean change=false;
                boolean possible=true;
                for(Pair k:cameron)
                {
                    if(intersect(k.key,k.value,x,y))
                    {
                        change=true;
                        break;
                    }
                }
                if(change==true)
                {
                    for(Pair k:jamie) {
                        if(intersect(k.key,k.value,x,y))
                        {
                            possible=false;
                            break;
                        }
                    }
                    if(possible==false)
                    {
                        output="IMPOSSIBLE";
                        break;
                    }
                    output+="J";
                    jamie.add(new Pair(x,y));
                }
                else {
                    output += "C";
                    cameron.add(new Pair(x,y));
                }
            }   
            System.out.println("Case #"+(i+1)+": "+output);
        }
    }
    public static boolean intersect(int x1, int y1, int x2, int y2)
    {
        if(y1<=x2)
            return false;
        if(y2<=x1)
            return false;
        return true;
        
    }
}
class Pair implements Comparable<Pair>
{
    int key, value;
    public Pair(int k, int v)
    {
     key=k;
     value=v;
    }
    public int getKey()
    {
        return key;
    }
    public int getValue()
    {
        return value;
    }

    public int compareTo(Pair p){
        return 0;
 }
}