
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        int itr=1;
        while(itr<=t)
        {
            int n= sc.nextInt();
            Intervals[] a= new Intervals[n];
            Intervals[] initialArray= new Intervals [n];
            for(int i=0; i<n; i++)
            {
                int startTime= sc.nextInt();
                int endTime= sc.nextInt();
                a[i]= new Intervals(startTime, endTime, i);
                initialArray[i]= new Intervals(startTime, endTime, i);
            }
            Arrays.sort(a);
//            printArray(a);
            String result = getSequence(a);
            if(result.equals("IMPOSSIBLE"))
            {
                System.out.println("Case #"+itr+": IMPOSSIBLE");
            }
            else {
//                Map<Intervals, String> map = new HashMap<Intervals, String>();
                String[] indexArray=new String[n];
                for (int i = 0; i < a.length; i++) {
//                    map.put(a[i], result.charAt(i) + "");
                    indexArray[a[i].index]=result.charAt(i) + "";
                }
                StringBuilder answer = new StringBuilder();
                for (int i = 0; i < indexArray.length; i++) {
                    answer.append(indexArray[i]);
                }

                System.out.println("Case #" + itr + ": " + answer.toString());
            }
            itr++;
        }
    }
    private static String getSequence(Intervals[] a)
    {
        StringBuilder res= new StringBuilder();
        int j=-1, c=-1;
        for(int i=0; i<a.length; i++)
        {
            if(a[i].startTime>=c)
            {
                c=a[i].endTime;
                res.append("C");
            }
            else if(a[i].startTime>=j)
            {
                j=a[i].endTime;
                res.append("J");
            }
            else
                return "IMPOSSIBLE";
        }
        return res.toString();
    }
    /*private static void printArray(Intervals[]a) {
        for (int i=0; i<a.length; i++) {
            System.out.println(a[i].startTime + ", " + a[i].endTime);
        }
        System.out.println("-------------------------");
    }*/
}
class Intervals implements Comparable<Intervals>
{
    int startTime;
    int endTime;
    int index;

    Intervals(int startTime, int endTime, int index)
    {
        this.endTime=endTime;
        this.startTime=startTime;
        this.index=index;
    }
    @Override
    public int compareTo(Intervals o) {
        if(this.startTime==o.startTime)
            return  this.endTime-o.endTime;
        return this.startTime-o.startTime;
    }
}
