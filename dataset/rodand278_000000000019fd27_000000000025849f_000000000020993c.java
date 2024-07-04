import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args)throws Exception {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());int c=0;
while(t>0){
c++;
int n= Integer.parseInt(br.readLine());
ArrayList<HashSet<String>> HR = new ArrayList<HashSet<String>>();
ArrayList<HashSet<String>> HC = new ArrayList<HashSet<String>>();
HashSet<Integer> duplicateColumn=new HashSet<Integer>();
int trace=0,duplicaterow=-1,countrow=0; 
  for(int i=0;i<n;i++)
  {
   String[] s=br.readLine().split("\\s+");
   trace+=Integer.parseInt(s[i]);
   HR.add(new HashSet<String>());
     for(int j=0;j<n;j++){
        if(i==0)
        {HC.add(new HashSet<String>());}
        HR.get(i).add(s[j]);
        HC.get(j).add(s[j]);
        if(duplicaterow!=i)
        {
         boolean row = checkLength(HR.get(i),j);
         if(row){duplicaterow=i;countrow++;}
        }
        if(!duplicateColumn.contains(j))
        {
            boolean col = checkLength(HC.get(j),i);
             if(col){duplicateColumn.add(j);}
        }
     }
  }
  System.out.println("Case #"+c+": "+trace+" "+countrow+" "+duplicateColumn.size());
  t--;
}
  }
public static boolean checkLength(HashSet<String> h,int n)
{
  boolean b=true;
  b=h.size()==n+1?false:true;
  return b;
}

}