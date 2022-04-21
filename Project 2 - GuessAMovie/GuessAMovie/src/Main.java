import java.io.File ;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {



        File booksFile = new File("movies.txt");
        Scanner scanner = new Scanner (booksFile);
        List<String> movies = new ArrayList<String>();

        if(booksFile.exists()) {

            while(scanner.hasNextLine()) {
                movies.add(scanner.nextLine().trim());
            }
            boolean finished = false;

            Scanner input = new Scanner(System.in);
            String randomMovie = movies.get(getRandomNumberUsingNextInt(0, movies.size()));
            String newString = new String(new char[getLetterCount(randomMovie)]).replace("\0", "_");

            char[] randomMovieArray = randomMovie.toCharArray();
            char[] newStringArray = newString.toCharArray();
            String wrongLetters = "";

            for(int i=0; i<getLetterCount(randomMovie); i++) {
                if(randomMovieArray[i]==' ') {
                    newStringArray[i]=' ';
                }
            }

            int count =0;

            while(newString.contains("_")) {


                System.out.println("You are guessing:" + newString + "(" + randomMovie + ")");
                System.out.println("You have guessed ("+count+") wrong letters: "+wrongLetters);
                System.out.print("Guess a letter:");

                char letter = input.next().charAt(0);

                for(int i=0; i<getLetterCount(randomMovie); i++) {
                    if(randomMovieArray[i]==letter) {
                        newStringArray[i]=letter;
                    }
                }

                if(randomMovie.indexOf(letter) == -1) {
                    count ++;
                    wrongLetters+=" "+letter;
                }

                newString=String.valueOf(newStringArray);

                if(!newString.contains("_")) {
                    System.out.println("You win!");
                    System.out.println("You have guessed "+"'"+randomMovie+"'"+" correctly.");
                }
            }

        }
        }
    private static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int getLetterCount(String string) {
        int count=0;
        for(int i = 0; i < string.length(); i++) {
                count++;
        }
        return count;
    }
}