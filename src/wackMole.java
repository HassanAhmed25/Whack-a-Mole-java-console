import java.util.Random;
import java.util.Scanner;

public class wackMole {

    static int row = 0,col = 0;
    static int score = 0;
    public static void main(String[] args) {

if(args.length == 2)
{
        row = Integer.parseInt(args[0]);
        col = Integer.parseInt(args[1]);


        int[][] arr = new int[row][col];

        printGrid(arr);
        System.out.println("Let's play.");
        System.out.println("Enter negative coordinates to stop playing.");
        int r,c;
        Scanner e = new Scanner(System.in);
       do {


           System.out.print("Enter x coordinate: ");
           Scanner sr= new Scanner(System.in);
           r = sr.nextInt();

           System.out.print("Enter y coordinate: ");
           Scanner sc= new Scanner(System.in);
           c = sc.nextInt();

           if (r < 0 || c < 0)
           {
               System.out.println("Thank you. Have a nice day");
               System.exit(0);
           }
           else {
               hitMole(arr,r,c);
           }
       }
       while (r >= 0 || c >= 0);
}

else
{
System.out.println("Invalid args");
}
    }

    public static void printGrid(int[][] arr){
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print("*");
            }

            System.out.print('\n');
        }
    }

//    public static void fillGrid(int arr[][])
//    {
//
//    }

    public static void hitMole(int[][] arr, int r, int c)
    {
        if (r >= arr.length || c >= arr[r].length)
        {
            System.out.println("That exceeds grid bounds. Try again.");
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    int rnd = (int) (Math.round(Math.random()));
                    arr[i][j] = rnd;
                    System.out.print(rnd);
                }

                System.out.print('\n');
            }
            if (arr[r][c] == 1) {

                score += 1;
                if (score < 10) {
                    System.out.println("That's a hit!");
                    System.out.println("Your score = " + score);
                }

                else if (score == 10) {
                    System.out.println("Your score = " + score + "YAY!! You won the game!");
                    System.out.println("Thank you. Have a nice day");
                    System.exit(0);
                }
            } else {

                System.out.println("That's a miss.");
                score -= 1;
                System.out.println("Your score = " + score);

                if (score < 0)
                {
                    System.out.println("That's a miss.");
                    System.out.println("GAME OVER!");
                    System.out.println("Thank you. Have a nice day");
                    System.exit(0);
                }
            }
        }
    }
}
