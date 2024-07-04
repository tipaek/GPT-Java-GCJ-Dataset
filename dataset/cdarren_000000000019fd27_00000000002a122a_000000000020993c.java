import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    Scanner sc = new Scanner(System.in);
    PrintWriter wr;

    List<List<Integer>> getMatrix() throws IOException {
        int length = Integer.parseInt(sc.nextLine());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            String line = sc.nextLine();
            String[] strArray = line.split(" ");
            
            for(int j = 0; j < strArray.length; j++) {
                temp.add(Integer.parseInt(strArray[j]));
            }
            result.add(temp);
        }
        return result;
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int numOfMatrix = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numOfMatrix; ++i) {
            String result = compute();
            wr.println(String.format("Case #%d: %s", i + 1, result));
        }
        rd.close();
        wr.close();
    }

     private String compute() throws IOException {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> columnResult = new ArrayList<>();

        result = getMatrix();
        int trace = 0;
        int row = 0;
        int column = 0;
        boolean rowFlag = false;
        boolean columnFlag = false;
        for (int i = 0; i < result.size(); i++) {
            rowFlag = false;
            Set<Integer> rowHash = new HashSet<>();
            for (int j = 0; j < result.size(); j++) {
                if (i == j) {
                    trace = trace + result.get(i).get(j);
                }
                if (rowHash.contains(result.get(i).get(j)) && rowFlag == false) {
                    row++;
                    rowFlag = true;
                } else {
                    rowHash.add(result.get(i).get(j));
                }
                if (i == 0) {
                    Set<Integer> columnHash = new HashSet<>();
                    int size = result.get(i).size();
                    for (int l = 0; l < size; l++) {
                        columnHash.add(result.get(l).get(j));
                    }
                    if (columnHash.size() != size) {
                        column++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(trace);
        sb.append(" ");
        sb.append(row);
        sb.append(" ");
        sb.append(column);
        return sb.toString();
    }

}