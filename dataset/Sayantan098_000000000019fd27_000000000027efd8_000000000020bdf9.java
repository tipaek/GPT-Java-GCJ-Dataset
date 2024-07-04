import java.util.*;
import java.io.*;

class merge
{
    int pos;
    int st;
    int end;
    String jc;
    public merge(int pos,int st,int end,String jc)
    {
        this.pos=pos;
        this.st=st;
        this.end=end;
        this.jc=jc;
    }
}

class Sortby
{
    static void endtime(merge[] arr)
    {
        Arrays.sort(arr, new Comparator<merge>(){
            @Override
            public int compare(merge p1,merge p2)
            {
               return p1.end-p2.end;
            }
        }
        );
    }
    static void position(merge[] arr)
    {
        Arrays.sort(arr, new Comparator<merge>(){
            @Override
            public int compare(merge p1,merge p2)
            {
               return p1.pos-p2.pos;
            }
        }
        );
    }
}
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int g=1;g<=tc;g++)
        {
            int n=Integer.parseInt(br.readLine());
            merge[] task=new merge[n];
            for(int i=0;i<n;i++)
            {
                String s=br.readLine();
                String[] sr=s.split(" ");
                task[i]= new merge(i,Integer.parseInt(sr[0]),Integer.parseInt(sr[1]),"0");
            }
            Sortby obj=new Sortby();
            obj.endtime(task);
            task[0].jc="J";
            int i=0;
            int x=-1,f2=0;
            for(int j=1;j<n;j++)
            {
                if(task[j].st>=task[i].end)
                   { task[j].jc="J";i=j;}
                  
                if((task[j].jc).equals("0")&&f2==0)
                   { x=j;f2=1;}
                
            }
            if(x>-1)
            {
            task[x].jc="C";
            for(int j=x+1;j<n;j++)
            {
               if(task[j].st>=task[x].end && (task[j].jc).equals("0"))
               {task[j].jc="C";x=j;}
            }
            }
            obj.position(task);
            //  for( i=0;i<n;i++)
            //      System.out.println(task[i].st+" "+task[i].end+" "+task[i].pos+" "+task[i].jc);
            String jcb="";
            int flg=0;
            
            for(i=0;i<n;i++)
            {
                if((task[i].jc).equals("0"))
                {flg=1;break;}
                else
                jcb+=task[i].jc;
            }
            
            if(flg==1)
            {System.out.println("IMPOSSIBLE");}
            else
            System.out.println(jcb);
           // for(int i=0;i<n;i++)
            //     System.out.println(task[i].st+" "+task[i].end);
            
            
       
        }
        
        
        
    }
    
}