import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path input = Paths.get("C:/Users/217042/Desktop/Java/caesarsCipher/src/input.txt");
        Path output = Paths.get("C:/Users/217042/Desktop/Java/caesarsCipher/src/output.txt");
        Path decOutput = Paths.get("C:/Users/217042/Desktop/Java/caesarsCipher/src/decOutput.txt");
        encrypt(input, output, 1);
        decrypt(output, decOutput, 1 );
        bruteforceDecrypt(output);

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
        writeToFile(outputFilePath, processString(inputFilePath, key, alphabet));
    }

    public static void decrypt(Path inputFilePath, Path outputFilePath, int key){
        String alphabet = "яюэьыъщшчцхфутсрпонмлкйизжёедгвба";
        //АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ
        writeToFile(outputFilePath, processString(inputFilePath, key, alphabet));
    }

    private static String processString(Path inputFilePath, int key, String alphabet) {
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
        }
        return result;
    }

    public static void bruteforceDecrypt(Path inputFilePath){
        String alphabet = "яюэьыъщшчцхфутсрпонмлкйизжёедгвба";
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nПрограмма будет выводить варианты с разным сдвигом. Вводите N пока не увидите осмысленный текст. Когда это произойдет введите Y. \n\n");
        for (int i = 1; i < 33; i++) {
            String str = processString(inputFilePath, i, alphabet);
            System.out.println(str);
            if (scanner.nextLine() == "Y"){
                System.out.print("Название файла для сохранения: ");
                String fileName = scanner.nextLine();
                writeToFile(Paths.get("C:/Users/217042/Desktop/Java/caesarsCipher/src/" + fileName), str);
            }
        }
    }
}