
import java.util.*;
public class Main{

public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x: nums) {
        if (set.contains(x)) return true;
        set.add(x);
    }
    return false;
}

     public static void main(String []args)
     {
       
    
     
     Scanner sc=new Scanner(System.in);
     int t = sc.nextInt() ;
     for( int uu = 0 ; uu<t ; uu++){
       int rows=sc.nextInt();
       int columns=rows ;
       
       //System.out.println("Enter array elements : ");    
        
       int twoD[][]=new int[rows][columns];
        
          
        for(int i=0; i<rows;i++)
         {            
            for(int j=0; j<columns;j++)
            {
                twoD[i][j]=sc.nextInt();
            }
         }
         
         int arr[] = new int[rows] ;
         int ans1 = 0 ;
         int ans2 = 0 ;
         int ans3 = 0 ;
         for(int i=0; i<rows;i++)
         {            
            for(int j=0; j<columns;j++)
            {
                arr[j] = twoD[i][j];
            }
            boolean a =containsDuplicate(arr);
            
            if( a == true)
            {
                ans2 = ans2++ ;
            }
         }
       
       for(int i=0; i<rows;i++)
         {            
            for(int j=0; j<columns;j++)
            {
                arr[j] = twoD[j][i];
            }
            boolean a =containsDuplicate(arr);
            
            if( a == true)
            {
                ans3 = ans3++ ;
            }
         }
         int h= 0 ;
         int y = 0 ;
       while( h<rows && y<rows)
       {
           ans1 = ans1 + twoD[h][y];
           h++;
           y++ ;
       }
       System.out.println(ans1+" "+ans2+" "+ans3);
     
     }
     
     }
}