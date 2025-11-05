import java.util.*;

/**
 * Manages blog data in memory (no database required)
 */
public class BlogManager {
    private List<Blog> blogs;
    private Map<String, Author> authors;
    private static BlogManager instance;
    
    private BlogManager() {
        blogs = new ArrayList<>();
        authors = new HashMap<>();
        initializeAuthors();
        initializeBlogs();
    }
    
    public static BlogManager getInstance() {
        if (instance == null) {
            instance = new BlogManager();
        }
        return instance;
    }
    
    private void initializeAuthors() {
        authors.put("John Smith", new Author("John Smith", 
            "Experienced software developer with 10+ years in Java and enterprise applications. " +
            "Passionate about teaching programming and sharing knowledge through technical blogs.",
            "john.smith@email.com", "Java Programming, Enterprise Development"));
        
        authors.put("Sarah Johnson", new Author("Sarah Johnson",
            "Full-stack web developer specializing in Spring Framework and microservices architecture. " +
            "Love building scalable web applications and sharing best practices.",
            "sarah.johnson@email.com", "Web Development, Spring Framework"));
        
        authors.put("Mike Chen", new Author("Mike Chen",
            "Mobile app developer with expertise in Android and iOS development. " +
            "Creator of several successful apps with millions of downloads.",
            "mike.chen@email.com", "Mobile Development, Android, iOS"));
        
        authors.put("Emma Wilson", new Author("Emma Wilson",
            "Wellness coach and lifestyle blogger. Focused on helping people achieve balance " +
            "through healthy habits, mindfulness, and self-care practices.",
            "emma.wilson@email.com", "Health & Wellness, Lifestyle"));
        
        authors.put("David Brown", new Author("David Brown",
            "Travel enthusiast and adventure blogger. Visited over 50 countries and shares " +
            "travel tips, destination guides, and cultural insights.",
            "david.brown@email.com", "Travel, Adventure"));
        
        authors.put("Lisa Anderson", new Author("Lisa Anderson",
            "Interior designer and home decor enthusiast. Specializes in modern, minimalist designs " +
            "and DIY home improvement projects.",
            "lisa.anderson@email.com", "Interior Design, Home Decor"));
        
        authors.put("Chef Maria", new Author("Chef Maria",
            "Professional chef with 15 years of culinary experience. Shares authentic recipes " +
            "from Italian cuisine and cooking techniques for home cooks.",
            "chef.maria@email.com", "Italian Cuisine, Cooking"));
        
        authors.put("Alex Green", new Author("Alex Green",
            "Vegan food blogger and recipe developer. Creating delicious plant-based recipes " +
            "that are easy to make and full of flavor.",
            "alex.green@email.com", "Vegan Cooking, Plant-Based Recipes"));
        
        authors.put("Nina Patel", new Author("Nina Patel",
            "Nutritionist and healthy living advocate. Expert in creating nutritious meals that " +
            "taste great and support overall well-being.",
            "nina.patel@email.com", "Nutrition, Healthy Living"));
        
        authors.put("Robert Taylor", new Author("Robert Taylor",
            "Serial entrepreneur and business consultant. Founded multiple successful startups " +
            "and mentors aspiring entrepreneurs.",
            "robert.taylor@email.com", "Entrepreneurship, Business Strategy"));
        
        authors.put("Jennifer Lee", new Author("Jennifer Lee",
            "Digital marketing expert with proven track record in growing online businesses. " +
            "Specializes in SEO, social media, and content marketing.",
            "jennifer.lee@email.com", "Digital Marketing, SEO"));
        
        authors.put("Michael Davis", new Author("Michael Davis",
            "Certified financial planner helping individuals achieve their financial goals. " +
            "Expert in personal finance, investing, and wealth management.",
            "michael.davis@email.com", "Financial Planning, Investment"));
        
        authors.put("Dr. Emily White", new Author("Dr. Emily White",
            "Climate scientist and environmental researcher. Ph.D. in Environmental Science. " +
            "Passionate about climate education and sustainable solutions.",
            "emily.white@email.com", "Climate Science, Environmental Research"));
        
        authors.put("Dr. James Miller", new Author("Dr. James Miller",
            "Astrophysicist and space exploration enthusiast. Ph.D. in Physics. " +
            "Follows and reports on the latest developments in space missions and discoveries.",
            "james.miller@email.com", "Astronomy, Space Science"));
        
        authors.put("Dr. Susan Kim", new Author("Dr. Susan Kim",
            "Renewable energy engineer and researcher. Ph.D. in Energy Systems. " +
            "Expert in solar and wind energy technologies.",
            "susan.kim@email.com", "Renewable Energy, Engineering"));
        
        authors.put("Tom Roberts", new Author("Tom Roberts",
            "Film critic and entertainment journalist. Reviews movies and TV shows, " +
            "covering everything from blockbusters to indie films.",
            "tom.roberts@email.com", "Film Criticism, Entertainment"));
        
        authors.put("Rachel Moore", new Author("Rachel Moore",
            "Book reviewer and literary enthusiast. Reads and reviews hundreds of books annually, " +
            "covering fiction, non-fiction, and everything in between.",
            "rachel.moore@email.com", "Book Reviews, Literature"));
        
        authors.put("Chris Martin", new Author("Chris Martin",
            "Music journalist and festival organizer. Covers music festivals, concerts, " +
            "and emerging artists across various genres.",
            "chris.martin@email.com", "Music Journalism, Festival Culture"));
    }
    
    private void initializeBlogs() {
        // Technology Blogs
        addBlogWithAuthor(1, "Introduction to Java Programming", 
            "Java is a powerful object-oriented programming language that has been around for over two decades and continues " +
            "to be one of the most widely used languages in the industry. In this comprehensive guide, we'll cover the " +
            "fundamentals of Java programming, starting from the basics.\n\n" +
            "First, let's understand what makes Java special. Java follows the 'Write Once, Run Anywhere' principle, meaning " +
            "code written in Java can run on any platform that has a Java Virtual Machine (JVM). This portability is one of " +
            "Java's greatest strengths.\n\n" +
            "Variables and Data Types:\n" +
            "Java is a statically-typed language, which means you must declare the type of every variable. Primitive data types " +
            "include int, double, char, boolean, byte, short, long, and float. Reference types include classes, interfaces, and arrays. " +
            "Understanding when to use each type is crucial for writing efficient Java code.\n\n" +
            "Control Structures:\n" +
            "Java provides standard control flow statements: if-else, switch-case, while loops, for loops, and do-while loops. " +
            "These allow you to control the execution flow of your program based on conditions and iterations.\n\n" +
            "Object-Oriented Programming:\n" +
            "Java is built around OOP concepts: classes, objects, inheritance, polymorphism, encapsulation, and abstraction. A class " +
            "is a blueprint for creating objects. Objects are instances of classes that encapsulate data and behavior. Inheritance " +
            "allows classes to inherit properties and methods from parent classes, promoting code reuse.\n\n" +
            "Best Practices:\n" +
            "1. Always use meaningful variable and method names\n" +
            "2. Follow Java naming conventions (camelCase for variables, PascalCase for classes)\n" +
            "3. Use access modifiers (private, protected, public) appropriately\n" +
            "4. Comment your code, but write self-documenting code when possible\n" +
            "5. Handle exceptions properly using try-catch blocks\n\n" +
            "Common Pitfalls:\n" +
            "Beginners often struggle with null pointer exceptions, forgetting to initialize objects, and misunderstanding pass-by-value " +
            "vs pass-by-reference. Understanding these concepts early will save you hours of debugging.\n\n" +
            "Getting Started:\n" +
            "To start programming in Java, download the Java Development Kit (JDK) and an IDE like IntelliJ IDEA or Eclipse. Write " +
            "your first 'Hello World' program, then gradually work on more complex projects. Practice regularly, build small projects, " +
            "and don't hesitate to refer to documentation.", 
            "John Smith", "Technology", "Programming");
        
        addBlogWithAuthor(2, "Spring Framework Basics", 
            "Spring Framework is one of the most popular Java frameworks, designed to simplify enterprise application development. " +
            "It provides a comprehensive programming and configuration model that addresses various aspects of Java application development.\n\n" +
            "What is Spring Framework?\n" +
            "Spring is an open-source framework that provides infrastructure support for developing Java applications. It eliminates the " +
            "need for writing boilerplate code and handles infrastructure concerns, allowing developers to focus on business logic.\n\n" +
            "Core Concepts:\n\n" +
            "1. Dependency Injection (DI):\n" +
            "Dependency Injection is a design pattern where objects receive their dependencies from an external source rather than creating " +
            "them internally. Spring's IoC container manages these dependencies. This promotes loose coupling and makes code more testable " +
            "and maintainable. You can inject dependencies through constructor injection, setter injection, or field injection.\n\n" +
            "2. Inversion of Control (IoC):\n" +
            "IoC is the principle where the framework controls the flow of the program. Instead of you creating objects, Spring creates " +
            "and manages them. The Spring container (ApplicationContext) is responsible for instantiating, configuring, and assembling " +
            "objects known as beans.\n\n" +
            "3. Aspect-Oriented Programming (AOP):\n" +
            "AOP allows you to separate cross-cutting concerns (like logging, security, transaction management) from business logic. " +
            "You can define aspects that apply common functionality across multiple parts of your application without modifying the code.\n\n" +
            "Setting Up a Spring Project:\n" +
            "You can create a Spring project using Spring Boot, which simplifies configuration. Start by creating a new Spring Boot project " +
            "using Spring Initializr or your IDE. Add necessary dependencies like spring-boot-starter-web for web applications. The @SpringBootApplication " +
            "annotation marks your main class.\n\n" +
            "Creating Beans:\n" +
            "Beans are objects managed by the Spring container. You can define beans using:\n" +
            "- @Component, @Service, @Repository, @Controller annotations\n" +
            "- @Bean methods in configuration classes\n" +
            "- XML configuration (less common nowadays)\n\n" +
            "Spring MVC Architecture:\n" +
            "Spring MVC follows the Model-View-Controller pattern. The DispatcherServlet receives requests and routes them to appropriate controllers. " +
            "Controllers process requests, interact with the service layer, and return views. The @RequestMapping or @GetMapping/@PostMapping " +
            "annotations map URLs to controller methods.\n\n" +
            "Benefits of Using Spring:\n" +
            "- Reduces boilerplate code\n" +
            "- Promotes best practices and design patterns\n" +
            "- Excellent integration with other frameworks\n" +
            "- Comprehensive testing support\n" +
            "- Active community and extensive documentation\n\n" +
            "Best Practices:\n" +
            "Use constructor injection for required dependencies, prefer interface-based programming, keep controllers thin, and organize your " +
            "code in layers (Controller, Service, Repository). This architecture makes your application more maintainable and testable.", 
            "Sarah Johnson", "Technology", "Web Development");
        
        addBlogWithAuthor(3, "Android App Development", 
            "Android app development has become one of the most sought-after skills in the tech industry. With billions of Android devices " +
            "worldwide, learning to build Android apps opens up tremendous opportunities. This comprehensive guide will walk you through " +
            "everything you need to know.\n\n" +
            "Getting Started:\n" +
            "First, download Android Studio, the official IDE for Android development. It includes the Android SDK, emulator, and all necessary " +
            "tools. Install Java JDK (version 8 or higher) as Android development requires it. Create your first project using the project wizard.\n\n" +
            "Understanding Activities:\n" +
            "An Activity represents a single screen with a user interface. The activity lifecycle consists of onCreate(), onStart(), onResume(), " +
            "onPause(), onStop(), and onDestroy(). Understanding these lifecycle methods is crucial for managing resources and maintaining " +
            "app state when the user navigates away or the system destroys your activity.\n\n" +
            "UI Components and Layouts:\n" +
            "Android uses XML for defining layouts. Common views include TextView, Button, EditText, ImageView, RecyclerView, and more. " +
            "Layouts like LinearLayout, RelativeLayout, ConstraintLayout, and FrameLayout help arrange views. ConstraintLayout is recommended " +
            "for complex, responsive designs as it allows you to create flat view hierarchies.\n\n" +
            "Handling User Interactions:\n" +
            "You can handle clicks using onClick listeners, either in XML with android:onClick or programmatically using setOnClickListener(). " +
            "For handling text input, use TextWatcher. Touch events can be handled with OnTouchListener for more complex interactions.\n\n" +
            "Fragments:\n" +
            "Fragments are reusable UI components that represent a portion of an activity. They're useful for creating flexible UIs that " +
            "work on both phones and tablets. Fragments have their own lifecycle but are managed by the host activity.\n\n" +
            "Data Persistence:\n" +
            "Android offers several options for storing data:\n" +
            "- SharedPreferences for key-value pairs\n" +
            "- SQLite database for structured data\n" +
            "- Room persistence library (recommended for databases)\n" +
            "- File storage for larger files\n\n" +
            "Networking and APIs:\n" +
            "Modern apps often need to fetch data from the internet. Use libraries like Retrofit or Volley for HTTP requests. Always perform " +
            "network operations on background threads to avoid blocking the UI thread. Use AsyncTask, Coroutines, or RxJava for asynchronous operations.\n\n" +
            "Best Practices:\n" +
            "1. Follow Material Design guidelines for a consistent user experience\n" +
            "2. Optimize images and use appropriate formats (WebP when possible)\n" +
            "3. Implement proper error handling and user feedback\n" +
            "4. Test on multiple devices and screen sizes\n" +
            "5. Use ProGuard to minimize APK size\n" +
            "6. Implement proper security practices, especially for user data\n\n" +
            "Publishing Your App:\n" +
            "Before publishing, create a signed APK or Android App Bundle. Prepare store listing materials including screenshots, descriptions, " +
            "and icons. Create a developer account on Google Play Console ($25 one-time fee). Follow Google's guidelines and policies. " +
            "Test your app thoroughly before releasing it to users.", 
            "Mike Chen", "Technology", "Mobile");
        
        // Lifestyle Blogs
        addBlogWithAuthor(4, "Healthy Morning Routine", 
            "How you start your morning significantly impacts the rest of your day. A healthy morning routine sets a positive tone, increases " +
            "productivity, and improves overall well-being. Let's explore evidence-based practices that can transform your mornings and your life.\n\n" +
            "The Importance of Morning Routines:\n" +
            "Research shows that morning routines reduce stress, improve decision-making, and increase feelings of control. Starting your day " +
            "with intentional activities rather than rushing helps you maintain calm and focus throughout the day.\n\n" +
            "1. Hydration First:\n" +
            "After 6-8 hours of sleep, your body is dehydrated. Start your day with a large glass of water (16-20 ounces). Add lemon for extra " +
            "vitamin C and digestive benefits. This kickstarts your metabolism and rehydrates your body after sleep.\n\n" +
            "2. Morning Movement:\n" +
            "You don't need an intense workout. Even 10-15 minutes of movement makes a difference. Try stretching, yoga, a brisk walk, or light " +
            "calisthenics. Morning exercise boosts energy, improves mood, and enhances cognitive function throughout the day.\n\n" +
            "3. Mindfulness and Meditation:\n" +
            "Spend 5-10 minutes in meditation or mindfulness practice. This could be deep breathing, guided meditation, or simply sitting quietly. " +
            "Apps like Headspace or Calm can help beginners. This practice reduces anxiety and improves mental clarity.\n\n" +
            "4. Sunlight Exposure:\n" +
            "Getting natural light within the first hour of waking helps regulate your circadian rhythm. Open curtains immediately, step outside, " +
            "or sit near a window. This improves sleep quality at night and boosts daytime energy.\n\n" +
            "5. Nutritious Breakfast:\n" +
            "Breakfast sets your metabolism for the day. Include protein, healthy fats, and complex carbohydrates. Examples: Greek yogurt with berries, " +
            "whole-grain toast with avocado and eggs, or oatmeal with nuts and fruit. Avoid sugary cereals and pastries that cause energy crashes.\n\n" +
            "6. Plan Your Day:\n" +
            "Take 5 minutes to review your schedule, set priorities, and identify your most important task. This reduces decision fatigue and helps " +
            "you focus on what matters most. Use the 'eat the frog' principle: tackle your hardest task first.\n\n" +
            "7. Avoid Screens Initially:\n" +
            "Resist checking your phone immediately. Give yourself at least 30-60 minutes before diving into emails and social media. This allows " +
            "your brain to wake up naturally and sets a calmer tone for the day.\n\n" +
            "Creating Your Routine:\n" +
            "Start small - don't try to implement everything at once. Pick 2-3 practices and commit to them for 21 days until they become habits. " +
            "Wake up 30 minutes earlier if needed. Remember, consistency beats perfection. Even a 15-minute routine is better than none.\n\n" +
            "Benefits You'll Notice:\n" +
            "Within weeks, you'll experience increased energy, better mood, improved focus, reduced stress, and greater overall satisfaction with life. " +
            "Your morning routine is an investment in yourself that pays dividends all day long.", 
            "Emma Wilson", "Lifestyle", "Health & Wellness");
        
        addBlogWithAuthor(5, "Travel Tips for Beginners", 
            "Traveling for the first time can be both exciting and overwhelming. Whether you're planning a weekend getaway or a month-long adventure, " +
            "these essential tips will help you navigate the world of travel confidently and make your journey smooth and enjoyable.\n\n" +
            "Planning Your Trip:\n\n" +
            "1. Choose Your Destination:\n" +
            "Start with destinations that are beginner-friendly: places with good infrastructure, English-speaking populations, or strong tourist support. " +
            "Consider factors like safety, visa requirements, weather, and cultural differences. Research extensively using travel blogs, guidebooks, " +
            "and forums like TripAdvisor or Reddit's travel communities.\n\n" +
            "2. Budget Planning:\n" +
            "Create a realistic budget covering flights, accommodations, food, activities, transportation, insurance, and a 10-15% buffer for unexpected " +
            "expenses. Use budget tracking apps and research typical costs in your destination. Look for free activities and local markets for cheaper meals.\n\n" +
            "3. Booking Flights:\n" +
            "Book flights 6-8 weeks in advance for domestic, 2-3 months for international. Use comparison sites like Skyscanner or Google Flights. " +
            "Be flexible with dates - mid-week flights are often cheaper. Clear your browser cookies or use incognito mode when searching for deals.\n\n" +
            "4. Accommodations:\n" +
            "For beginners, consider hotels with good reviews and 24/7 reception. As you gain confidence, try hostels, Airbnb, or guesthouses. Always " +
            "read recent reviews, check cancellation policies, and verify the location on a map before booking.\n\n" +
            "Packing Smart:\n\n" +
            "Pack light! You'll thank yourself later. Make a packing list and stick to it. Roll clothes instead of folding to save space. Pack versatile " +
            "items that mix and match. Remember: you can buy almost anything at your destination if needed.\n\n" +
            "Essential Items:\n" +
            "- Passport and copies (keep digital copies in cloud storage)\n" +
            "- Travel insurance documents\n" +
            "- Universal adapter and power bank\n" +
            "- Medications and first aid kit\n" +
            "- Comfortable walking shoes\n" +
            "- Lightweight rain jacket\n" +
            "- Copies of important documents\n\n" +
            "At the Airport:\n" +
            "Arrive 2 hours early for domestic flights, 3 hours for international. Check-in online when possible. Know your baggage limits and weigh " +
            "luggage at home. Keep liquids in a clear, quart-sized bag. Wear comfortable clothes and shoes you can easily remove for security.\n\n" +
            "Safety Tips:\n" +
            "- Never leave luggage unattended\n" +
            "- Keep valuables in a money belt or hidden pocket\n" +
            "- Share your itinerary with family/friends\n" +
            "- Research common scams in your destination\n" +
            "- Trust your instincts - if something feels wrong, avoid it\n" +
            "- Keep emergency contacts saved in your phone\n" +
            "- Know the local emergency number\n\n" +
            "Making the Most of Your Trip:\n" +
            "Talk to locals - they know the best spots. Try local food - food is a huge part of culture. Don't over-plan - leave room for spontaneity. " +
            "Take photos but don't view everything through a lens. Keep a travel journal to remember details. Be respectful of local customs and traditions.\n\n" +
            "Common Mistakes to Avoid:\n" +
            "- Overpacking\n" +
            "- Over-planning every minute\n" +
            "- Eating only at tourist restaurants\n" +
            "- Not getting travel insurance\n" +
            "- Ignoring local customs\n" +
            "- Exchanging money at airports (terrible rates)\n" +
            "- Forgetting to inform your bank about travel\n\n" +
            "Remember: Travel is about experiences, not perfection. Embrace the unexpected, stay flexible, and enjoy the journey. Every traveler was a " +
            "beginner once - you'll learn and improve with each trip!", 
            "David Brown", "Lifestyle", "Travel");
        
        addBlogWithAuthor(6, "Home Decorating Ideas", 
            "Your home should be a reflection of who you are - a sanctuary where you feel comfortable, inspired, and truly at peace. Transforming " +
            "your space doesn't require a massive budget or professional help. With creativity and some strategic choices, you can create a beautiful " +
            "home that tells your story.\n\n" +
            "Start with a Vision:\n" +
            "Before buying anything, spend time on Pinterest, Instagram, or design blogs to identify your style. Are you drawn to minimalist modern, " +
            "cozy farmhouse, bohemian eclectic, or Scandinavian simplicity? Create a mood board with colors, textures, and furniture pieces that inspire you.\n\n" +
            "Color Psychology:\n" +
            "Colors significantly impact mood and atmosphere. Blues and greens create calm and tranquility - perfect for bedrooms. Warm colors like yellows " +
            "and oranges add energy to kitchens and dining areas. Neutrals provide versatility and sophistication. Don't be afraid to use an accent wall " +
            "to add personality without overwhelming the space.\n\n" +
            "Furniture Arrangement:\n" +
            "The layout of your furniture affects both function and flow. Create conversation areas by grouping seating pieces. Leave enough space for " +
            "traffic flow (at least 3 feet). Don't push all furniture against walls - floating pieces in the room often works better. Use area rugs to define " +
            "spaces in open floor plans.\n\n" +
            "Lighting is Everything:\n" +
            "Good lighting transforms a room. Use layers: ambient (overhead), task (reading lamps), and accent (decorative). Add dimmer switches for mood " +
            "control. Maximize natural light with mirrors and light-colored window treatments. Replace harsh overhead lights with softer alternatives.\n\n" +
            "The Power of Plants:\n" +
            "Plants add life, improve air quality, and bring nature indoors. Start with low-maintenance options like pothos, snake plants, or ZZ plants. " +
            "Group plants together for visual impact. Use stylish planters that complement your decor. Hanging plants add vertical interest without taking " +
            "up floor space.\n\n" +
            "DIY Projects That Make a Difference:\n" +
            "- Paint outdated furniture for a fresh look\n" +
            "- Create gallery walls with meaningful art and photos\n" +
            "- Make your own throw pillows with fabric you love\n" +
            "- Refinish or paint old picture frames\n" +
            "- Create macrame wall hangings or plant hangers\n" +
            "- Add peel-and-stick wallpaper to accent areas\n\n" +
            "Accessorizing Like a Pro:\n" +
            "Accessories are the finishing touches that make a space feel complete. Use the rule of three - group items in odd numbers. Mix heights and " +
            "textures for visual interest. Books, candles, vases, and personal mementos add character. Don't overcrowd - edit ruthlessly.\n\n" +
            "Textiles and Texture:\n" +
            "Mix textures for depth: smooth leather, chunky knits, soft velvet, rough jute. Throw blankets, area rugs, curtains, and pillows are easy " +
            "ways to add texture and color. They're also easily changeable when you want a quick refresh.\n\n" +
            "Budget-Friendly Tips:\n" +
            "- Shop secondhand stores and flea markets for unique finds\n" +
            "- Wait for sales on bigger items\n" +
            "- Repurpose items you already own\n" +
            "- Focus on one room at a time\n" +
            "- Invest in quality basics, save on decorative items\n" +
            "- DIY instead of buying when possible\n\n" +
            "Creating Cozy Spaces:\n" +
            "Cozy isn't about size - it's about atmosphere. Add soft textiles, warm lighting, personal touches, and comfortable seating. Create nooks for " +
            "reading or relaxing. Use scented candles or diffusers to engage all senses.\n\n" +
            "Remember: Home decorating is a journey, not a destination. Take your time, trust your instincts, and create a space that makes you happy. " +
            "The best homes are those that evolve with you over time.", 
            "Lisa Anderson", "Lifestyle", "Home & Living");
        
        // Food Blogs
        addBlogWithAuthor(7, "Easy Pasta Recipes", 
            "Nothing beats a delicious homemade pasta dish. These easy recipes use simple ingredients you likely already have in your pantry, " +
            "yet deliver restaurant-quality results. Whether you're cooking for yourself or a crowd, pasta is versatile, comforting, and always satisfying.\n\n" +
            "Classic Spaghetti Carbonara:\n" +
            "This Roman classic requires only 5 ingredients: pasta, eggs, pancetta (or bacon), Parmesan cheese, and black pepper. The key is timing - " +
            "the hot pasta must be mixed with raw eggs off the heat to create a creamy sauce without scrambling. Reserve pasta water to adjust consistency. " +
            "Serve immediately while hot.\n\n" +
            "Creamy Fettuccine Alfredo:\n" +
            "Authentic Alfredo doesn't use heavy cream! It's simply butter, Parmesan cheese, and pasta water. Melt butter over low heat, toss with " +
            "hot pasta and freshly grated Parmigiano-Reggiano, adding pasta water gradually until creamy. The starch from the pasta water creates the " +
            "luscious sauce. Add a pinch of nutmeg for extra flavor.\n\n" +
            "Spicy Arrabbiata:\n" +
            "Arrabbiata means 'angry' in Italian, referring to the spicy heat. Sauté garlic and red pepper flakes in olive oil, add canned tomatoes " +
            "(crushed or diced), simmer 15-20 minutes. Toss with pasta, fresh basil, and a drizzle of olive oil. Adjust spice level with more or less " +
            "red pepper flakes.\n\n" +
            "Pasta Cooking Tips:\n" +
            "1. Use plenty of salted water (should taste like seawater)\n" +
            "2. Don't add oil to the water - it prevents sauce from sticking\n" +
            "3. Cook pasta 1-2 minutes less than package directions for al dente\n" +
            "4. Always reserve pasta water - it's liquid gold for sauces\n" +
            "5. Finish pasta in the pan with sauce for better flavor absorption\n\n" +
            "Ingredient Substitutions:\n" +
            "- No pancetta? Use bacon or skip the meat for a vegetarian version\n" +
            "- Out of fresh Parmesan? Any hard Italian cheese works\n" +
            "- Don't have the exact pasta shape? Use what you have - shape matters less than cooking it right\n" +
            "- Canned tomatoes vs fresh: canned are often better quality, especially off-season\n\n" +
            "Pro Tips for Restaurant Quality:\n" +
            "- Grate cheese fresh - pre-grated doesn't melt as well\n" +
            "- Use the right pasta shape for the sauce (long pasta for oil-based, short for chunky sauces)\n" +
            "- Finish with fresh herbs at the end for maximum flavor\n" +
            "- Serve pasta in warmed bowls\n" +
            "- A drizzle of good quality olive oil at the end elevates any dish\n\n" +
            "Quick Weeknight Pasta:\n" +
            "For busy evenings, try aglio e olio: sauté sliced garlic in olive oil with red pepper flakes, toss with pasta and parsley. Or toss cooked " +
            "pasta with pesto, cherry tomatoes, and mozzarella. Both take less than 15 minutes but taste incredible.", 
            "Chef Maria", "Food", "Recipes");
        
        addBlogWithAuthor(8, "Vegan Baking Guide", 
            "Vegan baking has evolved far beyond cardboard-tasting substitutes. With the right techniques and ingredients, you can create baked goods that " +
            "are every bit as delicious as traditional recipes, often even better! This guide will teach you everything you need to know.\n\n" +
            "Understanding Egg Substitutes:\n\n" +
            "1. Flax or Chia Eggs:\n" +
            "Mix 1 tablespoon ground flaxseed or chia seeds with 3 tablespoons water. Let sit 5 minutes until gel-like. Best for dense baked goods like " +
            "muffins, cookies, and quick breads. Adds a slight nutty flavor.\n\n" +
            "2. Aquafaba:\n" +
            "The liquid from canned chickpeas! 3 tablespoons = 1 egg. It whips like egg whites, perfect for meringues, mousses, and macarons. Also works " +
            "well in cakes and cookies. It's magical!\n\n" +
            "3. Applesauce or Mashed Banana:\n" +
            "1/4 cup = 1 egg. Great for moist baked goods. Applesauce is neutral; banana adds flavor. Reduces fat and adds natural sweetness.\n\n" +
            "4. Commercial Egg Replacers:\n" +
            "Products like Bob's Red Mill Egg Replacer work well and are consistent. Follow package instructions.\n\n" +
            "5. Silken Tofu:\n" +
            "Blended silken tofu (1/4 cup = 1 egg) creates incredibly moist cakes and brownies.\n\n" +
            "Dairy Alternatives:\n\n" +
            "Milk Substitutes:\n" +
            "- Unsweetened almond milk: most versatile, neutral flavor\n" +
            "- Oat milk: creamy, great for lattes and baking\n" +
            "- Coconut milk: rich, perfect for tropical flavors\n" +
            "- Soy milk: protein-rich, similar to dairy milk in recipes\n\n" +
            "Butter Substitutes:\n" +
            "- Vegan butter: brands like Earth Balance work 1:1 in most recipes\n" +
            "- Coconut oil: solid at room temp, great for cookies\n" +
            "- Avocado: in some recipes, provides creaminess and healthy fats\n\n" +
            "Essential Vegan Baking Tips:\n\n" +
            "1. Don't Overmix:\n" +
            "Overmixing develops gluten too much. Mix until just combined, especially for muffins and quick breads.\n\n" +
            "2. Adjust Baking Times:\n" +
            "Vegan baked goods may need slightly longer in the oven. Check doneness with a toothpick or internal temperature.\n\n" +
            "3. Add Moisture:\n" +
            "Since there's no butter, add extra liquid. Vegan recipes often include applesauce, oil, or plant milk.\n\n" +
            "4. Use Good Vanilla:\n" +
            "Quality extracts make a huge difference in vegan baking where there are fewer flavor layers.\n\n" +
            "5. Don't Skip the Acid:\n" +
            "Adding apple cider vinegar or lemon juice to plant milk creates buttermilk substitute, helping baked goods rise.\n\n" +
            "Easy Vegan Recipes to Start:\n\n" +
            "Chocolate Chip Cookies:\n" +
            "Use flax eggs, vegan butter, and dairy-free chocolate chips. The key is creaming the butter and sugar well, just like traditional cookies.\n\n" +
            "Vanilla Cupcakes:\n" +
            "Applesauce works beautifully here. Add a bit of apple cider vinegar to plant milk for lift. Frost with vegan buttercream using vegan butter.\n\n" +
            "Banana Bread:\n" +
            "Naturally vegan-friendly! Ripe bananas provide moisture and binding. Add nuts, chocolate chips, or blueberries.\n\n" +
            "Common Mistakes to Avoid:\n" +
            "- Using too much substitute (measure accurately)\n" +
            "- Forgetting that plant milks vary in consistency\n" +
            "- Not letting flax/chia eggs gel before using\n" +
            "- Overbaking (vegan goods can dry out faster)\n\n" +
            "The Bottom Line:\n" +
            "Vegan baking opens up new flavors and textures you might not have experienced. Experiment, take notes, and most importantly - have fun! " +
            "Many professional bakers now prefer vegan recipes because they're often lighter and more flavorful.", 
            "Alex Green", "Food", "Vegan");
        
        addBlogWithAuthor(9, "Quick Healthy Breakfasts", 
            "Starting your day with a nutritious breakfast sets you up for success. A well-balanced morning meal stabilizes blood sugar, provides sustained " +
            "energy, and prevents mid-morning crashes. These quick, healthy breakfast options take minimal time but deliver maximum nutrition.\n\n" +
            "The Perfect Breakfast Formula:\n" +
            "Aim for: Protein + Healthy Fats + Complex Carbs + Fiber. This combination keeps you full, provides steady energy, and supports brain function.\n\n" +
            "5-Minute Breakfasts:\n\n" +
            "1. Greek Yogurt Parfait:\n" +
            "Layer Greek yogurt (high protein), fresh berries (antioxidants), granola (fiber), and a drizzle of honey. Prep berries the night before. " +
            "Greek yogurt provides 15-20g protein per serving, keeping you satisfied for hours.\n\n" +
            "2. Avocado Toast:\n" +
            "Mash half an avocado on whole-grain toast, top with a poached or scrambled egg, sprinkle with red pepper flakes and sea salt. The healthy fats " +
            "from avocado and protein from egg create a complete meal. Takes 5 minutes if you multitask.\n\n" +
            "3. Protein Smoothie:\n" +
            "Blend: 1 scoop protein powder (or Greek yogurt), 1 cup frozen berries, 1 banana, 1 tablespoon nut butter, and plant milk. Add spinach for " +
            "extra nutrition - you won't taste it! Blend the night before and refrigerate, or keep ingredients ready.\n\n" +
            "Overnight Oats - Prep Once, Eat All Week:\n" +
            "Mix 1/2 cup rolled oats, 1/2 cup milk (dairy or plant-based), 1 tablespoon chia seeds, sweetener, and toppings. Let sit overnight. In the morning, " +
            "just grab and go! Variations: add cocoa powder and banana, pumpkin puree and spices, or tropical fruits with coconut.\n\n" +
            "Make-Ahead Options:\n\n" +
            "Egg Muffins:\n" +
            "Whisk eggs, pour into muffin tins with vegetables and protein (sausage, ham, cheese), bake. Store in fridge, reheat in morning. Perfect for meal prep!\n\n" +
            "Breakfast Burritos:\n" +
            "Scramble eggs with black beans, peppers, and cheese. Roll in tortillas, wrap individually, freeze. Microwave in the morning for a hot, filling breakfast.\n\n" +
            "Chia Seed Pudding:\n" +
            "Mix chia seeds with milk and flavorings (vanilla, cocoa, fruits), let sit 4+ hours or overnight. It becomes pudding-like. Top with nuts and fresh fruit.\n\n" +
            "Quick Cooking Tips:\n" +
            "- Keep hard-boiled eggs in the fridge for instant protein\n" +
            "- Pre-portion smoothie ingredients in freezer bags\n" +
            "- Cook a batch of steel-cut oats on Sunday, reheat portions all week\n" +
            "- Have healthy options visible - out of sight is out of mind\n\n" +
            "What to Avoid:\n" +
            "- Sugary cereals (spike and crash)\n" +
            "- Pastries and donuts (empty calories)\n" +
            "- Fruit juice alone (too much sugar, no fiber)\n" +
            "- Skipping breakfast (slows metabolism, increases cravings)\n\n" +
            "For Busy Mornings:\n" +
            "If you truly have no time, grab a banana with nut butter, a handful of nuts and an apple, or a hard-boiled egg. Something is always better " +
            "than nothing. Your body needs fuel to function optimally!\n\n" +
            "Remember: Breakfast doesn't have to be complicated. Focus on whole foods, include protein, and make it something you actually enjoy. When you " +
            "start your day with nutritious food, you're setting yourself up for better choices all day long.", 
            "Nina Patel", "Food", "Health & Nutrition");
        
        // Business Blogs
        addBlogWithAuthor(10, "Starting Your Own Business", 
            "Essential steps to launch your startup and turn your idea into a successful venture. Starting a business " +
            "requires careful planning and execution. We'll cover market research, business planning, legal requirements, " +
            "funding options, and building your team. Learn about common mistakes to avoid and strategies that successful " +
            "entrepreneurs use. Whether you're starting an online business, a service company, or a product-based venture, " +
            "this guide provides the foundation you need to get started on the right foot.", 
            "Robert Taylor", "Business", "Entrepreneurship");
        
        addBlogWithAuthor(11, "Digital Marketing Strategies", 
            "Effective ways to market your business online and reach your target audience. Digital marketing has " +
            "become essential for businesses of all sizes. We'll explore SEO, social media marketing, email campaigns, " +
            "content marketing, and paid advertising. Learn how to create a marketing strategy that fits your budget " +
            "and goals, measure your results, and adjust your approach. Discover the latest trends and tools that can " +
            "help your business stand out in the digital landscape.", 
            "Jennifer Lee", "Business", "Marketing");
        
        addBlogWithAuthor(12, "Financial Planning Basics", 
            "Manage your money wisely with these tips for budgeting, saving, and investing. Financial planning is " +
            "crucial for building wealth and achieving your long-term goals. We'll discuss creating a budget, " +
            "building an emergency fund, paying off debt, and starting to invest. Learn about different investment " +
            "options, retirement planning, and insurance basics. Taking control of your finances now will set you " +
            "up for a secure future. Start your journey to financial freedom today!", 
            "Michael Davis", "Business", "Finance");
        
        // Science Blogs
        addBlogWithAuthor(13, "Climate Change Explained", 
            "Understanding the science behind climate change and its impacts on our planet. Climate change is one " +
            "of the most pressing issues of our time. This article breaks down the greenhouse effect, carbon cycles, " +
            "and the evidence for human-caused climate change. We'll explore the impacts on weather patterns, " +
            "ecosystems, and human societies. Learn about mitigation strategies, renewable energy solutions, and " +
            "what individuals can do to make a difference. Knowledge is the first step toward action.", 
            "Dr. Emily White", "Science", "Environment");
        
        addBlogWithAuthor(14, "Space Exploration Updates", 
            "Latest news from space missions, including Mars rovers, new exoplanet discoveries, and upcoming missions. " +
            "Space exploration continues to expand our understanding of the universe. We'll cover recent discoveries " +
            "from NASA, ESA, and other space agencies, including findings about Mars, exoplanets in the habitable zone, " +
            "and developments in space technology. Learn about the James Webb Space Telescope's latest images, plans " +
            "for returning to the Moon, and the future of human spaceflight. The cosmos is full of wonders waiting " +
            "to be discovered!", 
            "Dr. James Miller", "Science", "Astronomy");
        
        addBlogWithAuthor(15, "Renewable Energy Revolution", 
            "How renewable energy is changing the world and what it means for our future. The shift to renewable energy " +
            "is happening faster than many predicted. We'll explore solar, wind, hydroelectric, and geothermal technologies, " +
            "their efficiency improvements, and cost reductions. Learn about energy storage solutions, smart grids, and " +
            "the economic and environmental benefits of clean energy. Discover how countries around the world are " +
            "transitioning to renewables and what innovations are on the horizon.", 
            "Dr. Susan Kim", "Science", "Energy");
        
        // Entertainment Blogs
        addBlogWithAuthor(16, "Top Movies of 2024", 
            "Must-watch films this year that you won't want to miss. From blockbuster action films to thought-provoking " +
            "dramas and hilarious comedies, 2024 has delivered exceptional cinema. We'll review the year's best films, " +
            "discussing plot, performances, direction, and what makes each movie special. Whether you're a fan of " +
            "superhero movies, indie films, or international cinema, this list has something for everyone. Grab some " +
            "popcorn and get ready to update your watchlist!", 
            "Tom Roberts", "Entertainment", "Movies");
        
        addBlogWithAuthor(17, "Best Books to Read", 
            "Our recommendations for your reading list, covering fiction, non-fiction, and everything in between. " +
            "Reading is one of life's greatest pleasures, and finding the right book can be transformative. We'll " +
            "share must-read books from various genres including science fiction, historical fiction, memoirs, " +
            "self-help, and more. Each recommendation includes why we loved it and who might enjoy it. Expand your " +
            "horizons and discover your next favorite book from our curated list!", 
            "Rachel Moore", "Entertainment", "Books");
        
        addBlogWithAuthor(18, "Music Festival Guide", 
            "Everything you need to know about festivals, from packing essentials to surviving multi-day events. " +
            "Music festivals are incredible experiences that bring people together through the power of music. " +
            "This comprehensive guide covers everything from choosing the right festival and buying tickets to " +
            "camping tips and staying safe. We'll also highlight some of the best festivals happening this year " +
            "across different genres. Get ready to dance, make memories, and experience the magic of live music!", 
            "Chris Martin", "Entertainment", "Music");
    }
    
    private void addBlogWithAuthor(int id, String title, String content, String authorName, 
                                  String genre, String category) {
        Blog blog = new Blog(id, title, content, authorName, genre, category);
        blogs.add(blog);
        if (authors.containsKey(authorName)) {
            authors.get(authorName).addBlog(id);
        }
    }
    
    public List<Blog> getAllBlogs() {
        return new ArrayList<>(blogs);
    }
    
    public List<Blog> getBlogsByGenre(String genre) {
        List<Blog> result = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.getGenre().equalsIgnoreCase(genre)) {
                result.add(blog);
            }
        }
        return result;
    }
    
    public List<Blog> getBlogsByCategory(String category) {
        List<Blog> result = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.getCategory().equalsIgnoreCase(category)) {
                result.add(blog);
            }
        }
        return result;
    }
    
    public List<Blog> getBlogsByGenreAndCategory(String genre, String category) {
        List<Blog> result = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.getGenre().equalsIgnoreCase(genre) && 
                blog.getCategory().equalsIgnoreCase(category)) {
                result.add(blog);
            }
        }
        return result;
    }
    
    public Set<String> getAllGenres() {
        Set<String> genres = new HashSet<>();
        for (Blog blog : blogs) {
            genres.add(blog.getGenre());
        }
        return genres;
    }
    
    public Set<String> getAllCategories() {
        Set<String> categories = new HashSet<>();
        for (Blog blog : blogs) {
            categories.add(blog.getCategory());
        }
        return categories;
    }
    
    public Blog getBlogById(int id) {
        for (Blog blog : blogs) {
            if (blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }
    
    public Author getAuthorByName(String name) {
        return authors.get(name);
    }
    
    public List<Blog> getBlogsByAuthor(String authorName) {
        List<Blog> result = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.getAuthorName().equals(authorName)) {
                result.add(blog);
            }
        }
        return result;
    }
}

