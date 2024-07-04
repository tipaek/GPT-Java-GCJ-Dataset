 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          
          char[] s = in.nextLine().toCharArray();
          Node root = new Node(s[0],s[0]-'0');
          Node end = new Node('-',0);
          Node aux = root;
          StringBuilder sb = new StringBuilder();
          for(int j=1;j<s.length;j++)
          {
              Node n = new Node(s[j],s[j]-'0');
              aux.next = n;
              aux = n;
          }
          aux.next = end;
          aux = root;
          
          for(;aux != null;aux = aux.next)
          {
              int openParentesis=0;
              if(aux.closingParentesis>0)
                for(int k=0;k<aux.closingParentesis;k++)sb.append(")");

              
              openParentesis = aux.val;
              
              for(int k=0;k<aux.val;k++)sb.append("(");
              if(aux != end)sb.append(aux.dig);
              if(aux.val==0)continue;
              aux.val = 0;
              for(Node next = aux.next;next!=null;next = next.next)
              {
                  if(next == end)
                  {
                	  end.closingParentesis += openParentesis;
                	  break;
                  }
                  if(next.val < openParentesis)
                  {
                      next.closingParentesis += openParentesis-next.val;
                      openParentesis = next.val;
                      if(openParentesis==0)break;
                  }
                  next.val -= openParentesis;
              }
          }
          
          
          System.out.println("Case #"+i+": "+sb.toString());
          
        }
      }
      
     static class Node
     {
         char dig;
         int val;
         int closingParentesis;
         Node next;
         Node(char d, int v)
         {
             dig = d;
             val = v;
         }
         
         void addBefore(Node n)
         {
             n.next = next;
             next = n;
         }
         
     }
      
    }
    
    