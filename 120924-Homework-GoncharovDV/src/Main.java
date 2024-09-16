import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Cow implements IAnimal {

    public void makeSound() {
        System.out.println("Moo moo, I'm a cow.");
    }
}
class Animal {
    public void move(){
        System.out.println("Animal is moving.");
    }
}

class BankAccount {
    private int accountNumber;
    private float balance;
    public BankAccount(int accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(float amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Deposit amount is negative!");
    }
    public void withdraw(float amount) {
        if (amount < balance) balance -= amount;
        else System.out.println("Withdrawal amount is greater than balance!");
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public float getBalance() {
        return balance;
    }
}

class Bike extends Transport{
    public void move(){
        System.out.println("Bike is moving");
    }
}

class Bird extends Animal {
    @Override
    public void move(){
        System.out.println("Bird is flying.");
    }
}

class Book {
    String title;
    String author;
    int year;
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Car extends Transport {
    public void move(){
        System.out.println("Car is moving.");
    }
}

class Cat implements IAnimal{
    public void makeSound(){
        System.out.println("Meow meow, I'm a cat.");
    }
}

class Device {
    public String brand;

    public void turnOn(){
        System.out.println("Device is turning on.");
    }
    public void turnOff(){
        System.out.println("Device is turning off.");
    }
}

class DogTask9 extends Animal {
    @Override
    public void move(){
        System.out.println("Dog is moving.");
    }
}

class Enemy {
    String name;
    double health;
    String enemyClass;
    double damageModifier;
    Weapon weapon = new Weapon("Toothpick", 3);

    public Enemy(String name, double health, double damageModifier, String playerClass) {
        this.name = name;
        this.health = health;
        this.damageModifier = damageModifier;
        this.enemyClass = playerClass;
    }

    public void battleCry() {
        if (enemyClass.equals("Barbarian")) damageModifier *= 3;
        else damageModifier /= 2;
    }

    public void hit(Player player){
        player.health -= weapon.damage * damageModifier;
    }

    public void pickupWeapon(Weapon weapon){
        this.weapon = weapon;
    }
}

class Fish extends Animal {
    @Override
    public void move() {
        System.out.println("Fish is swimming.");
    }
}

class Game {
    private static char[][] gameField = new char[3][3];
    private static PlayerTask20 lastPlay = null;

    private static void checkField(){
        char symbol = lastPlay.getSymbol();
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == symbol && gameField[i][1] == symbol && gameField[i][2] == symbol) {
                finishGame();
                return;
            }
            if (gameField[0][i] == symbol && gameField[1][i] == symbol && gameField[2][i] == symbol) {
                finishGame();
                return;
            }
        }

        if ((gameField[0][0] == symbol && gameField[1][1] == symbol && gameField[2][2] == symbol) ||
                (gameField[0][2] == symbol && gameField[1][1] == symbol && gameField[2][0] == symbol)) {
            finishGame();
        }
    }

    private static void finishGame() {
        gameField = new char[3][3];
        lastPlay.increaseScore();
        System.out.println("The game is finished. \n\n" + lastPlay.getName() + " has won with current score of: " + lastPlay.getScore());
        lastPlay = null;
    }

    public static void showField(){
        for (char[] str : gameField){
            for (char ch : str){
                System.out.print(ch + ' ');
            }
            System.out.println();
        }
    }

    public void setPlay(int index1, int index2, PlayerTask20 player){
        lastPlay = player;
        gameField[index1][index2] = player.getSymbol();
        checkField();
    }
}

interface IAnimal {
    void makeSound();
}

interface IPaymentSystem {
    void pay();
    void refund();
}

class Laptop extends Device{
    public void updateDrivers(){
        System.out.println("The drivers have been updated.");
    }
}

class Library {
    List<Book> books = new ArrayList<Book>();
    public Library(List<Book> books) {
        this.books = books;
    }
    public Library() {
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.author.equals(author)) {
                System.out.println("Found book: " + book.title + " by " + book.author + " released in " + book.year);
            }
        }
    }
    public void searchByYear(int year) {
        for (Book book : books) {
            if (book.year == year) {
                System.out.println("Found book: " + book.title + " by " + book.author + " released in " + book.year);
            }
        }
    }
}

class Order {
    String customerName;
    int orderId;
    public List<Product> products = new ArrayList<>();
    public Date orderDate;

    public Order(String customerName, int orderId, Date orderDate) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public double getTotal(){
        double total = 0;
        for (Product product : products){
            total += product.price;
        }
        return total;
    }

    public void addProduct(Product product){
        if (product != null) products.add(product);
    }

    @Override
    public String toString(){
        return "Order " + orderId + " by " + customerName + " made on " + orderDate;
    }

    public Date getOrderDate(){
        return orderDate;
    }
}

class Player {
    String name;
    double health;
    String playerClass;
    double damageModifier;
    Weapon weapon = new Weapon("Fists", 10);

    public Player(String name, double health, double damageModifier, String playerClass) {
        this.name = name;
        this.health = health;
        this.damageModifier = damageModifier;
        this.playerClass = playerClass;
    }

    public void hit(Enemy enemy){
        enemy.health -= weapon.damage * damageModifier;
    }
    public void pickupWeapon(Weapon weapon){
        this.weapon = weapon;
    }

}

class Person {
    String name;
    float age;
    String gender;
    public Person(String name, float age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void incrementAge(){
        age++;
    }
    public void showInfo(){
        System.out.println("Name: " + name + " Age: " + age + " Gender: " + gender);
    }
    public void changeName(String newName) {
        name = newName;
    }
}

class PlayerTask20 {
    private String name;
    private char symbol;
    private int score;

    public void makePlay(int index1, int index2, Game game){
        if (index1 >= 0 && index1 < 3 && index2 >= 0 && index2 < 3){
            game.setPlay(index1, index2,this);
        }
        else {
            System.out.println("Invalid indexes!");
        }
    }

    protected char getSymbol(){
        return symbol;
    }

    public void increaseScore(){
        score++;
    }
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
}

class Point {
    double x;
    double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

}

class Rectangle extends Shape {
    double width;
    double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return width * height;
    }
}

class RectangleTask14 {
    Point[] rectanglePoints = new Point[2];

    public double calculateArea() {
        return Math.abs(rectanglePoints[1].x - rectanglePoints[0].x) * Math.abs(rectanglePoints[0].y - rectanglePoints[1].y);
    }
}

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape{
    double radius;
    double getArea(){
        return Math.PI * Math.pow(radius, 2.0);
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

}

class Counter {
    public static int count = 0;
    public Counter() {
        count++;
    }
}

class CreditCard implements IPaymentSystem{
    public void pay(){
        System.out.println("Payment with a CreditCard");
    }
    public void refund(){
        System.out.println("Refund with a CreditCard");
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<Order>();
    public Customer(String name) {
        this.name = name;
    }

    public void addOrder(Order order) {
        order.customerName = name;
        orders.add(order);
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void showOrdersHistory(){
        orders.sort(Comparator.comparing(Order::getOrderDate));
        for (Order order : orders ){
            System.out.println(order.toString());
        }
    }
}

class Dog implements IAnimal{
    public void makeSound() {
        System.out.println("Woof woof, I'm a dog.");
    }
}

class Manager extends Worker{
    List<Worker> subordinates;
    public Manager(String name, float age, String gender, float salary, List<Worker> workers) {
        super(name, age,gender, salary);
    }
}

class Matrix {
    private int rows;
    private int cols;
    private int[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix add(int number) {
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[i][j] = this.data[i][j] + number;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrix multiplication is not defined for these dimensions.");
        }

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                result.data[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }
}

class PayPal implements IPaymentSystem{
    public void pay(){
        System.out.println("Payment with PayPal");
    }
    public void refund(){
        System.out.println("Refund with PayPal");
    }
}

class Smartphone extends Device{
    public void takePhoto(){
        System.out.println("A photo has been taken.");
    }
}

class Store {

    public List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
            }
        }
    }

    public Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}

class Student {
    String name;
    String group;
    double grade;

    public String getName() {
        return name;
    }
}

abstract class Transport {
    public abstract void move();
}

class UniqueID {

    private static int currentId = 0;

    public static synchronized int generateID() {
        return currentId++;
    }
}

class University {
    List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void filterByPerformance(double minGrade){
        for (Student student : students) {
            if (student.grade >= minGrade) {
                System.out.println("Student " + student.getName() + " in group " + student.group + " has grade " + student.grade);
            }
        }
    }
}

class Weapon {
    String name;
    double damage;

    public Weapon(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }
}

class Worker extends Person {
    float salary;
    public Worker(String name, float age, String gender, float salary) {
        super(name, age, gender);
        this.salary = salary;
    }
}
