import java.util.Scanner;

class Main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	    int n = scan.nextInt();
	    int p=0;
	    int size;
	    int i,j;
	    int trace;
	    int row,rowcount;
	    int column,columncount;
	    while(p<n){
	        trace = 0;
	        row = 0;
	        rowcount=0;
	        column=0;
	        columncount=0;
	        size = scan.nextInt();
	        int[][] arr = new int[size][size];
	        for(i=0;i<size;i++){
	            for(j=0;j<size;j++){
	                arr[i][j] = scan.nextInt();
					if(i==j){
						trace+=arr[i][j];
					}
                }
            }
	        for(i=0;i<size;i++){
	        	rowcount=0;
	            for(j=0;j<size-1;j++){
	                if(binarySearch(arr,i,j+1,size-1,arr[i][j])!=-1){
	                	rowcount++;
					}
                }
	            if(rowcount!=0){
	            	row++;
				}
            }
	        for(j=0;j<size;j++){
	        	columncount=0;
	        	for(i=0;i<size-1;i++){
	        		if(binarySearchColumn(arr,j,i+1,size-1,arr[i][j])!=-1){
	        			columncount++;
					}
				}
	        	if(columncount!=0){
	        		column++;
				}
			}


            System.out.println("Case #"+(p+1)+": "+trace+" "+row+" "+column);
	        p++;
        }
    }
	public static int binarySearch(int arr[][],int i, int l, int r, int x)
	{
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[i][mid] == x)
				return mid;

			if (arr[i][mid] > x)
				return binarySearch(arr,i, l, mid - 1, x);

			return binarySearch(arr,i, mid + 1, r, x);
		}

		return -1;
	}
	public static int binarySearchColumn(int arr[][],int j, int l, int r, int x)
	{
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid][j] == x)
				return mid;

			if (arr[mid][j] > x)
				return binarySearch(arr,j, l, mid - 1, x);

			return binarySearch(arr,j, mid + 1, r, x);
		}

		return -1;
	}
}
