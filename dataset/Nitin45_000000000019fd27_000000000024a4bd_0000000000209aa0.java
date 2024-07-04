import java.util.Scanner;

class Solution { 
    static int [] [] Latin(int n,int d) 

    { 
   int a [][]=new int[n][n];
   
        int k = n+1; 
        int r =0;
        int x;        
        for (int i = 0; i <n; i++) 

        { 
          
               int temp = k; 
            
              for( r=0;temp<=n;r++){
                if(temp==1)
              a[i][r]=d;
               else if(temp==d)
              a[i][r]=1;
              else
 
                a[i][r]=temp;
                
                temp++;
                 }
                 
            for (int j = r; j <n; j++) {
              
                x=j+1-i;

              if(x==1)
              a[i][j]=d;
               else if(x==d)
              a[i][j]=1;
              else
                a[i][j]=j+1-i;}
                  k--;    
        } 
        return a;
    }  


    public static void main (String[] args) 

    { 
      Scanner sc=new Scanner(System.in);
      

        int t = sc.nextInt();
        int p=0;
        boolean flag ;
       for(int i=0;p<t;p++){
         flag=true;
         int n =sc.nextInt();
         int trace =sc.nextInt();
         for(int j=1;j<=n;j++){
           
         
           if(n*j==trace){
           int d =j;
           flag =false;
           System.out.println("Case #"+(p+1)+": "+"POSSIBLE");
            int a [] []= Latin(n,d); 
           for( i =0;i<n;i++)
       {
          for(j=0;j<n;j++)
          System.out.print(a[i][j]+" ");
         System.out.println();
       }
       System.out.println();
         break;
          
           }
           
         }
         if(flag)
         
       System.out.println("Case #"+(p+1)+": "+"IMPOSSIBLE");
       }

    }
}