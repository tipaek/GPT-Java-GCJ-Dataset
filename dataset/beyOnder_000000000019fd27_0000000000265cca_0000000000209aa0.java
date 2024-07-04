import java.util.*;
class TestCase{
    int bigArr[][];
    int n;
    int rowArr[];
    int factorial;
    static int rowCount;
    public TestCase(int n,int rowArr[]) {
        this.n = n;
        this.rowArr = rowArr;
        factorial = fact(n);
        bigArr = new int[factorial][n];
        rowCount =0;
    }
    public static int fact(int n){
        if(n<3)return n;
        return n*fact(n-1);
    }
    public void permute(){
        permuteHelper(rowArr, 0,n);
    }
    private void permuteHelper(int[] arr, int index,int n){
        if(index >= n - 1){ //If we are at the last element - nothing left to permute
//            System.out.println(Arrays.toString(arr));
            //Print the array
//            System.out.println("row = "+rowCount+" ,size = "+bigArr.length);
            for(int i = 0; i < n; i++){
                bigArr[rowCount][i] = arr[i];
            }

//            if(arr.length > 0)
//                System.out.print(arr[arr.length - 1]);
//            System.out.println("]");
            rowCount++;
            return;
        }

        for(int i = index; i < n; i++){ //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index+1,n);

            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }
    public void printMatrix(){
        for(int i=0;i<factorial;i++){
            System.out.println(Arrays.toString(bigArr[i]));
        }
    }
}
public class Solution
{
//    static ArrayList<Integer[]> allPermutates;
    static void printMatrix(int arr[][]){
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static void printList(ArrayList<int[]> list){
        for(int i = 0;i< list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        TestCase testCase[] = new TestCase[t];
        int temp = 0;
        for(int h=1;h<=t;h++){
            int n = in.nextInt();
            int k = in.nextInt();
            int arr[][] = new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = (j+1+i)/(n+1)+(j+1+i)%(n+1);
                }
            }
            System.out.print("Case #"+h+": ");
//        printMatrix(arr);
            int brr[] = new int[n];
            for(int i=0;i<n;i++){
                brr[i] = i;
            }
            testCase[h-1] = new TestCase(n,brr);
            testCase[h-1].permute();
//            testCase[h-1].printMatrix();
            int sum=0;
            for(int p = 0;p<testCase[h-1].factorial;p++){
                sum = 0;
                for(int d=0;d<n;d++){
                    sum += arr[testCase[h-1].bigArr[p][d]][d];
                }
                if(sum == k){
//                    System.out.println(Arrays.toString(testCase[h-1].bigArr[p]));
                    System.out.println("POSSIBLE");
                    for(int g=0;g<n;g++){
                        temp = testCase[h-1].bigArr[p][g];
                        for(int u=0;u<n;u++){
                            System.out.print(arr[temp][u]+ " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }
            if(sum!=k){
                System.out.println("IMPOSSIBLE");
            }
        }


    }


}