import java.util.*;
import java.util.stream.Collectors;

public class solution1912 {

    // ✅ Inner class that matches the LeetCode definition
    static class MovieRentingSystem {
        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] e : entries) {
                final int shop = e[0];
                final int movie = e[1];
                final int price = e[2];
                unrented.putIfAbsent(movie, new TreeSet<>(comparator));
                unrented.get(movie).add(new Entry(price, shop, movie));
                shopAndMovieToPrice.put(new AbstractMap.SimpleEntry<>(shop, movie), price);
            }
        }

        public List<Integer> search(int movie) {
            return unrented.getOrDefault(movie, Collections.emptySet())
                .stream()
                .limit(5)
                .map(e -> e.shop)
                .collect(Collectors.toList());
        }

        public void rent(int shop, int movie) {
            final int price = shopAndMovieToPrice.get(new AbstractMap.SimpleEntry<>(shop, movie));
            unrented.get(movie).remove(new Entry(price, shop, movie));
            rented.add(new Entry(price, shop, movie));
        }

        public void drop(int shop, int movie) {
            final int price = shopAndMovieToPrice.get(new AbstractMap.SimpleEntry<>(shop, movie));
            unrented.get(movie).add(new Entry(price, shop, movie));
            rented.remove(new Entry(price, shop, movie));
        }

        public List<List<Integer>> report() {
            return rented.stream()
                .limit(5)
                .map(e -> List.of(e.shop, e.movie))
                .collect(Collectors.toList());
        }

        private record Entry(int price, int shop, int movie) {}

        private Comparator<Entry> comparator = Comparator.comparingInt(Entry::price)
            .thenComparingInt(Entry::shop)
            .thenComparingInt(Entry::movie);

        private Map<Integer, Set<Entry>> unrented = new HashMap<>();
        private Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> shopAndMovieToPrice = new HashMap<>();
        private Set<Entry> rented = new TreeSet<>(comparator);
    }

    // ✅ Main method for local testing
    public static void main(String[] args) {
        int[][] entries = {
            {0, 1, 5},
            {0, 2, 6},
            {1, 1, 4},
            {2, 1, 5}
        };

        MovieRentingSystem mrs = new MovieRentingSystem(3, entries);

        System.out.println("Search movie 1: " + mrs.search(1)); // expect shops [1,0,2]
        mrs.rent(1, 1);
        System.out.println("Report after renting (1,1): " + mrs.report());
        mrs.drop(1, 1);
        System.out.println("Report after dropping (1,1): " + mrs.report());
    }
}
