import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String solution = "";
        for(int k = 1; k <= t;k++){
            int n = sc.nextInt();
            int[][] matrix = new int[n][2];
            int[][] matrixSorted = matrix.clone();
            char osoba = 'J';
            char[] arr = new char[n];
            Stack<int[]> jStack = new Stack<>();
            Stack<int[]> cStack = new Stack<>();
            boolean impossible = false;

            Map<int[],Integer> map = new HashMap<>();

            for(int i = 0; i < matrix.length;i++){
                for(int j  = 0; j < matrix[i].length;j++){
                    matrix[i][j] = sc.nextInt();
                }
                map.put(matrix[i],i);
            }

            Arrays.sort(matrixSorted, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            for(int i = 0; i < matrixSorted.length;i++){
                arr[map.get(matrixSorted[i])] = osoba;
                if( i < matrixSorted.length - 1 && podudarajuSe(matrixSorted[i],matrixSorted[i+1])){
                    if(osoba == 'J'){
                        jStack.push(matrixSorted[i]);
                        osoba = getOsoba(osoba);

                        if(!cStack.isEmpty() && podudarajuSe(cStack.peek(),matrixSorted[i+1])){
                            impossible = true;
                            break;
                        }
                    }else{
                        cStack.push(matrixSorted[i]);
                        osoba = getOsoba(osoba);

                        if(!jStack.isEmpty() && podudarajuSe(jStack.peek(),matrixSorted[i +1])){
                            impossible = true;
                            break;
                        }


                    }
                }else{

                    if(osoba == 'J'){
                        jStack.push(matrixSorted[i]);
                    }else{
                        cStack.push(matrixSorted[i]);
                    }
                }
            }
            solution += "Case #" + k + ": " + (impossible ? "IMPOSSIBLE\n" : new String(arr) + "\n");
        }
        System.out.println(solution);
    }
    public static char getOsoba(char o){
        return o == 'J' ? 'C' : 'J';
    }
    public static boolean podudarajuSe(int[] a,int[] b){
        return a[1]  > b[0];
    }
}