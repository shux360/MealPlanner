package mealplanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MealPlanner {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<Meal> meals = new ArrayList<>();

        while (true) {
            System.out.println("What would you like to do (add, show, exit)?");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    addMeal(scanner, meals);
                    break;
                case "show":
                    showMeals(meals);
                    break;
                case "exit":
                    System.out.println("Bye!");
                    System.exit(0);
            }
        }
    }

    private static void addMeal(Scanner scanner, List<Meal> meals) {
        String category;
        String name;
        String[] ingredients;

        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        category = scanner.nextLine().toLowerCase();
        while (true) {
            if (category.equals("breakfast") || category.equals("lunch") || category.equals("dinner")) {
                break;
            } else {
                System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
                category = scanner.nextLine().toLowerCase();
            }
        }
        System.out.println("Input the meal's name:");
        name = scanner.nextLine();
        while (true) {
            if ((name.trim().matches("[a-zA-Z\\s]+")) && !name.isEmpty()) {
                break;
            } else {
                System.out.println("Wrong format. Use letters only!");
                name = scanner.nextLine();
            }
        }
        System.out.println("Input the ingredients:");
        String ingredientsLine = scanner.nextLine();
        while (true) {
            ingredients = ingredientsLine.split(",");
            boolean validIngredients = true;

            for (String ingredient : ingredients) {
                if (!ingredient.trim().matches("[a-zA-Z\\s]+") || ingredient.isEmpty()) {
                    validIngredients = false;
                    System.out.println("Wrong format. Use letters only!");
                    ingredientsLine = scanner.nextLine();
                    break;
                }
            }

            if (validIngredients) {
                break;
            }
        }

        Meal meal = new Meal(category, name, ingredients);
        meals.add(meal);

        System.out.println("The meal has been added!");
    }

    private static void showMeals(List<Meal> meals) {
        if (meals.isEmpty()) {
            System.out.println("No meals saved. Add a meal first.");
            return;
        }

        for (Meal meal : meals) {
            System.out.println("\nCategory: " + meal.getCategory());
            System.out.println("Name: " + meal.getName());
            System.out.println("Ingredients:");
            for (String ingredient : meal.getIngredients()) {
                System.out.println(ingredient);
            }
        }
    }


    static class Meal {
        private String category;
        private String name;
        private String[] ingredients;

        public Meal(String category, String name, String[] ingredients) {
            this.category = category;
            this.name = name;
            this.ingredients = ingredients;
        }

        public String getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }

        public String[] getIngredients() {
            return ingredients;
        }
    }
}
