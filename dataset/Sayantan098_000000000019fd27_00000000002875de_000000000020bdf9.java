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
            task[1].jc="C";
            int j=0;
            int c=1;
           
            for(int k=2;k<n;k++)
            {
                if(task[k].st>=task[j].end)
                   { task[k].jc="J";j=k;}
                  
                else if(task[k].st>=task[c].end)
                   { task[k].jc="C";c=k;}
                  
               
            }
            
            obj.position(task);
            //  for( i=0;i<n;i++)
            //      System.out.println(task[i].st+" "+task[i].end+" "+task[i].pos+" "+task[i].jc);
            String jcb="";
           // int flg=0;
            
            for(int i=0;i<n;i++)
            {
                if((task[i].jc).equals("0"))
                {jcb="IMPOSSIBLE";break;}
                else
                jcb+=task[i].jc;
            }
            
            
            System.out.println("Case #"+g+": "+jcb);
            // for(i=0;i<n;i++)
            //     System.out.println(task[i].st+" "+task[i].end+" "+task[i].pos+" "+task[i].jc);
            
            
       
        }
        
        
        
    }
    
}