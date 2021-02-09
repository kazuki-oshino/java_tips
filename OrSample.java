public class OrSample {
    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        int k = -1;

        // ケース１
        if (i == 1 && j > 1 || k < 0) {
            System.out.println("true1");
        }

        // ケース2
        if (i == 1 && (j > 1 || k < 0)) {
            System.out.println("true2");
        }
    }
}
