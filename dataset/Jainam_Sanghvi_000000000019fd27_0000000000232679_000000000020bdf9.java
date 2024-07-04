import java.util.*;
import java.io.*;

public class Solution
{
        static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U first;
        public V second;
   
        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
         public int compareTo(Pair<U, V> b) {
            int cmpU = first.compareTo(b.first);
            return cmpU != 0 ? cmpU : second.compareTo(b.second);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(),i=0,j=0,k=0;
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int flag=0;
            Pair<Integer,Integer> a[]=new Pair[n];
            int ar[][]=new int[n][2];
            int ar1[][]=new int[n][4];
            for(j=0;j<n;j++)
            {
                ar[j][0]=sc.nextInt();
                ar[j][1]=sc.nextInt();
                a[j]=new Pair<>(ar[j][0],ar[j][1]);
            }
            Arrays.sort(a);
           
            int jo=-1,jc=-1,co=-1,cc=-1;
            ar1[0][2]=1;
            for(j=0;j<n;j++)
            {
                ar1[j][0]=a[j].first;
                ar1[j][1]=a[j].second;
            }
            jo=ar1[0][0];
            jc=ar1[0][1];
            j=1;
            int y=0;
            while(co==-1&&j<n)
            {
                if(jc<=ar1[j][0])
                {
                    jc=ar1[j][1];
                    jo=ar1[j][0];
                    ar1[j][2]=1;
                }
                else
                {
                    co=ar1[j][0];
                    cc=ar1[j][1];
                    ar1[j][2]=2;
                }
                j++;
                y=j;
            }
            for(j=y;j<n;j++)
            {
                if(jc<=ar1[j][0])
                {
                    jc=ar1[j][1];
                    jo=ar1[j][0];
                    ar1[j][2]=1;
                }
                else if(cc<=ar1[j][0])
                {
                    co=ar1[j][0];
                    cc=ar1[j][1];
                    ar1[j][2]=2;
                }
                else
                {
                    flag=-1;
                }
            }
            String ans="";
            if(flag==-1){
                ans="IMPOSSIBLE";
            }else{
                for(j=0;j<n;j++){
                    for(k=0;k<n;k++){
                        if(ar[j][0]==ar1[k][0]&&ar[j][1]==ar1[k][1]&&ar1[k][3]==0){
                            if(ar1[k][2]==1){
                                ans+='C';
                            }else{
                                ans+='J';
                            }
                            ar1[k][3]=1;
                            break;
                        }
                    }
                }
            }
           
           
            System.out.println("Case #"+(i+1)+": "+ans);
            i++;
        }
    }
   
}
