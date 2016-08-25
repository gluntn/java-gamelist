import java.util.ArrayList;
import java.util.Scanner;

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
			command = input.next();
			
			switch(command) {
			case "add":
				// Why does Game and Publisher come out the same time
				System.out.println("Game: ");
				String game = parameter.nextLine();
				System.out.println("Publisher: ");
				String publisher = parameter.nextLine();
				System.out.println("Published year: ");
				int age = parameter.nextInt();
				games.add(new GameStorage(game, publisher, age));
				break;
			case "delete":
				// how the heck do i do this
				System.out.println("Not implemented yet lol");
				break;
			case "show":
				printList(games);
				break;
			case "edit":
				System.out.println("Not implemented yet lol");
				break;
			case "exit":
				System.out.println("quitting...");
				break;
			default:
				System.out.println("what");
				break;
			}
			
		}
		
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
}
