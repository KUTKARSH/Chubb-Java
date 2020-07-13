import java.util.Scanner;


public class Days {

    public static int getDays(int year,int month){
        if(month == 2)
        {
            if(year % 4 == 0)
                return 29;
            else
                return 28;
        }
        else if(month == 6 || month == 9 || month == 4 || month == 11)
            return 30;
        else
            return 31;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year ");
        int year = sc.nextInt();
        System.out.println("Enter the month ");
        int month = sc.nextInt();
        System.out.println("No of days = " + getDays(year,month));
    }
}