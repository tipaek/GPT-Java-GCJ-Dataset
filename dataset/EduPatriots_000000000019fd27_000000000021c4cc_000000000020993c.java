import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Attempt3 {
    
    static public class Matriz{
        int n;
        List<Integer> values= new ArrayList<>();
        
        public void lectura(){
            Scanner in = new Scanner(System.in);
            for(int i = 0; i < n*n; i++){
                values.add(in.nextInt());
            }
        }
        
        public void salida(int caso){
            int trace = 0, rows = 0, columns = 0;
            for(int i = 0; i < n; i++){
                trace = trace + values.get(i*(n+1)); 
            }
            for(int i = 0; i < n; i++){
                int orden[] = new int[n];
                for(int j = 0; j < n; j++)
                    orden[j] = values.get((j*n)+i);
                columns = columns + sort(orden, 0, n-1);
            }
            for(int i = 0; i < n; i++){
                int orden[] = new int[n];
                for(int j = 0; j < n; j++)
                    orden[j] = values.get(j+(i*n));
                rows = rows + sort(orden, 0, n-1);
            }
            System.out.println("Case #" + caso + ": " + trace + " " + columns + " " + rows + " ");
        }
    }
    
    static int sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
   
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        }
        for(int i = 0; i < high; i++){
            if(arr[i] == arr[i+1])
                return 1;
        }
        return 0;
    }
    
    static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        {  
            if (arr[j] < pivot) 
            { 
                i++; 
   
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    
    public static void main(String[] args) {
        int num, size;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        Matriz matrices[] = new Matriz[num];
        for(int i = 0; i < num; i++){
            matrices[i] = new Matriz();
            matrices[i].n = in.nextInt();
            matrices[i].lectura();
        }
        for(int i = 0; i < num; i++){
            matrices[i].salida(i+1);
        }
        
    }
}

