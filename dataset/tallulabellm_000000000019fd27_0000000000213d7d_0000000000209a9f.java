import java.io.*;

class Solution{
    public static void main(String[] args) {
//        Reader inputString = new StringReader("3\n" +
//                "4\n" +
//                "1 2 3 4\n" +
//                "2 1 4 3\n" +
//                "3 4 1 2\n" +
//                "4 3 2 1\n" +
//                "4\n" +
//                "2 2 2 2\n" +
//                "2 3 2 3\n" +
//                "2 2 2 3\n" +
//                "2 2 2 2\n" +
//                "3\n" +
//                "2 1 3\n" +
//                "1 3 2\n" +
//                "1 2 3");
//        Reader inputString = new StringReader("4\n" +
//                "0000\n" +
//                "101\n" +
//                "111000\n" +
//                "1");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(inputString);
        String line = "";
        try {
            while ((line = in.readLine())!=null){
                int numc = Integer.parseInt(line);
                for(int c=0;c<numc;c++){
                    String digits = in.readLine();
                    int length = digits.length();
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int i=0;i<length;i++){
                        int count = 1;
                        int j=i+1;
                        while (j<length&&digits.charAt(j)==digits.charAt(i)){
                            count++;
                            j++;
                        }
                        int need = Character.getNumericValue(digits.charAt(i));
                        for(int l=0;l<need;l++){
                            stringBuilder.append("(");
                        }
                        for(int l=0;l<count;l++){
                            stringBuilder.append(digits.charAt(i));
                        }
                        for(int l=0;l<need;l++){
                            stringBuilder.append(")");
                        }
                        i = j-1;
                    }
//                    System.out.println("Case #"+(c+1)+":"+" " + trace + " " +rowc + " " + colc + " ");
                    System.out.println("Case #"+(c+1)+":"+" " + stringBuilder.toString());
                }

            }
        }
        catch (IOException e){}

    }
}


