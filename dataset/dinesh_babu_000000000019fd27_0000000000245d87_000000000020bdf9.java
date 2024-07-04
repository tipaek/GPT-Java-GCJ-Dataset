import java.util.*;
public class Solution{
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1;i<=T;i++)
        {
            int n=sc.nextInt();
            ArrayList<ArrayList<Integer>> jamie = new ArrayList<>();
            ArrayList<ArrayList<Integer>> cameron = new ArrayList<>();
            String ans="";
            int fl2=1;
            for(int j=0;j<n;j++)
            {
                
                int start=sc.nextInt();
                int end=sc.nextInt();
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(start);temp.add(end);
                if(jamie.isEmpty())
                {
                    ans+="J";jamie.add(temp);
                }
                else if(cameron.isEmpty())
                {
                    ans+="C";cameron.add(temp);
                }
                else
                {
                         int fl=0;
                      for(ArrayList li : cameron)
                      {
                        if((  (Integer)li.get(0)>=end )|| ((Integer)li.get(1)<=start) )
                        continue;
                        else
                        {
                            fl=1;break;
                        }
                        
                      
                      }
                     if(fl==0){
                         cameron.add(temp);ans+="C"; continue;
                     } 
                     fl=0;
                      for(ArrayList li : jamie)
                       {
                     if(((Integer)li.get(0) >= end) || ((Integer)li.get(1)<=start) )
                        continue;
                        else
                        {
                            fl=1;break;
                        }
                        
                         }
                    if(fl==0) {
                        jamie.add(temp);ans+="J";continue;
                    }
                    else
                    {
                     fl2=0;   System.out.println("Case #"+i+": IMPOSSIBLE");break;
                    }
                    
                }
                

            }
            if(fl2==1 )  System.out.println("Case #"+i+": " +ans);
            
            
        }
        
        
        
        
    }
}