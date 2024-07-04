import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n,c=1;
	    n =  sc.nextInt();
	    while(c<=n){
	        int p,i,j,ce=0,je=0;
	        p=sc.nextInt();
	       
	        int input[][]= new int[p][3];
	        int task[][]=new int[p][2];
	        for(i=0;i<p;i++){
	            input[i][0]=sc.nextInt();
	            input[i][1]=sc.nextInt();
	            input[i][2]=0;

	           
	            task[i][0]=input[i][0];
	            task[i][1]=input[i][1];
	        }
	        mergeSort(input,0,p-1);
	        boolean imp=false;
	        char output[] = new char[p];
	        for(i=0;i<p;i++){
	            if(ce<=input[i][0]){
	                ce=input[i][1];
	                output[i]='C';
	               
	            }else if(je<=input[i][0]){
	                je=input[i][1];
	             
	                output[i]='J';
	             
	            }else{imp=true;break;}
	            
	        }
	        
	        if(imp){System.out.println("Case #"+c+": "+"IMPOSSIBLE");}
	        else{
	        	System.out.println("Case #"+c+": ");
	            for(i=0;i<p;i++){
	                for(j=0;j<p;j++){
	                    if(task[i][0]==input[j][0] && task[i][1]==input[j][1] && input[j][2]==0){
	                        
	                    	System.out.print(output[j]);
	                        input[j][2]=1;
	                        break;
	                    }
	                }
	            }
	            System.out.println();
	        }
	        c++;
	    }
		
		

	}
	
	static void merge(int arr[][], int l, int m, int r){ 
	    int i, j, k; 
	    int n1 = m - l + 1; 
	    int n2 =  r - m; 
	    int left[][]= new int[n1][2];
	    int right[][]= new int[n2][2]; 

	    for (i = 0; i < n1; i++){
	        left[i][0] = arr[l + i][0];
	        left[i][1] = arr[l + i][1]; 
	    }
	    for (j = 0; j < n2; j++){
	        right[j][0] = arr[m + 1+ j][0];
	        right[j][1] = arr[m + 1+ j][1]; 
	    }
	    i = 0; 
	    j = 0; 
	    k = l; 
	    while (i < n1 && j < n2) 
	    { 
	        if (left[i][0] <= right[j][0]) 
	        { 
	            arr[k][0] = left[i][0];
	            arr[k][1] = left[i][1]; 
	            i++; 
	        } 
	        else
	        { 
	            arr[k][0] = right[j][0];
	            arr[k][1] = right[j][1]; 
	            j++; 
	        } 
	        k++; 
	    } 
	    while (i < n1) 
	    { 
	        arr[k][0] = left[i][0];
	        arr[k][1] = left[i][1]; 
	        i++; 
	        k++; 
	    } 
	    while (j < n2) 
	    { 
	        arr[k][0] = right[j][0];
	        arr[k][1] = right[j][1]; 
	        j++; 
	        k++; 
	    } 
	} 

	public static void mergeSort(int arr[][], int l, int r) { 
	    if (l < r) 
	    { 
	        int m = l+(r-l)/2; 
	        mergeSort(arr, l, m); 
	        mergeSort(arr, m+1, r); 
	        merge(arr, l, m, r); 
	    } 
	} 


}
