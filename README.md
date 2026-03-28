# Railway Ticket Reservation System

The Java application operates through a console interface which enables users to book train tickets and view coach seat availability and receive fare prices in Indian Rupees.

---

## What This Thing Actually Does

The program runs when you pick your travel class between Sleeper and AC and General options before checking available seats in each coach and finishing your ticket booking process.

The system functions independently from databases because it does not require database access and it operates without graphical user interfaces and framework support. The program operates through direct Java code

---

## Why I Built This

I needed to find a project for my Java programming course. The task required students to demonstrate their understanding of arrays and all loop types and conditional statements and basic input handling. A ticket booking system uses all of these naturally - arrays for tracking seats, loops for checking coaches, if-else for validation, switch for menu handling.

Every person understands the universal principle which exists as a universal principle. You don't need to explain what booking a train ticket means.

---

## Getting Started

### What You Need

- Your machine requires Java JDK 8 or any later version for installation
- You need access to a terminal or command prompt interface
- The entire process consists of this single step### How to Run

```bash
# Step 1: Clone or download this repository

# Step 2: Go into the project folder
cd railway-booking-system

# Step 3: Compile the Java file
javac RailwayReservation

# Step 4: Run the program
java RailwayReservation

The main menu will display after you complete the running process.

---

## Ticket Classes and Prices

| Class | Price per Ticket | What You Get |
|-------|------------------|--------------|
| Sleeper | Rs. 450 | Sleeper class passengers receive blankets and fans together with their sleeping berths |
| AC | Rs. 1,250 | The AC class provides air conditioning and serves meals to its passengers |
| General | Rs. 150 |

The prices shown here derive from actual Indian Railways fares which apply to medium-length railway routes. The information does not match exactly but it appears to be sufficiently authentic.

---

## How the Program Works

1. **Start**: Three arrays get created - one for each ticket class. The system generates random seat numbers which range from five to twenty-five. The system generates numbers randomly which fall between five and twenty-five.

2. **Main Menu**: The program runs a do-while loop to maintain menu visibility until users select the exit option.3. **Booking Flow**:
- Select your desired class from options 1 through 3
- The program will check all coaches to display their current available seats
- The `continue` statement becomes apparent because Coach 3 requires ongoing maintenance work
- Enter how many tickets you want (max 6 per booking - actual IRCTC rule)
- The system performs input validation and verifies ticket availability from your submission
- If everything's good, it confirms the booking and shows total fare
- Seats get deducted from the coaches

4. **Exit**: Shows the complete count of tickets that users purchased during their entire booking process---

## Project Structure

```
railway-booking-system-ussing-java/
├── RailwayReservationPortal.java # All the code lives

Yes, it's just one Java file. The project needed multiple classes but I chose to combine them into a single file because this project demonstrates fundamental concepts in their basic form.

---

## Sample Output

```
==========================================================
IND

----------------------------------------------------------
SELECT YOUR

Option 1: SLEEPER CLASS
Price: Rs. 450

Option 2: AC CLASS (Air Conditioned)
Price: Rs. 1250 per ticket

Option 3: GENERAL CLASS
Price: Rs. 150 per ticket (INR)

Option 4: EXIT FROM SYSTEM

----------------------------------------------------------
Please select your option between

---

## Known Limitations

I need to make clear which features this system fails to provide:

- **No data persistence** - The program deletes all information when you turn off the system
- **No passenger details** - Users can view ticket numbers but the system hides all passenger identification details
- **No train selection** - The system lacks any features which allow users to pick between various routes and train schedules and train options
- **No actual payment** - The system calculates the fare but it does not support any payment processing functions
- **Sequential seat allocation** - Takes from Coach 1 first, then 2, etc

These items fulfill all the requirements set for the course project. The real system deployment would face these issues as problems.

---

## What I Learned Building This

- The Scanner nextInt() method preserves newline characters which developers must handle by calling nextLine() after its execution.
- Edge cases take longer than the main logic. Always.
- Console formatting is tedious but matters for readability.
- Developers must understand how to determine when they should stop implementing new features.

---

## Tech Details

| Item | Info |
|------|------|
| Language | Java |
| JDK Version | 8+ |
| Lines of Code | ~280 |
| External

---

## Author

**Ambrish Raj**
Roll Number:

---

## License

The student has created this project to fulfill their educational requirements.
