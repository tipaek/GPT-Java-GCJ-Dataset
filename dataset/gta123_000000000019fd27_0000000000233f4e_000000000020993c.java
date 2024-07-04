import java.util.Scanner;
class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
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
		for(int i=0;i<N;i++){
			for(int j=0;j<N-1;j++){
				if(arr[i][j] == arr[i][j+1])
			 a++;
			}
		}
		for(int j=0;j<N;j++){
			for(int i=0;i<N-1;i++){
				if(arr[i][j] == arr[i+1][j])
					b++;
			}
		}
		int k=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i==j)
			    k = k + arr[i][j];
			}
		}

		System.out.println(k);
    System.out.println(a);
		System.out.println(b);
		
	} }
}
