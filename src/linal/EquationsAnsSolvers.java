package linal;

import java.util.List;
import java.util.function.Function;

public class EquationsAnsSolvers {
    private static final List<IntegralSolver> methods = List.of(
            new RectangleMethodIntegralSolver(RectangleMethodIntegralSolver.RectangleMethodType.LEFT),
            new RectangleMethodIntegralSolver(RectangleMethodIntegralSolver.RectangleMethodType.CENTER),
            new RectangleMethodIntegralSolver(RectangleMethodIntegralSolver.RectangleMethodType.RIGHT),
            new TrapezoidalMethodIntegralSolver(),
            new SimpsonMethodIntegralSolver());

    private static final List<Equation> equations = List.of(
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> x * x - x + Math.log(x);
                }

                @Override
                public String equationToString() {
                    return "x^2-x+ln x";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> x * Math.sin(x);
                }

                @Override
                public String equationToString() {
                    return "x * sin(x)";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> 5 + 1d / Math.cos(x);
                }

                @Override
                public String equationToString() {
                    return "5+1/cos(x)";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return Math::sqrt;
                }

                @Override
                public String equationToString() {
                    return "sqrt(x)";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> Math.abs(-x * x + 10 * x - 20);
                }

                @Override
                public String equationToString() {
                    return "|-x^2+10x-20|";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> 1d / x;
                }

                @Override
                public String equationToString() {
                    return "1/x";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> 1 / Math.sqrt(x);
                }

                @Override
                public String equationToString() {
                    return "1/sqrt(x)";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> 1d/(Math.sqrt(x)*(x-5));
                }

                @Override
                public String equationToString() {
                    return "1/(sqrt(x)*(x-5))";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> 1d / (1 + Math.exp(1 / (x - 2)));
                }

                @Override
                public String equationToString() {
                    return "1/(1+exp(1/(x-2)))";
                }
            },
            new Equation() {
                @Override
                public Function<Double, Double> equation() {
                    return (Double x) -> Math.sin(x)/ x;
                }

                @Override
                public String equationToString() {
                    return "sin(x)/x";
                }
            }
    );
    public static List<Equation> getEquations() {
        return equations;
    }
    public static List<IntegralSolver> getMethods() {
        return methods;
    }
}
