import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        Integer tests = reader.nextInt();
        Integer board[][] = new Integer[100][100];
        Integer rowMap[] = new Integer[100];
        Integer colMap[] = new Integer[100];
        Integer rowCount;
        Integer colCount;
        Integer trace;
        String outString;

        for(Integer i=1; i<=tests; i++){
            trace = 0;
            rowCount = 0;
            Boolean rNeeded = true;
            colCount = 0;

            Integer size = reader.nextInt();
            Integer value;

            for(Integer j=0; j<size; j++){
                Arrays.fill(rowMap, 0);
                rNeeded = true;
                for(int k=0; k<size; k++){
                    board[j][k] = reader.nextInt();
                    if(rowMap[board[j][k]] == 1 && rNeeded){
                        rowCount++;
                        rNeeded = false;
                    }
                    else{
                        rowMap[board[j][k]] = 1;
                    }
                }
            }

            for(int j=0; j<size; j++){
                trace += board[j][j];
            }

            for(int j=0; j<size; j++){
                Arrays.fill(colMap, 0);
                for(int k=0; k<size; k++){
                    value = board[k][j];

                    if(colMap[value] == 1){
                        colCount++;
                        break;
                    }
                    else{
                        colMap[value] = 1;
                    }
                }
            }

            System.out.println("Case" + i.toString() + ": " + trace.toString() + " "
             + rowCount.toString() + " " + colCount.toString());
        }
    }
}