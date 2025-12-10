import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String quijote = "En un lugar de La Mancha de cuyo nombre no me quiero acordar";

        Map<String, Long> frecuencias = Arrays.stream(quijote.split(" "))
                .collect(Collectors.groupingBy(e -> Collectors.counting()));



    }
}