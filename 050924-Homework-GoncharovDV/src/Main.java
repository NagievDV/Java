import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Задача 1

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int num = scanner.nextInt();
//        System.out.println(num % 2==0 ? "Even" : "Odd");

//        Задача 2

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input num1: ");
//        int num1 = scanner.nextInt();
//        System.out.print("Input num2: ");
//        int num2 = scanner.nextInt();
//        System.out.print("Input num3: ");
//        int num3 = scanner.nextInt();
//        System.out.println("Minimal number is: " + Math.min(Math.min(num1, num2), num3));

//        Задача 3

//        System.out.println("Multiplication table for 5");
//        for (int i = 1; i <=10; i++){
//            System.out.println("5 * " + i + " = " + 5*i);
//        }

//        Задача 4 (Включая N)

//       Scanner scanner = new Scanner(System.in);
//       System.out.print("Input N: ");
//       int N = scanner.nextInt();
//       int sum = 0;
//       for(int i = 0; i <= N; i++){
//           sum +=i;
//       }
//        System.out.println("Sum of all numbers till N: " + sum);

//        Задача 5

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input N: ");
//        int N = scanner.nextInt();
//        int fib1 = 0, fib2=1;
//        for (int i = 0; i < N; i++) {
//            System.out.println("Fibonacci number["+ i + "] " + fib1);
//            int next = fib1 + fib2;
//            fib1 = fib2;
//            fib2 = next;
//        }

//        Задача 6

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int num = scanner.nextInt();
//        boolean isComplex = false;
//        for(int i = 2; i < num; i++){
//            if (num % i == 0){
//                isComplex = true;
//                break;
//            }
//        }
//        System.out.println(isComplex ? "This number is complex" : "This number is prime");

//        Задача 7

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int num = scanner.nextInt();
//        for (int i = num; i > 0; i--){
//            System.out.println(i);
//        }

//        Задача 8

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input A: ");
//        int A = scanner.nextInt();
//        System.out.print("Input B: ");
//        int B = scanner.nextInt();
//        int sum = 0;
//        for(int i = A; i <= B; i++){
//            sum+=i;
//        }
//        System.out.println("Sum of all numbers from A to B: " + sum);

//        Задача 9

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a string: ");
//        String str = scanner.nextLine();
//        for(int i = str.length() - 1; i >=0; i--){
//            System.out.print(str.charAt(i));
//        }

//        Задача 10

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int num = scanner.nextInt();
//        int count = 1;
//        while(num / 10 > 0){
//            count++;
//            num = num / 10;
//        }
//        System.out.println("This number has " + count + " digits");

//        Задача 11

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input N: ");
//        int N = scanner.nextInt();
//        int factorialN = 1;
//        for(int i = 1; i <= N; i++){
//            factorialN = factorialN * i;
//        }
//        System.out.println("Factorial of " + N + " is " + factorialN);

//        Задача 12

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int num = scanner.nextInt();
//        int sum = 0;
//        while(num / 10 > 0){
//            sum += num % 10;
//            num = num / 10;
//        }
//        sum += num;
//        System.out.println("Sum of all digits in this number: " + sum);

//        Задача 13

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a string: ");
//        String str = scanner.nextLine();
//        boolean isPalindrome = true;
//        for(int i = 0; i < str.length(); i++){
//            if (!(str.toCharArray()[i] == str.toCharArray()[str.length()-1-i])){
//                isPalindrome = false;
//            }
//        }
//        System.out.println(isPalindrome);

//        Задача 14

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input number of elements: ");
//        int len = scanner.nextInt();
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++){
//            System.out.print("Input number[" + i + "]: ");
//            arr[i] = scanner.nextInt();
//        }
//        int maxNum = arr[0];
//
//        for(int el : arr){
//            if(el > maxNum){
//                maxNum = el;
//            }
//        }
//        System.out.println("Max number in this array is: " + maxNum);

//        Задача 15

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input number of elements: ");
//        int len = scanner.nextInt();
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++){
//            System.out.print("Input number[" + i + "]: ");
//            arr[i] = scanner.nextInt();
//        }
//        int sum = 0;
//        for(int el : arr){
//            sum += el;
//        }
//        System.out.println("Sum of all elements of this array is: " + sum);

//        Задача 16

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input number of elements: ");
//        int len = scanner.nextInt();
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++){
//            System.out.print("Input number[" + i + "]: ");
//            arr[i] = scanner.nextInt();
//        }
//        int negative = 0, positive = 0;
//        for(int el : arr){
//            if(el > 0){
//                positive++;
//            }
//            else if(el < 0){
//                negative++;
//            }
//        }
//        System.out.println("This array has " + positive + " positive and " + negative + " negative elements");
//
//        Задача 17

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input A: ");
//        int A = scanner.nextInt();
//        System.out.print("Input B: ");
//        int B = scanner.nextInt();
//        for (int i = A; i <= B; i++) {
//            boolean isComplex = false;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isComplex = true;
//                    break;
//                }
//            }
//            if(!isComplex) {
//                System.out.println(i);
//            }
//        }

//        Задача 18

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a string: ");
//        String str = scanner.nextLine();
//        String vowels = "aeiouAEIOU";
//        String consonants = "qrtpsdfghjklzxcvbnmwyQRTPSDFGHJKLZXCVBNMWY";
//        int vowelsCount = 0, consonantsCount = 0;
//        for (char el : str.toCharArray()){
//            if(vowels.indexOf(el) != -1){
//                vowelsCount++;
//            }
//            else if(consonants.indexOf(el) != -1){
//                consonantsCount++;
//            }
//        }
//        System.out.println("This string has " + vowelsCount + " vowels and " + consonantsCount + " consonants");

//        Задача 19

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a string: ");
//        String str = scanner.nextLine();
//        String[] words = str.split(" ");
//        for (int i = words.length-1; i >= 0; i--){
//            System.out.print(words[i] + " ");
//        }

//        Задача 20

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input a number: ");
//        int number = scanner.nextInt(), num = number, count = 1, sum = 0;
//        while(num / 10 > 0){
//            num = num / 10;
//            count++;
//        }
//
//        num = number;
//        while(num / 10 > 0){
//            sum += Math.pow((num % 10), count);
//            num = num / 10;
//        }
//        sum += Math.pow((num % 10), count);
//        System.out.println(sum == number ? "Number "+ number + " is an Armstrong number" : "Number "+ number + " is not an Armstrong number");

    }
}