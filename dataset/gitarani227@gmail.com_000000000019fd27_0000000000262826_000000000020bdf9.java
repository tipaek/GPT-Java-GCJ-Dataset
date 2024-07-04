import java.util.*;
class Solution{
    static class pair implements Comparable<pair>
    {
        int s;
        int e;
       
        public int compareTo(pair ob)
        {
           
            return(this.s-ob.s);
           }
        
        }
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        int o=1;
        while(t!=0)
        {
            int n=ob.nextInt();
            pair[] arr=new pair[n];
                for(int i=0;i<n;i++)
                {
                    arr[i]=new pair();
                    arr[i].s=ob.nextInt();
                    arr[i].e=ob.nextInt();
                }
            
            Arrays.sort(arr);
            int C=1 , J=0 , ce=arr[0].e ,je=0 ;
            String str="C";

            for(int j=1;j<n;j++)
            {
                   if(arr[j].s>=ce)
                    {
                        ce=arr[j].e;
                        str=str+'C';
                        continue;
                       
                    }
                    if(arr[j].s>=je)
                            {   J=1;
                                je=arr[j].e;
                                str=str+'J';
                                continue;
                            }
                    
                    else 
                    {
                        if(C==1 && J==1)
                        {
                            str="IMPOSSIBLE";
                            break;
                        }
                    }
               
                
              
            }
            
            System.out.println("Case #"+o+": "+str);
            o++;
            t--;
        }
     }
}