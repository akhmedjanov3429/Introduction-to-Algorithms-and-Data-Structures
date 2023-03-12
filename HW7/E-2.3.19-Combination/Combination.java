public class Combination
{
    public static char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args)
    {
        // Guaranteed n <=26 
        int n = Integer.parseInt(args[0]);
        boolean[]  choice = new boolean[n];

        // Hint 1 : choice of the each letter in a particular combination
        // can be a true/false on the choice array
        // 
        // Example: if choice[4] = [true, false, true, false], then the
        // output should be "ac"

        // Hint 2 : The 'start' position is to increment towards
        // choice.length, and at each step, it chooses to include
        // letter[i] or not letter[i] by setting choice[i] to true or
        // fasle.

        combination_r( choice, 0);
    }
        
    public static void combination_r(boolean [] choice, int start){
        // Complete the code here, see README on course website for problem description and instructions.
        {
            if (start == choice.length)
            {
                for (int i = 0; i < choice.length; i++)
                {
                    if (choice[i])
                    {
                        System.out.print(letters[i]);
                    }
                }
                System.out.println();
            }
            else
            {
                choice[start] = true;
                combination_r(choice, start + 1);
                choice[start] = false;
                combination_r(choice, start + 1);
            }
        }
    



    }
}