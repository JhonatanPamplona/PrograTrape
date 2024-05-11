import java.util.Scanner;
import java.util.function.Function;

public class ReglaTrapecio {

    // Método para calcular la integral utilizando la regla del trapecio
    public static double reglaDelTrapecio(Function<Double, Double> funcion, double a, double b, int n) {
        double h = (b - a) / n;
        double suma = (funcion.apply(a) + funcion.apply(b))/2.0;
        System.out.println("Paso 1: Calculando la suma inicial: " + suma);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            double fx = funcion.apply(x);
            suma += fx;
            System.out.println("Paso " + (i + 1) + ": Evaluando f(" + x + ") = " + fx + " y sumando a la suma parcial: " + suma);
        }
        double integral = h * suma;
        System.out.println("Paso " + (n + 1) + ": Multiplicando la suma por el ancho del intervalo: " + integral);
        return integral;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la ecuación de la función al usuario
        System.out.println("Ingrese la ecuación de la función a integrar (por ejemplo, x^2):");
        System.out.print("f(x) = ");
        String ecuacion = scanner.nextLine();

        // Definir la función a integrar
        Function<Double, Double> funcion = x -> evaluarFuncion(ecuacion, x);

        // Definir los límites de integración
        System.out.println("Ingrese el límite inferior de integración:");
        double a = scanner.nextDouble();
        System.out.println("Ingrese el límite superior de integración:");
        double b = scanner.nextDouble();

        // Definir el número de subintervalos
        System.out.println();
        System.out.println("Ingrese el número de subintervalos:");
        int n = scanner.nextInt();

        // Calcular la integral utilizando la regla del trapecio
        System.out.println();
        System.out.println("Inicio del cálculo utilizando la regla del trapecio:");
        double integral = reglaDelTrapecio(funcion, a, b, n);

        // Imprimir el resultado final
        System.out.println();
        System.out.println("La aproximación de la integral es: " + integral);

        scanner.close();
    }

    // Método para evaluar la función ingresada por el usuario en un punto dado
    public static double evaluarFuncion(String ecuacion, double x) {
        // Aquí puedes usar una biblioteca como JEP (Java Expression Parser) para evaluar la ecuación,
        // pero para mantener el ejemplo simple, implementaremos una evaluación básica aquí.
        // Reemplaza esto con una evaluación más robusta según tus necesidades.
        return Math.pow(x, 2); // Por ejemplo, para x^2
    }
}
