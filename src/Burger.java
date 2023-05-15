public class Burger extends SideItem {
    private SideItem extra1;
    private SideItem extra2;
    private SideItem extra3;

    public Burger(String name, double price) {
        super("burger", name, price);

    }

    @Override
    public String getName(String name) {
        return super.getName(name) + " burger";
    }
    @Override
    public double extraPrice() {
        return super.firstPrice() +
                ((extra1 == null) ? 0 : extra1.extraPrice()) +
                ((extra2 == null) ? 0 : extra2.extraPrice()) +
                ((extra3 == null) ? 0 : extra3.extraPrice());
    }

    public double ToppingPrice(String toppingName){
        return switch (toppingName){
            case "mustard" , "cucumber" , "onion" -> 1.0;
            case "eggs" , "chilli" ,"salami" -> 1.50;
            case "fries" , "bacon" , "sauce" -> 2.50;
            default ->0;
        };
    }

    public void addTopping(String extra1, String extra2, String extra3){
        this.extra1 = new SideItem("topping", extra1, ToppingPrice(extra1));
        this.extra2 = new SideItem("topping", extra2, ToppingPrice(extra2));
        this.extra3 = new SideItem("topping", extra3, ToppingPrice(extra3));
    }

    public void printList(){
        printItem("base burger", firstPrice());
        if(extra1 != null){
            extra1.printItem();
        }
        if(extra2 != null){
            extra2.printItem();
        }
        if(extra3 != null){
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printList();
        System.out.println("-".repeat(30));
        super.printItem();
    }

}
