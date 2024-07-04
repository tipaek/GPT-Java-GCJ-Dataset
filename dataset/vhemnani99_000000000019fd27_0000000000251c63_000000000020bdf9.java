import java.util.*;
import java.io.*;
class P3
{
    static void activity(int a[][], int n, int t) 
    {
        int je = 0, ce = 0;
        int i, j; 
        char y[] = new char[n];
        final int col = 0;
        int q[][]= new int[n][4];
        for ( i = 0; i < n; i++) 
        {
            q[i][0]=a[i][0];
            q[i][1]=a[i][1];
            q[i][2] = i;
        }   

        Arrays.sort(q, new Comparator<int[]>() 
            { 
                @Override              
                public int compare(final int[] entry1,final int[] entry2) 
                { 
                    if (entry1[col] > entry2[col]) 
                        return 1; 
                    else
                        return -1; 
                } 
            });   
        System.out.println();
        int cameron = 0;
        int jamie = 0;
        StringBuffer sb = new StringBuffer();
        for(i = 0; i < n; i++)
        {
            int sta = q[i][0];
            int end = q[i][1];
            if(cameron<=sta) {
                q[i][3] = 0;
                cameron = end;
            }
            else {
                if(jamie<=sta) {
                    q[i][3] = 1;
                    jamie = end;
                }
                else {
                    System.out.println("Case #"+t+": "+"IMPOSSIBLE"+"\n");

                }
            }
        }  
        Arrays.sort(q, new Comparator<int[]>(){
                public int compare(int a1[], int a2[]) {
                    if(a1[2]>a2[2])
                        return 1;
                    else
                        return -1;
                }});

        
      
        for(i=0 ; i<q.length ; i++) {
            if(q[i][3]==0) sb.append('C');
            else sb.append('J');
        }

        System.out.println("Case #"+t+": "+sb.toString()+"\n");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
       
        int T = sc.nextInt();

        for (int TItr = 0; TItr < T; TItr++) 
        {
            int n = sc.nextInt();

            int a[][]=new int[n][2];

            for (int i = 0; i < n; i++) 
            {
                for(int j = 0; j < 2; j++)
                {
                    a[i][j] = sc.nextInt();
                }
            }

            activity(a,n,TItr);
        }
    }
}
