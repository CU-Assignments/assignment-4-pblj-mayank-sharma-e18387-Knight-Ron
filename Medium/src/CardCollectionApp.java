import java.util.*;

class CardCollection {
    private Map<String, List<String>> cards;

    public CardCollection() {
        cards = new HashMap<>();
    }

    public void addCard(String symbol, String card) {
        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(card);
    }

    public void findCards(String symbol) {
        if (cards.containsKey(symbol)) {
            System.out.println("Cards with symbol '" + symbol + "': " + cards.get(symbol));
        } else {
            System.out.println("No cards found for symbol '" + symbol + "'");
        }
    }

    public void displayAllCards() {
        System.out.println("All Cards:");
        for (Map.Entry<String, List<String>> entry : cards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class CardCollectionApp {
    public static void main(String[] args) {
        CardCollection cardCollection = new CardCollection();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter card symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter card name: ");
                    String card = scanner.nextLine();
                    cardCollection.addCard(symbol, card);
                    System.out.println("Card added!");
                    break;

                case 2:
                    System.out.print("Enter symbol to find: ");
                    String searchSymbol = scanner.nextLine();
                    cardCollection.findCards(searchSymbol);
                    break;

                case 3:
                    cardCollection.displayAllCards();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
