public class RationalNumber {
    public static Integer count = 0;

    private String number;

    public RationalNumber(String number) {
        count++;
        validate(number);

        if (!number.contains("/")) {
            number += "/1";
        }

        this.number = number;
    }

    // Valid formats: "3", "-3", "3/4", "-3/4", "3/-4", "-3/-4"
    private static void validate(String number) {
        if (number == null || number.isEmpty()) {
            throw new ArithmeticException("Rational number cannot be null or empty");
        }

        // Positive pattern: optional sign, one or more digits,
        // optionally followed by / then optional sign and one or more digits
        if (!number.matches("-?\\d+(/(-?\\d+))?")) {
            throw new ArithmeticException("Invalid rational number format: \"" + number + "\"");
        }

        int slashIndex = number.indexOf('/');
        if (slashIndex != -1) {
            int denominator = Integer.parseInt(number.substring(slashIndex + 1));
            if (denominator == 0) {
                throw new ArithmeticException("Denominator cannot be zero");
            }
        }
    }

    @Override
    public String toString() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}