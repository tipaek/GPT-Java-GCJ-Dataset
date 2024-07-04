import java.util.Scanner;

public class solve {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int tt = scanner.nextInt();
        for(int i = 0; i < tt; i++){
            String s = scanner.next();

            int repeat = 1;
            StringBuilder result = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                int no = s.toCharArray()[j];

                try {
                    if(s.charAt(j + 1) == no){
                        repeat++;
                        continue;
                    }
                }catch (Exception ignored){}

                for(int k = 0; k < no -48; k++){
                    result.append("(");
                }

                for(int k = 0; k < repeat; k++){
                    result.append((char) no);
                }

                for(int k = 0; k < no -48; k++){
                    result.append(")");
                }

                repeat = 1;
            }
            System.out.println("Case #" + (i+1) + ": " + result);
        }
    }
}
