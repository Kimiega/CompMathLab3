package linal;

import main.ReceiverParams;

public abstract class IntegralSolver {
    private final static Double MAGIC_CONST_1 = 0.0000001d;
    private final static long MAGIC_CONST_2 = 100_000_000L;
    private String name;
    private int k;

    protected IntegralSolver(int k) {
        this.k = k;
    }

    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    public final Solution integrate(Equation x, double a, double b, long n, double eps) {
        checkFunctionValue(a, x);
        checkFunctionValue(b, x);

        if (a == b)
            return new Solution(0d, 0);

        boolean isSwapped = false;
        if (b < a) {
            a=a+b-(b=a);
            isSwapped = true;
        }
        double I0;
        double I1 = darkIntegrate(x, a, b, n);

        do {
            I0 = I1;
            n *= 2;
            I1 = darkIntegrate(x, a, b, n);
            checkH((b-a)/n, eps);
            throwIfNTooBig(n);
        } while (Math.abs((I1-I0)/(Math.pow(2, k)-1)) > eps);

        if (isSwapped)
            I1 = -I1;

        return new Solution(I1, n);
    }
    protected final void checkFunctionValue(Double x, Equation e) {
        if (Double.isInfinite(e.equation().apply(x)))
            throw new ArithmeticException("Интеграл не существует");
        if (Double.isNaN(e.equation().apply(x)) && (Double.isNaN(e.equation().apply(x+MAGIC_CONST_1)) || Double.isNaN(e.equation().apply(x-MAGIC_CONST_1))))
            throw new ArithmeticException("Функция не определена в данном интервале");
        if (e.equation().apply(x) > MAGIC_CONST_2 * 100)
            throw new ArithmeticException("Значения функции слишком большие");
    }
    private void checkH(Double h, Double eps) {
        if (h < MAGIC_CONST_1)
            throw new ArithmeticException("Интеграл не существует");
    }
    private void throwIfNTooBig(long n) {
        if (n > MAGIC_CONST_2 && !ReceiverParams.isWaitTooLong())
            throw new ArithmeticException("Вычисления выполняются слишком долго, отмена операции");
    }
    protected abstract double darkIntegrate(Equation x, double a, double b, long n);
}
