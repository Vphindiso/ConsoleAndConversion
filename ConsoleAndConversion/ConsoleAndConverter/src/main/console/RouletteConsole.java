import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class RouletteConsole
{
   public static void main(String[] args)
   {
      
       Scanner keyboard = new Scanner(System.in);
       Random generator = new Random();
       double betAmount , winningAmount;
       String bet;
       int number = 0,rouletteNum, result;
       char response ;
       int resultArr[] = new int[36];
       
       for(int i = 0; i<getPlayers().size();i++ ){
        int wins = 0, losses=0;
        String outcome = "";
        do
            {
            System.out.print(getPlayers().get(i)+" : ");
           
            bet = keyboard.nextLine();
            betAmount = keyboard.nextDouble();
            rouletteNum = generator.nextInt(37);
           System.out.println("Roulette number: " + rouletteNum);
           
           if (bet.equalsIgnoreCase("Even") && rouletteNum % 2 ==0 )  
           {
               wins ++;
               outcome = "WIN";
               winningAmount = betAmount*2;
           }
           else if(bet.equalsIgnoreCase("odd") && rouletteNum % 2 !=0){
               wins++;
               outcome = "WIN";
               winningAmount = betAmount*2;
           }
           else if (bet.equalsIgnoreCase("number")){
               System.out.print("Place your bet on number(1-36): ");
               number = keyboard.nextInt();
               if(number == rouletteNum){
               wins++;
               outcome = "WIN";
               winningAmount = betAmount*36;
               }
           }
               
           else
           {
               losses ++;
               resultArr[rouletteNum]++;
               outcome = "LOSE";
           }
         
           System.out.print("\n Continue playing ? (y/n) ");
           response = keyboard.next().charAt(0);
           
        }
         while (response == 'y' || response == 'Y');
         System.out.println("Player              Bet      Outcome        Winnings");
         System.out.println(getPlayers().get(i)+ "          "+ bet +"          "+outcome+"          "+ wins);
         System.out.println("=============================================================================");
       }
   }
   public static List<String> getPlayers(){
       List<String> players = new ArrayList<>();
       try {
            BufferedReader reader = new BufferedReader(new FileReader("players.txt"));
            String line = reader.readLine();
            while (line != null) {
                players.add(line);
		// read next line
		line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return players;
   }
}