public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        // Нормализация знака и сокращение дроби
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraction sum(Fraction other) {
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction sum(int n) {
        return sum(new Fraction(n, 1));
    }

    public Fraction minus(Fraction other) {
        int newNum = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction minus(int n) {
        return minus(new Fraction(n, 1));
    }

    public Fraction mul(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction mul(int n) {
        return mul(new Fraction(n, 1));
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль.");
        }
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fraction div(int n) {
        return div(new Fraction(n, 1));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}