import java.util.*;

public class Que1 {
    
    public static void main(String[] args) {
        int N,T,trace[],rows[],cols[];
        String s;
        HashSet<Integer> hs=new HashSet<>();
        
        int a[][]={};
        
        Scanner in=new Scanner(System.in);
        //System.out.println("T");
        T=in.nextInt();
        trace=new int[T];
        rows=new int[T];
        cols=new int[T];
        
        for(int i=0;i<T;i++)
        {
            //System.out.println("N");
            N=in.nextInt();
            String tokens[];
            in.nextLine();
            
            a=new int[N][N];
            
            
            for(int j=0;j<N;j++)
            {

                s=in.nextLine();
                
                int p=0;
                tokens=s.split(" ");
                for(String token: tokens)
                {
                    a[j][p]=Integer.parseInt(token); 
                    p++;
                }
            }
            
            trace[i]=0;
            
            for(int k=0;k<N;k++)
            {
                for(int l=0;l<N;l++)
                {
                    if(k==l)
                        trace[i]=trace[i]+a[k][l];
                }   
            }
            
            
            
            rows[i]=0;
            for(int k=0;k<N;k++)
            {
                hs.clear();
                for(int l=0;l<N;l++)
                {
                    hs.add(a[k][l]);
                }   
                if(hs.size()<N)
                    rows[i]++;
            }
            
            cols[i]=0;
            for(int k=0;k<N;k++)
            {
                hs.clear();
                for(int l=0;l<N;l++)
                {
                    hs.add(a[l][k]);
                }   
                if(hs.size()<N)
                    cols[i]++;
            }
            
            
            
        }
        
        for(int i=0;i<T;i++)
        {
            System.out.print("Case #"+(i+1)+": ");
            System.out.print(trace[i]+" ");
            System.out.println(rows[i]+" "+cols[i]);
        }
    }
}
