import java.io.*;
import java.util.*;

class pair{
    int x,y;
    pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
 class Solution {

    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x=1;
        while(t-->0)
        {
            System.out.print("Case #"+x+": ");
            int n = sc.nextInt();
            boolean flag2 = true;
            ArrayList<pair> a = new ArrayList<pair>();
            for(int k=0;k<n;k++)
            {
                
                int start = sc.nextInt();
                int end = sc.nextInt();
                pair p = new pair(start,end);
                a.add(p);
            }
            ArrayList<pair> b = (ArrayList)a.clone();
            Collections.sort(b, new Comparator<pair>() { 
            @Override public int compare(pair p1, pair p2) 
            { 
                return p1.x - p2.x; 
            } 
        }); 
           int pc =0,pj =0;
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                pair p = b.get(i);
                int start = p.x;
                if(start>=pc)
                {
                    arr[i]="C";
                    pc = p.y;
                }
                else if(start>=pj)
                {
                    arr[i] = "J";
                    pj = p.y;
                }
                else
                {
                    flag2 = false;
                }
            }
            if(!flag2)
                System.out.println("IMPOSSIBLE");
            else
            {
                for(int i=0;i<n;i++)
                {
                    int x1 = a.get(i).x;
                    int y1 = a.get(i).y;
                    for(int j=0;j<n;j++)
                    {
                        pair q = b.get(j);
                        if(q.x==x1&&q.y==y1&&(!(arr[j].equals("A"))))
                        {
                            System.out.print(arr[j]);
                            arr[j] = "A";
                            break;
                        }
                    }
                }
                System.out.println();
            }
            x++;
        }
        
    }
}
