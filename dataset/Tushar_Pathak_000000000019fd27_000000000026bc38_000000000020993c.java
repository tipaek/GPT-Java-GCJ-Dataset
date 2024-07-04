import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        int task = 1;

        while(task <= test) {

            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> matrix = new ArrayList<>();

            for(int i = 0; i < n; ++ i) {

                matrix.add(Arrays.stream(br.readLine().split(" ")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList()));
            }

            long trace = 0;
            Set<Integer> row_count = new HashSet<>(), column_count = new HashSet<>();

            for(int i = 0; i < n; ++ i) {

                Set<Integer> row = new HashSet<>();
                Set<Integer> column = new HashSet<>();

                for (int j = 0; j < n; ++j) {

                    int value = matrix.get(i).get(j);
                    int columnValue = 0;

                    if (i == j) {

                        trace += value;
                        columnValue = value;
                    } else {

                        columnValue = matrix.get(j).get(i);
                    }

                    if(!row_count.contains(i)) {

                        if (row.contains(value)) {

                            row_count.add(i);
                        } else {

                            row.add(value);
                        }
                    }

                    if(!column_count.contains(i)) {

                        if (column.contains(columnValue)) {

                            column_count.add(i);
                        } else {

                            column.add(columnValue);
                        }
                    }

                }
            }

            System.out.println("Case #" + task + ": " + trace + " " + row_count.size() + " " + column_count.size());

            ++ task;
        }

    }

}

