import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static Integer[] arr = new Integer[100];
    static Integer[] original = new Integer[100];

    public static String rec(int start, int end){
        int min =10;
        for(int i=start;i<end;i++)
            if(arr[i]<min)
                min=arr[i];
        for(int i=start;i<end;i++)
                arr[i]=arr[i]-min;
        StringBuilder builder = new StringBuilder();

        for(int i=0;i<min;i++){
            builder.append('(');
        }
        int from=start;
        for(int i=start;i<end;i++){
            if(arr[i]==0){
                if(from!=i){
                    builder.append(rec(from,i));
                    builder.append(original[i]);
                    from=i+1;
                }else{
                    builder.append(original[i]);
                    from++;
                }
            }else{
                if(i==end-1)
                    builder.append(rec(from,i+1));
            }
        }
        for(int i=0;i<min;i++){
            builder.append(')');
        }
        return builder.toString();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<tests;i++){
            String digits= scanner.nextLine();
            for(int j=0;j<digits.length();j++) {
                arr[j] = Integer.parseInt(digits.substring(j, j + 1));
                original[j]=arr[j];
            }
            String result = rec(0,digits.length());
            System.out.println("Case #"+(i+1)+": "+result);
        }


    }
}
