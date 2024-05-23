package coms;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Entity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int selection; 
		String fileName;
		
		do {
		System.out.println(" ----------------------------- ");
		System.out.println("|__*___Lockers Pvt. Ltd.___*__|");
		System.out.println("|_*____Mduduzi Matabane_____*_|");
		System.out.println("|*_File Handling Application_*|");
		System.out.println(" ----------------------------- ");
		
		System.out.println("Please select your choice");
		System.out.println("1. View available Files");
		System.out.println("2. Create a File");
		System.out.println("3. View a file");
		System.out.println("4. Update a File");
		System.out.println("5. Search for a file");
		System.out.println("6. Delete a File");
		System.out.println("7. Exit");
		
		System.out.println("Enter your selection");
		selection=sc.nextInt();
		
		switch(selection)
		{
			//CRUD OPERATIONS
		
			//LIST
			case 1:
				
					
					File listedFiles = new File("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1");
					File[] list = listedFiles.listFiles();
					
					for(File files: list) {
						if(files.isFile()) {
							System.out.print("Available Files: ");
							System.out.print(files.getName());
							System.out.println("\t");
							
							
						}else if(!files.isFile()) {
							System.out.println("No Files Found");
							System.out.println("\t");
							System.out.println("1. Create new file");
							System.out.println("2. Main Menu");
							int choice;
							choice=sc.nextInt();
							switch(choice) {
							case 1:
								try {
									System.out.println("Enter new file name: ");
									fileName=sc.next();
									
									File createdFile = new File("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1\\"+fileName+".txt");
									if(createdFile.createNewFile()) {
										System.out.println(createdFile.getName()+" Created Successfully");
										System.out.println("\t");
										
										}else {
											System.out.println("File already exists");
											System.out.println("\t");
										}
								}catch(IOException e)
								{
									System.out.println("File not created");
									System.out.println("\t");
								}
								break;
							case 2:
								break;
							}
						}
							
					}
				
				break;
			//CREATE	
			case 2:
				try {
					System.out.println("Enter new file name: ");
					fileName=sc.next();
					
					File createdFile = new File("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1\\"+fileName+".txt");
					if(createdFile.createNewFile()) {
						System.out.println(createdFile.getName()+" Created Successfully");
						System.out.println("\t");
						
						}else {
							System.out.println("File already exists");
							System.out.println("\t");
						}
				}catch(IOException e)
				{
					System.out.println("File not created");
					System.out.println("\t");
				}
				break;
			//READ 	
			case 3:
			System.out.println("Please enter the name of the file: ");
			fileName = sc.next();
			
			File readfile = new File("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1\\"+fileName+".txt");
			try {
			Scanner Reader = new Scanner(readfile);
			while(Reader.hasNextLine()) {
				String text = Reader.nextLine();
				System.out.println(text);
				System.out.println("\t");
			}
			Reader.close();
			}catch(IOException e){
				System.out.println("File not found.");
				System.out.println("\t");
			}
			
				break;
			//UPDATE
			case 4:
				try {
					System.out.println("Enter file name to update.");
					fileName=sc.next();
					
					System.out.println("Enter The text you would like to add.");
					Scanner newText= new Scanner(System.in);
					String data= newText.nextLine();
					
					FileWriter obj = new FileWriter("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1\\"+fileName+".txt");
					obj.write(data);
					obj.close();
					System.out.println("Data written to File");
					System.out.println("\t");
					}catch(IOException e){
						System.out.println("data not written to file");
						System.out.println("\t");
					}
				break;
			//SEARCH
			case 5:
				
				System.out.println("Enter the name of the file you are looking for");
				fileName=sc.next();
				
				File searchedFile = new File("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1\\"+fileName+".txt");
				 if(searchedFile.exists()) {
					 System.out.println("File found in the System");
					 System.out.println("1. Read File");
					 System.out.println("2. Main Menu");
					 //view file
					 int choice2;
						choice2=sc.nextInt();
						switch(choice2) {
						case 1:
							try {
								Scanner Reader = new Scanner(searchedFile);
								while(Reader.hasNextLine()) {
									String text = Reader.nextLine();
									System.out.println(text);
									System.out.println("\t");
								}
								Reader.close();
								}catch(IOException e){
									System.out.println("Error updating File");
								}
						 //main menu
						 
							break;
						case 0:
							System.exit(choice2);
							break;
							default:
								
						}
					 
				 }else {
					 System.out.println("File not Found");
					 System.out.println("\t");
				 }
				break;
				//Delete
			case 6:
				System.out.println("Enter the name of the file you would like to delete");
				fileName=sc.next();
				
				File deletedFile=new File("C:\\Users\\GLOBAL KNOWLEDGE\\Desktop\\Phase1\\"+fileName+".txt");
				
				if(deletedFile!=null) {
					if(deletedFile.delete()) {
					System.out.println("File deleted");
					System.out.println("\t");
					}else {
						System.out.println("Error! File not Deleted");
						System.out.println("\t");
					}
				}
				
				break;
			case 7:
				System.out.println("We hope you had a wonderful experience");
				System.exit(selection);
				sc.close();
				break;
				default:
					System.out.println("Please re-enter your choice");
					System.out.println("\t");
			}
		}
		while(true);
		

		
		}
	}

