public class Largest {

    public static void main(String[] args) {
        int a = 65,b = 90, c = 114;
        System.out.print("Largest number is ");
        if(a > b && a > c)
            System.out.println(a);
        else if(b > a && b > c)
            System.out.println(b);
        else
            System.out.println(c);
    }
}
