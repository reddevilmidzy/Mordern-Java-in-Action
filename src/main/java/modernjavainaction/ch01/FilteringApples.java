package src.main.java.modernjavainaction.ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN),
                                                new Apple(155, Color.GREEN),
                                                new Apple(120, Color.RED));

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println("greenApples = " + greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println("heavyApples = " + heavyApples);

        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> Color.GREEN.equals(a.getColor()));
        System.out.println("greenApples2 = " + greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println("heavyApples2 = " + heavyApples2);

        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || Color.BROWN.equals(a.getColor()));
        System.out.println("weirdApples = " + weirdApples);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }


    public static boolean isGreenApple(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


}
