import java.util.Scanner;
import java.util.Random;

/*
 * Railway Ticket Reservation System
 * This program allows users to book train tickets for different classes
 * Each class has different pricing and seat availability
 *
 * Author: Student Project
 * Purpose: Demonstrates arrays, loops, conditionals, and user input handling
 */
public class RailwayReservationPortal {

    // Keeps track of how many tickets have been booked in total during this session
    private static int overallTicketsBooked = 0;

    // Ticket prices are stored in INR (Indian Rupees) for each travel class
    private static final int SLEEPER_PRICE_PER_TICKET = 450;   // Basic sleeping berth
    private static final int AC_CLASS_PRICE_PER_TICKET = 1250; // Air conditioned coach
    private static final int GENERAL_PRICE_PER_TICKET = 150;   // Unreserved seating

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Random randomGenerator = new Random();
        int menuSelection;

        // We have 5 coaches for each class type
        // Each coach can hold different number of seats (randomly assigned for demo)
        int[] sleeperCoachSeats = createSeatArray(randomGenerator);
        int[] acCoachSeats = createSeatArray(randomGenerator);
        int[] generalCoachSeats = createSeatArray(randomGenerator);

        // Welcome message for the user
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("      INDIAN RAILWAYS - TICKET RESERVATION SYSTEM         ");
        System.out.println("==========================================================");
        System.out.println("  Book your journey with us - Safe, Reliable, Affordable  ");
        System.out.println("==========================================================");

        // Main program loop - keeps running until user chooses to exit
        do {
            // Display the main menu with ticket types and their prices
            printTicketMenu();

            System.out.print("Please enter your choice (1 to 4): ");

            // Check if user entered a valid number
            if (userInput.hasNextInt()) {
                menuSelection = userInput.nextInt();
                userInput.nextLine(); // clear the buffer after reading integer
            } else {
                System.out.println();
                System.out.println("[ERROR] That is not a valid number. Please try again.");
                userInput.nextLine(); // discard the invalid input
                menuSelection = 0;
                continue;
            }

            // Process user's menu selection using switch statement
            switch (menuSelection) {
                case 1:
                    // User wants to book Sleeper Class tickets
                    processTicketBooking("Sleeper Class", sleeperCoachSeats,
                                        SLEEPER_PRICE_PER_TICKET, userInput);
                    break;

                case 2:
                    // User wants to book AC Class tickets
                    processTicketBooking("AC Class (Air Conditioned)", acCoachSeats,
                                        AC_CLASS_PRICE_PER_TICKET, userInput);
                    break;

                case 3:
                    // User wants to book General Class tickets
                    processTicketBooking("General Class", generalCoachSeats,
                                        GENERAL_PRICE_PER_TICKET, userInput);
                    break;

                case 4:
                    // User wants to exit the program
                    printExitMessage();
                    break;

                default:
                    // User entered a number outside 1-4 range
                    System.out.println();
                    System.out.println("[WARNING] Invalid option! Please select between 1 and 4.");
            }

        } while (menuSelection != 4);

        userInput.close();
    }

    /*
     * Creates an array of 5 coaches with random seat availability
     * Each coach gets between 5 and 25 seats randomly
     */
    private static int[] createSeatArray(Random rand) {
        int numberOfCoaches = 5;
        int[] seatArray = new int[numberOfCoaches];

        for (int coachNumber = 0; coachNumber < numberOfCoaches; coachNumber++) {
            // Generate random seats between 5 and 25 for each coach
            int minimumSeats = 5;
            int maximumSeats = 25;
            seatArray[coachNumber] = rand.nextInt(maximumSeats - minimumSeats + 1) + minimumSeats;
        }

        return seatArray;
    }

    /*
     * Displays the main menu showing all ticket types with their prices in INR
     */
    private static void printTicketMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("                  SELECT YOUR TICKET TYPE                 ");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.println("  Option 1: SLEEPER CLASS");
        System.out.println("            Price: Rs. " + SLEEPER_PRICE_PER_TICKET + " per ticket (INR)");
        System.out.println("            Features: Sleeping berth, Fan, Blanket");
        System.out.println();
        System.out.println("  Option 2: AC CLASS (Air Conditioned)");
        System.out.println("            Price: Rs. " + AC_CLASS_PRICE_PER_TICKET + " per ticket (INR)");
        System.out.println("            Features: AC, Comfortable berth, Meals included");
        System.out.println();
        System.out.println("  Option 3: GENERAL CLASS");
        System.out.println("            Price: Rs. " + GENERAL_PRICE_PER_TICKET + " per ticket (INR)");
        System.out.println("            Features: Basic seating, Most economical option");
        System.out.println();
        System.out.println("  Option 4: EXIT FROM SYSTEM");
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    /*
     * Handles the complete booking process for a specific ticket type
     * Shows seat availability, takes booking request, and confirms booking
     */
    private static void processTicketBooking(String classType, int[] coachSeats,
                                             int pricePerTicket, Scanner input) {

        System.out.println();
        System.out.println("==========================================================");
        System.out.println("  Checking seat availability for: " + classType);
        System.out.println("  Ticket Price: Rs. " + pricePerTicket + " per person");
        System.out.println("==========================================================");

        // Display seats available in each coach
        System.out.println();
        System.out.println("  COACH-WISE SEAT AVAILABILITY:");
        System.out.println("  ______________________________");

        int totalSeatsAvailable = 0;
        int coachCounter = 1;

        // Using for-each loop to go through each coach's seat coun1t
        for (int seatsInThisCoach : coachSeats) {

            // Coach number 3 is under maintenance, so we skip it
            if (coachCounter == 3) {
                System.out.println("  | Coach " + coachCounter + " | UNDER MAINTENANCE - Not Available |");
                coachCounter = coachCounter + 1;
                continue; // skip to next coach
            }

            // Show available seats for this coach
            System.out.println("  | Coach " + coachCounter + " | " + seatsInThisCoach + " seats available |");
            totalSeatsAvailable = totalSeatsAvailable + seatsInThisCoach;
            coachCounter++;
        }

        System.out.println("  |______________________________|");
        System.out.println();
        System.out.println("  >>> TOTAL AVAILABLE SEATS: " + totalSeatsAvailable + " <<<");
        System.out.println();

        // Check if any seats are available for booking
        if (totalSeatsAvailable > 0) {

            System.out.println("  [OK] Seats are available! You can proceed with booking.");
            System.out.println();
            System.out.println("  NOTE: Maximum 6 tickets can be booked at one time (IRCTC Rule)");
            System.out.println();
            System.out.print("  Enter number of tickets you want to book: ");

            int ticketsRequested;

            // Validate user input for number of tickets
            if (input.hasNextInt()) {
                ticketsRequested = input.nextInt();
                input.nextLine(); // clear buffer
            } else {
                System.out.println();
                System.out.println("  [ERROR] Please enter a valid number!");
                input.nextLine();
                return;
            }

            // Check if user is trying to book more than allowed limit
            if (ticketsRequested > 6) {
                System.out.println();
                System.out.println("  [REJECTED] You cannot book more than 6 tickets at once!");
                System.out.println("  Please start a new booking for additional tickets.");
                return; // exit this booking attempt
            }

            // Check for invalid ticket count
            if (ticketsRequested <= 0) {
                System.out.println();
                System.out.println("  [ERROR] Please enter a positive number of tickets!");
                return;
            }

            // Check if requested tickets are available
            if (ticketsRequested <= totalSeatsAvailable) {

                // Calculate total fare
                int totalFare = ticketsRequested * pricePerTicket;

                // Booking successful - show confirmation
                System.out.println();
                System.out.println("  **************************************************");
                System.out.println("  *         BOOKING CONFIRMED SUCCESSFULLY         *");
                System.out.println("  **************************************************");
                System.out.println();
                System.out.println("  Booking Details:");
                System.out.println("  -----------------");
                System.out.println("  Class Type      : " + classType);
                System.out.println("  Tickets Booked  : " + ticketsRequested);
                System.out.println("  Price per Ticket: Rs. " + pricePerTicket);
                System.out.println("  -----------------");
                System.out.println("  TOTAL AMOUNT    : Rs. " + totalFare + " (INR)");
                System.out.println("  -----------------");
                System.out.println();
                System.out.println("  Thank you for booking with Indian Railways!");
                System.out.println("  **************************************************");

                // Update the booking records
                overallTicketsBooked = overallTicketsBooked + ticketsRequested;
                updateSeatAvailability(coachSeats, ticketsRequested);

            } else {
                // Not enough seats for the request
                System.out.println();
                System.out.println("  [SORRY] Insufficient seats available!");
                System.out.println("  You requested " + ticketsRequested + " tickets but only "
                                 + totalSeatsAvailable + " seats are free.");
                System.out.println("  Please try booking fewer tickets.");
            }

        } else {
            // No seats available at all
            System.out.println("  [SORRY] No seats available in " + classType + " right now.");
            System.out.println("  Please try another class or check back later.");
        }

        // Show remaining seats after booking attempt
        displayRemainingSeatsInfo(classType, coachSeats);
    }

    /*
     * Reduces the seat count from coaches after successful booking
     * Distributes the booking across available coaches
     */
    private static void updateSeatAvailability(int[] coachSeats, int ticketsToDeduct) {

        // Go through each coach and deduct seats
        for (int i = 0; i < coachSeats.length && ticketsToDeduct > 0; i++) {

            // Skip coach 3 (index 2) as it's under maintenance
            if (i == 2) {
                continue;
            }

            // Deduct seats from this coach
            if (coachSeats[i] >= ticketsToDeduct) {
                // This coach has enough seats
                coachSeats[i] = coachSeats[i] - ticketsToDeduct;
                ticketsToDeduct = 0;
            } else {
                // Take whatever is available and move to next coach
                ticketsToDeduct = ticketsToDeduct - coachSeats[i];
                coachSeats[i] = 0;
            }
        }
    }

    /*
     * Shows the remaining seat count after a booking operation
     */
    private static void displayRemainingSeatsInfo(String classType, int[] coachSeats) {

        System.out.println();
        System.out.println("  --------------------------------------------------");
        System.out.println("  UPDATED SEAT STATUS FOR " + classType.toUpperCase());
        System.out.println("  --------------------------------------------------");

        int seatsStillAvailable = 0;

        // Count remaining seats using traditional for loop
        for (int coachIndex = 0; coachIndex < coachSeats.length; coachIndex++) {
            seatsStillAvailable = seatsStillAvailable + coachSeats[coachIndex];
        }

        System.out.println("  Seats still available: " + seatsStillAvailable);
        System.out.println("  --------------------------------------------------");
    }

    /*
     * Displays goodbye message when user exits the system
     */
    private static void printExitMessage() {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("             THANK YOU FOR USING OUR SERVICE              ");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println("  Session Summary:");
        System.out.println("  ----------------");
        System.out.println("  Total tickets booked in this session: " + overallTicketsBooked);
        System.out.println();
        System.out.println("  Have a safe and pleasant journey!");
        System.out.println("  Visit us again at Indian Railways Reservation Portal");
        System.out.println();
        System.out.println("==========================================================");
    }
}
