public class SideItem {
    private String type;
    private String name;
    private String size = "medium";
    private double price;

    public SideItem(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public double firstPrice(){
        return price;
    }

    public double extraPrice(){
        return switch(size){
            case "small" -> firstPrice() - 1.00;
            case "large" -> firstPrice() + 2.50;
            default -> firstPrice();
        };
    }

    public String getName(String name){
        if(type.equals("side") || type.equals("drink")){
            return size + " " + name;
        }
        return name;
    }

    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public void printItem(){
        printItem(getName(name), extraPrice());
    }

    public void setSize(String size) {
        this.size = size;
    }
}
