package linal;


public class RectangleMethodIntegralSolver extends IntegralSolver {
    private static final String LEFT_NAME = "Метод прямоугольников (левые)";
    private static final String CENTER_NAME = "Метод прямоугольников (средние)";
    private static final String RIGHT_NAME = "Метод прямоугольников (правые)";
    private static final int K = 2;

    private double typeOfMethod;

    public RectangleMethodIntegralSolver(RectangleMethodType type) {
        super(K);
        switch (type) {
            case CENTER -> { makeCenterBorders(); setName(CENTER_NAME);}
            case RIGHT -> { makeRightBorders(); setName(RIGHT_NAME);}
            default -> { makeLeftBorders(); setName(LEFT_NAME); }
        }
    }
    private void makeLeftBorders() {
        typeOfMethod = 0d;
    }
    private void makeCenterBorders() {
        typeOfMethod = 0.5d;
    }
    private void makeRightBorders() {
        typeOfMethod = 1d;
    }

    @Override
    protected double darkIntegrate(Equation x, double a, double b, long n) {
        double val = 0d;
        double h = (b-a)/n;
        for (int i = 0; i < n; ++i) {
            Double f = x.equation().apply(a+h*typeOfMethod+h*i);
            checkFunctionValue(a+h*typeOfMethod+h*i, x);
            if (f.isNaN())
                continue;
            val += x.equation().apply(a+h*typeOfMethod+h*i);
        }
        return h * val;
    }
    public enum RectangleMethodType {
        LEFT,
        CENTER,
        RIGHT
    }
}
