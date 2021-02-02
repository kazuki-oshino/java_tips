import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class ForEachTest {
    
    public static void main(String[] args) {
        // 単語リスト生成
        List<String> wordsList = new ArrayList<>();
        wordsList.add("乾パン");
        wordsList.add("乾パン");
        wordsList.add("乾パン");
        wordsList.add("食パン");

        wordsList.stream().forEach(System.out::println);

        // エセstream() やってはいけない！
        Map<String, Long> wordsCount1 = new HashMap<>();
        wordsList.stream().forEach(word -> {
            wordsCount1.merge(word, 1L, Long::sum);
        });
        System.out.println(wordsCount1); // {食パン=1, 乾パン=3}

        // 正しいstream()の使い方
        Map<String, Long> wordsCount2 = 
            wordsList.stream()
                     .collect(groupingBy(word -> word, counting()));
        System.out.println(wordsCount2); // {食パン=1, 乾パン=3}
    }

}
