import java.util.Scanner;

public class Solution{
    static int counter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int size = sc.nextInt();
        sc.nextLine();

        
        for(int n = 1; n <= cases; n++){
            counter = 1;
            int[] arr = new int[size];
            int diffP = -1, eqP = -1;
            int acc = 0;
            while(counter <= size/2){
                acc = 0;
                if(diffP != -1){
                    int before = arr[diffP-1];
                    System.out.println(diffP);
                    int after = Integer.parseInt(sc.nextLine());
                    if(after != before) changeArray(arr);
                }
                if(eqP != -1){
                    int before = arr[eqP-1];
                    System.out.println(eqP);
                    int after = Integer.parseInt(sc.nextLine());
                    if(after != before) changeArray(arr);
                }
                if(acc%2 != 0){
                    System.out.println(1);
                    sc.nextLine();
                    acc++;
                }

                while(acc < 10 && counter <= size/2){
                    System.out.println(counter);
                    arr[counter-1] = Integer.parseInt(sc.nextLine());
                    System.out.println(size-(counter-1));
                    arr[size-counter] = Integer.parseInt(sc.nextLine());
                    if(eqP == -1 && arr[counter-1] == arr[size-counter]){
                        eqP = counter;
                    }
                    if(diffP == -1 && arr[counter-1] != arr[size-counter]){
                        diffP = counter;
                    }
                    counter++;
                    acc+=2;
                }
                if(eqP != -1 && diffP != -1) break;
            }

            if(counter > size/2){
                if(!showResults(arr, sc)) break;
                continue;
            }

            while(acc < 10){
                System.out.println(1);
                sc.nextLine();
                acc++;
            }

            if(eqP != -1 && diffP != -1)
                normalCaseSolver(arr, eqP, diffP, sc);
            else if(eqP != -1 && diffP == -1)
                equalCaseSolver(arr, eqP, sc);
            else if(eqP == -1 && diffP != -1)
                diffCaseSolver(arr, diffP, sc);

            if(!showResults(arr, sc)) break;
        }

    }

    public static boolean showResults(int[] arr, Scanner sc) {
        StringBuilder s = new StringBuilder(arr.length);
        for(int i = 0; i < arr.length; i++){
            s.append(arr[i]);
        }
        System.out.println(s.toString());
        String accept = sc.nextLine();
        if(!accept.equals("Y")) return false;
        return true;
    }

    public static void normalCaseSolver(int[] arr, int eqP, int diffP, Scanner sc){
        while(counter <= arr.length/2){
            int eqC = arr[eqP-1];
            int diffC = arr[diffP-1];
            System.out.println(eqP);
            int eq1 = Integer.parseInt(sc.nextLine());
            System.out.println(diffP);
            int diff1 = Integer.parseInt(sc.nextLine());

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
            }
        }
    }

    public static void equalCaseSolver(int[] arr, int eqP, Scanner sc){
        while(counter <= arr.length/2){
            int eqC = arr[eqP-1];
            System.out.println(eqP);
            int eq1 = Integer.parseInt(sc.nextLine());
            System.out.println(eqP);
            eq1 = Integer.parseInt(sc.nextLine());

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
            }
        }
    }

    public static void diffCaseSolver(int[] arr, int diffP, Scanner sc){
        while(counter <= arr.length/2){
            int diffC = arr[diffP-1];
            System.out.println(diffP);
            int diff1 = Integer.parseInt(sc.nextLine());
            System.out.println(diffP);
            diff1 = Integer.parseInt(sc.nextLine());

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