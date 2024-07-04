import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Vestigium{
    public static void main(String args[]) throws IOException
    {
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    int T= Integer.parseInt(br.readLine());
    int y=1;
    while(T>0)
    {
        int m=Integer.parseInt(br.readLine());
        String b[]=new String[m];
        String b1[][]=new String[m][m];
        int a[][]=new int[m][m];
        int row[]=new int[m];
        int col[]=new int[m];
        int k=0,val,r,c;
        for(int i=0;i<m;i++)
        {
            b[i]=br.readLine();
        }
        for(int i=0;i<m;i++)
        {
          b1[i]=b[i].split(" ");
        }
        for(int i=0;i<m;i++)
        {
        for(int j=0;j<m;j++)
        {
            a[i][j]=Integer.parseInt(b1[i][j]);
        }
            
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==j)
                 k+=a[i][j];   
            }
        }
        for(int i=0;i<m;i++)
        {
            r=0;
            for(int j=0;j<m-1;j++)
            {
                val=a[i][j];
                for(int l=j+1;l<m;l++)
                {
                    if(val == a[i][l]){
                        r++;
                        
                    }
                        
                }
            }
            row[i]=r;
        }
        r=0;
        for(int i=0;i<m;i++)
        {
        if(row[i]!=0)
          r++;  
        }
        //columne
        for(int i=0;i<m;i++)
        {
            c=0;
            for(int j=0;j<m-1;j++)
            {
                val=a[j][i];
                for(int l=j+1;l<m;l++)
                {
                    if(val == a[l][i]){
                        c++;
                        
                    }
                        
                }
            }
            col[i]=c;
        }
        c=0;
        for(int i=0;i<m;i++)
        {
        if(col[i]!=0)
          c++;  
        }
        System.out.println("Case #"+y+": "+k+" "+r+" "+c);
        y++;
        T--;
        //br.read();
    }
    }
    
}