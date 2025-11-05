import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class BlogApp extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private BlogManager blogManager;

    // --- Auth UI ---
    private JPanel loginPanel;
    private JTextField userField;
    private JPasswordField passField;
    private Map<String, String> users = new HashMap<>();

    // Components for Blog List Panel
    private JPanel blogListPanel;
    private JTable blogTable;
    private JComboBox<String> genreCombo;
    private JComboBox<String> categoryCombo;
    
    public BlogApp() {
        super("Blog Application - Sign In");
        blogManager = BlogManager.getInstance();

        // Simple in-memory users (no DB)
        users.put("admin", "admin123");
        users.put("user1", "password1");
        users.put("user2", "password2");
        
        cardWebpack();
        
        // Add panels: login first, then blog list
        mainPanel.add(createLoginPanel(), "LOGIN");
        mainPanel.add(createBlogListPanel(), "BLOG_LIST");
        
        add(mainPanel);
        
        // --- Frame Setup ---
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // Start at login
        cardLayout.show(mainPanel, "LOGIN");
    }

    private void cardWebpack() {
        cardLayout = new javax.swing.OverlayLayout(this.getContentPane()) != null ? new CardLayout() : new CardLayout();
        mainPanel = new JPanel(cardLayout);
    }

    private boolean authenticate(String username, String password) {
        String expected = users.get(username);
        return expected != null && expected.equals(password);
    }

    private JPanel createLoginPanel() {
        // Blog-themed background (warm magazine/paper gradient)
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int w = getWidth(), h = getHeight();
                Color c1 = new Color(250, 245, 235); // paper
                Color c2 = new Color(236, 202, 162); // warm tan
                GradientPaint gp = new GradientPaint(0, 0, c1, 0, h, c2);
                g2.setPaint(gp);
                g2.fillRect(0, 0, w, h);
                g2.dispose();
            }
        };
        background.setLayout(new GridBagLayout());
        loginPanel = background;

        // Container with two columns: left illustration, right sign-in card
        JPanel container = new JPanel(new GridBagLayout());
        container.setOpaque(false);

        GridBagConstraints root = new GridBagConstraints();
        root.insets = new Insets(0, 0, 0, 0);
        root.gridx = 0; root.gridy = 0;
        background.add(container, root);

        // Left: Illustration / blog theme
        JPanel left = new JPanel(new GridBagLayout());
        left.setOpaque(true);
        left.setBackground(new Color(255, 255, 255, 180));
        left.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(225, 210, 190), 1, true),
            BorderFactory.createEmptyBorder(24, 28, 24, 28)
        ));
        GridBagConstraints l = new GridBagConstraints();
        l.insets = new Insets(6, 6, 6, 6);
        l.gridx = 0; l.gridy = 0; l.fill = GridBagConstraints.HORIZONTAL;
        JLabel brand = new JLabel("📖 Blog Haven", SwingConstants.LEFT);
        brand.setFont(new Font("Georgia", Font.BOLD, 28));
        left.add(brand, l);
        
        l.gridy++; JLabel tagline = new JLabel("Stories, guides and ideas worth reading.");
        tagline.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tagline.setForeground(new Color(100, 90, 80));
        left.add(tagline, l);

        // Category chips
        l.gridy++; JPanel chips = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6));
        chips.setOpaque(false);
        String[] cats = {"Technology", "Lifestyle", "Food", "Business", "Science", "Entertainment"};
        for (String c : cats) {
            JLabel chip = new JLabel("  " + c + "  ");
            chip.setOpaque(true);
            chip.setBackground(new Color(245, 235, 220));
            chip.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 205, 185), 1, true),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
            ));
            chips.add(chip);
        }
        left.add(chips, l);

        l.gridy++; JTextArea blurb = new JTextArea(
            "“A room without books is like a body without a soul.”\n" +
            "Read curated posts across genres and follow your favorite authors."
        );
        blurb.setEditable(false);
        blurb.setOpaque(false);
        blurb.setWrapStyleWord(true);
        blurb.setLineWrap(true);
        blurb.setFont(new Font("Serif", Font.ITALIC, 14));
        blurb.setForeground(new Color(90, 80, 70));
        GridBagConstraints ltxt = new GridBagConstraints();
        ltxt.gridx = 0; ltxt.gridy = 3; ltxt.fill = GridBagConstraints.BOTH; ltxt.weightx = 1; ltxt.weighty = 1;
        ltxt.insets = new Insets(12, 6, 6, 6);
        left.add(blurb, ltxt);

        // Right: Sign-in card
        JPanel card = new JPanel(new GridBagLayout());
        card.setOpaque(true);
        card.setBackground(Color.white);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(225, 210, 190), 1, true),
            BorderFactory.createEmptyBorder(24, 28, 24, 28)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;

        JLabel title = new JLabel("Sign in to Blog Haven", SwingConstants.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 22));
        card.add(title, gbc);

        gbc.gridy++; gbc.gridwidth = 2;
        JLabel subtitle = new JLabel("Welcome back!", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(new Color(120, 110, 100));
        card.add(subtitle, gbc);

        // Username
        gbc.gridy++; gbc.gridwidth = 1;
        gbc.gridx = 0; card.add(new JLabel("Username"), gbc);
        gbc.gridx = 1; userField = new JTextField(18);
        userField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 190, 180), 1, true),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        card.add(userField, gbc);

        // Password
        gbc.gridy++; gbc.gridx = 0; card.add(new JLabel("Password"), gbc);
        gbc.gridx = 1; passField = new JPasswordField(18);
        passField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 190, 180), 1, true),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        card.add(passField, gbc);

        // Show/Hide password
        gbc.gridy++; gbc.gridx = 1; gbc.gridwidth = 1;
        JCheckBox show = new JCheckBox("Show password");
        show.setOpaque(false);
        show.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        show.addActionListener(e -> passField.setEchoChar(show.isSelected() ? (char) 0 : '\u2022'));
        passField.setEchoChar('\u2022');
        card.add(show, gbc);

        // Actions row
        gbc.gridy++; gbc.gridx = 0; gbc.gridwidth = 2;
        JPanel actions = new JPanel(new GridBagLayout());
        actions.setOpaque(false);
        GridBagConstraints ac = new GridBagConstraints();
        ac.insets = new Insets(0, 6, 0, 6);
        
        JButton btnLogin = new JButton("Sign In");
        btnLogin.setBackground(new Color(176, 120, 80));
        btnLogin.setForeground(Color.white);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        btnLogin.addActionListener(e -> performLogin());
        ac.gridx = 0; ac.gridy = 0; actions.add(btnLogin, ac);

        JButton btnGuest = new JButton("Continue as Guest");
        btnGuest.setBackground(new Color(245, 235, 220));
        btnGuest.setForeground(new Color(80, 60, 40));
        btnGuest.setFocusPainted(false);
        btnGuest.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        btnGuest.addActionListener(e -> { setTitle("Blog Application - Guest"); loadBlogData(); cardLayout.show(mainPanel, "BLOG_LIST"); });
        ac.gridx = 1; ac.gridy = 0; actions.add(btnGuest, ac);
        
        card.add(actions, gbc);

        // Keyboard: Enter to submit
        passField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin();
                }
            }
        });

        // Hint removed as requested

        // Layout: place left and card side-by-side
        GridBagConstraints cLeft = new GridBagConstraints();
        cLeft.gridx = 0; cLeft.gridy = 0; cLeft.insets = new Insets(0, 0, 0, 16);
        cLeft.fill = GridBagConstraints.BOTH; cLeft.weightx = 1; cLeft.weighty = 1;
        container.add(left, cLeft);

        GridBagConstraints cRight = new GridBagConstraints();
        cRight.gridx = 1; cRight.gridy = 0; cRight.insets = new Insets(0, 16, 0, 0);
        cRight.fill = GridBagConstraints.VERTICAL; cRight.weightx = 0; cRight.weighty = 0;
        container.add(card, cRight);

        return loginPanel;
    }

    private void performLogin() {
        String u = userField.getText().trim();
        String p = new String(passField.getPassword());
        if (authenticate(u, p)) {
            setTitle("Blog Application - Welcome, " + u);
            loadBlogData();
            cardLayout.show(mainPanel, "BLOG_LIST");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createBlogListPanel() {
        blogListPanel = new JPanel(new BorderLayout());
        
        // Header
        JLabel header = new JLabel("📝 Blog Application", SwingConstants.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 32));
        
        // Filters + Logout (top area)
        JPanel top = new JPanel(new BorderLayout());
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.setBorder(swingBorder());
        
        // Genre Filter
        filterPanel.add(new JLabel("Genre:"));
        Set<String> genres = blogManager.getAllGenres();
        String[] genreArray = new String[genres.size() + 1];
        genreArray[0] = "All Genres";
        int i = 1;
        for (String genre : genres) {
            genreArray[i++] = genre;
        }
        genreCombo = new javax.swing.JComboBox<>(genreArray);
        genreCombo.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) { applyFilters(); }
        });
        filterPanel.add(genreCombo);
        
        // Category Filter
        filterPanel.add(new JLabel("Category:"));
        Set<String> categories = blogManager.getAllCategories();
        String[] categoryArray = new String[categories.size() + 1];
        categoryArray[0] = "All Categories";
        int j = 1;
        for (String category : categories) {
            categoryArray[j++] = category;
        }
        categoryCombo = new javax.swing.JComboBox<>(categoryArray);
        categoryCombo.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) { 
                applyFilters();
            }
        });
        filterPanel.add(categoryCombo);
        
        // Reset Button
        JButton resetButton = new JButton("Reset Filters");
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                genreCombo.setSelectedIndex(0);
                categoryCombo.setSelectedIndex(0);
                loadBlogData();
            }
        });
        filterPanel.add(resetButton);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(header, BorderLayout.CENTER);

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton logoutBtn = new JButton("Sign out");
        logoutBtn.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                if (userField != null) { userField.setText(""); }
                if (passField != null) { passField.setText(""); }
                setTitle("Blog Application - Sign In");
                cardLayout.show(mainPanel, "LOGIN");
            }
        });
        logoutPanel.add(logoutBtn);

        top.add(headerPanel, BorderLayout.NORTH);
        top.add(filterPanel, BorderLayout.CENTER);
        top.add(logoutPanel, BorderLayout.EAST);

        blogListPanel.add(top, BorderLayout.NORTH);
        
        // Table setup
        String[] columnNames = {"ID", "Title", "Category", "Author", "Genre"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        blogTable = new JTable(model);
        blogTable.setRowHeight(25);
        blogTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        
        // Make columns widths
        blogTable.setAutoCreateRowSorter(true);
        blogTable.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        blogTable.getColumnModel().getColumn(1).setPreferredWidth(300); // Title
        blogTable.getColumnModel().getColumn(2).setPreferredWidth(150); // Category
        blogTable.getColumnModel().getColumn(3).setPreferredWidth(150); // Author
        blogTable.getColumnModel().getColumn(4).setPreferredWidth(120); // Genre
        
        // Add double-click listener to view blog details
        blogTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int viewRow = blogTable.getSelectedRow();
                    if (viewRow >= 0) {
                        int modelRow = blogTable.convertRowIndexToModel(viewRow);
                        int blogId = (Integer) blogTable.getModel().getValueAt(modelRow, 0);
                        showBlogDetails(blogId);
                    }
                } else if (e.getClickCount() == 1) {
                    int viewRow = blogTable.getSelectedRow();
                    int viewCol = blogTable.getSelectedColumn();
                    if (viewRow >= 0 && viewCol == 3) { // Author column
                        int modelRow = blogTable.convertRowIndexToModel(viewRow);
                        int blogId = (Integer) blogTable.getModel().getValueAt(modelRow, 0);
                        Blog blog = blogManager.getBlogById(blogId);
                        if (blog != null) {
                            showAuthorPage(blog.getAuthorName());
                        }
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(blogTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Browse & Read Blogs (double-click to open)"));
        
        blogListPanel.add(scrollPane, BorderLayout.CENTER);
        
        return blogListPanel;
    }

    private javax.swing.border.TitledBorder swingBorder() {
        return BorderFactory.createTitledBorder("Filter Blogs");
    }

    private int num() {
        return blogTable.getSelectedRow();
    }

    private void loadBlogData() {
        List<Blog> blogs = ((BlogManager) blogManager).getAllBlogs();
        updateTable(blogs);
    }
    
    private void applyFilters() {
        String selected = (String) genreCombo.getSelectedItem();
        String selectedCategory = (String) categoryCombo.getSelectedItem();
        
        List<Blog> filteredBlogs;
        
        if ("All Genres".equals(selected) && "All Categories".equals(selectedCategory)) {
            filteredBlogs = blogManager.getAllBlogs();
        } else if ("All Genres".equals(selected)) {
            filteredBlogs = blogManager.getBlogsByCategory(selectedCategory);
        } else if ("All Categories".equals(selectedCategory)) {
            filteredBlogs = blogManager.getBlogsByGenre(selected);
        } else {
            filteredBlogs = blogManager.getBlogsByGenreAndCategory(selected, selectedCategory);
        }
        
        updateTable(filteredBlogs);
    }
    
    private void filteredBuffers() {
        // no-op placeholder for readability
    }

    private void updateTable(List<Blog> blogs) {
        DefaultTableModel model = (DefaultTableModel) blogTable.getModel();
        model.setRowCount(0); // Clear previous data
        
        for (Blog blog : blogs) {
            model.addRow(new Object[]{
                blog.getId(), 
                blog.getTitle(), 
                blog.getCategory(),
                blog.getAuthorName(),
                blog.getGenre()
            });
        }
    }
    
    private void showBlogDetails(int blogId) {
        Blog blog = blogManager.getBlogById(blogId);
        if (blog == null) {
            JOptionPane.showMessageDialog(this, "Blog not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JDialog dialog = new JDialog(this, "Blog Details", true);
        dialog.setSize(700, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel(blog.getTitle());
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel metaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        metaPanel.add(new JLabel("Author: "));
        JButton authorButton = new JButton(blog.getAuthorName());
        authorButton.setBorderPainted(false);
        authorButton.setContentAreaFilled(false);
        authorButton.setForeground(Color.BLUE);
        authorButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        authorButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                showAuthorPage(blog.getAuthorName());
            }
        });
        metaPanel.add(authorButton);
        metaPanel.add(new JLabel(" | Genre: " + blog.getGenre()));
        metaPanel.add(new JLabel(" | Category: " + blog.getCategory()));
        
        String detailsText = blog.getContent();
        if (detailsText == null || detailsText.trim().isEmpty()) {
            detailsText = "No article content available yet for '" + blog.getTitle() + "'.\n\n" +
                    "Overview:\n- " + blog.getTitle() + " is coming soon.\n\n" +
                    "What you'll find here when it's ready:\n" +
                    "• A clear introduction and context\n" +
                    "• Key concepts with examples\n" +
                    "• Practical tips and takeaways\n" +
                    "• Further reading recommendations";
        }
        JTextArea contentArea = new JTextArea(detailsText);
        contentArea.setFont(new Font("Serif", Font.PLAIN, 14));
        contentArea.setWrapStyleWord(true);
        contentArea.setLineWrap(true);
        contentArea.setEditable(false);
        contentArea.setBackground(Color.WHITE);
        JScrollPane contentScroll = new JScrollPane(contentArea);
        contentScroll.setBorder(BorderFactory.createTitledBorder("Content"));

        // Place meta at top and make content fill the dialog
        panel.add(metaPanel, BorderLayout.NORTH);
        panel.add(contentScroll, BorderLayout.CENTER);
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) { dialog.dispose(); }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.PAGE_END);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showAuthorPage(String authorName) {
        Author author = blogManager.getAuthorByName(authorName);
        if (author == null) {
            JOptionPane.showMessageDialog(this, "Author not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JDialog dialog = new JDialog(this, "Author: " + authorName, true);
        dialog.setSize(600, 500);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel nameLabel = new JLabel(authorName);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 28));
        panel.add(nameLabel, BorderLayout.NORTH);
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        infoPanel.add(new JLabel("Email:"), g(0));
        gbc.gridx = 1;
        infoPanel.add(new JLabel(author.getEmail()), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        infoPanel.add(new JLabel("Expertise:"), gbc);
        gbc.gridx = 1;
        infoPanel.add(new JLabel(author.getExpertise()), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        infoPanel.add(new JLabel("Blogs Published:"), gbc);
        gbc.gridx = 1;
        infoPanel.add(new JLabel(String.valueOf(author.getBlogCount())), gbc);
        
        panel.add(infoPanel, BorderLayout.CENTER);
        
        JTextArea bioArea = new JTextArea(author.getBio());
        bioArea.setFont(new Font("Serif", Font.PLAIN, 14));
        bioArea.setWrapStyleWord(true);
        bioArea.setLineWrap(true);
        bioArea.setEditable(false);
        bioArea.setBackground(Color.WHITE);
        JScrollPane bioScroll = new JScrollPane(bioArea);
        bioScroll.setBorder(BorderFactory.createTitledBorder("About"));
        
        List<Blog> authorBlogs = blogManager.getBlogsByAuthor(authorName);
        JPanel blogsPanel = new JPanel(new BorderLayout());
        blogsPanel.setBorder(BorderFactory.createTitledBorder("Blogs by " + authorName));
        
        String[] blogColumns = {"ID", "Title", "Genre", "Category"};
        DefaultTableModel blogModel = new DefaultTableModel(blogColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Blog blog : authorBlogs) {
            blogModel.addRow(new Object[]{
                blog.getId(),
                blog.getTitle(),
                blog.getGenre(),
                blog.getCategory()
            });
        }
        
        JTable authorBlogTable = new JTable(blogModel);
        authorBlogTable.setRowHeight(20);
        authorBlogTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = authorBlogTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        int blogId = (Integer) authorBlogTable.getValueAt(selectedRow, 0);
                        dialog.dispose();
                        showBlogDetails(blogId);
                    }
                }
            }
        });
        blogsPanel.add(new JScrollPane(authorBlogTable), BorderLayout.CENTER);
        
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(bioScroll, BorderLayout.NORTH);
        centerPanel.add(blogsPanel, BorderLayout.CENTER);
        
        panel.add(centerPanel, BorderLayout.SOUTH);
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) { dialog.dispose(); }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.PAGE_END);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }

    private GridBagConstraints g(int x) { GridBagConstraints g = new GridBagConstraints(); g.gridx = x; return g; }
    private String utilityName(String s){ return s; }

    // --- Main Method ---
    public static void main(String[] args) {
        // Ensure the Swing UI is created and updated on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new BlogApp());
    }
}
