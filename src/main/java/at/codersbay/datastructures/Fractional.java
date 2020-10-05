package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {
    private Integer numerator;
    private Integer denominator;

    public Fractional(Integer numerator, Integer denominator) {
        if (numerator == null) {
            throw new IllegalArgumentException("You shall not pass null!");
        } else if (denominator == null) {
            throw new IllegalArgumentException("You shall not pass null!");
        } else if (denominator == 0) {
            throw new IllegalArgumentException("You shall not divide through zero!");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Integer getNumerator() {
        return this.numerator;
    }

    public Integer getDenominator() {
        return this.denominator;
    }

    public Float asFloat() {
        return (float) this.numerator / this.denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Fractional) {
            // convert Object to Fractional
            Fractional help = (Fractional) obj;
            if (this.numerator == 0 && help.getNumerator() == 0) {
                return true;
            } else if (this.numerator == help.getNumerator() && this.denominator == help.getDenominator()) {
                return true;
            }
            while (help.getNumerator() > 1 && help.getDenominator() > 1) {
                if (help.getDenominator() % help.getNumerator() == 0) {
                    help.denominator /= help.getNumerator();
                    help.numerator /= help.getNumerator();
                    if (this.numerator == help.getNumerator() && this.denominator == help.getDenominator()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
            while (this.getNumerator() > 1 && this.getDenominator() > 1) {
                if (this.getDenominator() % this.getNumerator() == 0) {
                    this.denominator /= this.getNumerator();
                    this.numerator /= this.getNumerator();
                    if (this.numerator == help.getNumerator() && this.denominator == help.getDenominator()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public Fractional multiply(Fractional other) {
        return new Fractional(this.numerator * other.getNumerator(), this.denominator * other.denominator);
    }

    public Fractional multiply(Integer other) {
        return new Fractional(this.numerator * other, this.denominator);
    }

    public Fractional divide(Fractional other) {
        return new Fractional(this.numerator * other.getDenominator(), this.denominator * other.getNumerator());
    }

    public Fractional divide(Integer other) {
        return new Fractional(this.numerator * 1, this.denominator * other);
    }

    public Fractional add(Fractional other) {
        return new Fractional((this.numerator * other.getDenominator()) + (other.getNumerator() * this.getDenominator()), this.denominator * other.getDenominator());
    }

    public Fractional add(Integer other) {
        return new Fractional(this.numerator + other * this.getDenominator(), this.denominator);
    }

    public Fractional subtract(Fractional other) {
        return new Fractional((this.numerator * other.getDenominator()) - (other.getNumerator() * this.denominator), this.denominator * other.getDenominator());
    }

    public Fractional subtract(Integer other) {
        return new Fractional(this.numerator - (other * this.denominator), this.getDenominator());
    }

}