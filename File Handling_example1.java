package com.company;

//Importing the required Libraries
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class CodeEx1 {
    public static void main(String[] args) {
     StudentsData stds = new StudentsData("./students.txt");
     try {
         stds.readData(10);
         stds.listStudents();
         stds.write("./updatedstudents.txt");
     }catch(IOException e){
         e.printStackTrace();
     }
  }
}

class StudentsData {
    int num_students;
    //Creating the required arrays to store data
    private int[] reg_nums = new int[100] ;
    private String[] f_name = new String[100];
    private String[] l_name = new String[100];
    private String[] e_mail = new String[100];
    private String path ;
    private int N; //we need to store value of N because we may need to use it while writing
    StudentsData(String path){
        this.path = path;
    }
    //Function to read data from the file and store it in the arrays
    public void readData(int N) throws IOException{
        this.N = N;
        FileReader _reader = new FileReader(path);
        BufferedReader reader = new BufferedReader(_reader);
        String line = null ;
        //To store individual information from each line
        String[] temp = new String[4];
        num_students = Integer.parseInt(reader.readLine());
        int i=0 ;
        //Reading all the lines through N
        while((line=reader.readLine())!=null && i<N){
            temp = line.split(" ");
            f_name[i] = temp[0];
            l_name[i] = temp[1];
            e_mail[i] = temp[2];
            reg_nums[i] = Integer.parseInt(temp[3]);
            i+=1;
        }
        reader.close();
    }
    public void listStudents(){
        /*It is very unclear in the question that whether I should print everything
        * or just the names of students.But as it is mentioned "list of students"*/
        //So I will print name of students
        System.out.println("Name of Students are :-");
        for (int i=1;i<=N;i++){
            System.out.println(f_name[i-1]+" "+l_name[i-1]);
        }
    }
    //Function to write the data that we have read in a new format to a text file
    public void write(String path) throws IOException{
            FileWriter _writer = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(_writer);
            writer.write(num_students);
            //Writing record of every student till N
            for(int i=1;i<=N;i++){
                writer.write(reg_nums[i-1]+" ");
                writer.write(e_mail[i-1]+" ");
                writer.write(f_name[i-1]+" ");
                writer.write(l_name[i-1]+" ");
                writer.write(System.lineSeparator());
            }
            writer.flush();
            writer.close();
    }
}
