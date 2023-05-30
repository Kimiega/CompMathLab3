package main;

import linal.Equation;
import linal.IntegralSolver;

import java.util.*;

public class ReceiverParams {
    private static final String EXIT = "exit";
    private static final Set<String> YES_ARGS = new HashSet<>(List.of("y", "yes"));
    private static final long HARD_CODE_N = 4;
    private final Scanner scanner;
    private final List<Equation> equations;
    private final List<IntegralSolver> integralSolvers;
    private static boolean waitTooLong = false;
    public ReceiverParams(List<Equation> equations, List<IntegralSolver> methods) {
        scanner = new Scanner(System.in);
        this.equations = equations;
        this.integralSolvers = methods;
        System.out.println("Для выхода из программы введите \"exit\"");
        System.out.println("Ожидать долгие вычисления (Y[es], N[o] or anything):");
        String text = readNext();
        waitTooLong = YES_ARGS.contains(text.toLowerCase());
    }
    public static boolean isWaitTooLong() {
        return waitTooLong;
    }
    public InputParams receive() {
        System.out.println("Выберите функцию для интегрирования:");
        for (int i = 1; i <= equations.size(); ++i)
            System.out.printf("%d) %s\n", i, equations.get(i-1).equationToString());
        int equationNumber = Integer.parseInt(readNext());
        if (equationNumber < 1 || equationNumber > equations.size())
            throw new IllegalArgumentException("Вы ввели недопустимое значение");
        System.out.println("Введите пределы интегрирования a и b:");
        double a = Double.parseDouble(readNext().replace(",", "."));
        double b = Double.parseDouble(readNext().replace(",", "."));
        System.out.println("Введите точность вычисления:");
        double eps = Double.parseDouble(readNext().replace(",", "."));
        if (eps <= 0)
            throw new IllegalArgumentException("Точность должна быть БОЛЬШЕ нуля");
        System.out.println("Выберите метод для интегрирования:");
        for (int i = 1; i <= integralSolvers.size(); ++i)
            System.out.printf("%d) %s\n", i, integralSolvers.get(i-1).getName());
        int methodNumber = Integer.parseInt(readNext());
        if (methodNumber < 1 || methodNumber > integralSolvers.size())
            throw new IllegalArgumentException("Вы ввели недопустимое значение");
        return new InputParams(
                equations.get(equationNumber-1),
                a,
                b,
                HARD_CODE_N,
                eps,
                integralSolvers.get(methodNumber-1)
        );
    }
    private String readNext() {
       String next = scanner.next();
       if (EXIT.equals(next)) {
           System.out.println("Спасибо, до свидания");
           System.exit(0);
       }
       return next;
    }
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

}
