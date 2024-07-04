import java.util.*;
public class JavaApplication137 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc= new  Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0)
        {
            
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                        sum=sum+a[i][j];
                }
            }
           
            int ro=0;
              for(int i=0;i<n;i++)
            {
                 HashMap<Integer, Integer> m1=new HashMap<>();
                for(int j=0;j<n;j++)
                {
                    //System.out.println(a[i][j]);
                    if(m1.containsKey(a[i][j]))
                    {
                        //System.out.println("c");
                        ro++;
                        j=n;
                    }
                    else
                        m1.put(a[i][j],0);
                }
            }
              int co=0;
               for(int i=0;i<n;i++)
            {
                 HashMap<Integer, Integer> m2=new HashMap<>();
                for(int j=0;j<n;j++)
                {
                    //System.out.println(a[j][i]);
                    if(m2.containsKey(a[j][i]))
                    {
                       // System.out.println(" c");
                        co++;
                        j=n;
                    }
                    else
                        m2.put(a[j][i],0);
                }
            }
               System.out.println(sum+" "+ro+" "+co);
            
        }
                
    }
    
}