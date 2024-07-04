import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int tcases=sc.nextInt();
        for(int t=0;t<tcases;t++)
        {   int count=0,flag=1,ctime=-1,jtime=-1;
            String str="";
            int num=sc.nextInt();
            int arr[][]=new int[num][4];
            int start[]=new int[num];
            for(int s=0;s<num;s++)
            {
                arr[s][0]=sc.nextInt();
                arr[s][1]=sc.nextInt();
                arr[s][2]=s;
                arr[s][3]=0;
            }
            Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(final int[] a,final int[] b){
                if(a[0]>b[0])
                return 1;
                else
                return -1;
            }
            });
                  for(int g=0;g<num;g++)
                  {
                      
                    if(arr[g][0]>=ctime)
                      {
                         ctime=arr[g][1];
                         arr[g][3]=0;
                      }
                    else if(arr[g][0]>=jtime)
                      {    
                         jtime=arr[g][1];
                         arr[g][3]=1;
                      }
                      else{
                          str="IMPOSSIBLE";
                          flag=0;
                          break;
                      }
                  }
             if(flag==0)
             System.out.println("Case #"+(t+1)+": "+str);      
             else
             {
                  Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(final int[] a,final int[] b){
                if(a[2]>b[2])
                return 1;
                else
                return -1;
            }
            });
             for(int k=0;k<num;k++)
             {
                 if(arr[k][3]==0)
                 str+="C";
                 else
                 str+="J";
             }
             System.out.println("Case #"+(t+1)+": "+str);      
                 
                 
             }
            
        }
    }
}