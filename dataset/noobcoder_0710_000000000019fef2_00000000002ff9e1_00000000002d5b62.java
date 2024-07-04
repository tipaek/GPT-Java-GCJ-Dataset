import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String srg[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++)
        {
            String str[]=br.readLine().split(" ");
            long x=Long.parseLong(str[0]);
            long y=Long.parseLong(str[1]);
            Map<String,Integer> map=new HashMap<>();
            Map<String,String> par=new HashMap<>();
            map.put(0+" "+0,0);
            par.put(0+" "+0,"-1");
            Queue<String> queue=new LinkedList<>();
            queue.add(0+" "+0);
            int i=1;
            while(!queue.isEmpty()&&i<=10000)
            {
                StringBuffer sb=new StringBuffer(queue.poll());
                long x1=Long.parseLong(sb.substring(0,sb.indexOf(" ")));
                long y1=Long.parseLong(sb.substring(sb.indexOf(" ")+1));
                //System.out.println(x1+" "+y1);
                if(x1==x&&y1==y)
                break;
                long num1=x1+(long)Math.pow(2,map.get(sb.toString()));
                    //System.out.println(num1);
                    if(!map.containsKey(num1+" "+y1))
                    {
                        queue.add(num1+" "+y1);
                        map.put(num1+" "+y1,map.get(sb.toString())+1);
                        par.put(num1+" "+y1,sb.toString());
                    }
                //}
                //if((x1-(long)Math.pow(2,map.get(sb.toString()))))
                //{
                    if(!map.containsKey((x1-(long)Math.pow(2,map.get(sb.toString())))+" "+y1))
                    {
                        queue.add((x1-(long)Math.pow(2,map.get(sb.toString())))+" "+y1);
                        map.put((x1-(long)Math.pow(2,map.get(sb.toString())))+" "+y1,map.get(sb.toString())+1);
                        par.put((x1-(long)Math.pow(2,map.get(sb.toString())))+" "+y1,sb.toString());
                    }
                //}
                //if((y1+(long)Math.pow(2,map.get(sb.toString()))))
                //{
                    if(!map.containsKey(x1+" "+(y1+(long)Math.pow(2,map.get(sb.toString())))))
                    {
                        queue.add(x1+" "+(y1+(long)Math.pow(2,map.get(sb.toString()))));
                        map.put(x1+" "+(y1+(long)Math.pow(2,map.get(sb.toString()))),map.get(sb.toString())+1);
                        par.put(x1+" "+(y1+(long)Math.pow(2,map.get(sb.toString()))),sb.toString());
                    }
                //}
                //if((y1-(long)Math.pow(2,map.get(sb.toString()))))
                //{
                    if(!map.containsKey(x1+" "+(y1-(long)Math.pow(2,map.get(sb.toString())))))
                    {
                        queue.add(x1+" "+(y1-(long)Math.pow(2,map.get(sb.toString()))));
                        map.put(x1+" "+(y1-(long)Math.pow(2,map.get(sb.toString()))),map.get(sb.toString())+1);
                        par.put(x1+" "+(y1-(long)Math.pow(2,map.get(sb.toString()))),sb.toString());
                    }
               // }
               i++;
            }
            //pw.println(par);
            //pw.println(map);
            if(map.containsKey(x+" "+y))
            {
                //System.out.println(par);
                String s=x+" "+y;
                StringBuffer ss=new StringBuffer();
                while(!par.get(s).equals("-1"))
                {
                    String st=par.get(s);
                    //System.out.println(st);
                    StringBuffer sb1=new StringBuffer(st);
                    StringBuffer sb2=new StringBuffer(s);
                    long x1=Long.parseLong(sb1.substring(0,sb1.indexOf(" ")));
                    long y1=Long.parseLong(sb1.substring(sb1.indexOf(" ")+1));
                    long x2=Long.parseLong(sb2.substring(0,sb2.indexOf(" ")));
                    long y2=Long.parseLong(sb2.substring(sb2.indexOf(" ")+1));
                    if(x1==x2)
                    {
                        if(y1>y2)
                        {
                            ss.append("S");
                        }
                        else
                        ss.append("N");
                    }
                    else
                    {
                        if(x1<x2)
                        ss.append("E");
                        else
                        ss.append("W");
                    }
                    s=st;
                }
                ss.reverse();
                pw.println("Case #"+(p+1)+": "+ss);
            }
            else
            {
                pw.println("Case #"+(p+1)+": IMPOSSIBLE");
            }
        }
        pw.flush();
        pw.close();
    }
}