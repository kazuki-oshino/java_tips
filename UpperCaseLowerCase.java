import java.util.Locale;

public class UpperCaseLowerCase {
    public static void main(String[] args) {
        // 大文字→小文字変換
        String upperWord = "ABCDE";
        System.out.println(toLowerCaseIfNotNull(upperWord));

        // 小文字→大文字変換
        String lowerWord = "abcde";
        System.out.println(toUpperCaseIfNotNull(lowerWord));

        // nullを変換しようとすると空が返却される
        String nullWord = null;
        System.out.println(toLowerCaseIfNotNull(nullWord));
    }

    public static String toLowerCaseIfNotNull(String str) {
        if (str == null) {
            return "空だよー";
        }
        return str.toLowerCase(Locale.ENGLISH);
    }

    public static String toUpperCaseIfNotNull(String str) {
        if (str == null) {
            return "空だよー";
        }
        return str.toUpperCase(Locale.ENGLISH);
    }
}
