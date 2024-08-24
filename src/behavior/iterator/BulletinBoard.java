package behavior.iterator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Storage sequence editor
class ListPostIterator implements Iterator<Post> {
    private final Iterator<Post> postIterator;

    public ListPostIterator(List<Post> posts) {
        this.postIterator = posts.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.postIterator.hasNext();
    }

    @Override
    public Post next() {
        return this.postIterator.next();
    }
}

// Date sequence editor
class DatePostIterator implements Iterator<Post> {
    private final Iterator<Post> postIterator;

    public DatePostIterator(List<Post> posts) {
        posts.sort(Comparator.comparing(Post::getDate));
        this.postIterator = posts.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.postIterator.hasNext();
    }

    @Override
    public Post next() {
        return this.postIterator.next();
    }
}

class Board {
    private final List<Post> posts = new ArrayList<>();

    public void addPost(String title, LocalDate date) {
        this.posts.add(new Post(title, date));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Iterator<Post> getListPostIterator() {
        return new ListPostIterator(posts);
    }

    public Iterator<Post> getDatePostIterator() {
        return new DatePostIterator(posts);
    }
}

class Post {
    private final String title;
    private final LocalDate date;

    public Post(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public void getPostInformation() {
        System.out.println(title + " / " + date);
    }

    public LocalDate getDate() {
        return date;
    }
}

class BulletinBoardDemo {
    public static void main(String[] args) {
        Board board = new Board();

        board.addPost("Review of Design Patterns", LocalDate.of(2024, 8, 30));
        board.addPost("Who wants to play a game?", LocalDate.of(2024, 2, 6));
        board.addPost("How to do this?", LocalDate.of(2024, 6, 1));

        printPostInformationList(board.getListPostIterator()); // Look up posts in order of storage
        /*
        Review of Design Patterns / 2024-08-30
        Who wants to play a game? / 2024-02-06
        How to do this? / 2024-06-01
         */

        printPostInformationList(board.getDatePostIterator()); // Look up posts in order of date
        /*
        Who wants to play a game? / 2024-02-06
        How to do this? / 2024-06-01
        Review of Design Patterns / 2024-08-30
         */
    }

    private static void printPostInformationList(Iterator<Post> postIterator) {
        while(postIterator.hasNext()) {
            Post post = postIterator.next();
            post.getPostInformation();
        }
    }
}