import java.util.Scanner;

public class MealOrder {
    private Burger burger;
    private SideItem side;
    private SideItem drink;

    public MealOrder(String burger, String sideL, String drinkL) {
        this.burger = new Burger(burger, 5.0);
        this.drink = new SideItem("drink", drinkL, 1.50);
        this.side = new SideItem("side", sideL, 2.00 );
    }

    public double getTotalPrice(){
        return side.extraPrice() + drink.extraPrice() + burger.extraPrice();
    }

    public void printFullList(){
        burger.printItem();
        drink.printItem();
        side.printItem();
        System.out.println("-".repeat(30));
        SideItem.printItem("total price", getTotalPrice());
    }

    public void addBurgerTopping(String extra1, String extra2, String extra3){
        burger.addTopping(extra1, extra2, extra3);
    }

    public void setDrinkSize(String size){
        drink.setSize(size);
    }


    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select from the options below: ");
        System.out.println("a) Order your burger");
        System.out.println("b) Choose drink and size");
        System.out.println("c) Set the side's size");
        System.out.println("d) See toppings list and their price");
        System.out.println("f) See current basket and total price");
        System.out.println("e) Exit application");
        char option;
        do{
            option = sc.next().charAt(0);
            switch(option){
                case 'a':
                    System.out.println("************");
                    System.out.println("Choose whether you want chicken, beef, or pork burger: ");
                    this.burger = new Burger(sc.next(), 5.00);
                    burger.printItem();
                    break;
                case 'b':
                    System.out.println("***********");
                    this.drink = new SideItem("drink", sc.next(), 1.50);
                    drink.setSize(sc.next());
                    drink.printItem();
//                    drink.getName(sc.next());
//                    drink.setSize(sc.next());
//                    drink.printItem();
                    break;
                case 'c':
                    System.out.println("***********");
                    this.side = new SideItem("side", sc.next(), 2.00 );
                    side.setSize(sc.next());
                    side.printItem();
                    break;
                case 'd':
                    System.out.println("First tier -> mustard, cucumber, and onion. Each costs: 1.0.");
                    System.out.println("Second tier -> eggs, chilli,and salami. Each costs: 1.50");
                    System.out.println("Third tier -> fries, bacon, and sauce. Each costs: 2.50");
                    addBurgerTopping(sc.next().trim(), sc.next().trim(), sc.next().trim());
                    System.out.println("The total burger components are:");
                    burger.printList();
                    break;
                case 'f':
                    System.out.println("The totals are: ");
                    printFullList();

            }
        } while (option != 'e');
        System.out.println("Thank you for choosing us!");

    }
}
