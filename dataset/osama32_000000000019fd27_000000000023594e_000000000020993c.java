public class Vestigium{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int n = scan.nextInt();
        int first[][] = new int[n][n];
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < n ;j++){
                first[i][j] = scan.nextInt();
            }
        }
        
    }
}