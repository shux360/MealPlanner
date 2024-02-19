import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        String meal = scanner.nextLine();

        System.out.println("Input the meal's name:");
        String mealName = scanner.nextLine();

        System.out.println("Input the ingredients:");
        String input = scanner.nextLine();
        String[] ingredients = input.split(",");

        System.out.println("Category: " +meal);
        System.out.println("Name: " +mealName);
        System.out.println("Ingredients: ");
        for (String ingredient : ingredients) {
            System.out.println(ingredient);
        }
        System.out.println("The meal has been added!");
    }
}