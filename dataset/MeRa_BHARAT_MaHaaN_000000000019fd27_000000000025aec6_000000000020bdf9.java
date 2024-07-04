
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
       Scanner kb=new Scanner(System.in);
       
       int T=kb.nextInt();
       for(int t=0;t<T;t++)
       {boolean flag=true;
      
       int n=kb.nextInt();
  ArrayList <Integer>min =new ArrayList();
       ArrayList<Integer> max =new ArrayList();
  ArrayList <Integer>sus1 =new ArrayList();
       ArrayList <Integer>sus2 =new ArrayList();    
       ArrayList<Integer>indexes=new ArrayList();
String str[]=new String[n];
str[0]="C";
       for(int i=0;i<n;i++)
       {
           min.add(kb.nextInt());
           max.add(kb.nextInt());
       
           
       }
       pqr:
       for(int i=0;i<n;i++)
       {  flag=true;
           //System.out.println("i is  "+i);
       sus1.removeAll(sus1);
      sus2.removeAll(sus2);
       indexes.removeAll(indexes);
       for(int j=0;j<n;j++)
       {  if(j!=i)
       {
     
               if(min.get(i)<min.get(j)&&min.get(j) <max.get(i) ||      min.get(i)<max.get(j)&&max.get(j) <max.get(i)  )
               {
                   sus1.add(min.get(j));
                   sus2.add(max.get(j));
           indexes.add(j);
               }
               else if((min.get(j)<min.get(i)&&max.get(j)>max.get(i))  )
               {  
             //      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                   
                  
                         sus1.add(min.get(j));
                   sus2.add(max.get(j));
                   indexes.add(j);
                 
                   
               }
     
       }
       }/////j loop ends
           
    //   System.out.println("sus1 is "+sus1);
       //    System.out.println("sus2 is "+sus2);
          //     System.out.println("indexes= "+indexes);
      
               
               if(indexes.size()!=0)
               {
                 for(int k=0;k<indexes.size();k++)
               {
                    if(str[i]=="C"&&str[indexes.get(k)]==null)
                       str[indexes.get(k)]="J";
                   else if(str[i]=="J"&&str[indexes.get(k)]==null)
                       str[indexes.get(k)]="C";
                  
               }
               }
               else{
               str[i]="C";
               
               }          
       
       ////////////////////////////////////////////
               if(sus1.size()>1)
               {
                for(int h=0;h<sus1.size();h++)
               {
                   for(int g=0;g<sus1.size();g++)
                   {
                       if(sus1.get(g)<sus2.get(h)&&sus2.get(g)>sus2.get(h))
                       {
                           flag=false;
                           break pqr;
                       }
                   }
               }     
               }
      
           /////////////////////////////////////////////////
       }//////i loop ends
       
       
       String fin="";
       if(flag==true)
       { // System.out.println("String is");
       for(int i=0;i<str.length;i++)
       {
          fin=fin+str[i];
       }
        
       }
       else
         fin="IMPOSSIBLE";
         
       
       
           System.out.println("Case #"+(t+1)+": "+fin);
       
       
       
       }
        
        
        
        
        
    }
    
}
