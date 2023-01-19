import java.util.Scanner;

public class CoffeeMachine {
  public static boolean exit = false;
  public static int supplyWater = 400;
  public static int supplyMilk= 540;
  public static int supplyBeans = 120;
  public static int disposableCups = 9;
  public static int money = 550;

  // water, milk, beans, price
  public static int[] espresso= {250, 0, 16, 4};
  public static int[] latte = {350, 75, 20, 7};
  public static int[] cappuccino = {200, 100, 12, 6};
  public static void main(String[] args) {
    while (!exit) {
      getUserAction();
    }
  }

  public static void getUserAction() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Write action (buy, fill, take, remaining, exit):");
    String choice = scanner.next();

    switch (choice) {
      case "buy" -> {
        buy();
      }
      case "fill" -> {
        fill();
      }
      case "take" -> {
        take();
      }
      case "remaining" -> {
        machineStatus();
      }
      case "exit" -> {
        exit = true;
      }
      default -> {
        System.out.println("Unknown command");
      }
    }
  }

  public static void machineStatus() {
    System.out.println("The coffee machine has:");
    System.out.println(supplyWater + " ml of water");
    System.out.println(supplyMilk + " ml of milk");
    System.out.println(supplyBeans + " g of coffee beans");
    System.out.println(disposableCups + " disposable cups");
    System.out.println("$" + money + " of money");

    System.out.println();
  }

  public static void buy() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    String choice = scanner.next();

    switch (choice) {
      case "1" -> {
        buyEspresso();
      }
      case "2" -> {
        buyLatte();
      }
      case "3" -> {
        buyCappuccino();
      }
      case "back" -> {
        getUserAction();
      }
      default -> {
        System.out.println("Unknown command");
      }
    }

  }

  public static void buyEspresso() {
    int relativeWater = supplyWater / espresso[0];
    int relativeBeans = supplyBeans / espresso[2];

    if (relativeWater < 1) {
      System.out.println("Sorry, not enough water!");
    } else if (relativeBeans < 1) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (disposableCups < 1) {
      System.out.println("Sorry, not enough coffee cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");

      supplyWater -= espresso[0];
      supplyMilk -= espresso[1];
      supplyBeans -= espresso[2];
      money += espresso[3];
      disposableCups--;
    }
  }

  public static void buyLatte() {
    int relativeWater = supplyWater / latte[0];
    int relativeMilk = supplyMilk / latte[2];
    int relativeBeans = supplyBeans / latte[2];

    if (relativeWater < 1) {
      System.out.println("Sorry, not enough water!");
    } else if (relativeMilk < 1) {
      System.out.println("Sorry, not enough milk!");
    } else if (relativeBeans < 1) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (disposableCups < 1) {
      System.out.println("Sorry, not enough coffee cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");

      supplyWater -= latte[0];
      supplyMilk -= latte[1];
      supplyBeans -= latte[2];
      money += latte[3];
      disposableCups--;
    }
  }

  public static void buyCappuccino() {
    int relativeWater = supplyWater / cappuccino[0];
    int relativeMilk = supplyMilk / cappuccino[2];
    int relativeBeans = supplyBeans / cappuccino[2];

    if (relativeWater < 1) {
      System.out.println("Sorry, not enough water!");
    } else if (relativeMilk < 1) {
      System.out.println("Sorry, not enough milk!");
    } else if (relativeBeans < 1) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (disposableCups < 1) {
      System.out.println("Sorry, not enough coffee cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");

      supplyWater -= cappuccino[0];
      supplyMilk -= cappuccino[1];
      supplyBeans -= cappuccino[2];
      money += cappuccino[3];
      disposableCups--;
    }
  }

  public static void fill() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Write how many ml of water you want to add:");
    int waterInput = scanner.nextInt();
    System.out.println("Write how many ml of milk you want to add:");
    int milkInput = scanner.nextInt();
    System.out.println("Write how many grams of coffee beans you want to add:");
    int beansInput = scanner.nextInt();
    System.out.println("Write how many disposable cups you want to add:");
    int cupsInput = scanner.nextInt();

    supplyWater+= waterInput;
    supplyMilk+= milkInput;
    supplyBeans+= beansInput;
    disposableCups+= cupsInput;

    System.out.println();
  }

  public static void take() {
    System.out.println("I gave you $" + money);
    System.out.println();

    money = 0;
  }
}
