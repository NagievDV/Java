import java.nio.file.Path;
import java.util.*;

public class StatisticDecryption {

    private static final Map<Character, Double> frequencyMap = new HashMap<>();

    static {
        frequencyMap.put('о', 0.109);
        frequencyMap.put('е', 0.084);
        frequencyMap.put('а', 0.073);
        frequencyMap.put('и', 0.075);
        frequencyMap.put('н', 0.067);
        frequencyMap.put('т', 0.063);
        frequencyMap.put('с', 0.055);
        frequencyMap.put('л', 0.045);
        frequencyMap.put('р', 0.043);
        frequencyMap.put('к', 0.038);
        frequencyMap.put('м', 0.032);
        frequencyMap.put('д', 0.030);
        frequencyMap.put('п', 0.029);
        frequencyMap.put('у', 0.028);
        frequencyMap.put('я', 0.027);
        frequencyMap.put('г', 0.027);
        frequencyMap.put('ь', 0.025);
        frequencyMap.put('з', 0.024);
        frequencyMap.put('в', 0.019);
        frequencyMap.put('й', 0.017);
        frequencyMap.put('ч', 0.016);
        frequencyMap.put('х', 0.013);
        frequencyMap.put('ц', 0.012);
        frequencyMap.put('ш', 0.010);
        frequencyMap.put('щ', 0.008);
        frequencyMap.put('ъ', 0.002);
        frequencyMap.put('ы', 0.020);
        frequencyMap.put('э', 0.003);
        frequencyMap.put('ю', 0.004);
        frequencyMap.put('ф', 0.002);
    }

    public static List<Map.Entry<Double, String>> decrypt(Path inputFilePath) {
        List<Map.Entry<Double, String>> bestDecryptions = new ArrayList<>();
        double highestScore = Double.MAX_VALUE;

        for (int shift = 1; shift < 33; shift++) {
            String currentDecryption =  Main.processString(inputFilePath, shift, "яюэьыъщшчцхфутсрпонмлкйизжёедгвба" );
            double score = evaluateFrequency(currentDecryption.toString());
            bestDecryptions.add(new AbstractMap.SimpleEntry<>(score, currentDecryption.toString()));
        }
        bestDecryptions.sort(Map.Entry.comparingByKey());

        return bestDecryptions;
    }

    private static double evaluateFrequency(String text) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char ch : text.toCharArray()) {
            if (frequencyMap.containsKey(ch)) {
                letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
            }
        }

        double score = 0;
        int totalLetters = text.length();
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            char letter = entry.getKey();
            double frequency = (double) entry.getValue() / totalLetters;
            score += Math.abs(frequency - frequencyMap.get(letter));
        }
        return score;
    }

}
