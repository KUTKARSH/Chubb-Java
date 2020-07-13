public class Swap {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("Before swapping\na = "+a+ " b = "+b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping\na = "+a+ " b = "+b);
    }
}