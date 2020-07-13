import java.util.Scanner;


public class Sales {

    public static double calculate(int income,int yoe){
        if(income > 100000)
        {
            if(yoe > 15)
                return 0.2 * income;
            else
                return 0.25 * income;
        }
        else if(income >= 50000 && income <= 100000)
        {
            if(yoe > 10)
                return 0.15 * income;
            else
                return 0.2 * income;
        }
        else
        {
            if(yoe > 5)
                return 0.1 * income;
            else
                return 0.15 * income;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the income");
        int income = sc.nextInt();
        System.out.println("Enter years of experience");
        int yoe = sc.nextInt();
        System.out.println("Commission = " + calculate(income,yoe));

    }
}
