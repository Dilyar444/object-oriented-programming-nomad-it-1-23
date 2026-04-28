public class Main {
    public static void main(String[] args) {

        RationalNumber r1 = new RationalNumber("1/2");
        RationalNumber r2 = new RationalNumber("2/3");



        RationalCalculator calculator = new RationalCalculator();
        RationalNumber result = calculator.add(r1, r2);
        RationalNumber result2 = calculator.subtract(r1, r2);
        System.out.println(result);
        System.out.println(result2);

    }
}