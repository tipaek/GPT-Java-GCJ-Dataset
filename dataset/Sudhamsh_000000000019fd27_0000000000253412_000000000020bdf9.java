import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import  java .util.*;
class Data implements Comparable<Data>{
    int start;
    int end;
    char c;
    Data(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
    public int compareTo(Data d)
    {
        return start>d.start?1:-1;
    }
}
class Solution {
    public static void main(String[] agrs) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int x = 1;
        Scanner sc = new Scanner(System.in);
        while (t-- > 0) {
            ArrayList<Data> a=new ArrayList<>();
            LinkedList<Data> order=new LinkedList<>();
            int n=Integer.parseInt(br.readLine());
            while(n-->0)
            {
                String s[]=br.readLine().split(" ");
                Data d=new Data(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
                a.add(d);
                order.add(d);
            }
            int j=Integer.MIN_VALUE;
            int c=Integer.MIN_VALUE;
            Collections.sort(a);
            boolean f=false;
            for(int i=0;i<a.size();i++)
            {
                if(j<=a.get(i).start)
                {
                    a.get(i).c='J';
                    j=a.get(i).end;
                }
                else if(c<=a.get(i).start)
                {
                    a.get(i).c='C';
                    c=a.get(i).end;
                }
                else
                {
                    f=true;
                    break;
                }
            }
            if(f)
            {
                bw.write("Case #"+x+": IMPOSSIBLE\n");
            }
            else
            {
                String ans="";
                for(int i=0;i<order.size();i++)
                    ans+=order.get(i).c;
                bw.write("Case #"+x+": "+ans+"\n");
            }
            x++;
        }
        bw.flush();
    }
}