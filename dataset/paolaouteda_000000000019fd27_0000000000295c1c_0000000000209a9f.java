import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String t1 = sc.nextLine();
        int t = Integer.parseInt(t1);
        int m = 1;
        do{
            String s = sc.nextLine();
            int n = s.length();
            int[] arr = new int[n];
            ArrayList<String> result = new ArrayList<String>();
            int count = 0;
    
            for(int i = 0; i < n; i++){
                int entero = Integer.parseInt(String.valueOf(s.charAt(i)));
                arr[i] = entero;
            }
    
            int num = 0;
            int i = 0;
            while(i < n) {
                num = arr[i];
                if (num == 0) {
                    while (count > 0) {
                        result.add(")");
                        count--;
                    }
                    result.add(Integer.toString(0));
                    i++;
                } else {
                count = num - count;
                int aux = count;
                while (aux > 0) {
                    result.add("(");
                    aux--;
                }
                count = num;
                result.add(Integer.toString(num));
                if (i + 1 < n) {
                    int j = i + 1;
                    if (arr[j] == 0) {
                        while (count > 0) {
                            result.add(")");
                            count--;
                        }
                        i++;
                    } else if (arr[j] == num) {
                        while (arr[j] == num && j < n) {
                            result.add(Integer.toString(arr[i + 1]));
                            j++;
                        }
                        i = j;    //    RECORDAR QUE PASA SI TODOS SON IGUALES
                    } else if (arr[i + 1] < num) {
                        result.add(Integer.toString(arr[i + 1]));
                        aux = arr[i + 1];
                        while (aux > 0) {
                            result.add(")");
                            aux--;
                        }
                        count = count - arr[i + 1];
                        i = i + 2;
                    } else if (arr[i + 1] > num) {
                        aux = arr[i];
                        while (aux > 0) {
                            result.add(")");
                            aux--;
                        }
                        count = count - arr[i];
                        i = i + 1;
                    }
                } else {
                    while (count > 0) {
                        result.add(")");
                        count--;
                    }
                    i++;
                }
            }
            }
            String solution = "";
            for(String str : result){
                solution += str;
            }
            System.out.println("Case #"+m+": "+solution);
            m++;
            t--;
        }while(t > 0);
    }

}
