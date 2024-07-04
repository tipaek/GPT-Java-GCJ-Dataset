import java.io.*;
import java.util.*;
class sol{
    public static void main(String args[])throws IOException
    {
    InputStreamReader r=new InputStreamReader(System.in);    
    BufferedReader br=new BufferedReader(r);
    int t=Integer.parseInt(br.readLine());
    int n=0;
    List<Integer> arrc=new ArrayList<Integer>();
    List<Integer> arrj=new ArrayList<Integer>();
    String ans="";
    int flagj=0;
    int flagc=0;
    int s=0;
    int e=0;
    String[] r2 = new String[2];
    for(int i=0; i<t; i++)
    {
         arrj.clear();
         arrc.clear();
         flagj=0;
         flagc=0;
         ans="";
         ans="Case #"+Integer.toString(i+1)+": ";
         n=Integer.parseInt(br.readLine());
         for(int j=0;j<n;j++)
         {
            //System.out.println(j);
            flagj=0;
            flagc=0;
            r2=br.readLine().split(" ");
            s=Integer.parseInt(r2[0]);
            //System.out.println(s);
            e=Integer.parseInt(r2[1]);
            for(int k=0; k==0||k<arrj.size();k=k+2)
            {
                flagj=1;
                if(arrj.isEmpty())
                    {
                        arrj.add(s);
                        arrj.add(e);
                        break;
                    }
                else
                {
                    if(e<=arrj.get(k) || s>=arrj.get(k+1) && flagj==1)
                    {
                        if(k+2==arrj.size()-1)
                        {
                           arrj.add(s);
                           arrj.add(e);
                           break; 
                        }
                        else
                            continue;
                    }
                    else
                    {
                        flagj=0;
                        break;
                    }
                }
                // if(flagj==1)
                // {
                //     ans=ans+"J";
                //     break;
                // }
            }
            if(flagj==0){
            for(int k=0; k==0||k<arrc.size();k=k+2)
            {
                flagc=1;
                if(arrc.isEmpty())
                    {
                        arrc.add(s);
                        arrc.add(e);
                        break;
                    }
                else
                {
                    if(s>=arrc.get(k+1) || e<=arrc.get(k) && flagc==1)
                    {
                        if(k+2==arrc.size()-1)
                        {
                           arrc.add(s);
                           arrc.add(e);
                           break; 
                        }
                        else
                            continue;
                    }
                    else
                    {
                        flagc=0;
                        break;
                    }
                }
                // if(flagj==1)
                // {
                //     ans=ans+"J";
                //     break;
                // }
            }
        }
        if(flagj==1){
            ans=ans+"J";           
            continue;}
        else if(flagc==1)
        {
            ans=ans+"C";
            continue;}
        
        else{
            ans="Case #"+Integer.toString(i+1)+": "+"IMPOSSIBLE";
            break;
        }
    }
    System.out.println(ans);

         }
    }
    }

