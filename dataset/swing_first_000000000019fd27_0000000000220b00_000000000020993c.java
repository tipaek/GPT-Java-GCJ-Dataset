import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
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
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        Boolean hasNext(){
            try{
                return br.ready();
            } catch(Exception e){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tests = reader.nextInt();

        Long rowCount;
        Long colCount;
        Long trace;
        Integer size;

        HashSet<Long> testRepeats = new HashSet<>();
        ArrayList<List<Long>> matrix = new ArrayList<>();

        for(Integer k=1; k<=tests; k++){
            matrix.clear();
            rowCount = 0L;
            colCount = 0L;
            trace = 0L;

            size = reader.nextInt();

            for(int i=0; i<size; i++){
                matrix.add(new ArrayList<Long>());
                for(int j=0; j<size; j++){
                    matrix.get(i).add(reader.nextLong());
                }
            }

            for(int i=0; i<size; i++){
                trace += matrix.get(i).get(i);
            }

            
            for(int i=0; i<size; i++){
                testRepeats.clear();
                for(int j=0; j<size; j++){
                    testRepeats.add(matrix.get(i).get(j));
                }
                if(testRepeats.size() < size) rowCount++;
            }

            for(int i=0; i<size; i++){
                testRepeats.clear();
                for(int j=0; j<size; j++){
                    testRepeats.add(matrix.get(j).get(i));
                }
                if(testRepeats.size() < size) colCount++;
            }
            
            
            System.out.println("Case " + k.toString() + ": " +
                    trace.toString() + " " + rowCount.toString() + " " + colCount.toString());
        }
    }
}
