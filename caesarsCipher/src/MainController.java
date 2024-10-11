import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MainController {
    private int currentKey = 1;
    public Path filePath;
    public String alphabet;
    private int currentStatIndex = 0;
    private List<Map.Entry<Double, String>> decryptedTexts;
    @FXML
    private RadioButton rbEncrypt;

    @FXML
    private RadioButton rbBruteforceDecrypt;

    @FXML
    private RadioButton rbDecrypt;

    @FXML
    private RadioButton rbStatisticDecrypt;

    @FXML
    private Label lbFilePath;

    @FXML
    private TextArea taResult;

    @FXML
    public void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        rbEncrypt.setToggleGroup(toggleGroup);
        rbDecrypt.setToggleGroup(toggleGroup);
        rbBruteforceDecrypt.setToggleGroup(toggleGroup);
        rbStatisticDecrypt.setToggleGroup(toggleGroup);
    }

    @FXML
    public void handleChooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            filePath = selectedFile.toPath();
            lbFilePath.setText(filePath.toString());
            taResult.setText(Main.readFromFile(filePath));
        }
    }

    @FXML
    public void handleProcess() {
        Path path = Paths.get(lbFilePath.getText());
        if (rbEncrypt.isSelected()) {
            alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            taResult.setText(Main.processString(path, Integer.parseInt(showKeyInputDialog()), alphabet));
        }
        else if (rbDecrypt.isSelected()) {
            alphabet = "яюэьыъщшчцхфутсрпонмлкйизжёедгвба";
            taResult.setText(Main.processString(path, Integer.parseInt(showKeyInputDialog()), alphabet));
        }
        else if (rbBruteforceDecrypt.isSelected()){
            alphabet = "яюэьыъщшчцхфутсрпонмлкйизжёедгвба";
            taResult.setText("Сдвиг: " + currentKey + "\n" + Main.processString(path, currentKey, alphabet));

            currentKey++;

            if (currentKey > alphabet.length() - 1) {
                currentKey = 1;
            }
        }
        else if (rbStatisticDecrypt.isSelected()) {
            if (decryptedTexts == null) {
                decryptedTexts = StatisticDecryption.decrypt(filePath);
            }

            if (currentStatIndex < decryptedTexts.size()) {
                Map.Entry<Double, String> entry = decryptedTexts.get(currentStatIndex);
                taResult.setText("Рейтинг: " + entry.getKey() + "\nТекст: " + entry.getValue());

                currentStatIndex++;
            } else {
                currentStatIndex = 0;
            }
        }
    }


    @FXML
    public void handleSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить шифр");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        fileChooser.setInitialFileName("output.txt");

        Stage stage = new Stage();
        File fileToSave = fileChooser.showSaveDialog(stage);
        if (fileToSave != null) {
            try {
                // Записываем текст из taResult в выбранный файл
                Main.writeToFile(fileToSave.toPath(), taResult.getText());
            } catch (Exception e) {
                e.printStackTrace();
                // Здесь можно добавить оповещение об ошибке
            }
        }

    }

    public String showKeyInputDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Введите ключ");
        dialog.setHeaderText("Требуется ключ для расшифровки");
        dialog.setContentText("Введите ключ:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

}
