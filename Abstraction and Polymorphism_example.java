package com.company;

import javax.print.Doc;

public class CodeEx1 {
    public static void main(String[] args) {
        Shape rect = new Rectangle("Rectangle",30,45);
        Shape sphere = new Sphere("Sphere",5);
        Shape cylinder = new Cylinder("Cylinder",20,50);
        Paint paint1 = new Paint();
        System.out.printf("Amount of paint required for "+ rect.toString()+
                " is "+paint1.compute_amount_of_paint(rect)+"\n");
        System.out.printf("Amount of paint required for "+ sphere.toString()+
                " is "+paint1.compute_amount_of_paint(sphere)+"\n");
        System.out.printf("Amount of paint required for "+ cylinder.toString()+
                " is "+paint1.compute_amount_of_paint(cylinder)+"\n");

    }
}

abstract class Shape{
    private String shapeName;
    Shape(){}
    Shape(String shapeName){
        this.shapeName=shapeName;
    }
    public abstract double area();
    public String toString(){
        return shapeName;
    }

    //Setter and Getter

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}

class Sphere extends Shape{
    private double radius;
    Sphere(){}
    Sphere(String shapeName,double radius){
        super(shapeName);
        this.radius=radius;
    }

    @Override
    public double area() {
        return 4*Math.PI*(radius*radius);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                '}';
    }

    //Setter and Getter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;

    Rectangle(){}
    Rectangle(String shapeName,double length,double width){
        super(shapeName);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length*width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", name= "+this.getClass().getName()+
                " }";
    }
    //Setters and Getters

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

class Cylinder extends Shape{
    private double radius;
    private double height;
    Cylinder(){}
    Cylinder(String shapeName,double radius,double height){
        super(shapeName);
        this.radius=radius;
        this.height=height;
    }

    @Override
    public double area() {
        return Math.PI *radius*radius*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", height=" + height +
                ", name= "+this.getClass().getName()+
                " }";
    }
    //Getters and Setters

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class Paint{
    private String paintType;
    private Object coverage;  //I don't know what this attribute is intended for as there is no
    //clear explanation in the question
    public double compute_amount_of_paint(Shape obj){
        return obj.area();
    }

    public String getPaintType() {
        return paintType;
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }
}

