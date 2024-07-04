import java.utils.*;
class TestClass {
    
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        // each testcase
        for(int tc=0; tc<TC; tc++) {
            int N = sc.nextInt(); // size
            
            int arr[][] = new int [N][N];
            
            for(i=0; i<N; i++) {
                String str = sc.next();
                for(j=0; j<N; j++) {
                    int p = (int)(str.charAt(j));
                    arr[i][j] = p;
                }
            }
            System.out.printLn(arr);
        }
    }
}