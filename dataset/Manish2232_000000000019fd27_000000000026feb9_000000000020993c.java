import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int totalSlots= Integer.parseInt(br.readLine());

        List<List<Integer>> answers=new ArrayList<>();

        for (int a=0;a<totalSlots;a++)
        {
            List<List<Integer>> matrix=new ArrayList<>();
            int matrixRange=Integer.parseInt(br.readLine());
            int rowDuplicate=0;
            int columnDuplicate=0;

            for(int b=0;b<matrixRange;b++)
            {
                String[] matrixValues=br.readLine().split(" ");
                List<Integer> innerList=new ArrayList<>();

                for (String matrixValue : matrixValues) {
                    int temp=Integer.parseInt(matrixValue);
                    innerList.add(temp);

                }
                matrix.add(innerList);
            }


            // logic start from here
            //finding row duplicate

            for (int c=0;c<matrix.size();c++) {
                Set<Integer> mySet = new HashSet<>(matrix.get(c));

                if(mySet.size()!=matrix.get(c).size()){
                    rowDuplicate++;
                }
                mySet.clear();
            }

            // finding column duplicates
            for (int c=0;c<matrix.size();c++) {
                Set<Integer> mySet = new HashSet<>();

                for (int d = 0; d < matrix.size(); d++) {
                    mySet.add(matrix.get(d).get(c));
                }

                if(mySet.size()!=matrix.get(c).size()){
                    columnDuplicate++;
                }

                mySet.clear();
            }

            // finding trace
            int offset=0;
            int trace=0;
            for (int c=0;c<matrix.size();c++) {
                trace=trace+matrix.get(c).get(offset++);


            }
            List<Integer> answer=new ArrayList<>();
            answer.add(trace);
            answer.add(rowDuplicate);
            answer.add(columnDuplicate);
            answers.add(answer);
        }


        for (int i = 0; i < answers.size(); i++) {
            System.out.println(String.format("Case #%d: %d %d %d",i,answers.get(i).get(0),answers.get(i).get(1),answers.get(i).get(2)));
        }


    }
}