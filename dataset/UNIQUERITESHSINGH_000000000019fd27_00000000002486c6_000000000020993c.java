
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for(int tc=1 ; tc <= testCaseCount ; tc++)
        {
            int k = 0;
            int r = 0;
            int c = 0;
            int N = scanner.nextInt();
            Map<Integer, List<Number>> coumnMap = new HashMap<>();
            boolean [] colTrack = new boolean[N];
            if(N>10)
            {
                for(int i=0;i<N ;i++)
                {
                    colTrack[i] = true;
                }
            }
            for(int i=0; i<N;i++)
            {
                boolean hasDuplicateInRow = false;
                if(N>10) hasDuplicateInRow =true;
                List<Integer> rowData = new ArrayList<>();
                for(int j=0;j<N; j++)
                {
                    int value = scanner.nextInt();
                    if(i==j)k+=value;
                    if(!hasDuplicateInRow)
                    {
                        if (rowData.contains(value)) {
                            hasDuplicateInRow = true;
                            rowData = null;
                        } else {
                            rowData.add(value);
                        }
                    }
                    if(!colTrack[j]) {
                        if (coumnMap.get(j) == null) {
                            List<Number> numbers = new ArrayList<>();
                            numbers.add(value);
                            coumnMap.put(j, numbers);
                        } else {
                            List<Number> numbers = coumnMap.get(j);
                            if (numbers.contains(value)) {
                                c++;
                                colTrack[j] = true;
                                numbers = null;
                            } else {
                                numbers.add(value);
                            }
                        }
                    }
                }
                if(hasDuplicateInRow) r++;
            }
            System.out.println("Case #"+tc+": "+k+" "+r+" "+c);
        }
        scanner.close();

    }
}
