import java.util.Scanner;

class Main{
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
		int x=1;
	while(T-->0){
	    int N = sc.nextInt();
	    int arr[][] = new int[N][N];
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            arr[i][j] = sc.nextInt();
            }
        }
	    int a = 0;
	    int b = 0;
	    int k = arr[N-1][N-1];
		for(int i=0;i<N;i++){
			for(int j=0;j<N-1;j++){
				if(arr[i][j] == arr[i][j+1])
			        a++;
				if(arr[j][i] == arr[j+1][i])
					b++;
				if(i==j)
			        k = k + arr[i][j];	
			}
		}

		System.out.println("Case#"+x+":"+ k+" "+ a+" "+ b);
		x++;
	} }
}