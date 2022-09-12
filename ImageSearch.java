package ImageSearch;
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
       
            // READ FILE INTO HASHMAP
        try{
            Scanner inFile = new Scanner(new File("image_info.txt"));
            
            while(inFile.hasNextLine()){ 
                String fileLine = inFile.nextLine();
                Scanner lineReader = new Scanner(fileLine);     //READ EACH LINE SEPARATELY
                
                while(lineReader.hasNext()){        
                String key = lineReader.next();     //READ FIRST WORD INTO "key" VARIABLE
                List<String> values = new ArrayList<>();
                
                    while(lineReader.hasNext()){    //READ THE REST OF THE LINE INTO A LIST                         
                        values.add(lineReader.next());
                    }
                
                images.put(key, values);    //ADD THE NEW KEY AND ITS CORRESPONDING VALUES TO THE MAP

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
        
                
            // USER INTERACTION AND SEARCH
        try{    
            Scanner keyboard = new Scanner(System.in);
                     
            String userChoice1 = " ";
            String userChoice2 = " ";
            String conj = " ";

            do{
                System.out.println("\nWhat would you like to search for?");
                
                String input = keyboard.nextLine();
                Scanner inputReader = new Scanner(input);
                
                while(inputReader.hasNext()){   //READ EACH WORD AS A SEPARATE STRING
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
                   
                   if(userChoice2.equals(" ")){     //USER ENTERS ONE SEARCH TERM
                        if(entry.getValue().contains(userChoice1)){
                        System.out.println("\t\t" + entry.getKey());
                        }  
                   }
                   else if(conj.equalsIgnoreCase("and")){   //MULTIPLE SEARCH TERMS CONTAINING "and", RETURN ALL IMAGES W/ BOTH ELEMENTS
                       if(entry.getValue().contains(userChoice1)&&(entry.getValue().contains(userChoice2))){
                        System.out.println("\t\t" + entry.getKey());
                        }  
                   }
                   else if(conj.equalsIgnoreCase("or")){    //MULTIPLE SEARCH TERMS CONTAINING "or", RETURN ALL IMAGES W/ AT LEAST ONE ELEMENT
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