import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int q=Integer.parseInt(br.readLine());
        for(int p=0;p<q;p++)
        {
            String str[]=br.readLine().split(" ");
            int x=Integer.parseInt(str[0]);
            int y=Integer.parseInt(str[1]);
            String s=str[2];
            Map<String,Integer> map=new HashMap<>();
            Map<String,Integer> map2=new HashMap<>();
            map.put(x+" "+y,0);
            int mi=1;
            int maxx=x,minx=x,maxy=y,miny=y;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='S')
                {
                    y--;
                    map.put(x+" "+y,mi);
                    miny=Math.min(miny,y);
                }
                else if(s.charAt(i)=='N')
                {
                    y++;
                    map.put(x+" "+y,mi);
                    maxy=Math.max(maxy,y);
                }
                else if(s.charAt(i)=='W')
                {
                    x--;
                    map.put(x+" "+y,mi);
                    minx=Math.min(minx,x);
                }
                else
                {
                    x++;
                    map.put(x+" "+y,mi);
                    maxx=Math.max(maxx,x);
                }
                mi++;
            }
            int min=Integer.MAX_VALUE;
            map2.put("0 0",0);
            Queue<String> queue=new LinkedList<>();
            queue.add("0 0");
            if(map.containsKey("0 0"))
            min=Math.min(min,Math.max(0,map.get("0 0")));
            while(!queue.isEmpty())
            {
                str=queue.poll().split(" ");
                int x1=Integer.parseInt(str[0]);
                int y1=Integer.parseInt(str[1]);
                if(s.length()>=(int)Math.abs(x1+1)&&!map2.containsKey((x1+1)+" "+y1))
                {
                queue.add((x1+1)+" "+y1);
                map2.put((x1+1)+" "+y1,map2.get(x1+" "+y1)+1);
                if(map.containsKey((x1+1)+" "+y1)&&map.get((x1+1)+" "+y1)>=map2.get((x1+1)+" "+y1))
                min=Math.min(min,map.get((x1+1)+" "+y1));
                }
                if(s.length()>=(int)Math.abs(x1-1)&&!map2.containsKey((x1-1)+" "+y1))
                {
                queue.add((x1-1)+" "+y1);
                map2.put((x1-1)+" "+y1,map2.get(x1+" "+y1)+1);
                if(map.containsKey((x1-1)+" "+y1)&&map.get((x1-1)+" "+y1)>=map2.get((x1-1)+" "+y1))
                min=Math.min(min,map.get((x1-1)+" "+y1));
                }
                if(s.length()>=(int)Math.abs(y1+1)&&!map2.containsKey(x1+" "+(y1+1)))
                {
                queue.add(x1+" "+(y1+1));
                map2.put(x1+" "+(y1+1),map2.get(x1+" "+y1)+1);
                if(map.containsKey(x1+" "+(y1+1))&&map.get(x1+" "+(y1+1))>=map2.get(x1+" "+(y1+1)))
                min=Math.min(min,map.get(x1+" "+(y1+1)));
                }
                if(s.length()>=(int)Math.abs(y1-1)&&!map2.containsKey(x1+" "+(y1-1)))
                {
                queue.add(x1+" "+(y1-1));
                map2.put(x1+" "+(y1-1),map2.get(x1+" "+y1)+1);
                if(map.containsKey(x1+" "+(y1-1))&&map.get(x1+" "+(y1-1))>=map2.get(x1+" "+(y1-1)))
                min=Math.min(min,map.get(x1+" "+(y1-1)));
                }
            }
            while(!queue.isEmpty())
            {
                String st=queue.poll();
                if(map.containsKey(st))
                min=Math.min(min,Math.max(map.get(st),map2.get(st)));
            }
            if(min==Integer.MAX_VALUE||min>s.length())
            pw.println("Case #"+(p+1)+": IMPOSSIBLE");
            else
            pw.println("Case #"+(p+1)+": "+min);
        }
        pw.flush();
        pw.close();
    }
}