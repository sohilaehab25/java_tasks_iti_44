import java.math.BigDecimal;

class ComplexNumber<T extends BigDecimal, R extends BigDecimal> {
    private T real;
    private T img;

    public ComplexNumber(T _real, T _img) {
        this.real = _real;
        this.img = _img;
    }

    public T getReal() {
        return real;
    }

    public T getImag() {
        return img;
    }

    public ComplexNumber<R, R> addComplex(ComplexNumber<T, R> number) {
        R sumReal = (R) this.real.add(number.real);
        R sumImg = (R) this.img.add(number.img);
        return new ComplexNumber<>(sumReal, sumImg);
    }

    public ComplexNumber<R, R> subtractComplex(ComplexNumber<T, R> number) {
        R diffReal = (R) this.real.subtract(number.real);
        R diffImg = (R) this.img.subtract(number.img);
        return new ComplexNumber<>(diffReal, diffImg);
    }
}

public class task3 {
    public static void main(String args[]) {
        BigDecimal real1 = new BigDecimal(10);
        BigDecimal img1 = new BigDecimal(5);
        BigDecimal real2 = new BigDecimal(21);
        BigDecimal img2 = new BigDecimal(25);

        ComplexNumber<BigDecimal, BigDecimal> complex1 = new ComplexNumber<>(real1, img1);
        ComplexNumber<BigDecimal, BigDecimal> complex2 = new ComplexNumber<>(real2, img2);

        ComplexNumber<BigDecimal, BigDecimal> resultAdd = complex1.addComplex(complex2);
        ComplexNumber<BigDecimal, BigDecimal> resultSubtract = complex1.subtractComplex(complex2);

        System.out.println("Addition : " + resultAdd.getReal() + " + " + resultAdd.getImag() + "i");
        System.out.println("Subtraction : " + resultSubtract.getReal() + " + " + resultSubtract.getImag() + "i");
    }
}
