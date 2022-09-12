
// Arefa Haque
// CIS 2352
// Spring 2022
// Prof. John P. Baugh

package com.mycompany.project3;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;


public class ImageSearch {

    public static void main(String[] args) {
        
        HashMap<String, List<String>> images = new HashMap<>();
       
        // Read file into hashmap
        try{
            Scanner inFile = new Scanner(new File("image_info.txt"));
            
            while(inFile.hasNextLine()){ 
                String fileLine = inFile.nextLine();
                Scanner lineReader = new Scanner(fileLine); //read each line separately
                
                while(lineReader.hasNext()){        
                String key = lineReader.next(); //read first word into key variable
                List<String> values = new ArrayList<>();
                
                    while(lineReader.hasNext()){ //read the rest of the words into a list                             
                        values.add(lineReader.next());
                    }
                
                images.put(key, values); //add the new key and its values to the map

                }
                 
               lineReader.close();
            }
            
            inFile.close();     
        }
        catch(FileNotFoundException ex){
            System.out.println("ERROR: Could not open file. Please reopen the "
                    + "program and try again.\n");
            System.exit(0);
        }
        
                
        // User interaction and search
        try{    
            Scanner keyboard = new Scanner(System.in);
                     
            String userChoice1 = " ";
            String userChoice2 = " ";
            String conj = " ";

            do{
                System.out.println("\nWhat would you like to search for?");
                
                String input = keyboard.nextLine();
                Scanner inputReader = new Scanner(input);
                
                while(inputReader.hasNext()){ //Read each word into separate strings
                    userChoice1 = inputReader.next().toLowerCase();
                    
                    while(inputReader.hasNext()){
                        conj = inputReader.next().toLowerCase();
                        
                            while(inputReader.hasNext()){
                            userChoice2 = inputReader.next().toLowerCase();
                        } 
                    }   
                }
                             
               System.out.println("\n\tSearch results: ");
               
               for(Map.Entry<String, List<String>> entry: images.entrySet()){
                   
                   if(userChoice2.equals(" ")){ //One search term
                        if(entry.getValue().contains(userChoice1)){
                        System.out.println("\t\t" + entry.getKey());
                        }  
                   }
                   else if(conj.equalsIgnoreCase("and")){ //Containing both terms
                       if(entry.getValue().contains(userChoice1)&&(entry.getValue().contains(userChoice2))){
                        System.out.println("\t\t" + entry.getKey());
                        }  
                   }
                   else if(conj.equalsIgnoreCase("or")){ //Containing either term
                       if(entry.getValue().contains(userChoice1)||(entry.getValue().contains(userChoice2))){
                        System.out.println("\t\t" + entry.getKey());
                        }                    
                   }
                   
               }      
               
                 inputReader.close(); 
            }
            while(!conj.equals("End program."));
            
            keyboard.close();       
        }
        catch(InputMismatchException ex){
            System.out.println("\nERROR: Invalid entry. Please reopen the "
                    + "program and try again.");   
            System.out.println();
        }
        
    }
}
