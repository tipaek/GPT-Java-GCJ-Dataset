import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
  public static void main(String[] args)throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  int t=Integer.parseInt(br.readLine());
  int count=1;
  while(t>0)
  {
    int u=Integer.parseInt(br.readLine());
    HashMap<Character,int[]> map=new HashMap<Character,int[]>();
    HashMap<Character,Integer> Max=new HashMap<Character,Integer>();
    for(int i=1;i<=10000;i++)
    {
      String[] s=br.readLine().split("\\s+");
      if(s[1].length()==s[0].length()&&s[0]!="-1"){
       for(int j=0;j<s[0].length();j++){
         char c=s[1].charAt(j);
        char c1=s[0].charAt(j);
        int v=Character.getNumericValue(c1);
         if(map.containsKey(c)){
          map.get(c)[v]++;
          int max=map.get(c)[v]>Max.get(c)?v:Max.get(c);
          Max.put(c,max);
         }else{
           int[] arr=new int[10];
          arr[v]++;
          Max.put(c,v);
         }
       }
      }
    }
    String D=getString(Max,"AAAAAAAAAA");
    //String[] s=br.readLine().split("\\s+");
  //   int x=Integer.parseInt(s[0]);int y=Integer.parseInt(s[1]);
  //   HashSet<Integer> set=new HashSet<Integer>();
  //   int initx=0,inity=0;
  //   if((x+y)%2==0)
  //   {
  //    System.out.println("Case #"+count+": IMPOSSIBLE");
  //   }else
  //   {
  //     int max=0;
  //     max=Math.abs(x)>Math.abs(y)?x:y;
  //   max=findbin(Math.abs(max));
  //   String[] str=new String[max+1];

  //   int even =x%2==0?x:y;
  //   int odd=x%2!=0?x:y;
  //   int flag=x%2==0?0:1;
  //    int check=even>0?0:1;
  //  str=getEven(Math.abs(even),str,flag,max,check);
  //  check=odd>0?0:1;
  //  str=getOdd(Math.abs(odd),str,flag,max,check);
  // String st=getString(str,max);
// System.out.println(Arrays.toString(str));
 System.out.println("Case #"+count+": "+D);
    }
    t--;
  }
  static String getString( HashMap<Character,Integer> Max,String c){
     for (Map.Entry val : Max.entrySet()) { 
            Character key = (Character)val.getKey(); 
  
            // Add some bonus marks 
            // to all the students and print it 
            int value = (int)val.getValue(); 
            c=c.substring(0, value) + key + c.substring(value + 1);
        } 
    return c;
  }

}
