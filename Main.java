import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

/*
 * TODO: Add a way to edit DONE
 * TODO: Make the show function a little prettier
 * TODO: GUI elements eventually?
 * TODO: Conflict between eventual duplicate gameList objects, fix
 * 	TODO: Fetch images from the web to show the game-cover
 * Author: William Ø.
 * Date: 26.08.2016
 * Name: Video Game "Library"
 */

public class Main {

	public static void main(String []args) {
		ArrayList<GameStorage> games = new ArrayList<GameStorage>();
		boolean finished = false;
		String command = "hello";
		Scanner input = new Scanner(System.in);
		Scanner parameter = new Scanner(System.in);
		
		System.out.println("Welcome to the Game Library!");
		
		while(!finished || command == "exit") {
			System.out.println("What would you like to do? \n"
					+ "(add) new game, (delete) game, (show) list, (edit) game");
			command = input.nextLine();
			
			switch(command) {
				case "add":
					// Why does Game and Publisher come out the same time
					System.out.println("Game: ");
					String game = parameter.next();
					System.out.println("Publisher: ");
					String publisher = parameter.next();
					System.out.println("Published year: ");
					int age = parameter.nextInt();
					games.add(new GameStorage(game, publisher, age));
					break;
				case "delete":
					// how the heck do i do this
					// First of all, check if the list is empty
					if(games.size() == 0) {
						System.out.println("Empty list!");
						break;
					}
					// get the query
					String query = parameter.next();
					// Find all the elements that matches the query
					ArrayList<GameStorage> gameList = findElement(games, query);
					printNumberedList(gameList);
					System.out.println("\nWhich number would you like to delete?");
					int deleteAt = getIntFromUser(parameter);
					// Make sure there are no illegal selections
					if(deleteAt <= 0 || deleteAt > gameList.size()) System.out.println("Nothing there!");
					else {
						// Is this the best practice?
						GameStorage tempVal = gameList.get(deleteAt - 1);
						games.remove(tempVal);
						System.out.println(tempVal.getName() + " is deleted!");
					}
					break;
				case "show":
					printList(games);
					break;
				case "edit":
					// System.out.println("Not implemented yet lol");
					// TODO: Remove all the capital E's
					// and figure out another way to do this
					
					System.out.println("Which item would you like to change?");
					String queryE = parameter.next();
					
					ArrayList<GameStorage> gameListE = findElement(games, queryE);
					printNumberedList(gameListE);
					System.out.println("\nWhich number would you like to edit?");
					int indexToEdit = getIntFromUser(parameter);
					// Change to property/properties
					// Formatted string string.length() == 1 ? property : properties
					GameStorage currentGame = gameListE.get(indexToEdit - 1);
					// TODO: figure this one out
					// not good omg
					boolean done = false;
					while(!done) {
						// TODO: fix so that it actually loops
						// why does it not loop?
						System.out.println("What aspect will you edit?\nName, publisher or age? (TYPE 'done' WHEN YOU ARE DONE.)");
						String param = parameter.next();
						if(param == "exit") break;
						switch(param) {
							case "name":
								String nameE = parameter.next();
								currentGame.setName(nameE);
								break;
							case "publisher":
								String publisherE = parameter.next();
								currentGame.setPublisher(publisherE);
								break;
							case "age":
								int ageE = getIntFromUser(parameter);
								currentGame.setAge(ageE);
								break;
							case "done":
								done = true;
								break;
							default:
								System.out.println(param + "is not a valid command!");	
						}
						
						break;
					}
					
					
					break;
				case "exit":
					System.out.println("quitting...");
					finished = true;
					break;
				default:
					System.out.println(command + " is not a valid command!");
					break;
			}
			
		}
		
		// Close the Scanner objects
		parameter.close();
		input.close();
		
	}
	
	public static void printList(ArrayList<GameStorage> gameList) {
		if(gameList.size() <= 0) { System.out.println("List is empty!"); }
		else {
			for(int i = 0; i < gameList.size(); i++) {
				System.out.println(
							  gameList.get(i).getName() + " " 
							+ gameList.get(i).getPublisher() + " " 
							+ gameList.get(i).getAge() 
						);
			}
		}
	}

	public static ArrayList<GameStorage> findElement(ArrayList<GameStorage> gameList, String query) {
		ArrayList<GameStorage> temp = new ArrayList<GameStorage>();
		for(int i = 0; i < gameList.size(); i++) {
			// Check if the given query is equal to the current element
			// Java is at the given moment
			//if((gameList.get(i).getName()).equalsIgnoreCase(query)) 
			
			// TODO: Make it so that it only checks the beginning
			if(StringUtils.containsIgnoreCase(gameList.get(i).getName(), query)){
				// If the gameList is empty, say that it didn't find anything
				// and break the loop
				if(gameList.size() == 0) {
					System.out.println("Did not find anything!");
					break;
				}
				temp.add(gameList.get(i));
			}
		}
		return temp;
	}
	
	// Function that prints out a numbered list so that 
	// Maybe "port" this to the class itself?
	public static void printNumberedList(ArrayList<GameStorage> gameList) {
		for(int i = 0; i < gameList.size(); i++) {
			System.out.println((i+1) + " " + gameList.get(i).getName());
		}
	}
	
	// Make sure that the user actaully inputs an integer
	public static int getIntFromUser(Scanner s) {
		while(!s.hasNextInt()) {
			s.next();
			// Strictly not necessary, but still
			System.out.println("Please input a number!");
		}
		return s.nextInt();
	}
	
}