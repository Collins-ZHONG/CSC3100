// package CSC3100;

public class Math {
    public int add(int x, int y) {
        return x + y;       
    }
    
    public int square(int x) {
        return x * x;
    }
    
    public int pythagorean(int a, int b) {
        int c;
        int aSquared = square(a);
        int bSquared = square(b);
        c = add(aSquared, bSquared);
        return c;
    }
    
    public void encourage() {
        System.out.println("You can do math!!!");
        return;       // This return statement is technically optional.
    }
    
}

