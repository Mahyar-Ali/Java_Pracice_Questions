package com.company;
import java.util.Date;



public class Main{
    public static void main(String args[]){
        System.out.println("Testing Student Class:-");
        Student S1 = new Student("John Cena",0000,"JohnCena@BrockLesnar",1122,2002,1);
        System.out.printf("Name: "+S1.getName()+" _emailaddress "+S1.getEmailAddress()," ");
        System.out.println(" _Contact Number "+S1.getContactnumber());
        System.out.println();
        Faculty f1 = new Faculty("Roman Reigns",0000,"RomanReigns@UnderTaker",1122,13);
        f1.setJobDescription(" Every one knows about his Job!",2000000,"Load? This man is a beast!");
        f1.SetHiringDate(21,6,2002);
        System.out.println("Testing Faculty Class:-");
        System.out.printf("Name: "+f1.getName()+" _emailaddress "+f1.getEmailAddress()," ");
        System.out.println(" _Contact Number "+f1.getContactnumber());
        System.out.println("Office Number "+f1.getOfficenumber()+" _Descripiton "+f1.getDescripiton());
        System.out.println(" Salary "+f1.getSalary()+" _Teaching Load: "+f1.getTeachingLoad());
    }
    }

class Person {
    private String name;
    private int CNIC;
    private int contactnumber;
    private String emailAddress;

    Person() {
    }

    public Person(String name, int CNIC, int contactnumber, String emailAddress) {
        this.name = name;
        this.CNIC = CNIC;
        this.contactnumber = contactnumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getCNIC() {
        return CNIC;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    /*As a person has only one name name CNIC number so they cannot be changed one initialized*/
    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}

class Student extends Person{
    private int batch;
    private int regnumber;
    Student (){}
    public Student(String name,int CNIC,String emailaddress,int contactnumber){
        super(name,CNIC,contactnumber,emailaddress);
        batch = 2019;

    }
    public Student(String name,int CNIC,String emailaddress,int contactnumber,int batch,int regnumber){
        this(name,CNIC,emailaddress,contactnumber);
        this.batch = batch;
        this.regnumber= regnumber;
    }

    //Batch and registration number are only assigned once to each student


    public int getBatch() {
        return batch;
    }

    public int getRegnumber() {
        return regnumber;
    }
}

class Faculty extends Person{
    private int officenumber;
    private HiringDate hiringDate;
    private JobDescription jobDescription;
    Faculty(){}
    public Faculty(String name,int CNIC,String emailaddress,int contactnumber){
        super(name,CNIC,contactnumber,emailaddress);
        jobDescription = new JobDescription();
        hiringDate = new HiringDate();
    }

    public Faculty(String name,int CNIC,String emailaddress,int contactnumber,int officenumber){
        this(name,CNIC,emailaddress,contactnumber);
        this.officenumber = officenumber;

    }

    public void setOfficenumber(int officenumber){
        this.officenumber=officenumber;
    }

    public int getOfficenumber() {
        return officenumber;
    }

    /*Association Composition Objects */
    /*I have initialized their values here because otherwise Constructor would have so many
     parameters yo handle*/
    public void SetHiringDate(int day,int month,int year){
        hiringDate.setDay(day);
        hiringDate.setMonth(month);
        hiringDate.setYear(year);
    }
    public void setJobDescription(String Description,int salary,String TeachingLoad){
        jobDescription.setDescription(Description);
        jobDescription.setSalary(salary);
        jobDescription.setTeachingload(TeachingLoad);
    }
    public String getDescripiton(){
        return jobDescription.getDescription();
    }
    public String getHiringDate(){
        return hiringDate.getDate();
    }

    public int getSalary(){
        return jobDescription.getSalary();
    }
    public String getTeachingLoad(){
        return jobDescription.getTeachingload();
    }
}

class HiringDate{
    private int day;
    private int month;
    private int year;
    HiringDate(){}
    public HiringDate(int day,int month,int year){
        this.day =day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate(){
        return day+"/"+month+"/"+year;
    }
}

class JobDescription{
    private String Description;
    private int salary;
    private String teachingload;

    JobDescription(){}
    public JobDescription(String Description,int salary,String teachingload){
        this.Description = Description;
        this.salary = salary;
        this.teachingload = teachingload;
    }

    public int getSalary() {
        return salary;
    }

    public String getDescription() {
        return Description;
    }

    public String getTeachingload() {
        return teachingload;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTeachingload(String teachingload) {
        this.teachingload = teachingload;
    }
}