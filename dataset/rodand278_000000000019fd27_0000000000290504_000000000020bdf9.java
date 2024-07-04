import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args)throws Exception {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());int c=0;
while(t>0){
c++;
int n=Integer.parseInt(br.readLine());
ArrayList<Schedule> list=new ArrayList<Schedule>();
HashMap<Integer,String> hm=new HashMap<Integer,String>();

//Goes in the list

for(int i=0;i<n;i++)
{
  String[] s=br.readLine().split("\\s+");
  list.add(new Schedule(Integer.parseInt(s[0]),i+1,"",true,false));
  list.add(new Schedule(Integer.parseInt(s[1]),i+1,"",false,true));
}

//sort the list
Collections.sort(list,new ValComparator());  
// System.out.println(list);
StringBuilder newString=new StringBuilder();
boolean C=true,J=true,flag=true;
for(int i=0;i<list.size();i++)
{
  if(list.get(i).start){
    if(C||J)
  {
    if(C){
       C=false;
       String st="C";
       hm.put(list.get(i).task,st);
    }else{
       J=false;
       String st="J";
       hm.put(list.get(i).task,st);
     //  System.out.println(i+1);
    }
  }else
  {
     newString.replace(0,newString.length(),"IMPOSSIBLE");
     flag=false;
     break;
  }
  }else
  {
    Integer index=list.get(i).task;
    //System.out.println(index);
    String str=hm.get(index);
    if("C".equals(str))
    {C=true;}else
    {J=true;}
  }
}
if(flag)
{
  for(int i=0;i<n;i++)
{
  Integer in=i+1;
 // System.out.println(in);
  newString.append(hm.get(in));
}
}
System.out.println("Case #"+c+": "+newString);
t--;

}

}

}
class Schedule{
  int val=0,task=-1;
  String worker="";
  boolean start=true,end=true;
  
  public Schedule(int v,int t,String w,boolean s,boolean e){
     val=v;task=t;
     worker=w;
     start=s;end=e;
  }

}
class ValComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Schedule s1=(Schedule)o1;  
Schedule s2=(Schedule)o2;  
  
if(s1.val==s2.val){
   if(s1.start&&s2.end){
    return 1;
   }else if(s2.start&&s1.end){
    return -1;
   }else
   {
     return 0;
   }
}
else if(s1.val>s2.val)  
return 1;  
else  
return -1;   
} 

}  
