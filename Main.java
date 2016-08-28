import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

/*
 * TODO: Add a way to edit
 * TODO: Make the show function a little prettier
 * TODO: GUI elements eventually?
 * TODO: Conflict between eventual duplicate gameList objects, fix
 * 	TODO: Fetch images from the web to show the game-cover
 * 
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
					int deleteAt = parameter.nextInt();
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
					
					System.out.println("Which item would you like to change?");
					String queryE = parameter.next();
					
					ArrayList<GameStorage> gameListE = findElement(games, queryE);
					printNumberedList(gameListE);
					System.out.println("\nWhich number would you like to edit?");
					// Change to property/properties
					// Formatted string string.length() == 1 ? property : properties
					System.out.println("What properties would you like to edit?");
					// TODO: figure this one out
					// not good omg
					boolean done = false;
					while(!done) {
						// TODO: add functionality
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
	
	public static void printNumberedList(ArrayList<GameStorage> gameList) {
		for(int i = 0; i < gameList.size(); i++) {
			System.out.println((i+1) + " " + gameList.get(i).getName());
		}
	}
	
}