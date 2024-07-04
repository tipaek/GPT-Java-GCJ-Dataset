import java.util.*;
class Solution{
    public static void main(String[]args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int p=1;
        while(p<=t)
        {  
            int n=s.nextInt();
            int [][]a=new int[n][2];
            
            int[][]aux=new int[n][2];
            for(int i=0;i<n;i++)
            {   a[i][1]=s.nextInt();
                aux[i][0]=a[i][1];
                a[i][0]=s.nextInt();
                aux[i][1]=a[i][0];
                
            }Arrays.sort(a, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1,int[] o2) {

                int t1 = o1[1];
                int p1 = o1[0];
               int t2 = o2[1];
             int p2 = o2[0];

                if (t1 == t2) {
                    return (p1 > p2 ? 1 : (p1 == p2 ? 0 : -1));
                } else {
                    return (t1 < t2 ? -1 : 1);
                }

            }
        });
        for(int i=0;i<n;i++)
            {  int temp=a[i][0];
                a[i][0]=a[i][1];
                a[i][1]=temp;
            }
             
        String ans="J";
        int j=a[0][1],c=0;
        for(int i=1;i<n;i++)
        {        if(a[i][0]<a[i-1][1]&&a[i][0]>=c)
                    {ans+="C";
                    c=a[i][1];
                    }
                  else  if(a[i][0]<a[i-1][1]&&a[i][0]>=j)
                    {ans+="J";
                    j=a[i][1];
                    }
                    else if(a[i][0]>=a[i-1][1])
                    {   ans+=ans.charAt(ans.length()-1);
                    if(ans.charAt(ans.length()-1)=='J')
                    j=a[i][1];
                    else
                    c=a[i][1];
                    }
                    else
                    {ans="IMPOSSIBLE";
                    break;
                    }
        }
        String nans="";
        if(!ans.equals("IMPOSSIBLE"))
        {
            for(int i=0;i<n;i++)
            {
                for(int k=0;k<n;k++)
                {
                    if(aux[i][0]==a[k][0]&&aux[i][1]==a[k][1])
                    {
                        nans+=ans.charAt(k);
                        break;
                    }
                    
                }
            }
        }
           
            if(!ans.equals("IMPOSSIBLE"))
             System.out.println("Case #"+p+":"+" "+nans);
             else
             System.out.println("Case #"+p+":"+" "+ans);
     p++;
        }
    }
}