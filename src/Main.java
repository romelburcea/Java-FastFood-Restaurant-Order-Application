import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello dear Customer. To start, type burger, drink, and side.");
        System.out.println("Enter first item: ");
        String burger = sc.nextLine();
        System.out.println("Enter second item: ");
        String drink = sc.nextLine();
        System.out.println("Enter third item: ");
        String side = sc.nextLine();
        MealOrder mo = new MealOrder(burger, side, drink);

//        mo.addBurgerTopping("cheese", "salami", "bacon");
//        mo.setDrinkSize("large");
//        mo.printFullList();
        mo.menu();


    }
}
