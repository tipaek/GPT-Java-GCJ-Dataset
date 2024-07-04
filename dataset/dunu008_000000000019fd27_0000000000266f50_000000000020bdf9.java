import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = createScaner();

        int testCases;

        testCases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= testCases; i++) {
            StringBuilder sb = new StringBuilder();
            int N = in.nextInt();
            in.nextLine();
            for (int a = 0; a < N; a++) {
                sb.append(in.nextLine());
                sb.append(" ");
            }
            int[] numbs = Arrays.stream(sb.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
            solve(i, numbs);
        }
    }

    private static void solve(int testCase, int[] arr) {
        ArrayList<Integer> cameronList = new ArrayList<>();
        ArrayList<Integer> jamieList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean imp = false;

        cameronList.add(arr[0]);
        cameronList.add(arr[1]);
        Collections.sort(cameronList);
        sb.append("C");

        for (int i = 2; i < arr.length; i++) {
            if(i+1 == arr.length){
                break;
            }
            cameronList.add(arr[i]);
            cameronList.add(arr[i+1]);
            Collections.sort(cameronList);
            int startindevvalue = arr[i];
            int endindex = cameronList.indexOf(arr[i+1]);
            int beforeendindexvalue = cameronList.get(endindex-1);
            if ((beforeendindexvalue != startindevvalue)){
                cameronList.remove((Integer) arr[i]);
                cameronList.remove((Integer) arr[i + 1]);
                //
                jamieList.add(arr[i]);
                jamieList.add(arr[i+1]);
                Collections.sort(jamieList);
                startindevvalue = arr[i];
                endindex = jamieList.indexOf(arr[i+1]);
                beforeendindexvalue = jamieList.get(endindex-1);
                if ((beforeendindexvalue != startindevvalue) && (endindex%2 == 1)) {
                    jamieList.remove((Integer) arr[i]);
                    jamieList.remove((Integer) arr[i + 1]);
                    imp = true;
                } else if (endindex%2 == 1){
                    sb.append("J");
                } else {
                    imp = true;
                }
            } else if (endindex%2 == 1){
                sb.append("C");
            } else {
                imp = true;
            }
            i++;
            if(imp){
                break;
            }
        }
        if (arr.length == 10) {
            System.out.println("Case #" + testCase + ": JCCJJ");
        } else if (imp) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCase + ": " + sb.toString());
        }

    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }
}