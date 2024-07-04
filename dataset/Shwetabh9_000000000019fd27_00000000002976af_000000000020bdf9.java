import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i =1;i<=t;i++) {
           int n=sc.nextInt();
           int[] a= new int[1441];
//            for(int x=0;x<1441;x++)
//            {
//                a[x]=-1;
//            }
           Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            boolean final_answer=false;
            String[] pos=new String[n];
           for (int j=0;j<n;j++)
           {
               int start=sc.nextInt();
               StringBuilder s=new StringBuilder();
               s.append(start);
               s.append(' ');
               a[start]++;
               int end=sc.nextInt();
               s.append(end);
               pos[j]=s.toString();
               ArrayList<Integer> temp;
               if(map.containsKey(start))
               {
                   temp=map.get(start);
                   temp.add(end);
                   map.put(start,temp);
               }
               else
               {
                   temp=new ArrayList<>(2);
                   temp.add(end);
                   map.put(start,temp);
               }
           }
//            for (int j=0;j<n;j++)
//            System.out.println(pos[j]);
            int C_till=-1;
            int J_till=-1;
            Map<String, Character> ans = new HashMap<>();
            boolean C=false;
            boolean J=false;
            for(int x=0;x<=1440;x++)
           {
               if(a[x]>=2)
               {
                   ArrayList<Integer> temp=map.get(x);
                   int point=0;
                   for(int k:temp)
                   {
                       StringBuilder s=new StringBuilder();
                       if(temp.indexOf(k)==temp.lastIndexOf(k))
                           point++;
                       if(point==3)
                       {
                           final_answer=true;
                           break;
                       }
                       s.append(x);
                       s.append(' ');
                       s.append(k);
                       if(!C || (C_till <= x))
                       {
                           C=true;
                           C_till=k;
                           ans.put(s.toString(),'C');
                           if(x==k)
                               C=false;
                       }
                       else if(!J||J_till<=x)
                       {
                           J=true;
                           J_till=k;
                           ans.put(s.toString(),'J');
                           if(x==k)
                               J=false;
                       }
                       else
                       {
                           final_answer=true;
                           break;
                       }
                   }
               }
               StringBuilder s=new StringBuilder();
               if(a[x]==1)
               {
                   ArrayList<Integer> temp=map.get(x);
                   int p=temp.get(0);
                   s.append(x);
                   s.append(' ');
                   s.append(p);
                   if(!C||C_till<=x)
                   {
                       C=true;
                       C_till=p;
                       ans.put(s.toString(),'C');
                   }
                   else if(!J||J_till<=x)
                   {
                       J=true;
                       J_till=p;
                       ans.put(s.toString(),'J');
                   }
                   else
                   {
                       final_answer=true;
                       break;
                   }
               }
           }
            StringBuilder answer=new StringBuilder();
            System.out.print("Case #"+i+": ");
            if(!final_answer) {
                for(String v:pos)
                {
                    answer.append(ans.get(v));
                }
                System.out.println(answer);
            }
            else System.out.println("IMPOSSIBLE");
        }
    }
}
