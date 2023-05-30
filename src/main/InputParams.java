package main;

import linal.Equation;
import linal.IntegralSolver;

public class InputParams {
    private final Equation equation;
    private final double a;
    private final double b;
    private final long n;
    private final double eps;
    private final IntegralSolver method;
    public InputParams(Equation equation, double a, double b, long n, double eps, IntegralSolver method) {
        this.equation = equation;
        this.a = a;
        this.b = b;
        this.n = n;
        this.eps = eps;
        this.method = method;
    }

    public Equation getEquation() {
        return equation;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public long getN() {
        return n;
    }
    public double getEps() {
        return eps;
    }

    public IntegralSolver getMethod() {
        return method;
    }
}
