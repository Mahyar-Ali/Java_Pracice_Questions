package com.company;

import java.io.*;
import java.util.Scanner;

public class ProcessSample {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path to the file ");
            String path = scanner.next();
            File file = new File(path);
            System.out.println();
            while(!file.isDirectory() && !file.canRead()){
                System.out.print("File Does not exist or it is not readable.Enter path again ");
                path = scanner.next();
                file = new File(path);
                System.out.println();
            }
            System.out.print("Enter the path to the file for writing data ");
            String sec_path = scanner.next();
            System.out.println();
            while(sec_path==path){
                System.out.print("It should be different from the first file ");
                sec_path = scanner.next();
                System.out.println();
            }
            //To store the text in each line
            String line = null;
            try {
                //Creating the objects of buffered class to read and write data
                FileReader _reader = new FileReader(path);
                BufferedReader reader = new BufferedReader(_reader);
                FileWriter _writer = new FileWriter(sec_path);
                BufferedWriter writer = new BufferedWriter(_writer);
                //Looping over the sample.txt file until it ends
                while ((line = reader.readLine()) != null){
                    //To store the number of occurrences of the word 'the'
                    int counter_the = 0 ;
                    //split each line into individual words and then loop over all the words
                    for(String word : line.split(" ")){
                        if(word.equals("the")){
                            //Increment the counter if 'the' is found
                            counter_the+=1;
                        }
                    }
                    //Write the given line into the new file
                    writer.write(line);
                    //append the number of occurrences os the word 'the' at end of each line
                    writer.write(" "+Integer.toString(counter_the));
                    writer.write(System.lineSeparator());
                    //flush the buffer
                    writer.flush();
                }
                //close the files
                reader.close();
                writer.close();
                _reader.close();
                _writer.close();

                //create file reference of new file to find its size
                File new_file = new File(sec_path);
                //size in bytes
                float filesize = new_file.length();
                System.out.printf("Size of new File is %f Kilobytes",filesize/1024);
            }
            catch (IOException e){
                e.printStackTrace();
            }
    }
}
