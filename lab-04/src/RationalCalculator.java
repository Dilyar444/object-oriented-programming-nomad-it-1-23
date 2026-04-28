public class RationalCalculator {

    public static RationalNumber add(RationalNumber r1, RationalNumber r2) {
        int indexOfSlash1 = r1.getNumber().indexOf('/');
        int indexOfSlash2 = r2.getNumber().indexOf('/');

        System.out.println(indexOfSlash1);
        System.out.println(indexOfSlash2);

        int num1 = Integer.parseInt(r1.getNumber().substring(0, indexOfSlash1));
        int num2 = Integer.parseInt(r2.getNumber().substring(0, indexOfSlash2));

        int den1 = Integer.parseInt(
                r1.getNumber().substring(indexOfSlash1 + 1, r1.getNumber().length()));

        int den2 = Integer.parseInt(
                r2.getNumber().substring(indexOfSlash2 + 1, r2.getNumber().length()));
        System.out.println(num1 + "/" + den1);
        System.out.println(num2 + "/" + den2);

        int newDen = den1 * den2;

        int newNum1 = den2 * num1;
        int newNum2 = den1 * num2;
        int newNum = newNum1 + newNum2;

        String result = newNum + "/" + newDen;
        return new RationalNumber(result);
    }

    public RationalNumber subtract(RationalNumber r1, RationalNumber r2) {
        int indexOfSlash1 = r1.getNumber().indexOf('/');
        int indexOfSlash2 = r2.getNumber().indexOf('/');
        // 12/34 - 23/65 = ?/34*65
        int num1 = Integer.parseInt(r1.getNumber().substring(0, indexOfSlash1));
        int num2 = Integer.parseInt(r2.getNumber().substring(0, indexOfSlash2));

        int den1 = Integer.parseInt(r1.getNumber().substring(indexOfSlash1 + 1));
        int den2 = Integer.parseInt(r2.getNumber().substring(indexOfSlash2 + 1));

        // 34*65=
        int newDen = den1 * den2;

        int newNum1 = den2 * num1;
        int newNum2 = den1 * num2;

        int newNum = newNum1 - newNum2;

        String result = newNum + "/" + newDen;

        System.out.println(result);
        return new RationalNumber(result);

    }


}