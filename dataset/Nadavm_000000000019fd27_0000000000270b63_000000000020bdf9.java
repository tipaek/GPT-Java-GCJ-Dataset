import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        Activity[] acts;
        for (int K = 1; K <= T; K++) {
            int N = in.nextInt();
            acts = new Activity[N];
            for (int i = 0; i < N; i++)
                acts[i] = new Activity(in.nextInt(), in.nextInt());
            System.out.println("Case #" + K + ": " + sced(acts, N));
        }
    }
    public static String sced(Activity[] ar, int N)
    {
        Activity[] arr = new Activity[N];
        for(int a = 0; a < N; a++)
        {
            arr[a] = ar[a];
        }
        Arrays.sort(arr, new Sortbyroll());
        arr[0].setDoing('C');
        int canStartC = arr[0].getEnd(), canStartJ = 0;
        for (int i = 1; i < N; i++)
        {
            if (arr[i].getStart() >= canStartC){
                arr[i].setDoing('C');
                canStartC = Math.max(canStartC, arr[i].getEnd());
            }
            else if (arr[i].getStart() >= canStartJ)
            {
                arr[i].setDoing('J');
                canStartJ = Math.max(arr[i].getEnd(), canStartJ);
            }
            else
                return "IMPOSSIBLE";
        }
        String s = "";
        for(int j = 0; j < N; j++)
            s += ar[j].getDoing();
        return s;
    }


}
class Sortbyroll implements Comparator<Activity>
{
    public int compare(Activity a, Activity b)
    {
        return a.getStart() - b.getStart();
    }
}
class Activity
{
    protected int start;
    protected int end;
    protected char doing;
    public Activity(int start, int end)
    {
        this.start = start;
        this.end = end;
        doing = ' ';
    }
    public int diff()
    {
        return this.start - this.end;
    }
    public char getDoing()
    {
        return this.doing;
    }
    public int getStart()
    {
        return this.start;
    }
    public int getEnd()
    {
        return this.end;
    }
    public void setDoing(char c)
    {
        this.doing = c;
    }
}