class CheckDuplicate{

    public static void main(String args[]){
        
        // Note the numbers in args starts from 1 to N, where N is args.length
        
        // Fill in the blanks

        int[] a = new int[args.length];


        for (int i = 0; i < args.length  ; i++) {


            a[i] =  Integer.parseInt(args[i]) ;

        }


        for (int i = 0; i < a.length; i++) {


            int cnt = 1;


            for ( int j = i+1; j < a.length; j++ ) {


                if ( a[i] == a[j] )  cnt ++;

            }


            if ( cnt > 1 ) {


                System.out.println(cnt);


                System.out.println("There are duplicate values");


                return;
            }
        }

        System.out.println("There is no duplicate value");
    }
}


