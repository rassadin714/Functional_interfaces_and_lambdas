import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(-3);
        integerList.add(-5);
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer element) {
                return element > 0;
            }
        };
        for (Integer element : integerList) {
            if(integerPredicate.test(element)) {
                System.out.println(element);
            }
        }

        Predicate<Integer> predicate = el -> el > 0;
        for (Integer element : integerList) {
            if(predicate.test(element)) {
                System.out.println(element);
            }
        }


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Василий"));
        personList.add(new Person("Сергей"));
        personList.add(new Person("Юлия"));
        personList.add(new Person("Виктор"));
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Добрый день, " + person.getName());
            }
        };
        for (Person person: personList){
            consumer.accept(person);
        }

        Consumer<Person> consumer1 = person -> System.out.println("Добрый день, " + person.getName());
        for (Person person: personList){
            consumer1.accept(person);
        }


        List<Double> doubleList = new ArrayList<>();
        doubleList.add(11.1);
        doubleList.add(12.2);
        doubleList.add(22.2);
        doubleList.add(33.4);
        Function<Double, Long> doubleLongFunction = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        for (Double element: doubleList){
            System.out.println(doubleLongFunction.apply(element));
        }

        Function<Double, Long> function = d -> d.longValue();
        for (Double element: doubleList){
            System.out.println(function.apply(element));
        }


        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                int a = (int) Math.floor(Math.random()*101);
                return a;
            }
        };
        System.out.println();
        System.out.println(supplier.get());
        System.out.println();

        Supplier<Integer> supplier1 = () -> (int)Math.floor(Math.random()*101);
        System.out.println(supplier1.get());


        Predicate <Integer> predicate1 = a -> a >0;
        Function<Integer, String> function1 = a -> "положительное число " + a;
        Function<Integer, String> function2 = a -> "отрицательное число " + a;
        System.out.println(ternaryOperator(predicate1,function1, function2).apply(-5));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Function<T, U> function = t -> {
            if (condition.test(t)){
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };
        return  function;

    }
}