import java.util.Scanner;
import java.lang.Math;

class Mergesort{
	static int [][]A;
    static int [][]aux;
    static int n;

    public Mergesort(int A[][], int n){
    	this.A = A;
        this.aux = new int[n][4];
        this.n = n;
    }
    
    void sort(int low, int high, int t) {
    	if (low < high) {
    		int middle = (low + high) / 2;
    		sort(low, middle,t);
    		sort(middle + 1, high,t);
    		merge1(low, middle, high,t);
    	}
    }
    void merge1(int low, int middle, int high,int t) {
    	for (int i = low; i <= high; i++){
            aux[i][0] = A[i][0];
            aux[i][1] = A[i][1];
            aux[i][2] = A[i][2];
            aux[i][3] = A[i][3];
    	}
        int i = low;
        int j = middle + 1;
        int k = low;

    while (i <= middle && j <= high) {
    	if (aux[i][t] <= aux[j][t]) {
        A[k][0] = aux[i][0];
        A[k][1] = aux[i][1];
        A[k][2] = aux[i][2];
        A[k][3] = aux[i][3];
    	i++;}   
    	else {
            A[k][0] = aux[j][0];
            A[k][1] = aux[j][1];
            A[k][2] = aux[j][2];
            A[k][3] = aux[j][3];
    		j++;
    	}
        k++;
    }
    
    while (i <= middle) {
        A[k][0] = aux[i][0];
        A[k][1] = aux[i][1];
        A[k][2] = aux[i][2];
        A[k][3] = aux[i][3];
    	k++;
    	i++;
    }
    while (j <= high) {
        A[k][0] = aux[j][0];
        A[k][1] = aux[j][1];
        A[k][2] = aux[j][2];
        A[k][3] = aux[j][3];
    	k++;
    	j++;
    }
}

public static void allot()
{
    A[0][1] = 1;
    int prev = 0;
    for(int i=1; i<n; i++)
    {
        if (A[i][2]>=A[prev][3])
        {   
            A[i][1] = 1;
            prev = i;
        }
    }
    for(int i=1; i<n; i++)
    {
        if(A[i][1] == -1)
        {
            prev=i;
            A[i][1] = 2;
            break;
        }
    }
    for(int i=prev+1; i<n; i++)
    {
        if (A[i][1] == -1 && A[i][2]>=A[prev][3])
        {
            A[i][1] = 2;
            prev = i;
        }
    }
}

}

class Test{
	public static void main(String args[]) {
	 	Scanner sc=new Scanner(System.in);
         int t = sc.nextInt();
         for(int s=0; s<t; s++)
         {
            int n =sc.nextInt();
            int arr[][]= new int[n][4];
            for(int i=0; i<n; i++)
            {
                arr[i][0] = i;
                arr[i][1] = -1;
                arr[i][2] = sc.nextInt();
                arr[i][3] = sc.nextInt();
            }
            Mergesort m = new Mergesort(arr,n);
            m.sort(0,n-1,3);
            m.allot();
            m.sort(0, n-1,0);
            System.out.print("Case #");
            System.out.print(s+1);
            System.out.print(": ");
            int flag =0;
            for(int i=0; i<n; i++)
            {
                if(arr[i][1] == -1)
                    {flag=1;
                    break;}
            }
            if (flag==1)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            for(int i=0; i<n; i++)
            {
                if (arr[i][1] == 1)
                    System.out.print("C");
                else
                    System.out.print("J");
            }
            System.out.println();
         }
         sc.close();
     }
}