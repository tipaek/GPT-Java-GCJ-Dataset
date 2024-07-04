import java.io.*;
class vestigium
{   
    int M[][];
    void matrix(int N,int x)throws IOException
    {
        DataInputStream in=new DataInputStream(System.in);
        M=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                M[i][j]=Integer.parseInt(in.readLine());
                if(M[i][j]<1 && M[i][j]>N)
                    j--;
            }
        }
        int k=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j)
                    k+=M[i][j];
            }
        }
        int r=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               if(M[i][j]==M[i][j+1] && (j+1)<N)
                    r++;
            }
        }
        int c=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               if(M[j][i]==M[j][i+1] && (i+1)<N)
                    c++;
            }
        }
        System.out.println("Case #"+i+": "+k+" "+r+" "+c);
    }
    public static void main(String args[])throws IOException
    {
        int T,N;
        DataInputStream in=new DataInputStream(System.in);
        vestigium obj=new vestigium();
        T=Integer.parseInt(in.readLine());
        if(T>=1 && T<=100)
        {
            for(int i=1;i<=T;i++)
            {
                N=Integer.parseInt(in.readLine());
                if(N>=2 && N<=100)
                    obj.matrix(N,i);
            }
        }
    }
}