package com.company;

public class Main1 {
    public static void main(String[] args) {

        // Declare and create Product array of size 5
        Product[] pa = new Product[5];

        // Create object instances and assign them to
        // the type of Product.
        pa[0] = new TV( 1000, "Samsung", 30);
        pa[1] = new TV( 2000, "Sony", 50);
        pa[2] = new MP3Player( 250, "Apple", "blue");
        pa[3] = new Book( 34, "Sun press", 1992);
        pa[4] = new Book( 15, "Korea press", 1986);

        // Compute total regular price and total
        // sale price.
        double totalRegularPrice = 0;
        double totalSalePrice    = 0;

        for (int i=0; i<pa.length; i++){

            // Call a method of the super class to get
            // the regular price.
            totalRegularPrice += pa[i].getRegularPrice();

            // Since the sale price is computed differently
            // depending on the product type, overriding (implementation)
            // method of the object instance of the sub-class
            // gets invoked.  This is runtime polymorphic
            // behavior.
            totalSalePrice += pa[i].computeSalePrice();

            System.out.println("Item number " + i +
                    ": Type = "          + pa[i].getClass().getName() +
                    ", Regular price = " + pa[i].getRegularPrice() +
                    ", Sale price = "    + pa[i].computeSalePrice());
        }

        System.out.println("totalRegularPrice = " + totalRegularPrice);
        System.out.println("totalSalePrice = "    + totalSalePrice);
    }
}

abstract class Product{
    private double regularPrice;

    //Default and Parametrized Constructors
    Product(){}
    Product(double regularPrice){
        this.regularPrice=regularPrice;
    }

    //Declare the abstract method
    public abstract double computeSalePrice();

    //getter and setter
    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }
}

abstract class Electronics extends Product{
    private   String Manufacturer;

    //Default and Parametrized Constructors
    Electronics(){}
    Electronics(double regularPrice,String manufacturer){
        super(regularPrice);
        this.Manufacturer=manufacturer;
    }

    //Getter and Setter
    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}

class MP3Player extends Electronics{
    private String color;

    //Default and Parametrized Constructors
    MP3Player(){}
    MP3Player(double regularPrice,String Manufacturer,String color){
        super(regularPrice,Manufacturer);
        this.color = color;
    }

    //Override the computeSalePrice method
    @Override
    public double computeSalePrice() {
        // Formula for computing sales price was not given in the question.So I figured it out
        //I don't know if it is the correct formula
        return ((90*getRegularPrice())/100);
    }

    //Getter and Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class TV extends Electronics{
    private int size;

    //Default and Parametrized Constructors
    TV(){}
    TV(double regularPrice,String Manufacturer,int size){
        super(regularPrice,Manufacturer);
        this.size=size;
    }

    //Override the computeSalePrice method
    @Override
    public double computeSalePrice() {
        // Formula for computing sales price was not given in the question.So I figured it out
        //I don't know if it is the correct formula
        return ((getRegularPrice()*80)/100);
    }

    //Getter and Setter
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Book extends Product{

    private String publisher;
    private int yearPublished;

    //Default and Parametrized Constructors
    Book(){}
    Book(double regularPrice,String publisher,int yearPublished){
        super(regularPrice);
        this.yearPublished=yearPublished;
        this.publisher=publisher;
    }

    //Override the computeSalePrice method
    @Override
    public double computeSalePrice() {
        // Formula for computing sales price was not given in the question.So I figured it out
        //I don't know if it is the correct formula
        return (getRegularPrice()/2);
    }

    //Getters and Setters
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getPublisher() {
        return publisher;
    }
}


