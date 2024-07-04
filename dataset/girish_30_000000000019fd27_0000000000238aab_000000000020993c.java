import java.util.*;
class Solution {

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        String [] str=new String[t];
        int i=0;
        while(i<t)
        {    int n=s.nextInt();
             int sum=0;
             int [][] matrixref=new int[n][n];
            int [] rowcount=new int[n];
            List<Integer> [] lref=new LinkedList[n];
            int [] colcount=new int[n];
            for(int x=0;x<n;x++)
            {
                lref[x]=new LinkedList<>();
            }
             for(int j=0;j<n;j++)
             {
                 for(int k=0;k<n;k++)
                 {
                     matrixref[j][k]=s.nextInt();
                 }
             }
            for(int j=0;j<n;j++)
            {   List<Integer> lnew=new LinkedList<>();
                int count=0;
                for(int k=0;k<n;k++)
                {
                    int value=matrixref[j][k];
                    if(j==k)
                    {
                        sum = sum + value;
                    }
                    if(!lref[k].contains(value))
                    {
                        lref[k].add(value);
                    }
                    else
                    {
                        colcount[k]=colcount[k]+1;
                    }

                    if(!lnew.contains(value))
                    { lnew.add(value);}

                    else
                    {
                        count=count+1;
                    }
                }
                rowcount[j]= count;
            }
            int rowsum=0,colsum=0;
            for(int element:rowcount)
            {
                if(element!=0)
                    rowsum=rowsum+1;
            }
            for(int element:colcount)
            {
                if(element!=0)
                    colsum=colsum+1;
            }
               str[i]=("Case #"+String.valueOf(i+1)+": " + String.valueOf(sum)+" " + String.valueOf(rowsum) +" " +String.valueOf(colsum));
              i=i+1;
        }
        for(String sref:str)
        {
            System.out.println(sref);
        }
      }
}
