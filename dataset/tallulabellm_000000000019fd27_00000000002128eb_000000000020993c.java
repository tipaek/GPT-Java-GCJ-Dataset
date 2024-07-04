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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(inputString);
        String line = "";
        try {
            while ((line = in.readLine())!=null){
                int numc = Integer.parseInt(line);
                for(int c=0;c<numc;c++){
                    int trace = 0;
                    int rowc = 0;
                    int colc = 0;
                    int n = Integer.parseInt(in.readLine());
                    int[][] matrix = new int[n][n];
                    for(int row=0;row<n;row++){
                        String[] cols = in.readLine().split(" ");
                        for(int j=0;j<n;j++){
                            matrix[row][j] = Integer.parseInt(cols[j]);
                        }
                        trace += matrix[row][row];
                    }

                    for(int i=0;i<n;i++){
                        boolean[] seen = new boolean[n];
                        for(int j=0;j<n;j++){
                            if(seen[matrix[i][j]-1]){
                                rowc++;
                                break;
                            }
                            seen[matrix[i][j]-1] = true;
                        }
                    }
                    for(int j=0;j<n;j++){
                        boolean[] seen = new boolean[n];
                        for(int i=0;i<n;i++){
                            if(seen[matrix[i][j]-1]){
                                colc++;
                                break;
                            }
                            seen[matrix[i][j]-1] = true;
                        }
                    }
                    System.out.println("Case #"+(c+1)+":"+" " + trace + " " +rowc + " " + colc + " ");
                }

            }
        }
        catch (IOException e){}

    }
}


