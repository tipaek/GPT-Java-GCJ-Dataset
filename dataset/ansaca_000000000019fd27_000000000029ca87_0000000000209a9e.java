import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int size = sc.nextInt();
        sc.nextLine();

        
        for(int n = 1; n <= cases; n++){
            int[] arr = new int[size];
            int diffP = -1, eqP = -1;

            for(int j = 0; j < size/10; j++){
                for(int i = 1; i <= 5; i++){
                    System.out.println(i);
                    arr[i-1] = Integer.parseInt(sc.nextLine());
                    System.out.println(size-(i-1));
                    arr[size-i] = Integer.parseInt(sc.nextLine());
                    if(eqP == -1 && arr[i-1] == arr[size-i]){
                        eqP = i;
                    }
                    if(diffP == -1 && arr[i-1] != arr[size-i]){
                        diffP = i;
                    }
                }
                if(eqP != -1 && diffP != -1) break;
            }

            clear(arr, eqP, diffP);

            if(eqP != -1 && diffP != -1)
                normalCaseSolver(arr, eqP, diffP, sc);
            else if(eqP != -1 && diffP == -1)
                equalCaseSolver(arr, eqP, sc);
            else if(eqP == -1 && diffP != -1)
                diffCaseSolver(arr, diffP, sc);


            String s = "";
            for(int i = 0; i < arr.length; i++){
                s = s+arr[i];
            }
            System.out.println(s);
            String accept = sc.nextLine();
            if(!accept.equals("Y")) break;
        }
    }

    public static void normalCaseSolver(int[] arr, int eqP, int diffP, Scanner sc){
        int counter = 1, acc = 0;
        while(counter <= arr.length/2 || acc == 10){
            acc = 0;
            int eqC = arr[eqP-1];
            int diffC = arr[diffP-1];
            System.out.println(eqP);
            int eq1 = Integer.parseInt(sc.nextLine());
            System.out.println(diffP);
            int diff1 = Integer.parseInt(sc.nextLine());
            acc = 2;

            if(eq1 != eqC) {
                changeArray(arr);
                if(diff1 == diffC)
                    rotateArray(arr);
            }else{
                if(diff1 != diffC)
                    rotateArray(arr);
            }

            
            for(int i = 0; i < 4; i++){
                while(counter == eqP || counter == diffP) counter++;
                if(counter > arr.length/2) break;
                System.out.println(counter);
                arr[counter-1]=Integer.parseInt(sc.nextLine());
                System.out.println(arr.length - (counter-1));
                arr[arr.length - counter]=Integer.parseInt(sc.nextLine());
                counter++;
                acc+=2;
            }
        }
    }

    public static void equalCaseSolver(int[] arr, int eqP, Scanner sc){
        int counter = 1, acc = 0;
        while(counter <= arr.length/2 || acc == 10){
            acc = 0;
            int eqC = arr[eqP-1];
            System.out.println(eqP);
            int eq1 = Integer.parseInt(sc.nextLine());
            System.out.println(eqP);
            eq1 = Integer.parseInt(sc.nextLine());
            acc = 2;

            if(eq1 != eqC)
                changeArray(arr);
            
            for(int i = 0; i < 4; i++){
                while(counter == eqP) counter++;
                if(counter > arr.length/2) break;
                System.out.println(counter);
                arr[counter-1]=Integer.parseInt(sc.nextLine());
                System.out.println(arr.length - (counter-1));
                arr[arr.length - counter]=Integer.parseInt(sc.nextLine());
                counter++;
                acc+=2;
            }
        }
    }

    public static void diffCaseSolver(int[] arr, int diffP, Scanner sc){
        int counter = 1, acc = 0;
        while(counter <= arr.length/2 || acc == 10){
            acc = 0;
            int diffC = arr[diffP-1];
            System.out.println(diffP);
            int diff1 = Integer.parseInt(sc.nextLine());
            System.out.println(diffP);
            diff1 = Integer.parseInt(sc.nextLine());
            acc = 2;

            if(diff1 != diffC)
                changeArray(arr);

            for(int i = 0; i < 4; i++){
                while(counter == diffP) counter++;
                if(counter > arr.length/2) break;
                System.out.println(counter);
                arr[counter-1]=Integer.parseInt(sc.nextLine());
                System.out.println(arr.length - (counter-1));
                arr[arr.length - counter]=Integer.parseInt(sc.nextLine());
                counter++;
                acc+=2;
            }
        }
    }

    public static void changeArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1)
                arr[i] = 0;
            else if(arr[i] == 0)
                arr[i] = 1;
        }  
    }

    public static void rotateArray(int[] arr) {
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - (i+1)];
            arr[arr.length - (i+1)] = temp;
        }
    }

    public static void clear(int[] arr, int p1, int p2) {
        for(int i = 0; i < arr.length; i++){
            if(i == p1-1 || i == p2-1) continue;
            if(i == arr.length-p1 || i == arr.length-p2) continue;
            arr[i] = -1;
        }
    }
}