import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    //Задача 1
    public static float maxNum(float num1, float num2) throws Exception{
            if (num1 == num2){
                throw new Exception("Numbers are equal!");
            }
            else if (num1 > num2){
                return num1;
            }
            else {
                return num2;
            }
    }
    //Задача 2
    public static float divisionCalc(float num1, float num2) throws ArithmeticException{
        if(num2 == 0){
            throw new ArithmeticException("Zero division error!");
        }
        else{
            return num1 / num2;
        }
    }
    //Задача 3
    public static void tryParse(String str) throws NumberFormatException{
        try{
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("This string can not be converted!");
        }
    }
    //Задача 4
    public static void ageValidation(int age) throws IllegalArgumentException{
        if (0 > age ){
            throw new IllegalArgumentException("Age can not be less than 0 and more than 150!");
        }
    }
    //Задача 5
    public static float findRoot(float num, float pow) throws IllegalArgumentException{
        if (num < 0){
            throw new IllegalArgumentException("Root of " + num + " can no be found!");
        }
        else {
            return (float) Math.pow(num, 1.0 / pow);
        }
    }
    //Задача 6
    public static int Factorial(int num) throws IllegalArgumentException{
        if (num < 0){
            throw new IllegalArgumentException("Factorial of " + num + " can no be found!");
        }
        else {
            int fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            return fact;
        }
    }
    //Задача 7
    public static void hasZeros(int[] arr) throws Exception{
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0){
                throw new Exception("This array contains a zero!");
            }
        }
    }
    //Задача 8
    public static double Pow(int arg, int pow) throws IllegalArgumentException{
        if (!(pow < 0)){
            return Math.pow(arg, pow);
        }
        else {
            throw new IllegalArgumentException("Provided power argument is invalid!");
        }
    }
    //Задача 9
    public static String sliceStr(String str, int arg) {
        if (arg <= str.length() ){
            return str.substring(0, arg);
        }
        else {
            throw new IllegalArgumentException("Provided argument is invalid!");
        }
    }
    //Задача 10
    public static int findElement(int[] arr, int toSearch) throws Exception{
        for (int i = 0; i < arr.length - 1; i++) {
            if (toSearch == i){
                return i;
            }
        }
        throw new Exception("Element not found!");
    }
    //Задача 11
    public static String convertToBinary(int num) throws IllegalArgumentException{
        if (!(num < 0)){
            return Integer.toBinaryString(num);
        }
        throw new IllegalArgumentException("This number can not be converted to binary!");
    }
    //Задача 12
    public static void isDividable(float num1, float num2) throws ArithmeticException{
        if (!(num2 == 0)){
            float res = num1 / num2;
        }
        throw new ArithmeticException("Zero division error!");
    }
    //Задача 13
    public static String findElementInList(List<String> list, int index) throws IndexOutOfBoundsException{
        if (!(index > list.size())){
            return list.get(index);
        }
        throw new IndexOutOfBoundsException("This index is too big!");
    }
    //Задача 14
    public static void validatePassword(String password) throws WeakPasswordException{
        if (password.length() < 8){
            throw new WeakPasswordException("This password is too weak!");
        }
    }
    //Задача 15
    public static void validateDate(String date) throws DateTimeParseException{
        try {
            Date.parse(date);
        }
        catch (IllegalArgumentException e){
            throw new DateTimeParseException("This string can not be converted to date!", date, 52);
        }
        //Оно итак выбрасывает InvalidArgument, не знаю как по-другому обработать и ваще зачем тут DateTimeParseException :)
    }
    //Задача 16
    public static String concatStrings(String str1, String str2) throws NullPointerException{
        if ((str1 == null) || (str2 == null)){
            throw new NullPointerException("One of provided strings is NULL!");
        }
        return str1 + str2;
    }
    //Задача 17
    public static float getRemainder(float num1, float num2) throws ArithmeticException{
        if (!(num2 == 0)){
            return num1 % num2;
        }
        throw new ArithmeticException("Zero division exception!");
    }
    //Задача 18
    public static double findSquareRoot(float num) throws ArithmeticException{
        if (!(num < 0)){
            return Math.sqrt(num);
        }
        throw new ArithmeticException("Square root can not be found!");
    }
    //Задача 19
    public static double celsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Температура не может быть ниже абсолютного нуля (-273.15°C).");
        }
        return (celsius * 9 / 5) + 32;
    }
    //Задача 20
    public static void checkString(String str) throws IllegalArgumentException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is empty or null!");
        }
    }
}