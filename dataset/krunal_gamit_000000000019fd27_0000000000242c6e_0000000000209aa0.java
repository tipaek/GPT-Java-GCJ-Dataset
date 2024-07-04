import java.util.*;
class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int mat[][] = new int [t][t];
        int n1[] = new int[t];
        int k1[] = new int[t];
        for (int z=0;z<t;z++) {
            n1[z] = sc.nextInt();
            k1[z] = sc.nextInt();
        }
        for(int z=0;z<t;z++) {
            int size = n1[z];

            int[][] matrix = new int[size][];
            matrix[0] = MatrixOps.createOrderedArray(size, 1);

            for (int x = 0; x < size; x++) {
                matrix[x] = MatrixOps.createOrderedArray(size, 1);
                do {
                    MatrixOps.shuffle(matrix[x]);
                } while (!MatrixOps.compare2DArray(matrix[x], matrix, 0, x));
            }
            int k=0;
            for (int i=0;i<size;i++)
            {
                for (int j=0;j<size;j++)
                {
                    if(i==j)
                    {
                        k += matrix[i][j];
                    }
                }
            }
            if (k1[z] == k) {
                System.out.println("Case #" + (z + 1) + ": " + "POSSIBLE");
                for (int i=0;i<size;i++)
                {
                    for (int j=0;j<size;j++)
                    {
                        System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (z + 1) + ": " + "IMPOSSIBLE");
            }

        }
    }
}

class MatrixOps {

    public static void shuffle(int[] arr){
        Random random = new Random();
        for(int x = 0; x < arr.length; x++)
            swap(arr, x, random.nextInt(arr.length));
    }

    public static int[] createOrderedArray(int size, int startValue) {
        int[] num = new int[size];
        for (int x = 0; x < num.length; x++)
            num[x] = x + startValue;
        return num;
    }

    public static boolean compare2DArray(int[] arr1, int[][] arr2, int begin, int end) {
        for (int x = begin; x < end; x++)
            if (!compareArray(arr1, arr2[x]))
                return false;
        return true;
    }


    private static boolean compareArray(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length)
            return false;
        for(int x=0; x<arr1.length; x++)
            if(arr1[x] == arr2[x])
                return false;
        return true;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}