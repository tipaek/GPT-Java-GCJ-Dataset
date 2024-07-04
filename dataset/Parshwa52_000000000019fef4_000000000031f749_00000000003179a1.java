import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int ind=0;
        for (int i2 = 1; i2<= t; ++i2) 
        {
          int u = in.nextInt();
          HashMap<Character,Integer> index=new HashMap<>();
         // HashSet<Character> set=new HashSet<>();
          HashSet<Character> set1=new HashSet<>();
          char ch[]=new char[10];
          int alloc=0;
          long low[]={1,1,1,1,1,1,1,1,1,1};
          long high[]={9,9,9,9,9,9,9,9,9,9};
          long num=0;String str="",sumstr="";
          for(int i1=1;i1<=10000;i1++)
          {
              num=in.nextLong();
              str=in.next();
              if(set1.size()!=10)
              {
                  for(int j=0;j<str.length();j++)
                  {
                      if(set1.contains(str.charAt(j))==false)
                      set1.add(str.charAt(j));
                  }
              }
              if(str.length()==1)
              {
                  if(index.containsKey(str.charAt(0))==false)
                  {
                      ch[alloc]=str.charAt(0);
                      index.put(str.charAt(0),alloc);
                      ind=index.get(str.charAt(0));
                      sumstr+=str.charAt(0);
                      //alloc++;
                      alloc++;
                      if(num<high[ind])
                      {
                          high[ind]=num;
                      }
                      if(low[ind]==high[ind])
                      {
                          for(int i=0;i<10;i++)
                          {
                              if(i!=ind)
                              low[i]++;
                          }
                      }
                      
                  }
                  else
                  {
                      ind=index.get(str.charAt(0));
                      //alloc++;
                      if(num<high[ind])
                      {
                          high[ind]=num;
                      }
                      if(low[ind]==high[ind])
                      {
                          for(int i=0;i<10;i++)
                          {
                              if(i!=ind)
                              low[i]++;
                          }
                      }
                  }
              }
          }
          char ans[]=new char[10];
          char charc=' ';
          int indexr=0;
          for (Map.Entry<Character,Integer> entry : index.entrySet())  
          {
              charc=entry.getKey() ;
              
              indexr=entry.getValue();
              //System.out.println(charc+" "+indexr);
              //if(set1.contains()
              //ans[0]=charc;
              //else
              //{
                  int k=(int)high[indexr];
                 // System.out.println("k="+k);
                  ans[k]=charc;
                  set1.remove(charc);
              //}
          }
          for(char stock : set1){
                 //System.out.println(stock);
                 ans[0]=stock;
                 break;
                }
           String ansstr=new String(ans);
         // int m = in.nextInt();
          System.out.println("Case #" + i2 + ": " + ansstr);
        }
      }
    }