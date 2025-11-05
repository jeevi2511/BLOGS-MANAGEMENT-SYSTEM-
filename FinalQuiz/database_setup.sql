

-- Blogs table for blog posts
CREATE TABLE IF NOT EXISTS blogs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_name VARCHAR(100) NOT NULL,
    genre VARCHAR(50) NOT NULL DEFAULT 'General',
    category VARCHAR(50) NOT NULL DEFAULT 'Uncategorized',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);



-- Insert sample blog posts
INSERT INTO blogs (title, content, author_name, genre, category) VALUES 
    ('Welcome to My Blog', 'This is the first blog post. Welcome everyone!', 'admin', 'General', 'Introduction'),
    ('Java Swing Tutorial', 'Learn how to create GUI applications using Java Swing.', 'user1', 'Programming', 'Tutorial'),
    ('Database Design', 'Best practices for designing relational databases.', 'user2', 'Database', 'Tutorial'),
    ('Spring Framework Introduction', 'An introduction to the Spring Framework for Java developers.', 'admin', 'Programming', 'Tutorial');
