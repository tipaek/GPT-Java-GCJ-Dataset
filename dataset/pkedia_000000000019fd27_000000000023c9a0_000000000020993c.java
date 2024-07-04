

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String data = in.nextLine();
        int numberOFTestCases = Integer.parseInt(data);

        for (int caseNumber=1; caseNumber<=numberOFTestCases;caseNumber++){
            int n = Integer.parseInt(in.nextLine());

            int noOfRows=0;
            int noOfColumn=0;
            int trace=0;

            Set[] columnSet = new Set[n];

            for(int j=0;j<n;j++)
                columnSet[j] = new HashSet<Integer>(n);

            for(int i=0;i<n;i++) {
                boolean rowDuplicated = false;
                data = in.nextLine();
                String[] datas = data.split(" ");
                //System.out.println(datas.length);
                Set<Integer> set = new HashSet<>(n);
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(datas[j]);

                    if (i == j)
                        trace += input;

                    if (!rowDuplicated) {
                        if (set.contains(input)) {
                            noOfRows++;
                            rowDuplicated = true;
                        } else {
                            set.add(input);
                        }
                    }

                    if (columnSet[j] != null) {

                        if (columnSet[j].contains(input)) {
                            noOfColumn++;
                            columnSet[j] = null;
                        } else {
                            columnSet[j].add(input);
                        }


                    }

                }
            }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + noOfRows+" "+noOfColumn );






        }

        in.close();

    }
}
