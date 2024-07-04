import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String checkSchedule(int[][] oldArray, int[][] array)
    {
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(final int[] entry1,
                               final int[] entry2) {

                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });

        ArrayList<String> cList = new ArrayList<>();
        ArrayList<String> jList = new ArrayList<>();

        Integer prevCEndTime = 0;
        Integer prevJEndTime = 0;
        StringBuffer stringBuffer = new StringBuffer();


        for(int i=0;i<array.length;i++)
        {
            if(cList.size() == 0)
            {
                cList.add(array[i][0]+","+array[i][1]);
                prevCEndTime = array[i][1];

            }
            else
            {
                if(array[i][0] >= prevCEndTime)
                {
                    cList.add(array[i][0]+","+array[i][1]);
                    prevCEndTime = array[i][1];
                }
                else
                {
                    if(jList.size() == 0)
                    {
                        jList.add(array[i][0]+","+array[i][1]);
                        prevJEndTime = array[i][1];
                    }
                    else
                    {
                        if(array[i][0] >= prevJEndTime)
                        {
                            jList.add(array[i][0]+","+array[i][1]);
                            prevJEndTime = array[i][1];
                        }
                        else
                        {
                            return "IMPOSSIBLE";
                        }

                    }

                }

            }
            
        }

        for(int i=0;i<oldArray.length;i++)
        {
           if(cList.contains(oldArray[i][0]+","+oldArray[i][1]))
           {
               stringBuffer.append("C");
           }
           else
           {
                stringBuffer.append("J");
           }

        }

    return  stringBuffer.toString();

    }



    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = in.nextInt();
        in.nextLine();

        for (int k = 1; k <= testCase; ++k) {
            Integer n = in.nextInt();
            in.nextLine();
            int[][] array= new int[n][2];
            int[][] oldArray= new int[n][2];

            for(int i=0;i<n;++i)
            {
                String[] rowArray = in.nextLine().split(" ");
                array[i][0] = Integer.valueOf(rowArray[0]);
                array[i][1] = Integer.valueOf(rowArray[1]);

                oldArray[i][0] = Integer.valueOf(rowArray[0]);
                oldArray[i][1] = Integer.valueOf(rowArray[1]);

            }
            System.out.println("Case #"+k+": "+checkSchedule(oldArray, array));
        }
    }
}
