public class Grade {

    public static void printGrade(int grade){
        if(grade >= 95)
            System.out.println("S");
        else if(grade >= 90 && grade < 95)
            System.out.println("A");
        else if(grade >= 80 && grade < 90)
            System.out.println("B");
        else if(grade >= 70 && grade < 80)
            System.out.println("C");
        else
            System.out.println("Fail");
    }

    public static void main(String[] args) {
        int grade = 91;
        printGrade(grade);
        grade = 96;
        printGrade(grade);
        grade = 69;
        printGrade(grade);
    }
}