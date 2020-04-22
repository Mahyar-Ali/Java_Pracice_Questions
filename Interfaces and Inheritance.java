package com.company;

import javax.print.Doc;

public class CodeEx1 {
        public static void main(String[] args) {

// Declare and create Product array of size 5
            ProductInterface[] pa = new Product[5];

// Create object instances and assign them to the type of Product.
            pa[0] = new TV(1000, "Samsung", 30);
            pa[1] = new TV(2000, "Sony", 50);
            pa[2] = new MP3Player(250, "Apple", "blue");
            pa[3] = new Book(34, "Sun press", 1992);
            pa[4] = new Book(15, "Korea press", 1986);
            // Compute total regular price and total sale price.
            double totalRegularPrice = 0;
            double totalSalePrice = 0;
            for (int i=0; i<pa.length; i++){

                    totalRegularPrice += pa[i].getRegularPrice();
                    totalSalePrice += pa[i].computeSalePrice();

                System.out.println("Item number " + i +
                        ": Type = " + pa[i].getClass().getName() +
                        ", Regular price = " + pa[i].getRegularPrice() +
                        ", Sale price = " + pa[i].computeSalePrice());
            }
            System.out.println("totalRegularPrice = " + totalRegularPrice);
            System.out.println("totalSalePrice = " + totalSalePrice);
        }
}

interface ProductInterface{
    public void setRegularPrice(double regularPrice);
    public double computeSalePrice();
    public double getRegularPrice();

}

//In the last lab this class was declared as abstract but now in the UML diagram there is no
//abstract sign, So I will override the abstract methods by just returning zero.
class Product implements ProductInterface{
    private double regularPrice;
    Product(){}
    Product(double regularPrice){
        this.regularPrice=regularPrice;
    }

    @Override
    public double computeSalePrice() {
        return 0; //I have mentioned the reason above.
    }


    @Override
    public double getRegularPrice() {
        return regularPrice;
    }

    @Override
    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }
}

interface ElectronicsInterface{
    public String getManufacturer();
}
class Electronics extends Product implements ElectronicsInterface{
    private String manufacturer;
    Electronics(){}
    Electronics(double regularPrice,String manufacturer){
                super(regularPrice);
                this.manufacturer=manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }
}

class MP3Player extends Electronics{
    private String color;
    MP3Player(){}
    MP3Player(double regularPrice,String Manufacturer,String color){
        super(regularPrice,Manufacturer);
        this.color = color;
    }

    @Override
    public double computeSalePrice() {
        // Formula for computing sales price was not given in the question.So I figured it out
        //I don't know if it is the correct formula
        return ((90*getRegularPrice())/100);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class TV extends Electronics{
    private int size;
    TV(){}
    TV(double regularPrice,String Manufacturer,int size){
        super(regularPrice,Manufacturer);
        this.size=size;
    }

    @Override
    public double computeSalePrice() {
        // Formula for computing sales price was not given in the question.So I figured it out
        //I don't know if it is the correct formula
        return ((getRegularPrice()*80)/100);
    }

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

    Book(){}
    Book(double regularPrice,String publisher,int yearPublished){
        super(regularPrice);
        this.yearPublished=yearPublished;
        this.publisher=publisher;
    }

    @Override
    public double computeSalePrice() {
        // Formula for computing sales price was not given in the question.So I figured it out
        //I don't know if it is the correct formula
        return (getRegularPrice()/2);
    }

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




