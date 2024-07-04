public class Test {
    public static void main(String[] args) {
        printArguments(args);
    }

    private static void printArguments(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}