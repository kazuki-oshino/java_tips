import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

public class MapForEach {
    public static void main(String[] args) {
        
        Map<String, String> userMap = new HashMap<>();
        userMap.put("00111", "山田太郎");
        userMap.put("00112", "スズキ次郎");
        userMap.put("00113", "斎藤健二");

        // BiConsumerを宣言
        BiConsumer<String, String> logAccess = MapForEach::logAccess;
        BiConsumer<String, String> insertAccessRecord = MapForEach::insertAccessRecord;

        // BiConsumerで宣言した処理を呼び出し
        userMap.forEach(logAccess.andThen(insertAccessRecord));
        
        // EntrySetを使用したループ
        // for (Entry<String, String> user : userMap.entrySet()) {
        //     logAccess(user.getValue(), user.getKey());
        //     insertAccessRecord(user.getKey(), user.getValue());
        // }

    }

    static void logAccess(String employeeId, String name) {
        System.out.println("access! 社員番号:" + employeeId + " " + "氏名:" + name );
    }

    static void insertAccessRecord(String employeeId, String name) {
        System.out.println("アクセスログをデータベースに投入! 社員番号:" + employeeId + " " + "氏名:" + name );
    }

}
