import java.util.Objects;

class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + Double.hashCode(im);
        return result;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ComplexNumber cplxNum = (ComplexNumber) obj;
        return Double.compare(re, cplxNum.re) == 0 && Double.compare(im, cplxNum.im) == 0;
    }
}
//public boolean equals(Object other) {
//        /* Check this and other refer to the same object */
//        if (this == other) {
//            return true;
//        }
//
//        /* Check other is Person and not null */
//        if (!(other instanceof Person)) {
//            return false;
//        }
//
//        Person person = (Person) other;
//
//        /* Compare all required fields */
//        return age == person.age &&
//                Objects.equals(firstName, person.firstName) &&
//                Objects.equals(lastName, person.lastName);
//    }
//}