import java.util.Arrays;
import java.util.Scanner;

// Product class to represent each item
class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name      : " + productName);
        System.out.println("Category  : " + category);
    }
}

public class EcommerceSearchSystem {

    // Linear Search by productId
    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id)
                return p;
        }
        return null;
    }

    // Binary Search by productId (requires sorted array)
    public static Product binarySearch(Product[] products, int id) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == id)
                return products[mid];
            else if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product(103, "Shoes", "Fashion"),
            new Product(101, "Laptop", "Electronics"),
            new Product(105, "Book", "Stationery"),
            new Product(104, "Watch", "Accessories"),
            new Product(102, "Bag", "Travel")
        };

        long timeTakenLinear = -1;
        long timeTakenBinary = -1;

        System.out.println("=== E-COMMERCE PRODUCT SEARCH SYSTEM ===");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Linear Search (by Product ID)");
            System.out.println("2. Binary Search (by Product ID)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter product ID to search: ");
            int searchId = sc.nextInt();

            switch (choice) {
                case 1:
                    long startLinear = System.nanoTime();
                    Product foundLinear = linearSearch(products, searchId);
                    long endLinear = System.nanoTime();
                    timeTakenLinear = endLinear - startLinear;

                    if (foundLinear != null) {
                        System.out.println("Product found using Linear Search:");
                        foundLinear.display();
                    } else {
                        System.out.println("Product not found.");
                    }
                    System.out.println("Time Taken: " + timeTakenLinear + " ns");
                    break;

                case 2:
                    Product[] sortedProducts = Arrays.copyOf(products, products.length);
                    Arrays.sort(sortedProducts, (a, b) -> Integer.compare(a.productId, b.productId));

                    long startBinary = System.nanoTime();
                    Product foundBinary = binarySearch(sortedProducts, searchId);
                    long endBinary = System.nanoTime();
                    timeTakenBinary = endBinary - startBinary;

                    if (foundBinary != null) {
                        System.out.println("Product found using Binary Search:");
                        foundBinary.display();
                    } else {
                        System.out.println("Product not found.");
                    }
                    System.out.println("Time Taken: " + timeTakenBinary + " ns");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            
        }

        
    }
}
