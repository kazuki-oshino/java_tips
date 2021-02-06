import java.util.UUID;

public class Uuid {
    public static void main(String[] args) {
        String uuidStr = "40c79cf6-bf1d-4f87-8cb9-95fb5a8fc619";
        UUID uuid = UUID.fromString(uuidStr);
        System.out.println(uuid.toString());
    }
}
