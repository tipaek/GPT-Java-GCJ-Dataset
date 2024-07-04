import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int tcases=sc.nextInt();
        for(int t=0;t<tcases;t++)
        {   int count=0,flag=1,cflag=1,jflag=1,ctime=-1,jtime=-1;
            String str="";
            int num=sc.nextInt();
            int arr[][]=new int[num][2];
            for(int s=0;s<num;s++)
            {
                arr[s][0]=sc.nextInt();
                arr[s][1]=sc.nextInt();
            }
            Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(final int[] a,final int[] b){
                if(a[0]>b[0])
                return 1;
                else
                return -1;
            }
            });
            for(int i=0;i<num;i++)
            {  count=0;
               for(int j=0;j<i;j++)
               {
                   if(arr[i][0]<arr[j][1])
                   count++;
                   if(count>1)
                   {count=0;
                   flag=0;
                   break;}
               }
               if(flag==0)
               break;
            }
            if(flag==0)
            System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            else
            {
                  for(int g=0;g<num;g++)
                  {
                      
                    if(arr[g][0]>=ctime)
                      {
                         ctime=arr[g][1];
                         str+="C";
                      }
                    else if(arr[g][0]>=jtime)
                      {    
                         jtime=arr[g][1];
                         str+="J";
                      }
                  }
             System.out.println("Case #"+(t+1)+": "+str);      
            }
            
        }
    }
}