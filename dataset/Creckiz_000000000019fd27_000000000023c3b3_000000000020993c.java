
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
class Solution {

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        int next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    static class RecurrenceCount{
        HashSet<Integer> hs;


        public RecurrenceCount()
        {
            hs = new HashSet<>();
        }

        public void add(int data){
           hs.add(data);
        }

        public boolean hasRecurrence(int size){
            return (size!=hs.size())?true:false;
        }

    }

    public static void main(String[] args) {

        FastReader f=new FastReader();

        int t=f.next();

        while (t-->0){
            int m=f.next();

            int matrix[][]=new int[m][m];
            RecurrenceCount r;
            int count=0,cRow=0,cCol=0;

            for (int i=0;i<m;i++){
                r=new RecurrenceCount();
                for(int j=0;j<m;j++){
                    matrix[i][j]=f.next();
                    r.add(matrix[i][j]);
                    if(i==j)
                        count+=matrix[i][j];
                }
                if(r.hasRecurrence(m))
                    cRow++;
            }

            for (int i=0;i<m;i++){
                r=new RecurrenceCount();
                for(int j=0;j<m;j++){
                    r.add(matrix[j][i]);
                }

                if(r.hasRecurrence(m))
                    cCol++;
            }

            System.out.println("Case #"+(t+1)+": "+count+" "+cRow+" "+cCol);

        }
    }
}
