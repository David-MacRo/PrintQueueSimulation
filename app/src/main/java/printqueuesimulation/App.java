/*
 * This source file was generated by the Gradle 'init' task
 */
package printqueuesimulation;

import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        PrintQueueManager printie = new PrintQueueManager();
        Scanner scannie = new Scanner(System.in);
        System.out.println("Welcome to the Print Queue Manager!\n" + //
                        "\n");
        int input = -1;
        do{
            System.out.println("Please select an option:\n" + //
            "\n" + //
            "1. Add a print job\n" + //
            "\n" + //
            "2. Process next print job\n" + //
            "\n" + //
            "3. View all print jobs\n" + //
            "\n" + //
            "4. Exit");
            input = scannie.nextInt();
            scannie.nextLine(); //clear values.
            switch (input) {
                case 1:
                    System.out.println("Please enter a description for the print job:");
                    printie.addPrintJob(scannie.nextLine());
                    break;
                case 2:
                    printAJob(printie);
                    System.out.println("(continue)");
                    scannie.nextLine();
                    break;
                case 3:
                    while(printie.size() != 0){
                        printAJob(printie);
                    }
                    System.out.println("\n(continue)");
                    scannie.nextLine();
                    break;
                default:
                    break;
            }
        } while (input != 4);

        scannie.close();
        throw new GracefulException();
    }

    private static void printAJob(PrintQueueManager printie){
        try {
            PrintJob output = printie.processNextPrintJob();
            System.out.printf("Job #%s\nDescription: %s", output.getJobID(), output.getDescription());              
        } catch (EmptyQueueException e) {
            System.out.println("There are no remaining print jobs;");
        } 

    }
}
