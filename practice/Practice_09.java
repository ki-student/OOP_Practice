import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice_09 {
    public static void main(String[] args) {
        String fileName = "novel.txt";  // 파일 이름을 적절히 수정하세요
        try {
            String content = readFromFile(fileName);
            String[] words = customSplit(content);
            Map<String, Integer> wordFrequency = calculateWordFrequency(words);

            // 결과 출력
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }

    private static String readFromFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static String[] customSplit(String s) {
        return s.split("[\t\n :.,;-]");
    }

    private static Map<String, Integer> calculateWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}