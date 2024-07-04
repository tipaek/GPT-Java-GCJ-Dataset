import java.util.*;

public class Solution{
    static class node{
    char ch;
    int x;
    node(char ch,int x)
    {
        this.ch=ch;
        this.x=x;
    }
}
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int k=1;
        while(k<=t)
        {
            HashMap<Character,Integer> map=new HashMap<>();
            HashMap<Character,Boolean> map2=new HashMap<>();
            int u=s.nextInt();
            int num=(int)Math.pow(10,u)-1;
            for(int i=1;i<=(int)Math.pow(10,4);i++)
            {
                String x=s.next();
                if(!x.equals("-1"))
                {
                    String str=s.next();
                    if(x.length()==str.length())
                    {
                        int r=x.charAt(0)-'0';
                    if(!map.containsKey(str.charAt(0)))
                    {
                        map.put(str.charAt(0),r);
                    }
                    else
                    {
                        map.put(str.charAt(0),Math.min(map.get(str.charAt(0)),r));
                    }
                    }
                    
                    for(int j=0;j<str.length();j++)
                  {
                    map2.put(str.charAt(j),true);
                  }
                }
                
                
                
            }
            ArrayList<node> arr=new ArrayList<node>();
            for(char ch:map.keySet())
            {
                node newnode=new node(ch,map.get(ch));
                arr.add(newnode);
            }
            Collections.sort(arr,new Comparator<node>(){
                public int compare(node a,node b)
                {
                    return a.x-b.x;
                }
            });
            String small="";
            for(char ch:map2.keySet())
            {
                if(!map.containsKey(ch))
                {
                    small=small+ch+"";
                    break;
                }
            }
            for(int i=0;i<arr.size();i++)
            {
                //System.out.println(arr.get(i).x);
                small=small+arr.get(i).ch+"";
            }
            System.out.println("Case #"+k+": "+small);
            k++;
        }
    }
}