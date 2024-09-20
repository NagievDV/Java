import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path input = Paths.get("C:/Users/217042/Desktop/caesarsCipher/src/input.txt");
        Path output = Paths.get("C:/Users/217042/Desktop/caesarsCipher/src/output.txt");
        Path decOutput = Paths.get("C:/Users/217042/Desktop/caesarsCipher/src/decOutput.txt");
        encrypt(input, output, 1);
        decrypt(output, decOutput, 1 );

    }

    public static String readFromFile(Path filePath) {
        try {
            return new String(Files.readAllBytes(filePath));
        } catch (IOException ex) {
            return "";
        }
    }

    public static void writeToFile(Path filePath, String content) {
        try {
            Files.writeString(filePath, content, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            return;
        }
    }

    public static void encrypt(Path inputFilePath, Path outputFilePath, int key) throws IllegalArgumentException {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        //АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ
        if (key < 1 || key > alphabet.length() - 1)
            throw new IllegalArgumentException("Key must be greater than 0 and less than 33");
        char[] inputString = readFromFile(inputFilePath).toCharArray();
        String result = "";
        for (int i = 0; i < inputString.length; i++) {
            char currentChar = inputString[i];
            if (!Character.isLetter(currentChar)) {
                result += currentChar;
                continue;
            }
            int indexToAdd = alphabet.indexOf(Character.toLowerCase(currentChar)) + key;
            if (indexToAdd > alphabet.length() - 1) {
                indexToAdd -= alphabet.length();
            }
            result += Character.isUpperCase(currentChar) ? Character.toUpperCase(alphabet.charAt(indexToAdd)) : alphabet.charAt(indexToAdd);

            writeToFile(outputFilePath, result);
        }
    }

    public static void decrypt(Path inputFilePath, Path outputFilePath, int key){
        String alphabet = "яюэьыъщшчцхфутсрпонмлкйизжёедгвба";
        //АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ
        if (key < 1 || key > alphabet.length() - 1)
            throw new IllegalArgumentException("Key must be greater than 0 and less than 33");
        char[] inputString = readFromFile(inputFilePath).toCharArray();
        String result = "";
        for (int i = 0; i < inputString.length; i++) {
            char currentChar = inputString[i];
            if (!Character.isLetter(currentChar)) {
                result += currentChar;
                continue;
            }
            int indexToAdd = alphabet.indexOf(Character.toLowerCase(currentChar)) + key;
            if (indexToAdd > alphabet.length() - 1) {
                indexToAdd -= alphabet.length();
            }
            result += Character.isUpperCase(currentChar) ? Character.toUpperCase(alphabet.charAt(indexToAdd)) : alphabet.charAt(indexToAdd);
            System.out.println(result);
            writeToFile(outputFilePath, result);
        }
    }
}