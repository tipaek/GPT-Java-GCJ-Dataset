public class Solution {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println();
        for(int a = 1;a <= N;a++)
        {
            int size = in.nextInt();
            int[][] mat = new int[size][size];

            for(int i = 0;i < size;i++)
            {
                for(int j = 0;j < size;j++) mat[i][j] = in.nextInt();
            }
            int k = trace(mat,size);
            int r = dupedRows(mat,size);
            int c = dupedCols(mat,size);

            System.out.println("Case #" + a + ":" + " " + k + " " + r + " " + c);
        }
    }

    public static int trace(int[][] arr, int size)
    {
        int sum = 0;

        for(int i = 0;i < size;i++)
        {
            for(int j = 0;j < size;j++)
            {
                if(i==j) sum = sum + arr[i][j];
            }
        }
        return sum;
    }
    public static int dupedRows(int[][] arr, int size)
    {
        int count = 0;
        HashMap<Integer,Integer> h = new HashMap<>();

        for(int i = 0;i < size;i++)
        {
            int[] row = arr[i];

            for (int k : row) {
                if (h.containsKey(k)) {
                    count++;
                    break;
                } else h.put(k, 1);
            }
            h.clear();
        }
        return count;
    }

    public static int dupedCols(int[][] arr,int size)
    {
        int count = 0;
        HashMap<Integer,Integer> h = new HashMap<>();

        for(int i = 0;i < size;i++)
        {
            for(int j = 0;j < size;j++)
            {
                int k = arr[j][i];

                if(h.containsKey(k))
                {
                    count++;
                    break;
                }
                else h.put(k,1);
            }
            h.clear();
        }
        return count;
    }
}