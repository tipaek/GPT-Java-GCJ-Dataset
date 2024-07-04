import java.util.*;

 class Vest{
  
  
    public static void main(String[] args){
       
        Scanner sc=new Scanner(System.in);
       
        int t=sc.nextInt();
       
        while(t-->0){
           
            int n=sc.nextInt();
           
            int a[][]=new int[n+1][2*n+1];
            int b[][]=new int[2*n+1][n+1];
           
            boolean visr[]=new boolean[n+1];
            boolean visc[]=new boolean[n+1];
           
            int ct=0,mt=0,k=0;
           
            for(int i=1;i<=n;i++){
               
                for(int j=1;j<=n;j++){
                   
                    int v=sc.nextInt();
                   
                    if(!visr[i]&&a[i][i+v]!=1)
                    a[i][i+v]=1;
                    else if(!visr[i]){
                    visr[i]=true;
                    ct++;
                    }
                   
                    if(!visc[j]&&b[j+v][j]!=1)
                    b[j+v][j]=1;
                    else if(!visc[j]){
                    visc[j]=true;
                    mt++;
                    }
                   
                    if(i==j)
                    k=k+v;
                }
               
            }
           
            System.out.println(k+" "+ct+" "+mt);
        }
       
    }

   
   
  
  
}