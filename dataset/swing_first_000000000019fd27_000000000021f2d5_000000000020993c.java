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
        Integer board[][] = new Integer[5000][5000];
        Boolean rowMap[] = new Boolean[5000];

        Integer rowCount;
        Integer colCount;
        Integer trace;
        
        
        for(Integer k=1; k<=tests; k++){
            trace = 0;
            rowCount = 0;
            colCount = 0;
            Boolean rNeeded = true;
            Integer size = reader.nextInt();
            Integer value;

            for(Integer i=0; i<size; i++){
                Arrays.fill(rowMap, false);
                rNeeded = true;
                for(int j=0; j<size; j++){
                    value = reader.nextInt();
                    board[i][j] = value;
                    if(rNeeded && rowMap[value] == true){
                        rowCount++;
                        rNeeded = false;
                    }
                    else{
                        rowMap[value] = true;
                    }
                }
            }

            for(int i=0; i<size; i++){
                trace += board[i][i];
            }

            for(int i=0; i<size; i++){
                Arrays.fill(rowMap, false);
                for(int j=0; j<size; j++){
                    value = board[j][i];

                    if(rowMap[value] == true){
                        colCount++;
                        break;
                    }
                    else{
                        rowMap[value] = true;
                    }
                }
            }

            System.out.println("Case" + k.toString() + ": " + trace.toString() + " "
             + rowCount.toString() + " " + colCount.toString());
        }
    }
}