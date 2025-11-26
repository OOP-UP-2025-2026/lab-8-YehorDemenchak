package ua.opnu;

public class BookData implements Comparable<BookData> {
    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviews() {
        return reviews;
    }

    public double getTotal() {
        return total;
    }

    public double getRating() {
        if (reviews == 0) {
            return 0.0;
        }
        return total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        int ratingComparison = Double.compare(otherRating, thisRating);

        if (ratingComparison == 0) {
            return this.title.compareTo(other.title);
        }

        return ratingComparison;
    }
}
