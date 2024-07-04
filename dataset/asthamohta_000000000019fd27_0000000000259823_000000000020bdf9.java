import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
    public static class Node
    {
        int start,end,index;
        Node(int s,int e,int i)
        {
            start=s;
            end=e;
            index=i;
        }
    }
    public static HashMap<String,String> map=new HashMap<String,String>();
    public static String ways(int ct,int jt,int a,Node time[])
    {
        if(map.containsKey(a+" "+ct+" "+jt))
            return map.get(a+" "+ct+" "+jt);
        if(a>=time.length)
            return "";
        if(ct>time[a].start && jt>time[a].start){
        //    System.out.println(a+" "+ct+" "+jt+" IMPOSSIBLEyo");
            map.put((a+" "+ct+" "+jt),"IMPOSSIBLE");
            return "IMPOSSIBLE"; }
        String C="IMPOSSIBLE",J="IMPOSSIBLE";
        if(ct<=time[a].start)
            C=ways(time[a].end,jt,a+1,time);
        if(jt<=time[a].start)
            J=ways(ct,time[a].end,a+1,time);
        
        if(!C.equals("IMPOSSIBLE")){
            map.put((a+" "+ct+" "+jt),"C"+C);
            return "C"+C;}
        if(!J.equals("IMPOSSIBLE")){ 
            map.put((a+" "+ct+" "+jt),"J"+J);
            return "J"+J;}
        
        map.put((a+" "+ct+" "+jt),"IMPOSSIBLE");
        return "IMPOSSIBLE";
    }
    public static class timeComp implements Comparator<Node> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Node a, Node b) 
    { 
        return a.start - b.start; 
    } 
}
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    for(int x=0;x<test;x++)
	    {
            int a=sc.nextInt();
            Node time[]=new Node[a];
            Node original[]=new Node[a];
            for(int i=0;i<a;i++){
                time[i]=new Node(sc.nextInt(),sc.nextInt(),i);
                original[i]=new Node(time[i].start,time[i].end,i);
            }
            Arrays.sort(time,new timeComp());
            
            map=new HashMap<String,String>();
            HashMap<String,String> res=new HashMap<String,String>();
            String sol=ways(-1,-1,0,time);
            if(sol.equals("IMPOSSIBLE"))
            {
                 System.out.println("Case #"+(x+1)+": "+sol);
                continue;
            }
            char c[]=new char[sol.length()];
             for(int i=0;i<time.length;i++)
             {
                 c[time[i].index]=sol.charAt(i);
             }
            sol="";
            for(int i=0;i<time.length;i++)
                sol=sol+c[i];
            System.out.println("Case #"+(x+1)+": "+sol);
	    
	    }
	 }
}