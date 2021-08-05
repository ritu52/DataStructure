package DijkstraInterpreter;

public class AppTesting {

     /**
      * Below is the implementation of basic mathematical expression evaluator using Java.Util.Stack
      * It is based on Shunting Yard Algorithm.
      * Console output of a program is:
           Evaluating Expression '( ( 3 + 4 ) + ( 5 + 5 ) )' results in::: 17.0
           Evaluating Expression '( ( 3 + 4 ) * ( 5 + 5 ) )' results in::: 70.0
           Evaluating Expression '( ( 16 + 4 ) / ( 5 + 5 ) )' results in::: 2.0
           Evaluating Expression '( ( 16 + 4 ) - ( 5 + 5 ) )' results in::: 10.0
      * @param args: not in use
      */
    public static void main(String[] args) {

         DijkstraInterpreter dj = new DijkstraInterpreter();
         dj.evaluateExpression( "( ( 3 + 4 ) + ( 5 + 5 ) )");
         System.out.println("Evaluating Expression '( ( 3 + 4 ) + ( 5 + 5 ) )' results in::: " + dj.getResult());
         dj.evaluateExpression( "( ( 3 + 4 ) * ( 5 + 5 ) )");
         System.out.println("Evaluating Expression '( ( 3 + 4 ) * ( 5 + 5 ) )' results in::: " + dj.getResult());
         dj.evaluateExpression( "( ( 16 + 4 ) / ( 5 + 5 ) )");
         System.out.println("Evaluating Expression '( ( 16 + 4 ) / ( 5 + 5 ) )' results in::: " + dj.getResult());
         dj.evaluateExpression( "( ( 16 + 4 ) - ( 5 + 5 ) )");
         System.out.println("Evaluating Expression '( ( 16 + 4 ) - ( 5 + 5 ) )' results in::: " + dj.getResult());
    }
}
