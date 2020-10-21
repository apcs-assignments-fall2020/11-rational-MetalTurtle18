public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b)
    {
        numerator = a;
        denominator = b;
    }
    
    // This method takes two Rationals, add thems up, 
    // and returns a Rational equal to the sum
    public static Rational add(Rational r, Rational s)
    {
        int newNumerator = r.numerator * s.denominator + s.numerator * r.denominator;
        int newDenominator = r.denominator * s.denominator;
        
        return simplify(new Rational(newNumerator, newDenominator));
    }

    // Finds the greatest common factor between a and b
    public static int greatestCommonFactor(int a, int b){
        for (int i = Math.min(a, b); i > 0; i--)
            if (a % i == 0 && b % i == 0)
                return i;
        return 1;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        return new Rational(r.numerator / greatestCommonFactor(r.numerator, r.denominator), r.denominator / greatestCommonFactor(r.numerator, r.denominator));
    }

    // This method takes two Rationals, subtracts thems up, 
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s)
    {
        int newNumerator = r.numerator * s.denominator - s.numerator * r.denominator;
        int newDenominator = r.denominator * s.denominator;

        return simplify(new Rational(newNumerator, newDenominator));
    }
    
    public static Rational multiply(Rational r, Rational s)
    {
       return simplify(new Rational(r.numerator * s.numerator, r.denominator * s.denominator));
    }
    
    public static Rational divide(Rational r, Rational s)
    {
        return simplify(new Rational(r.numerator * s.denominator, r.denominator * s.numerator));
    }



    // These following methods are NOT static, we'll talk about them next class!
    // This returns a string representation of a Rational (e.g. "1/2")
    @Override
    public String toString()
    {
        return this.numerator + "/" + this.denominator;
    }


    public Rational add(Rational s)
    {
        int newNumerator = this.numerator * s.denominator + s.numerator * this.denominator;
        int newDenominator = this.denominator * s.denominator;
        return simplify(new Rational(newNumerator, newDenominator));
    }
    
    public Rational subtract(Rational s)
    {
        int newNumerator = this.numerator * s.denominator - s.numerator * this.denominator;
        int newDenominator = this.denominator * s.denominator;
        return simplify(new Rational(newNumerator, newDenominator));
    }
    
    public Rational multiply(Rational s)
    {
        return simplify(new Rational(this.numerator * s.numerator, this.denominator * s.denominator));
    }
    
    public Rational divide(Rational s)
    {
        return simplify(new Rational(this.numerator * s.denominator, this.denominator * s.numerator));
    }
}













