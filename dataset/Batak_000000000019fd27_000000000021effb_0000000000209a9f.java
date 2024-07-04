import java.util.Scanner;

class nesting_depth {
   public static final void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      String convert_int = str;
      int kotlin = Integer.parseInt(convert_int);
      int k = 1;
      int data = kotlin;
      if (k <= kotlin) {
         while(true) {
            String x = sc.nextLine();
            String finalstringcodejam = "";
            int codejam = 0;
            int i = 0;
            int len = x.length() - 1;
            if (i <= len) {
               while(true) {
                  int z;
                  for(z = x.charAt(i) - 48; codejam > z; --codejam) {
                     finalstringcodejam = finalstringcodejam + ")";
                  }

                  while(codejam < z) {
                     finalstringcodejam = finalstringcodejam + "(";
                     ++codejam;
                  }

                  finalstringcodejam = finalstringcodejam + "" + z;
                  if (i == len) {
                     break;
                  }

                  ++i;
               }
            }

            while(codejam != 0) {
               finalstringcodejam = finalstringcodejam + ")";
               --codejam;
            }

            String result = "Case #" + k + ": " + finalstringcodejam;
            System.out.println(result);
            if (k == data) {
               break;
            }

            ++k;
         }
      }

   }
}
