import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int t = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0;i<t;i++)
        {
            count++;
            int n = Integer.parseInt(br.readLine());
            int[][] mat = new int[n][n];
            int r=0,c=0,trace=0;

            for(int p =0;p<n;p++)
            {
                String[] line = br.readLine().split(" ");
                for(int q = 0;q<n;q++)
                {
                    mat[p][q] = Integer.parseInt(line[q]);
                }
            }


            for(int p =0;p<n;p++)
       {
            HashSet<Integer> set = new HashSet<>();

          forq:  for(int q = 0;q<n;q++)
            {
               
               if(set.add(mat[p][q]))
               {

               }else{
                    r++;
                    break forq;
               }
            }
            set.clear();
           
        }

        for(int p = 0;p<n;p++)
        {
            HashSet<Integer> stecol = new HashSet<>();
         forcol:   for(int q = 0;q<n;q++)
            {
                if(stecol.add(mat[q][p])){

                }else{
                    c++;
                    break forcol;
                }
            }
            stecol.clear();
        }

        for(int p = 0;p<n;p++)
        {
           
            for(int q = 0;q<n;q++)
            {
                if(p==q)
                {
                    trace = trace+mat[p][q];
                }
            }      
        }

        System.out.println("case #"+count+": "+trace+" "+r+" "+c);

        }

        br.close();
  
    }

}