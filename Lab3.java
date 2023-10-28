import java.util.Arrays;
import java.util.Comparator;

public class Lab3 {
    public static void main(String[] args) {
        try {
            String testString = "This is a short sentence!!! However, this sentence is a bit longer than the previous one. This one is the longest sentence among all in this example, as it has the most words.";

            String resultString = sortSentencesByWordCountAsc(testString);
            System.out.println(resultString);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static String sortSentencesByWordCountAsc(String string) throws Exception {
        if (!isTextValid(string)) {
            throw new Exception("Review your input");
        }

        //Seeks for a WHITESPACE after [.!?] 
        String[] sentences = string.split("(?<=[.!?])\\s");

        Arrays.sort(sentences, Comparator.comparingInt(s -> s.split("\\s+").length));
        
        String resultString = "";
        for (String sentence : sentences) {
            resultString += sentence + " ";
        }
        return resultString.toString().trim();
    }

    private static boolean isTextValid(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        char first = text.charAt(0);
        char last = text.charAt(text.length() - 1);

        return Character.isUpperCase(first) && (last == '.' || last == '?' || last == '!');
    }
}