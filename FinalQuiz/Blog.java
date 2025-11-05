public class Blog {
    private int id;
    private String title;
    private String content;
    private String authorName;
    private String genre;
    private String category;

    // Constructor, Getters, and Setters
    public Blog(int id, String title, String content, String authorName, String genre, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.genre = genre;
        this.category = category;
    }

    public int getId() { 
        return id; 
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() { 
        return title; 
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() { 
        return content; 
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() { 
        return authorName; 
    }
    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

