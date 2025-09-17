import java.util.*;

public class solution2353 {
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);

        System.out.println(foodRatings.highestRated("korean"));   // kimchi
        System.out.println(foodRatings.highestRated("japanese")); // ramen

        foodRatings.changeRating("sushi", 16);

        System.out.println(foodRatings.highestRated("japanese")); // sushi
    }
}

class FoodRatings {
    Map<String, TreeSet<Pair>> cuisineToRatingAndFoods = new HashMap<>();
    Map<String, String> foodToCuisine = new HashMap<>();
    Map<String, Integer> foodToRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            cuisineToRatingAndFoods.putIfAbsent(
                cuisines[i],
                new TreeSet<>(
                    Comparator.<Pair>comparingInt(p -> -p.rating)
                              .thenComparing(p -> p.food)
                )
            );
            cuisineToRatingAndFoods.get(cuisines[i]).add(new Pair(ratings[i], foods[i]));
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);
        TreeSet<Pair> ratingAndFoods = cuisineToRatingAndFoods.get(cuisine);
        ratingAndFoods.remove(new Pair(oldRating, food));
        ratingAndFoods.add(new Pair(newRating, food));
        foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cuisineToRatingAndFoods.get(cuisine).first().food;
    }
}

// helper class (since Java doesn't have built-in Pair like C++)
class Pair {
    int rating;
    String food;

    Pair(int rating, String food) {
        this.rating = rating;
        this.food = food;
    }

    // needed so TreeSet can identify same Pair correctly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return rating == pair.rating && food.equals(pair.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, food);
    }
}
