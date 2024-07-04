import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String checkSchedule(Map<Integer,Integer> map)
    {
        Map<Integer, Integer> Cmap = new HashMap<>();
        Map<Integer, Integer> Jmap = new HashMap<>();

        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        sorted.putAll(map);
        StringBuffer stringBuffer = new StringBuffer();

        Integer prevCEndTime = 0;
        Integer prevJEndTime = 0;


        for (Map.Entry<Integer,Integer> entry : sorted.entrySet())
        {
            if(Cmap.isEmpty())
            {
                Cmap.put(entry.getKey(), entry.getValue());
                prevCEndTime = entry.getValue();

            }
            else
            {
                if(entry.getKey() >= prevCEndTime)
                {
                    Cmap.put(entry.getKey(), entry.getValue());
                    prevCEndTime = entry.getValue();
                }
                else
                {
                    if(Jmap.isEmpty())
                    {
                        Jmap.put(entry.getKey(), entry.getValue());
                        prevJEndTime = entry.getValue();
                    }
                    else
                    {
                        if(entry.getKey() >= prevJEndTime)
                        {
                            Jmap.put(entry.getKey(), entry.getValue());
                            prevJEndTime = entry.getValue();
                        }
                        else
                        {
                            return "IMPOSSIBLE";
                        }

                    }

                }

            }


        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
           if(Cmap.containsKey(entry.getKey()) && Cmap.get(entry.getKey()) == entry.getValue())
           {
               stringBuffer.append("C");
           }

            if(Jmap.containsKey(entry.getKey()) && Jmap.get(entry.getKey()) == entry.getValue())
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
            Map<Integer, Integer> map = new LinkedHashMap<>();

            for(int i=0;i<n;++i)
            {
                String[] rowArray = in.nextLine().split(" ");
                map.put(Integer.valueOf(rowArray[0]),Integer.valueOf(rowArray[1]));

            }
            System.out.println("Case #"+k+": "+checkSchedule(map));
        }
    }
}
