# Railway Ticket Reservation System

A console-based Java application that lets you book train tickets, check seat availability across coaches, and calculate fares in Indian Rupees.

---

## What This Thing Actually Does

You run the program, pick a travel class (Sleeper, AC, or General), see how many seats are free in each coach, and book your tickets. The system tracks everything - seat counts go down when you book, fare gets calculated based on how many tickets you want, and at the end it tells you how many tickets you booked during the session.

No database. No GUI. No frameworks. Just plain Java running in your terminal.

---

## Why I Built This

Needed a project for my Java programming course. The assignment required demonstrating arrays, different loop types, conditionals, and input handling. A ticket booking system uses all of these naturally - arrays for tracking seats, loops for checking coaches, if-else for validation, switch for menu handling.

Plus, it's something everyone understands. You don't need to explain what booking a train ticket means.

---

## Getting Started

### What You Need

- Java JDK 8 or higher installed on your machine
- A terminal or command prompt
- That's literally it

### How to Run

```bash
# Step 1: Clone or download this repository
git clone https://github.com/ambrishraj06/Java_Project.git

# Step 2: Go into the project folder
cd railway-booking-system-ussing-java

# Step 3: Compile the Java file
javac RailwayReservationPortal.java

# Step 4: Run the program
java RailwayReservationPortal
```

After running, you'll see the main menu. Type a number (1-4) and press Enter to navigate.

---

## Ticket Classes and Prices

| Class | Price per Ticket | What You Get |
|-------|------------------|--------------|
| Sleeper | Rs. 450 | Sleeping berth, fan, blanket |
| AC | Rs. 1,250 | Air conditioning, meals included |
| General | Rs. 150 | Basic seating, budget option |

These prices are based roughly on actual Indian Railways fares for medium-distance routes. Not exact, but realistic enough.

---

## How the Program Works

1. **Start**: Three arrays get created - one for each ticket class. Each array has 5 elements (5 coaches). Seat counts are randomly generated between 5-25.

2. **Main Menu**: A do-while loop shows the menu repeatedly until you choose Exit.

3. **Booking Flow**:
   - Pick a class (1, 2, or 3)
   - Program loops through all coaches and shows available seats
   - Coach 3 is always "under maintenance" (to demonstrate the `continue` statement)
   - Enter how many tickets you want (max 6 per booking - actual IRCTC rule)
   - System validates your input and checks availability
   - If everything's good, it confirms the booking and shows total fare
   - Seats get deducted from the coaches

4. **Exit**: Shows total tickets booked during the session.

---

## Project Structure

```
railway-booking-system-ussing-java/
├── RailwayReservationPortal.java   # All the code lives here
├── RailwayReservationPortal.class  # Compiled bytecode (after javac)
├── README.md                        # You're reading this
└── PROJECT_REPORT.md               # Detailed project documentation
```

Yes, it's just one Java file. Could have split it into multiple classes, but that would've complicated things for what's essentially a demonstration of core concepts.

---

## Sample Output

```
==========================================================
      INDIAN RAILWAYS - TICKET RESERVATION SYSTEM
==========================================================
  Book your journey with us - Safe, Reliable, Affordable
==========================================================

----------------------------------------------------------
                  SELECT YOUR TICKET TYPE
----------------------------------------------------------

  Option 1: SLEEPER CLASS
            Price: Rs. 450 per ticket (INR)
            Features: Sleeping berth, Fan, Blanket

  Option 2: AC CLASS (Air Conditioned)
            Price: Rs. 1250 per ticket (INR)
            Features: AC, Comfortable berth, Meals included

  Option 3: GENERAL CLASS
            Price: Rs. 150 per ticket (INR)
            Features: Basic seating, Most economical option

  Option 4: EXIT FROM SYSTEM

----------------------------------------------------------
Please enter your choice (1 to 4):
```

---

## Known Limitations

Let me be upfront about what this doesn't do:

- **No data persistence** - Close the program and everything resets
- **No passenger details** - Just ticket counts, no names or IDs
- **No train selection** - No routes, schedules, or multiple trains
- **No actual payment** - Fare is calculated but nothing's charged
- **Sequential seat allocation** - Takes from Coach 1 first, then 2, etc.

These are fine for a course project. Would be problems for actual deployment.

---

## What I Learned Building This

- Scanner's `nextInt()` leaves newlines in the buffer. Call `nextLine()` after it.
- Edge cases take longer than the main logic. Always.
- Console formatting is tedious but matters for readability.
- Knowing when to stop adding features is a skill.

---

## Tech Details

| Item | Info |
|------|------|
| Language | Java |
| JDK Version | 8+ |
| Lines of Code | ~280 |
| External Dependencies | None |
| Testing | Manual |
---

## Author

**Ambrish Raj**
Roll Number: 24BHI10019
Course: Java Programming
March 2026
---

## License
This is a student project for educational purposes. Feel free to use it for learning, but don't copy it directly for your own assignments - that defeats the purpose of learning.
