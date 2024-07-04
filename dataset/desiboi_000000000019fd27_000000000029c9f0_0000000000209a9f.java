import java.util.Scanner;
class IntPar{
    static int str2int(String s){
        return Integer.parseInt(s);
    }
    public static String s1(String s){
        String[] s_list = s.split("");
        String[] new_s_list = new String[s_list.length];
        for (int i = 0; i < s_list.length; i++){
            new_s_list[i] = s_list[i];
        }

        for (int i = 0; i < Integer.parseInt(s_list[0]); i++){
            new_s_list[0] = "(".concat(new_s_list[0]);
        }

        for (int i = 0; i < Integer.parseInt(s_list[s_list.length-1]); i++){
            new_s_list[s_list.length -1] = new_s_list[s_list.length -1].concat(")");
        }

        for (int i = 0; i < s_list.length - 1; i++){
            int added_brackets = str2int(s_list[i+1]) - str2int(s_list[i]);
            if (added_brackets > 0){
                for (int j = 0; j < added_brackets; j++){
                    new_s_list[i] = new_s_list[i].concat("(");
                } 
            } else {
                for (int j = 0; j < 0-added_brackets; j++){
                    new_s_list[i] = new_s_list[i].concat(")");
                } 
            }
        }
        
        s = String.join("", new_s_list);

        return s;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            System.out.print("Enter the number: ");
            String n = sc.next();
            System.out.println(s1(n));
            System.out.println();
        }
        
    }
}