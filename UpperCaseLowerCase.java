import java.util.Locale;

public class UpperCaseLowerCase {
    public static void main(String[] args) {
        // 大文字→小文字変換
        String upperWord = "ABCDE";
        System.out.println(upperWord.toLowerCase());

        // 小文字→大文字変換
        String lowerWord = "abcde";
        System.out.println(lowerWord.toLowerCase());

        // nullを変換しようとするとエラー発生
        String nullWord = null;
        System.out.println(nullWord.toLowerCase());
    }

    public static String toUpperCaseIfNotNull(String str) {
        if (str == null) {
            return "";
        }
        return str.toUpperCase();
    }

    public static String toLowerCaseIfNotNull(String str) {
        if (str == null) {
            return "";
        }
        return str.toLowerCase();
    }
}
