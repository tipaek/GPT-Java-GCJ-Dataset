import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
     int n = in.nextInt(); 
     ArrayList<act> ar = new ArrayList<act>();
     
     char res[]=new char[n];
     for(int j=0;j<n;j++)
     {
       ar.add(new act(in.nextInt(),in.nextInt(),j));
}

 Collections.sort(ar, new Sortbyend());
 
int c=0,j=0;int cend=0;int q=0;
for(int k=0;k<ar.size();k++)
{
 if(c<=ar.get(k).start) 
 {
     res[ar.get(k).pos]='C';
     c=ar.get(k).end;
     
}
else if(j<=ar.get(k).start)
{
  res[ar.get(k).pos]='J';
     j=ar.get(k).end;  

}
else
{
    System.out.print("Case #"+i+": ");
    System.out.println("IMPOSSIBLE");
    q=1;
    break;
}
}
if(q==0)
{
     System.out.print("Case #"+i+": ");
    for(int p=0;p<n;p++)
    System.out.print(res[p]);
    System.out.println();
}
}
}
}


class Sortbyend implements Comparator<act> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(act a,act b) 
    { 
        return a.end - b.end; 
    }
    
}
 

class act
{
  int start;
  int end;
  int pos;
  public act(int start,int end,int pos) 
    { 
        this.start = start; 
        this.end = end;
        this.pos=pos;
  
    } 
}