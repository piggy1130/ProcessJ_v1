package std;

public class jl_random {
    // static java.util.Random r = new java.util.Random(0);
    
    // public static void initRandom(long seed) {
    //     r = new java.util.Random(seed);
    // }
    
    // public static long longRandom() {
    //     return r.nextLong() & Long.MAX_VALUE;
    // }

    // return a random number between 0 and 1
    public static double jl_random_1(){
        double randomnumber = Math.random();
        return randomnumber;
    }

    // return a INT random number between 0 and 100
    public static int jl_random_100(){
        int randomnumber = (int) (Math.random()*101);
        return randomnumber;
    }



}
