import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;



public class Main {



  static Scanner input = new Scanner(System.in);



  // Queue implementation

  static Queue<String> queue = new LinkedList<>();



  public static void main(String[] args) {



    int choice;



    do {

      System.out.println("\n===== PERMUTATION AND COMBINATION =====");

      System.out.println("[1] Add Elements to Queue");



      System.out.println("[2] Display Queue");

      System.out.println("[3] Generate Permutations");

      System.out.println("[4] Generate Combinations");

      System.out.println("[5] Exit");

      System.out.print("Enter choice: ");



      choice = input.nextInt();



      switch (choice) {



        case 1:

          addElements();

          break;



        case 2:

          displayQueue();

          break;



        case 3:

          generatePermutations();

          break;



        case 4:

          generateCombinations();

          break;



        case 5:

          System.out.println("Program terminated.");

          break;



        default:

          System.out.println("Invalid choice!");

      }



    } while (choice != 5);

  }



  // TODO 1: Accept elements and add them to the Queue

   static void addElements() {



    System.out.print("How many elements to add? ");

    int n = input.nextInt();



    for (int i = 0; i < n; i++) {

      System.out.print("Enter element: ");

      queue.add(input.next());

    }



    System.out.println("Queue: " + queue);



    System.out.println("Dequeuing two elements...");



    queue.poll();

    queue.poll();



    System.out.println("Updated Queue: " + queue);

  }



  static void displayQueue() {



    if (queue.isEmpty()) {

      System.out.println("Queue is empty!");

    } else {

      System.out.println("Queue: " + queue);

      System.out.println("Front element: " + queue.peek());

    }

  }



  static void generatePermutations() {



    if (queue.isEmpty()) {

      System.out.println("Queue is empty!");

      return;

    }



    String[] elements = queue.toArray(new String[0]);



    System.out.print("Enter number of elements to arrange: ");

    int r = input.nextInt();



    if (r < 1 || r > elements.length) {

      System.out.println("Invalid number!");

      return;

    }



    int count = 0;

    int n = elements.length;



    System.out.println("Permutations:");



    for (int i = 0; i < n; i++) {

      if (r == 1) {

        System.out.print(elements[i] + " ");

        count++;

      } else {

        for (int j = 0; j < n; j++) {

          if (j == i) continue;



          if (r == 2) {

            System.out.print(elements[i] + elements[j] + " ");

            count++;

          } else {

            for (int k = 0; k < n; k++) {

              if (k == i || k == j) continue;



              if (r == 3) {

                System.out.print(elements[i] + elements[j] + elements[k] + " ");

                count++;

              }

            }

          }

        }

      }

    }



    System.out.println("\nTotal Permutations: " + count);

  }



  static void generateCombinations() {



    if (queue.isEmpty()) {

      System.out.println("Queue is empty!");

      return;

    }



    String[] elements = queue.toArray(new String[0]);



    System.out.print("Enter number of elements to select: ");

    int r = input.nextInt();



    if (r < 1 || r > elements.length) {

      System.out.println("Invalid number!");

      return;

    }



    int count = 0;

    int n = elements.length;



    System.out.println("Combinations:");



    if (r == 1) {

      for (int i = 0; i < n; i++) {

        System.out.print(elements[i] + " ");

        count++;

      }

    } else if (r == 2) {

      for (int i = 0; i < n; i++ ) {

        for (int j = i + 1; j < n; j++) {

          System.out.print(elements[i] + elements[j] + " ");

          count++;

        }

      }

    } else if (r == 3) {

      for (int i = 0; i < n; i++) {

        for (int j = i + 1; j < n; j++) {

          for (int k = j + 1; k < n; k++) {

            System.out.print(elements[i] + elements[j] + elements[k] + " ");

            count++;

          }

        }

      }

    }



    System.out.println("\nTotal Combinations: " + count);

  }

}