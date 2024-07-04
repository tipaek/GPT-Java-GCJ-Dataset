import java.util.*;
public class Solution {

    static class pair
    {
        int a,b,l;
        pair(int a,int b,int l)
        {
            this.a=a;
            this.b=b;
            this.l=l;
        }
    }
    static class sorter implements Comparator<pair> {
        @Override
        public int compare(pair o1, pair o2) {
            return o1.a-o2.a;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {

          int n=sc.nextInt();

          ArrayList<pair> al=new ArrayList<>();
          for(int i=0;i<n;i++)
          {
              int t11=sc.nextInt();
              int t2=sc.nextInt();
              pair t1=new pair(t11,t2,i);
              al.add(t1);
          }
          Collections.sort(al, new sorter());
        /*  for(int i=0;i<al.size();i++)
          {
              System.out.println(al.get(i).a+" "+al.get(i).b);
          }*/
          ArrayList<Integer> al1=new ArrayList<>();
          ArrayList<Integer> al2=new ArrayList<>();

          al1.add(0);
          int flag=0;
          for(int i=1;i<al.size();i++)
          {
              int t1=al.get(i).a;
              if(al.get(al1.get(al1.size()-1)).b>t1)
              {
                  if(al2.size()==0) al2.add(i);

                  else if(al.get(al2.get(al2.size()-1)).b>t1)
                  {
                      flag=-1;
                      break;
                  }
                  else
                      al2.add(i);
              }
              else
              {
                 al1.add(i);
              }
          }
          if(flag==-1)
          {
              System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");

          }
          else
          {
              char c1[]=new char[n];

              for(int i=0;i<al1.size();i++)
              {
                  c1[al.get(al1.get(i)).l]='C';
              }
              for(int i=0;i<al2.size();i++)
              {
                  c1[al.get(al2.get(i)).l]='J';
              }
              StringBuilder sb=new StringBuilder("");
              for(int i=0;i<n;i++)
              {
                  sb.append(c1[i]);
              }
              System.out.println("Case #"+(ii+1)+": "+sb.toString());
          }



        }

    }

}
