import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        for(int z=0;z<T;z++)
        {
            result.append("Case #");
            int N = Integer.parseInt(reader.readLine());
            int [][]M = new int[N][3];

            //array filling
            for(int i=0;i<N;i++)
            {
                String []v = reader.readLine().split(" ");
                for(int j=0;j<2;j++)
                {
                    M[i][j] = Integer.parseInt(v[j]);
                }
                M[i][2] = i;
            }

            //sorting
            for(int i=0;i<N;i++)
            {
                int min = i;
                for(int j=i+1;j<N;j++)
                {
                    if(M[j][0]<M[min][0])
                        min = j;
                }
                int []temp = M[min];
                M[min] = M[i];
                M[i] = temp;
            }


            int []done = new int[N];
            int [][]process = {{-1,-1},{-1,-1}};
            int current = 0;
            for(int i=0;i<N;i++)
            {
                boolean notFound = true;
                for(int j=0;j<2;j++)
                {
                    if(i==0||current==done[i-1])
                    {
                        if(M[i][1]<process[current][0]||M[i][0]>process[current][1]) {
                            process[current] = M[i];
                            done[i] = current;
                            notFound = false;
                            break;
                        }
                        else {
                            current++;
                            if(current==2)
                                current = 0;
                        }
                    }
                    else
                    {
                        if(M[i][0]>=process[current][1]) {
                            process[current] = M[i];
                            done[i] = current;
                            notFound = false;
                            break;
                        }
                        else {
                            current++;
                            if(current==2)
                                current = 0;
                        }
                    }
                }
                if(notFound) {
                    current = -1;
                    break;
                }
            }


            result.append(z+1);
            result.append(": ");
            if(current==-1)
            {
                result.append("IMPOSSIBLE\n");
                continue;
            }


            //sorting
            for(int i=0;i<N;i++)
            {
                int min = i;
                for(int j=i+1;j<N;j++)
                {
                    if(M[j][2]<M[min][2])
                        min = j;
                }
                int []t = M[min];
                M[min] = M[i];
                M[i] = t;

                int temp = done[min];
                done[min] = done[i];
                done[i] = temp;
            }

            for(int i:done) {
                if(i==0)
                    result.append('C');
                else
                    result.append('J');
            }
            result.append("\n");
        }
        System.out.print(result.toString().trim());
    }
}
