import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MathematicalActionException, DifferentTypesOfNumbers {
        Scanner scanner;

        while (true){
            scanner = new Scanner(System.in);

            System.out.println("Please enter an input(for example 5 + 3)");
            String[] array = scanner.nextLine().trim().split(" ");

            if(array.length!=3){
                try {
                    throw new IncorrectInputException("Incorrect input!");
                } catch (IncorrectInputException e) {
                    e.printStackTrace();
                    break;
                }
            }

            roman_or_arabic ra = new roman_or_arabic(array[0],array[2]);

            //check a and b type
            if (ra.ifArabic()){
                Action action = new Action(array[1],Integer.parseInt(array[0]),Integer.parseInt(array[2]));
                try {
                    System.out.println(action.doing());
                }
                catch (BoundsOfNumberException bb){
                    System.out.println("Sorry but some element is greater than 10(or less than 0) !");
                }
                catch (Exception e){
                    throw new MathematicalActionException("Incorrect or unsupported math action!");
                }
            }
            else if (ra.ifRoman()){
                Action action = new Action(array[1],ra.getAa(),ra.getBb());
                try {
                    System.out.println(ra.getRomanChar(action.doing()));
                }
                catch (BoundsOfNumberException b){
                    System.out.println("Sorry but some element is greater than 10(or less than 0) !");
                }
                catch (Exception e){
                    throw new MathematicalActionException("Incorrect or unsupported math action!");
                }
            }
            else throw new DifferentTypesOfNumbers("Sorry,but numbers have different types!");
        }
    }

}

