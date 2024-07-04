import java.util.HashMap;
import java.util.Scanner;
class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int q=0;q<t;q++)
        {

            int n= sc.nextInt();
            int[][]matrix= new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            int totra=0;
            for(int i=0;i<n;i++)
                totra+=matrix[i][i];
            //HashMap<Integer,Integer> map= new HashMap<>();
            int cr=0,cc=0;
            for(int i=0;i<n;i++){
               // map= new HashMap<>();
               for(int j=1;j<n;j++)
               {
                   if(matrix[i][0]==matrix[i][j])
                   {
                       cr=cr+1;
                   }
               }
               
                
            }
            for(int i=0;i<n;i++){
               // map= new HashMap<>();
               for(int j=1;j<n;j++)
               {
                   if(matrix[0][i]==matrix[i][j])
                   {
                       cc=cc+1;
                   }
               }
               
                
            }
            System.out.println("Case #"+(q+1)+": "+totra+" "+cr+" "+cc);
        }
    }


}