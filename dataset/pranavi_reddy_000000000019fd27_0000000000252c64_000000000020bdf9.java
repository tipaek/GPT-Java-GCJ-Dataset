import java.io.*;
import java.util.*;
class Solution
{
    public static boolean overlap(int x1,int x2,int y1,int y2)
    {
        return (x1>=y1&&x1<y2)||(x2>y1&&x2<=y2)||(y1>=x1&&y1<x2)||(y2>x1&&y2<=x2);
    }
    public static void main(String[] args)
    {
        Scanner bf=new Scanner(System.in);
        int t=bf.nextInt();
        int mike=1;
        while(t!=0)
        {
            t--;
            String ans="";
            int n=bf.nextInt();
            ArrayList<Integer> sc=new ArrayList<Integer>();
            ArrayList<Integer> ec=new ArrayList<Integer>();
            ArrayList<Integer> sj=new ArrayList<Integer>();
            ArrayList<Integer> ej=new ArrayList<Integer>();
            int love=0;
            while(n!=0)
            {
                n--;
                int flag=0;
                
                int st=bf.nextInt();
                int et=bf.nextInt();
                if(sc.size()==0){
                ans=ans+"C";
                flag=1;
                    sc.add(st);
                    ec.add(et);
                }
                else
                {
                    int see=0;
                    for(int i=0;i<sc.size();i++)
                    {
                        int beg=sc.get(i);
                        int end=ec.get(i);
                        if(overlap(st,et,beg,end))
                        {
                            see=1;
                            break;
                        }
                
                    }
                    if(see==0)
                    {
                        ans=ans+"C";
                            sc.add(st);
                            ec.add(et);
                            flag=1;
                            
                    }
                }
                if(flag==0)
                {
                    if(sj.size()==0){
                ans=ans+"J";
                flag=1;
                    sj.add(st);
                    ej.add(et);
                }
                else
                {
                    int see=0;
                    for(int i=0;i<sj.size();i++)
                    {
                        int beg=sj.get(i);
                        int end=ej.get(i);
                         if(overlap(st,et,beg,end))
                        {
                            see=1;
                            break;
                        }
                        
                    }
                    if(see==0)
                    {
                        ans=ans+"J";
                            flag=1;
                            sj.add(st);
                            ej.add(et);
                            
                    }
                }
                    
                }
                if(flag==0)
                {
                    love=1;
                }
                
            }
            if(love==1)
            System.out.println("Case #"+mike+": IMPOSSIBLE");
            else
            System.out.println("Case #"+mike+": "+ans);
            mike++;
        }
    }
}