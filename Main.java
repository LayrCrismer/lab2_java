import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Точки");
            System.out.println("2. Прямые");
            System.out.println("3. Студенты, оценки");
            System.out.println("4. Точки и Линии");
            System.out.println("5. Дроби и арифметические операции");
            System.out.println("0. Выход");
            System.out.print("Ввод (0-5): ");

            int choice = getValidIntInput(scanner);

            switch (choice) {
                case 1:
                    runTask1(scanner);
                    break;
                case 2:
                    runTask2();
                    break;
                case 3:
                    runTask3();
                    break;
                case 4:
                    runTask4();
                    break;
                case 5:
                    runTask5();
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Ошибка: выберите пункт от 0 до 5.");
            }
        }
        scanner.close();
    }
        private static int getValidIntInput(Scanner scanner) {
            while (!scanner.hasNextInt()) {
                System.out.print("Неверный ввод. Пожалуйста, введите целое число: ");
                scanner.next();
            }
            return scanner.nextInt();
        }


        private static double getValidDoubleInput(Scanner scanner) {
            while (!scanner.hasNextDouble()) {
                System.out.print("Неверный ввод. Введите число (например, 5.5 или 3): ");
                scanner.next();
            }
            return scanner.nextDouble();
        }

        private static void runTask1(Scanner scanner) {
            System.out.println("Точка координат]");
            System.out.println("Создание 2 точек (X и Y для каждой):");

            Point[] points = new Point[2];
            for (int i = 0; i < 2; i++) {
                System.out.print("Введите X для точки " + (i + 1) + ": ");
                double x = getValidDoubleInput(scanner);
                System.out.print("Введите Y для точки " + (i + 1) + ": ");
                double y = getValidDoubleInput(scanner);
                points[i] = new Point(x, y);
            }

            System.out.println("\nРезультаты создания точек:");
            for (int i = 0; i < points.length; i++) {
                System.out.println("Точка " + (i + 1) + ": " + points[i]);
            }
        }

        private static void runTask2() {
            System.out.println("\nПрямая");
            Point p1 = new Point(1, 3);
            Point p2 = new Point(23, 8);
            Line line1 = new Line(p1, p2);
            
            Line line2 = new Line(new Point(5, 10), new Point(25, 10));
            
            Line line3 = new Line(line1.getStart(), line2.getEnd());

            System.out.println("1. " + line1);
            System.out.println("2. " + line2);
            System.out.println("3. " + line3);

            // новые координаты первой и второй линий
            line1.setStart(new Point(0, 0));
            line2.setEnd(new Point(30, 30));
            System.out.println("\nПосле изменения начала линии 1 и конца линии 2:");
            System.out.println("Линия 3 автоматически изменилась: " + line3);
        }

        private static void runTask3() {
            System.out.println("\nСтудент");
            //Вася
            Student vasya = new Student("Вася", new int[]{3, 4, 5});
            
            //Петя с оценками васи
            Student petya = new Student("Петя", vasya.getGrades());
            
            //смена первой оценки пети
            petya.getGrades()[0] = 5;
            
            System.out.println("Вася: " + vasya);
            System.out.println("Петя: " + petya);
            //оценка Васи тоже изменились, Петя ссылался на тот же массив в памяти

            //Андрей
            Student andrew = new Student("Андрей", vasya.getGrades());
            andrew.getGrades()[1] = 2;
            System.out.println("\nАндрей" + andrew);
            System.out.println("Вася после изменения у Андрея: " + vasya);
        }

        private static void runTask4() {
            System.out.println("\nТочки и Линии");
            Point t1 = new Point(3, 5);
            Point t2 = new Point(25, 6);
            Point t3 = new Point(7, 8);
            System.out.println("Точка 1: " + t1);
            System.out.println("Точка 2: " + t2);
            System.out.println("Точка 3: " + t3);

            Line l1 = new Line(1, 3, 23, 8);
            Line l2 = new Line(5, 10, 25, 10);
            Line l3 = new Line(l1.getStart(), l2.getEnd());
            System.out.println("Линия 1: " + l1);
            System.out.println("Линия 2: " + l2);
            System.out.println("Линия 3: " + l3);
        }

        private static void runTask5() {
            System.out.println("\nДроби");
            Fraction f1 = new Fraction(1, 3);
            Fraction f2 = new Fraction(2, 3);
            Fraction f3 = new Fraction(4, 5);

            System.out.println("Созданные дроби: f1 = " + f1 + ", f2 = " + f2 + ", f3 = " + f3);

            Fraction resSum = f1.sum(f2);
            System.out.println(f1 + " + " + f2 + " = " + resSum);

            Fraction resMul = f1.mul(f2);
            System.out.println(f1 + " * " + f2 + " = " + resMul);

            // Вычисление выражения из пункта 4: f1.sum(f2).div(f3).minus(5)
            Fraction complexResult = f1.sum(f2).div(f3).minus(5);
            System.out.println("Результат выражения f1.sum(f2).div(f3).minus(5) = " + complexResult);
        }
    }