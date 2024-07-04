import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String solution = "";
        for(int k = 1; k <= t;k++){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();

            int num = 0;
            int zagrade = 0;
            int prvi = Character.getNumericValue(arr[0]);

            num = prvi;
            zagrade = prvi;

            for(int i = 0; i < prvi;i++){
                sb.append('(');
            }
            sb.append(prvi);

            for(int i = 1; i < arr.length;i++){
                int d = Character.getNumericValue(arr[i]);

                if(d == num){
                    sb.append(d);
                }else if(d > num){
                    int diff = d - num;
                    for(int j = 0; j < diff;j++){
                        sb.append('(');
                        zagrade++;
                    }
                    sb.append(d);
                }else{
                    int diff = num - d;
                    for(int j = 0; j < diff ;j++){
                        sb.append(')');
                        zagrade--;
                    }
                    sb.append(d);

                }
                num = Character.getNumericValue(arr[i]);

            }
            while (zagrade -- > 0){
                sb.append(')');
            }

            solution += "Case#" + k + ": "+sb.toString();
            solution = "";
            System.out.println(solution);
        }
//        System.out.println(solution);
    }
}