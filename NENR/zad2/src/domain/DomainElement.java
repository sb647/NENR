package domain;

import java.util.Arrays;

public class DomainElement {

    private int[] values;

    public DomainElement(int... values) {
        this.values = values ;
    }

    public int getNumberOfComponents() {
        return this.values.length;
    }

    public int getComponentValue(int n) {
        if(n >= 0 && n < values.length) {
            return values[n];
        }
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomainElement)) return false;
        DomainElement that = (DomainElement) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        if(values.length == 1) {
            return String.valueOf(values[0]);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");

            for(int v : values){
                sb.append(v);
                sb.append(",");
            }

            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            return sb.toString();
        }

    }

    public static DomainElement of(int... array) {
        return new DomainElement(array);
    }

    public int[] getValues() {
        return values;
    }
}
