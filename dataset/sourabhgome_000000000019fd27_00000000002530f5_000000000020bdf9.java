import java.util.*;
import java.io.*;
class Arr implements Comparable<Arr>
{
 public int start;
 public int end;
 public int index;
 Arr(){}
 Arr(int start, int end, int index)
 {
  this.start=start;
  this.end=end;
  this.index=index;
 }
 public int compareTo(Arr a)
 {
  if(start==a.start) return 0;
  else if(start<a.start) return -1;
  else return 1;
 }
}
public class del1
{
 public static void main(String gg[])
 {
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int tests=sc.nextInt();
  int t=0;
  while(t<tests)
  {
   int n,i;
   n=sc.nextInt();
   Arr arr[]=new Arr[n];
   for(i=0;i<n;i++)
   {
    arr[i]=new Arr();
    arr[i].start=sc.nextInt();
    arr[i].end=sc.nextInt();
    arr[i].index=i;
   }
   Arrays.sort(arr);
   int count=0;
   int C[]=new int[2];
   int J[]=new int[2];
   char res[]=new char[n];
   C[0]=arr[0].start;
   C[1]=arr[0].end;
   res[arr[0].index]='C';
   for(i=1;i<n;i++)
   {
    if(arr[i].start>=C[1])
    {
     C[0]=arr[i].start;
     C[1]=arr[i].end;
     res[arr[i].index]='C';
    }
    else if(arr[i].start>=J[1])
    {
     J[0]=arr[i].start;
     J[1]=arr[i].end;
     res[arr[i].index]='J';
    }
    else
    {
     count=1;
     break;
    }
   }
   String str="";
   if(count==0)
   {
    for(i=0;i<n;i++) str+=res[i];
   }
   else
   {
    str="IMPOSSIBLE";
   }
   System.out.println("Case #"+(t+1)+": "+str);
   t++;
  }
 }
}