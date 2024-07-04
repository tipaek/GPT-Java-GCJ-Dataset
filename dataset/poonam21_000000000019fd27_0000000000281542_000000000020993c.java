import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
class Solution
{
   public static void main(String[] args)
{ 
        Scanner sc=new Scanner(System.in);
       int T=sc.nextInt();
         for(int  p=0;p<T;p++)
         {  
            int sum=0;
           int Matrix=sc.nextInt();
           Set<Integer>hs=new HashSet<>(Matrix);
           int array[][]=new int[Matrix][Matrix];
              for(int i = 0; i < Matrix; i++){

                for(int j = 0; j < Matrix; j++)
 
              {
                  array[i][j] = sc.nextInt();
              }
        }
       for(int i=0,j=0;i<Matrix;i++,j++)
         
         {
            sum=sum+array[i][j];
             }
     int count1 = 0;
    for (int i = 0; i < Matrix; i++) 
     {   
         for (int j = 0; j < Matrix; j++) 
             {
              if(!hs.add(array[i][j]))
        {
                count1++;
            hs.clear();
            break;
          }
         }
     
       hs.clear();
   
       }
   
       int count2 = 0; 
   
       for (int i = 0; i < Matrix; i++) 
 
         {   
           
 for (int j = 0; j < Matrix; j++)
 
            {
 
                if(!hs.add(array[j][i]))
 
               {
             
                     count2++;
      
                     hs.clear();
     
                           break;
               }
 }

            hs.clear();

          }
   System.out.println("Case #"+(p+1)+": "+sum+" "+count1+" "+count2);
 
       }
 
   }
}