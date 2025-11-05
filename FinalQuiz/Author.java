import java.util.List;
import java.util.ArrayList;

public class Author {
    private String name;
    private String bio;
    private String email;
    private String expertise;
    private List<Integer> blogIds;
    
    public Author(String name, String bio, String email, String expertise) {
        this.name = name;
        this.bio = bio;
        this.email = email;
        this.expertise = expertise;
        this.blogIds = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getBio() {
        return bio;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getExpertise() {
        return expertise;
    }
    
    public List<Integer> getBlogIds() {
        return blogIds;
    }
    
    public void addBlog(int blogId) {
        if (!blogIds.contains(blogId)) {
            blogIds.add(blogId);
        }
    }
    
    public int getBlogCount() {
        return blogIds.size();
    }
}

