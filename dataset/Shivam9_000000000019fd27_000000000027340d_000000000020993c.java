import java.util.Scanner;

public class Vestigium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        
        int x = sc.nextInt();
        
        int k[] = new int[x];
        int r[] = new int[x];
        int c[] = new int[x];
        int rek = 0, rer = 0, rec = 0,check=0,checker=0;
        
        for(int y=0;y<x;y++)
        {    
            int matLen = sc.nextInt();
            int ar[][] = new int[matLen][matLen];
            for(int i=0;i<matLen;i++)
            {
                for(int j=0;j<matLen;j++)
                {
                    ar[i][j] = sc.nextInt();
                }
                
                //Matching rows
                for(int a=0;a<matLen;a++)
                {
                    int l = a+1;
                    for(int b=l;b<matLen;b++)
                    { 
                        if(ar[i][a]==ar[i][b] && a!=b)
                        {
                            rer++;
                            check++;
                            break;
                        }
                    }
                    if(check!=0)
                    {
                        check=0;
                        break;
                    }
                }
            }
            //Matching columns
            for(int d=0;d<matLen;d++)
            {    
                for(int a=0;a<matLen;a++)
                {
                    int l = a+1;
                    for(int b=l;b<matLen;b++)
                    { 
                        if(ar[a][d]==ar[b][d] && a!=b)
                        {
                            
                            rec++;
                            checker++;
                            break;
                        }
                    }
                    
                    if(checker!=0)
                    {
                        checker=0;
                        break;
                    }
                }
            }
            for(int z=0;z<matLen;z++)
            {
                rek += ar[z][z];
                
            }
            k[y] = rek;
            r[y] = rer;
            c[y] = rec;
            rek = 0;
            rer = 0;
            rec = 0;
        }
        
        
        for(int g=0;g<x;g++)
        {
            int h = g + 1;
            System.out.println("Case #"+h+": "+k[g]+" "+r[g]+" "+c[g]);
        }
    }
    
}
