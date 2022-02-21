# Java Lab Assignment Part 2
#### This Exercise 4 & 5 is java project which contains 2 java code.

1. Library
2. Vehicle Rent

## Installation

Use Intellij Idea and JDK 11, Maven is used for automation. junit4 is used for unit testing.


## Dependencies
Add the following dependency to pom.xml file.
```python
<dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## Exercise 4
Program for amazing library system having the following features:

1. List all books written by an author using following criteria:
   •	alphabetical asc/desc,
   •	publication date asc/desc,
   •	rating asc/desc;

2. Given a book, know who is the author / are the authors;
3. How many books has an author written;
4. Given a Date, what are the books written in that year;
5. ... who is the most prolific author?

#### Implementation
1. Book
2. Author
3. InMemoryLibraryServiceImpl
4. Main : Run Main.java class to print the output

#### Check Output
"src\main\java\Library\Main.main()"

#### Resources
Books.csv

Note: In the CSV there are many columns: ignore the useless ones.

#### Unit Testing

1. BookTest : test the functionality of book class.

2. InMemoryLibraryServiceImplTest : Test the functionality of library service.


## Exercise 5
Program in Java for the management of the vehicles of a car rental.

The features that must be available in the application are:
1. Addition of a new rental of a vehicle by a customer, with which the rental start and end dates, customer data and a reference to the rented vehicle are recorded;
2. Return of the vehicle to the car rental;
3. Display of the list of all vehicles belonging to the car rental fleet.
4. View the list of all vehicles available for rental in a specified period of time.
5. Adding a new vehicle to the car rental fleet.
6. Cancellation of a vehicle from the car rental fleet.
7. Importing vehicles from a CSV file, with which it is possible to add new vehicles to the car rental fleet.
8. Export of all car rental vehicles in a CSV file.

#### Implementation
1. Customer   : Run Customer.java class to print the output.
2. Rental  : Details of vehicle.
3. Vehicle  : Detils for car rental


#### Check Output
"src\main\java\VehicleRent\Customer.main()"

#### Resources
1 Rental.csv -(Rented vehicle)

2 Vehicle.csv- (Vehicle available for Rent)


#### Unit Testing

1. RentalTest : Test the functionality of Rental class.
2. VehicleTest: Test the functionality of Vehicle class.


## License
@Gitanjali Jadhav