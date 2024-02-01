import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        TreeSet<String> set = new Scanner(System.in).tokens().skip(1)
                .collect(Collectors.toCollection(TreeSet::new));
        set.forEach(System.out::println);
    }
}