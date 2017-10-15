package texteditor;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class History {
    StackOfTen<String> text = new StackOfTen<>();
    Stack<String> undo = new Stack<>();
    Scanner user = new Scanner(System.in);
    boolean quit = false;
    boolean isEmpty = false;

    public void startProgram() {
        System.out.println("Welcome to the text editor\nType 'create' to start a new document");
        while (user.hasNext()) {
            String userInput = user.nextLine().toLowerCase();
            isEmpty = false;
            try {
                commandSwitch(userInput);
                if (isEmpty){
                    continue;
                }
                System.out.println("\nLatest Entry: " + text.peek());
            } catch (EmptyStackException e) {
                System.out.println("*History is empty*");
            }
            System.out.println("Choose: Create | Copy | Delete | Undo | Quit \n");
        }
    }

    public void commandSwitch(String s) {

        switch (s) {
            case "create":
                System.out.print("Enter your text: ");
                text.push(user.nextLine());
                break;
            case "copy":
                text.push(text.peek());
                System.out.println(text.peek() + "has been copied");
                break;
            case "delete":
                undo.push(text.pop());
                System.out.println("Entry item '" + undo.peek() + "' has been deleted");
                break;
            case "undo":
                text.push(undo.pop());
                System.out.println("Entry item '" +text.peek() + "' has been added back to history");
                break;
            case "quit":
                System.out.println("Program terminated\nGoodbye");
                System.exit(0);
                break;
            case "":
                isEmpty = true;
                break;
            default:
                System.out.println("That is not a valid command");
                break;
        }
    }

    public void create(String input) {
        text.push(input);
    }

    public class StackOfTen<T> extends Stack<T> {

        public StackOfTen() {
            super();
        }

        @Override
        public T push(T object) {
            while (this.size() >= 10) {
                this.remove(0);
            }
            return super.push(object);
        }
    }
}
