import java.util.*;
public class Solution {
     public static char person(char p)
        {
            return p== 'J' ? 'C' : 'J';
        }
      public static boolean problem(int a[],int b[])
     {
         return a[1]>b[0];
     }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=1;i<=test;i++)
        {
         int val=sc.nextInt();
         int mat[][]=new int[val][2];
         int matsorted[][]=mat.clone();
         char person='J';
         char chars[]=new char[val];
         Stack<int[]> jstack=new Stack<>();
         Stack<int[]> cstack=new Stack<>();
         boolean ans=false;
         Map<int[],Integer> map=new HashMap<>();
         for(int j=0;j<mat.length;j++)
         {
             for(int k=0;k<mat[j].length;k++)
             {
                 mat[j][k]=sc.nextInt();
             }
             map.put(mat[j],j);
         }
         Arrays.sort(matsorted,new Comparator<int[]>(){
         @Override
         public int compare(int a[],int b[])
         {
             return a[0]-b[0];
         }
         
         });
         for(int j=0;j<matsorted.length;j++)
         {
             chars[map.get(matsorted[j])]=person;
             if(j<matsorted.length-1 && problem(matsorted[j],matsorted[j+1]))
             {
                 if(person=='J')
                 {
                     jstack.push(matsorted[j]);
                     person=person(person);
                     if(!cstack.isEmpty() && problem(cstack.peek(),matsorted[j+1]))
                     {
                         ans=true;
                         break;
                     }
                 }
                 else
                 {
                     cstack.push(matsorted[j]);
                     person=person(person);
                      if(!jstack.isEmpty() && problem(jstack.peek(),matsorted[j+1]))
                     {
                         ans=true;
                         break;
                     }
                 }
             }
             else
             {
                 if(person=='J')
                     jstack.push(matsorted[j]);
                 else
                     cstack.push(matsorted[j]);
             }
         }
            System.out.println("Case #"+i+": "+(ans ?"IMPOSSIBLE":new String(chars)));
         
        }
        
    }
    
    
    
}