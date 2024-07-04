import java.util.*;
class Solution { 

    //static int arr[][];
      
    // Function to print n x n Latin Square 
    static void printLatin(int n, int sum) 
    { 
          
        // A variable to control the  
        // rotation point. 
        int k = sum; 
      
        // Loop to print rows 
        for (int i = 0; i < n; i++) 
        { 
  
            // This loops runs only after 
            // first iteration of outer  
            // loop. It prints 
            // numbers from n to k 
            int temp = k; 
  
            while (temp <= n) 
            { 
                System.out.print(temp + " "); 
                temp++; 
            } 
      
            // This loop prints numbers from 
            // 1 to k-1. 
            for (int j = 1; j < k; j++) 
                System.out.print(j + " "); 
      
            k--; 
            if(k<=0){
                k=n;
            }
            System.out.println(); 
        } 
    } 

    public static boolean checkRow(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        //int count = 0;
        boolean flag = false;
        for(int i=0; i<n; i++){
            map.clear();
            for(int j=0; j<n; j++){
                if(map.containsKey(arr[i][j])){
                    //count++;
                    flag = true;
                    break;
                }
                else{
                    map.put(arr[i][j], 1);
                
                }
            }
        }
        return flag;
    }

    public static boolean checkCol(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        //int count = 0;
        boolean flag = false;
        for(int i=0; i<n; i++){
            map.clear();
            for(int j=0; j<n; j++){
                if(map.containsKey(arr[i][j])){
                    //count++;
                    flag = true;
                    break;
                }
                else{
                    map.put(arr[i][j], 1);
                
                }
            }
        }
        return flag;
    } 

    static int arr[][];
    static int n;

    public static void printLatin2(int sum){
        System.out.println("N: "+n);
        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++){
                if(i==j){
                    arr[i][j] = i+1;
                    sum -= i+1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++){
                if(i!=j){
                    arr[i][j] = checkNum(i, j);
                }
                //System.out.print("a "+arr[i][j]);
            }
            //System.out.println();
        }
    }

    public static int checkNum(int i, int j){
        System.out.println("N: "+n);
        int num = 0;
        while(num<n){
            num++;
            if(row(num, i)){
                System.out.print("n1 "+num+" ");
                if(col(num, j)){
                    System.out.print("n2 "+num+" ");
                    break;
                }
            }
        //System.out.println("n: "+num);
        }
        System.out.println("n "+num+" ");
        return num;
    }

    public static boolean row(int num, int j){
        boolean flag = true;
        for(int i =0; i<n ; i++){
            //System.out.println("r: "+arr[j][i]+" n "+num+" ");
            if(arr[j][i] == num){
                flag = false;
                break;
            }
        }
        return flag;
    }
     
    public static boolean col(int num, int j){
        boolean flag = true;
        for(int i =0; i<n ; i++){
            //System.out.println("c: "+arr[i][j]+" n "+num+" ");
            if(arr[i][j] == num){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static int s = 1;
    public static void init(){
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = 0;
            }
        }
    }

    public static boolean printLatin3(int sum){
        genLatin();
        int ans = checkSum(sum);
        while(ans==0 && s<=n){
            genLatin();
            //System.out.println("a "+ans);
            ans = checkSum(sum);
        }
        if(ans>0){
            if(ans == 2){
                invert();
            }
            return true;
        }
        else{
            return false;
        }
        
    }

    public static void genLatin(){
        //System.out.println(n);
        int val;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                val = (s*(i+1)+j+1)%n;
                if(val == 0){
                    val = n;
                }
                arr[i][j] = val;

            }
        }
        s++;
    }

    public static int checkSum(int sum){
        int check_sum_ltr = 0;
        int check_sum_rtl = 0;
        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++){
                if(i==j){
                    check_sum_ltr += arr[i][j];
                }
                if(i+j+1 == n){
                    check_sum_rtl += arr[i][j];
                }
            }
        }
        if(check_sum_ltr == sum){
            return 1;
        }
        else if(check_sum_rtl == sum){
            return 2;
        }
        else{
            return 0;
        }
    }

    public static void invert(){
        int t;
        for(int i=0; i<n ; i++){
            for(int j=0; j<n/2 ; j++){
                t = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = t;
            }
        }
    }

    // Driver code 
    public static void main (String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int curCase = 1;
        while(curCase <= t){
            n = sc.nextInt();
            int k = sc.nextInt();
            arr = new int[n][n];
            int sum;
            System.out.print("Case #"+curCase+": ");
            // Invoking printLatin function 
            init();
            s=1;
            if(n<=2){
                if(k%n == 0){
                    sum = k/n;
                    if(sum <=n){
                        System.out.println("POSSIBLE");
                        printLatin(n, sum);
                    } 
                    else{
                        System.out.println("IMPOSSIBLE");
                    }
                }
                else{
                    System.out.println("IMPOSSIBLE");
                }
            }
            else{
                if(printLatin3(k)){
                    System.out.println("POSSIBLE");
                    for(int i =0; i<n; i++){
                        for(int j=0; j<n; j++){
                            System.out.print(arr[i][j]+" ");

                        }
                        System.out.println();
                    }
                }
                else{
                    System.out.println("IMPOSSIBLE");
                }
            }
            //System.out.println();
            curCase++;
        }
    } 
} 