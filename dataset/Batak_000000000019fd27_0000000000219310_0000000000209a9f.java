import java.util.Scanner;

class prog2 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      String str2 = str;
      int convert_int = Integer.parseInt(str2);
      int k = 1;
      int str3 = convert_int;
      if (k <= convert_int) {
         while(true) {
            String x = sc.nextLine();
            String ans = "";
            Integer[] a = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int open = 0;
            int i = 0;
            int data = x.length() - 1;
            if (i <= data) {
               while(true) {
                  int z = x.charAt(i) - 48;
                  if (z == 0) {
                     while(true) {
                        if (open == 0) {
                           ans = ans + "0";
                           break;
                        }

                        ans = ans + ")";
                        --open;
                        a = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                     }
                  } else if (i > 0 && x.charAt(i) == x.charAt(i - 1)) {
                     ans = ans + "" + z;
                  } else if (z > 0 && a[z] == 0) {
                     ans = ans + '(' + z;
                     a[z] = a[z] + 1;
                     ++open;
                  } else {
                     ans = ans + ")";
                     a[z] = a[z] - 1;
                  }

                  if (i == data) {
                     break;
                  }

                  ++i;
               }
            }

            while(open != 0) {
               ans = ans + ")";
               --open;
            }

            String final_ans = "Case #" + k + ": " + ans;
            System.out.println(final_ans);
            if (k == str3) {
               break;
            }

            ++k;
         }
      }

   }
}




