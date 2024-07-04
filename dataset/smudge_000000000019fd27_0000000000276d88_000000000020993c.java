import java.io.*;
import java.util.*;
import java.math.*;


public class Solution {


    public String getTheAnswer(int[][] matrix)
    {
        int theTrace = 0;

        for(int r=0; r < matrix.length; r++) {
            theTrace = theTrace + matrix[r][r];
        }

        int numRepRows = 0;

        for(int r=0; r < matrix.length; r++)
        {
            Hashtable<Integer, Integer> tab = new Hashtable<Integer,Integer>();
            for(int c = 0; c < matrix.length; c++)
            {
                Integer num = tab.get(new Integer(matrix[r][c]));
                if(num != null) {
                    numRepRows++;
                    break;
                }else
                    {
                        tab.put(new Integer(matrix[r][c]), new Integer(matrix[r][c]));
                    }

            }

        }

        int numRepCols = 0;
        for(int c=0; c < matrix.length; c++)
        {
            Hashtable<Integer, Integer> tab = new Hashtable<Integer,Integer>();
            for(int r = 0; r < matrix.length; r++)
            {
                Integer num = tab.get(new Integer(matrix[r][c]));
                if(num != null) {
                    numRepCols++;
                    break;
                }else
                {
                    tab.put(new Integer(matrix[r][c]), new Integer(matrix[r][c]));
                }

            }

        }

        return Integer.toString(theTrace) + " " + Integer.toString(numRepRows) + " " + Integer.toString(numRepCols);

    }


    public static void main(String[] args) {




        // TODO code application logic here
        Solution ov = new Solution();
        try
        {
           // BufferedReader input =  new BufferedReader(new FileReader(args[0]));
            BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            // FileWriter writer = new FileWriter("output.txt", false);
            //    BufferedWriter bufferedWriter = new BufferedWriter(writer);



            int numT = Integer.parseInt(input.readLine());

            for(int i = 0; i < numT; i++)
            {
                //System.err.println("Doing case "+(i+1));
                StringTokenizer tok = new StringTokenizer(input.readLine(), " ");
                int N = Integer.parseInt(tok.nextToken());

                int [][] matrix = new int[N][N];

                for(int n=0; n < N; n++ )
                {
                    tok = new StringTokenizer(input.readLine(), " ");
                    for(int c=0; c < N; c++)
                    {
                        matrix[n][c] = Integer.parseInt(tok.nextToken());
                    }

                }


                // String answer = ov.getMinimumFlips(panString, flipperSize);
                String result = ov.getTheAnswer(matrix);
                System.out.println("Case #"+(i+1)+": "+result);
                //bufferedWriter.newLine();


            }

            input.close();
            //bufferedWriter.close();

        }
        catch(Exception e)
        {
            System.err.println(e);
            e.printStackTrace();

        }



    }
}
