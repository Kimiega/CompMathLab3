package main;

import linal.EquationsAnsSolvers;
import linal.Solution;

public class Main {

    public static void main(String[] args) {
       ReceiverParams receiver = new ReceiverParams(EquationsAnsSolvers.getEquations(), EquationsAnsSolvers.getMethods());
       while(true) {
           try {
               InputParams input = receiver.receive();
               Solution solution = input.getMethod().integrate(
                       input.getEquation(),
                       input.getA(),
                       input.getB(),
                       input.getN(),
                       input.getEps()
               );
               receiver.printf("Значение интеграла = %f\n", solution.getValue());
               receiver.printf("Число разбиений = %d\n", solution.getK());
           } catch (Exception ex) {
               receiver.printf("%s\n", ex.getMessage());
           }
           finally {
               receiver.printf("\n");
           }
       }
    }
}
