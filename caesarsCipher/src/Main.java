import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class Main extends Application {

public static void main(String[] args) {
    Path input = Paths.get("src/resources/input.txt");
    Path output = Paths.get("src/resources/output.txt");
    Path decOutput = Paths.get("src/resources/decOutput.txt");
    launch(args);
}
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.setTitle("Шифр Цезаря");

        stage.show();
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

    public static String processString(Path inputFilePath, int key, String alphabet) {
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
        for (int i = 1; i < 33; i++) {
            String str = processString(inputFilePath, i, alphabet);
            System.out.println(str);
        }
    }

}
