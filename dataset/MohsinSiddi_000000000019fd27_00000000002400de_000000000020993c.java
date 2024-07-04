import java.io.*; 
import java.util.*; 
class Main {
    
     public static int countRepNumbersInCol(int[][] ar, int col,int c2)
    {
        int n=ar.length;
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(ar[i][col]==ar[j][col])
             c2++;
             
            if(c2==1)
            return c2;
        }
        
    }
    return 0;
    }
    
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       for(int id=0;id<t;id++){
       int n=sc.nextInt();
       int[][] ar=new int[n][n];
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               ar[i][j]=sc.nextInt();
           }
       }
       int sum=0;
       int c1=0;
       int c2=0;
        for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++){
               if(i==j){
                sum = sum + ar[i][j];
               }
           }
       }
       
       for(int i=0;i<n;i++)
       {
           int col=i;
           c2+=countRepNumbersInCol(ar,col,0);
       }
       
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++)
                {
                    if(ar[i][j]==ar[i][k]){
                    c1++;
                    break;
                    }
                 }
                 if(c1!=0)
                    break;
           }
       }
       System.out.println("Case #"+id+": "+sum+" "+c1+" "+c2);
       }
    }
}