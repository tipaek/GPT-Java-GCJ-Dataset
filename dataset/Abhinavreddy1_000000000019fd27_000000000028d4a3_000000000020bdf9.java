import java.io.*;
import java.util.*;
class Pair{
    int start;
    int finish;
    Pair(int a,int b){
        start=a;
        finish=b;
    }
}
public class Solution {
    public static String f(List<Pair> jobs)
    {
        ArrayList<Pair> al=new ArrayList<Pair>();
        for(int i=0;i<jobs.size();i++) al.add(jobs.get(i));
        Collections.sort(jobs, (x, y) -> x.start - y.start);
        StringBuilder sb=new StringBuilder("");
        boolean c=false;
        boolean j=false;
        int ce=-1;
        int je=-1;
        HashMap<Pair,Character> hm=new HashMap<>();
        for (int i = 0; i < jobs.size(); i++){
            if(c==false || ce<=jobs.get(i).start){
                ce=jobs.get(i).finish;
                c=true;
                //sb.append("C");
                hm.put(jobs.get(i),'C');
            }
            else if(j==false || je<=jobs.get(i).start){
                je=jobs.get(i).finish;
                j=true;
                //sb.append("J");
                hm.put(jobs.get(i),'J');
            }
            else return "IMPOSSIBLE";
        }
        for(Pair x:al) sb.append(hm.get(x));
        return sb.toString();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int p=1;p<=t;p++){
            int n=Integer.parseInt(br.readLine());
            ArrayList<Pair> al=new ArrayList<>();
            for(int i=0;i<n;i++){
                String[] s=br.readLine().split(" ");
                al.add(new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
            }
            bw.write("Case #"+p+": "+f(al)+"\n");
        }
        bw.flush();
    }
}