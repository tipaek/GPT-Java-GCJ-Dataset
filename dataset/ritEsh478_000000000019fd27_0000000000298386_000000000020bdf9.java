import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scan= new Scanner(System.in);
        int t= scan.nextInt();
        int l=1;
        while(l<=t)
        {
            int n= scan.nextInt();
            Intervals[] a= new Intervals[n];
            Intervals[] initArray= new Intervals [n];
            for(int i=0; i<n; i++)
            {
                int startTime= scan.nextInt();
                int endTime= scan.nextInt();
                a[i]= new Intervals(startTime, endTime, i);
                initArray[i]= new Intervals(startTime, endTime, i);
            }
            Arrays.sort(a);

            String res = Sequence(a);
            if(res.equals("IMPOSSIBLE"))
            {
                System.out.println("Case #"+l+": IMPOSSIBLE");
            }
            else {

                String[] indArray=new String[n];
                for (int i = 0; i < a.length; i++) {

                    indArray[a[i].ind]=res.charAt(i) + "";
                }
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < indArray.length; i++) {
                    answer.append(indArray[i]);
                }

                System.out.println("Case #" + l + ": " + answer.toString());
            }
            l++;
        }
    }
    private static String Sequence(Intervals[] a)
    {
        StringBuilder res= new StringBuilder();
        int j=-1, c=-1;
        for(int i=0; i<a.length; i++)
        {
            if(a[i].startingTime>=c)
            {
                c=a[i].endingTime;
                res.append("J");
            }
            else if(a[i].startingTime>=j)
            {
                j=a[i].endingTime;
                res.append("C");
            }
            else
                return "IMPOSSIBLE";
        }
        return res.toString();
    }
    
}
class Intervals implements Comparable<Intervals>
{
    int startingTime;
    int endingTime;
    int ind;

    Intervals(int startingTime, int endingTime, int ind)
    {
        this.endingTime=endingTime;
        this.startingTime=startingTime;
        this.ind=ind;
    }
    @Override
    public int compareTo(Intervals o) {
        if(this.startingTime==o.startingTime)
            return  this.endingTime-o.endingTime;
        return this.startingTime-o.startingTime;
    }
}