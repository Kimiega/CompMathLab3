package linal;

public class SimpsonMethodIntegralSolver extends IntegralSolver {
    private static final String NAME = "Метод Симпсона";
    private static final int K = 4;
    public SimpsonMethodIntegralSolver() {
        super(K);
        setName(NAME);
    }
    @Override
    protected double darkIntegrate(Equation x, double a, double b, long n) {
        double val = 0d;
        double h = (b-a)/n;
        Double f;
        f = x.equation().apply(a);
        checkFunctionValue(a,x);
        if (!f.isNaN())
            val += f;
        f = x.equation().apply(b);
        checkFunctionValue(b,x);
        if (!f.isNaN())
            val += f;
        for (int i = 1; i < n; i+=2) {
            f = x.equation().apply(a+h*i);
            checkFunctionValue(a+h*i,x);
            if (f.isNaN())
                continue;
            val += 4*f;
        }
        for (int i = 2; i < n; i+=2) {
            f = x.equation().apply(a+h*i);
            checkFunctionValue(a+h*i,x);
            if (f.isNaN())
                continue;
            val += 2*f;
        }
        return h/3*val;
    }
}
