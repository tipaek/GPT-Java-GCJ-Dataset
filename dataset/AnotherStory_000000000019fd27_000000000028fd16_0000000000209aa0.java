import java.util.*;

public class Solution {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
        result.add(new ArrayList<Integer>());
     
        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
     
            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < l.size()+1; j++) {
                    l.add(j, num[i]);
     
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
     
                    l.remove(j);
                }
            }
     
            result = new ArrayList<ArrayList<Integer>>(current);
        }
     
        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int ts = 0; ts < t; ts++) {
            int n = sc.nextInt();
            int reqSum = sc.nextInt();

            int generateArr[] = new int[n];

            for(int i = 0; i < n; i++)
                generateArr[i] = (i + 1);

            ArrayList<ArrayList<Integer>> generateArrayList = permute(generateArr);

            int permutations = generateArrayList.size();
            int generateMat[][] = new int[permutations][generateArrayList.get(0).size()];

            for(int i = 0; i < generateArrayList.size(); i++) {
                for(int j = 0; j < generateArrayList.get(i).size(); j++) {
                    generateMat[i][j] = generateArrayList.get(i).get(j);
                }
            }

            boolean answerFound = false;

            for(int g = 0; g < permutations; g++) {

                int arr[][] = new int[n][n];

                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++)
                        arr[i][j] = generateMat[(i + j) % n][g];
                }
                
                int sum = 0;
                for(int i = 0; i < n; i++) {
                    sum += arr[i][i];
                }

                if(sum == reqSum) {
                    System.out.println("Case #" + (ts + 1) + ": " + "POSSIBLE");
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < n; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }

                    answerFound = true;
                    break;
                }
            }
            
            if(!answerFound)
                System.out.println("Case #" + (ts + 1) + ": " + "IMPOSSIBLE");
        }
    }
}