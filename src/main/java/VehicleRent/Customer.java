package VehicleRent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Customer {

    public static void main(String[] args) {
        
        FileWriter vehicleWriter;
        FileWriter customerDetailWriter;


        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Rental> rentals = new ArrayList<>();

        Vehicle vehicle = null;
        Rental rental1;
        Vehicle v;



        Scanner scanner = new Scanner(System.in);
        int selection;
        int num = 0;
        String customerName = "";

       
        //int number = 0;
        String op = null;

        try {
            vehicleWriter = new FileWriter("C:\\Users\\211619\\IdeaProjects\\Java-Lab_Exercise5\\src\\main\\resources\\Vehicle.csv");
            customerDetailWriter = new FileWriter("C:\\Users\\211619\\IdeaProjects\\Java-Lab_Exercise5\\src\\main\\resources\\Rental.csv");

            do
            //while (number < 10)
            {
                System.out.println("Enter your choice : ");
                System.out.println("1. Enter Vehicle Record\n" +
                        "2. Enter Customer Record for Rental\n" +
                        "3. Check cars Avilablity for Rent \n" +
                        "4. Show cars on Rent  \n" +
                        "5. Check avilability of cars on rent \n" +
                        "6. Add New Vehicle\n" +
                        "7. Cancle the vehicle \n" +
                        "8. Import Data to CSV File\n" +
                        "9. Export Data from CSV File\n" +
                        "10.Exit"
                );
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("******************** Enter Vehicle Details ********************");
                        System.out.println("Enter identification code : ");
                        int code = scanner.nextInt();
                        //sc.nextLine();

                        //sc = new Scanner(System.in);
                        System.out.println("Enter brand : ");
                        String brand = scanner.next();

                        //sc = new Scanner(System.in);
                        System.out.println("Enter Model : ");
                        String model = scanner.next();

                        scanner = new Scanner(System.in);
                        System.out.println("Enter number of Seats : ");
                        int seats = scanner.nextInt();
                        scanner.nextLine();

                        //sc = new Scanner(System.in);
                        System.out.println("Enter license plate : ");
                        String lplate = scanner.next();

                        vehicle = new Vehicle(code, brand, model, seats, lplate);
                        vehicles.add(vehicle);

                        break;

                    case 2:
                        System.out.println("******************** Enter Customer Details ********************");
                        System.out.println("\n*********************************************");
                        if (vehicles.size() >= 0) {
                            System.out.println("Enter Name Of customer :");
                            customerName = scanner.next();

                            System.out.println("Enter Number of your choice : ");
                            for (int i = 0; i < vehicles.size(); i++) {
                                System.out.println((i + 1) + "-"
                                        + "Identification_code : " + vehicles.get(i).getIdentificationCode()
                                         + "\tBrand : " + vehicles.get(i).getBrand()
                                         + "\tModel : " + vehicles.get(i).getModel()
                                         + "\tNo of seats : " + vehicles.get(i).getNumberOfSeat()
                                         + "\tLicense Plate : " + vehicles.get(i).getLicensePlate());
                            }
                            selection = scanner.nextInt();

                            System.out.println("Enter start Date(dd-mm-yyyy) : ");
                            String date = scanner.next();
                            Date parseDate1 = null;
                            parseDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);


                            System.out.println("Enter End Date(dd-mm-yyyy) : ");
                            String date1 = scanner.next();
                            Date parseDate2 = null;
                            parseDate2 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);

                            long timediff = parseDate2.getTime() - parseDate1.getTime();
                            long numberOFDays = (timediff / (1000 * 60 * 60 * 24));

                            System.out.println(numberOFDays + " Days for car required on rent");
                            if (vehicles.size() >= 1) {
                                v = new Vehicle(vehicles.get(selection - 1).getIdentificationCode(), vehicles.get(selection - 1).getBrand(), vehicles.get(selection - 1).getModel(), vehicles.get(selection - 1).getNumberOfSeat(), vehicles.get(selection - 1).getLicensePlate());
                                vehicles.remove(selection - 1);
                            } else {
                                v = new Vehicle(vehicles.get(0).getIdentificationCode(), vehicles.get(0).getBrand(), vehicles.get(0).getModel(), vehicles.get(0).getNumberOfSeat(), vehicles.get(0).getLicensePlate());
                                vehicles.remove(0);
                            }


                            rental1 = new Rental(customerName, parseDate1.toString(), parseDate2.toString(), (int) numberOFDays, selection, v);
                            rentals.add(rental1);

                        } else {
                            System.out.println("Please Enter vehicle Record To book a car on Rent ");
                        }
                        break;

                    case 3:
                        System.out.println("\n*********************************************");
                        System.out.println("******************** Total Cars Available for Rent ********************");
                        if(vehicles.size() > 0) {
                            for (int i = 0; i < vehicles.size(); i++) {
                                System.out.println((i + 1) + ". : " + "Identification code : " + vehicles.get(i).getIdentificationCode()
                                        + "," + " Brand : " + vehicles.get(i).getBrand()
                                        + "," + " Model : " + vehicles.get(i).getModel()
                                        + "," + " No of Seats : " + vehicles.get(i).getNumberOfSeat()
                                        + "," + " License plate : " + vehicles.get(i).getLicensePlate());
                            }
                        }else {
                            System.out.println("Currently no any car is Avilable for Rent");
                        }
                        //System.out.println("\n*********************************************");

                        break;

                    case 4:
                        System.out.println("\n*********************************************");
                        System.out.println("******************** Available car on Rent ********************");
                        if(rentals.size() >= 1) {
                            for (int i = 0; i < rentals.size(); i++) {
                                System.out.println((i + 1) + "."
                                        +"Identification_code : "+ rentals.get(i).getVehicle().getIdentificationCode() +
                                        "\tName of customer : "+ rentals.get(i).getCustomer_Name() +
                                        "\tStart Date : " + rentals.get(i).getStart_date() +
                                        "\tEnd Date : "  + rentals.get(i).getEnd_date() +
                                        "\tNo of Days : " + rentals.get(i).getNumber_of_days() +
                                        "\tLicense_plate : " + rentals.get(i).getVehicle().getLicensePlate() +
                                        "\tBrand : " + rentals.get(i).getVehicle().getBrand() +
                                        "\tModel : " + rentals.get(i).getVehicle().getModel() +
                                        "\tNumber of seats :" + rentals.get(i).getVehicle().getNumberOfSeat());
                            }
                        }else{
                            System.out.println("No Record found");
                        }

                        //System.out.println("\n*********************************************");
                        break;

                    case 5:
                        System.out.println("******************** Available car on Rent in given period ********************");
                        if(vehicles.size() >= 1) {
                            scanner.nextLine();
                            System.out.println("Enter start Date(dd-mm-yyyy) to check Availablity : ");
                            String startdate = scanner.next();
                            Date parsestartdate = null;
                            parsestartdate = new SimpleDateFormat("dd-MM-yyyy").parse(startdate);


                            System.out.println("Enter End Date(dd-mm-yyyy) to check Availablity: ");
                            String enddate = scanner.next();
                            Date parseenddate = null;
                            parseenddate = new SimpleDateFormat("dd-MM-yyyy").parse(enddate);

                            if(rentals.size() >=1 ) {
                                for (int i = 0; i < rentals.size(); i++) {
                                    if ((rentals.get(i).getStart_date().compareTo(parsestartdate.toString()) > 0) &&
                                            (rentals.get(i).getEnd_date().compareTo(parseenddate.toString()) > 0) || (rentals.get(i).getStart_date().compareTo(parsestartdate.toString()) < 0) && (rentals.get(i).getEnd_date().compareTo(parseenddate.toString()) < 0)) {
                                                System.out.println("Identification code : " + vehicles.get(i).getIdentificationCode()
                                                + "\tBrand : " + vehicles.get(i).getBrand()
                                                + "\tModel : " + vehicles.get(i).getModel()
                                                + "\tNo of Seats : " + vehicles.get(i).getNumberOfSeat()
                                                + "\tLicense plate : " + vehicles.get(i).getLicensePlate());
                                    } else {
                                        System.out.println("Car is not Available on Rent.");
                                    }
                                }
                            }else{
                                System.out.println("******************** Cars Available on Rent ********************");
                                for (int i=0;i<vehicles.size();i++){
                                    System.out.println("Identification code : " + vehicles.get(i).getIdentificationCode()
                                            + "\tBrand : " + vehicles.get(i).getBrand()
                                            + "\tModel : " + vehicles.get(i).getModel()
                                            + "\tNo of Seats : " + vehicles.get(i).getNumberOfSeat()
                                            + "\tLicense plate : " + vehicles.get(i).getLicensePlate());
                                }
                                System.out.println("*******************************************");
                            }
                        }else{
                            System.out.println("No Vehicles are avilable on rent");
                        }
                        break;

                    case 6:
                        System.out.println("******************** Add new Vehicle ********************");
                        System.out.println("Enter identification code : ");
                        int idcode = scanner.nextInt();
                        scanner.nextLine();

                        scanner = new Scanner(System.in);
                        System.out.println("Enter brand Name : ");
                        String brandName = scanner.nextLine();

                        scanner = new Scanner(System.in);
                        System.out.println("Enter Model Name : ");
                        String modelName = scanner.nextLine();

                        scanner = new Scanner(System.in);
                        System.out.println("Enter number of Seats : ");
                        int noOfSeats = scanner.nextInt();
                        scanner.nextLine();

                        scanner = new Scanner(System.in);
                        System.out.println("Enter license plate : ");
                        String licenseplate = scanner.nextLine();


                        vehicle = new Vehicle(idcode, brandName, modelName, noOfSeats, licenseplate);
                        vehicles.add(vehicle);

                        break;

                    case 7:
                        System.out.println("******************** Cancle the Vehicle ********************");
                        if(rentals.size() >= 1) {
                            for (int i = 0; i < rentals.size(); i++) {
                                System.out.println((i + 1) + "-"
                                        +"Identification_code : "+ rentals.get(i).getVehicle().getIdentificationCode() +
                                        "\tName Of customer : "+ rentals.get(i).getCustomer_Name() +
                                        "\tStart Date :"+ rentals.get(i).getStart_date() +
                                        "\tEnd Date : " + rentals.get(i).getEnd_date() +
                                        "\tNo of Days : "+ rentals.get(i).getNumber_of_days() +
                                        "\tLicense plate : " + rentals.get(i).getVehicle().getLicensePlate() +
                                        "\tBrand : " + rentals.get(i).getVehicle().getBrand() +
                                        "\tModel : "+ rentals.get(i).getVehicle().getModel() +
                                        "\tNumber of seats : "+ rentals.get(i).getVehicle().getNumberOfSeat());
                            }
                            System.out.println("Enter Number to Cancel the Car : ");
                            int idCode = scanner.nextInt();
                            scanner.nextLine();

                            vehicle = new Vehicle(rentals.get(idCode - 1).getVehicle().getIdentificationCode(),
                                    rentals.get(idCode - 1).getVehicle().getBrand(),
                                    rentals.get(idCode - 1).getVehicle().getModel(),
                                    rentals.get(idCode - 1).getVehicle().getNumberOfSeat(),
                                    rentals.get(idCode - 1).getVehicle().getLicensePlate());
                            vehicles.add(vehicle);
                            rentals.remove(idCode-1);


                        }else{
                            System.out.println("No any record found to cancel the vehicle");
                        }
                        break;

                    case 8:
                        System.out.println("******************** Import data to CSV file ********************");
                        if(vehicles.size() >= 1) {
                            for (int i = 0; i < vehicles.size(); i++) {
                                vehicleWriter.write(vehicles.get(i).getIdentificationCode() +
                                        "\t" + vehicles.get(i).getBrand() + "," + vehicles.get(i).getModel() +
                                        "\t" + vehicles.get(i).getNumberOfSeat() +
                                        "\t" + vehicles.get(i).getLicensePlate()+"\n");

                            }
                            System.out.println("Vehicle Data is Imported");
                        }else if(rentals.size()>=1){
                            for (int i = 0; i < rentals.size(); i++) {
                                vehicleWriter.write(rentals.get(i).getVehicle().getIdentificationCode() +
                                        "\t" + rentals.get(i).getVehicle().getBrand() +
                                        "\t" + rentals.get(i).getVehicle().getModel() +
                                        "\t" + rentals.get(i).getVehicle().getNumberOfSeat() +
                                        "\t" + rentals.get(i).getVehicle().getLicensePlate() + "\n");

                            }
                            System.out.println("Vehicle data is imported in CSV file");
                        }else
                        {
                            System.out.println("No vehicle record to import in to CSV file");
                        }
                        if(rentals.size() >=1 ) {
                            for (int i = 0; i < rentals.size(); i++) {
                                customerDetailWriter.write(rentals.get(i).getCustomer_Name() +
                                        "," + rentals.get(i).getStart_date() +
                                        "," + rentals.get(i).getEnd_date() +
                                        "," + rentals.get(i).getNumber_of_days() +
                                        "," + rentals.get(i).getVehicle().getIdentificationCode() +
                                        "," + rentals.get(i).getVehicle().getBrand() +
                                        "," + rentals.get(i).getVehicle().getModel() +
                                        "," + rentals.get(i).getVehicle().getNumberOfSeat() +
                                        "," +  rentals.get(i).getVehicle().getLicensePlate() + "\n");
                            }
                            System.out.println("Rental Data is imported in CSV file");
                            //myWriter1.close();
                        }else{
                            System.out.println("No rental record to import in to CSV file");
                        }
                        vehicleWriter.close();
                        customerDetailWriter.close();
                        break;

                    case 9:
                        System.out.println("******************** Export data from CSV file ********************");
                        String line = "";
                        /*vehicleWriter.close();
                        customerDetailWriter.close();*/
                        try
                        {
                            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\211619\\IdeaProjects\\Java-Lab_Exercise5\\src\\main\\resources\\Vehicle.csv"));
                            boolean flag = false;
                            System.out.println("******************** Vehicle Data ********************");
                            while ((line = br.readLine()) != null) {

                                String vehicledetails[] = line.split(",");

                                System.out.println("Identification_Code : "+vehicledetails[0]+
                                        "\tBrand : "+vehicledetails[1]+
                                        "\tModel : "+vehicledetails[2]+
                                        "\tNo of Seats : "+vehicledetails[3]+
                                        "\tLicense plate : "+vehicledetails[4]);
                                flag = true;
                            }
                            if(flag == false){
                                System.out.println("No record found ");
                            }
                            System.out.println("**********************************************************");
                        }catch (
                                IOException e)
                        {
                            e.printStackTrace();
                        }
                        try
                        {
                            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\211619\\IdeaProjects\\Java-Lab_Exercise5\\src\\main\\resources\\Rental.csv"));
                            boolean flag1 = false;
                            System.out.println("******************** Rental Data ********************");
                            while ((line = br.readLine()) != null) {

                                String Rent[] = line.split(",");
                                System.out.println("Name Of Customer : "+Rent[0]
                                        +"\tStart Date="+Rent[1]
                                        +"\tEnd Date="+Rent[2]
                                        +"\tNo of Days="+Rent[3]
                                        +"\tIdentification Code="+Rent[4]
                                        + "\tBrand="+Rent[5]
                                        +"\tModel="+Rent[6]
                                        + "\tNo of Seats="+Rent[7]
                                        +"\tLicense plate="+Rent[8]);
                                flag1 = true;
                            }
                            if(flag1 == false){
                                System.out.println("No record found ");
                            }
                            System.out.println("**************************************************************");
                        }catch (
                                IOException e)
                        {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        System.out.println("Please enter correct choice.");
                        break;

                }
                scanner = new Scanner(System.in);
                System.out.println("Do you want to continue enter y/n :");
                op = scanner.nextLine();

            }while(op.equalsIgnoreCase("y"));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
