import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

// Customer class
class Customer {
    private int custid;
    private String name;
    private String email;

    public Customer(int customerId, String name, String email) 
    {
        this.custid = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return custid;
    }

    public String getName() {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

     public int compareTo(Customer other) {
        // Implement comparison based on customer ID
        return Integer.compare(this.custid, other.custid);
    }
}

//Product class
class Product {
    private int proid;
    private String name;
    private double price;

    public Product(int productId, String name, double price) 
    {
        this.proid = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() 
    {
        return proid;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}

//Order class
class Order {
    private int quantity;
    private int orderid;
    private Customer customer;
    private ArrayList<Product> products;

    public Order(int orderId, int q, Customer customer) 
    {
        this.orderid = orderId;
        this.quantity = q;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) 
    {
        products.add(product);
    }

    public int getOrderId() 
    {
        return orderid;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}

public class AmazonCRM_Program {

    public static void main(String []args)
    {
        // Data structures for managing customers, products, and orders
        ArrayList<Customer> custList = new ArrayList<>();
        HashMap<String, Customer> custMap = new HashMap<>();
        TreeSet<Customer> custTreeSet = new TreeSet<>(Comparator.comparing(Customer::getCustomerId));
    
        ArrayList<Product> productsList = new ArrayList<>();
        HashMap<String, Product> productMap = new HashMap<>();
        HashSet<Product> productsHashSet = new HashSet<>();
    
        ArrayList<Order> ordersList = new ArrayList<>();
    
        Scanner sc= new Scanner(System.in);
        // Customer registration Test Case
        System.out.println("Customer Registration:");
        System.out.print("Enter customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter customer name: ");
        String customerName = sc.next();
        System.out.print("Enter customer email: ");
        String customerEmail = sc.next();

        Customer customer = new Customer(customerId, customerName, customerEmail);
        custList.add(customer);
        custMap.put("customer_Id" + customerId, customer);
        custTreeSet.add(customer);

        // Product addition Test Case
        System.out.println("\nProduct Addition:");
        System.out.print("Enter product ID: ");
        int productId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter product name: ");
        String productName = sc.nextLine();
        System.out.println("Enter the price of the product: ");
        double price = sc.nextDouble();

        Product product = new Product(productId, productName, price);
        productsList.add(product);
        productMap.put("product_Id" + productId, product);
        productsHashSet.add(product);

        // Order placement Test Case
        System.out.println("\nOrder Placement:");
        System.out.print("Enter order ID: ");
        int orderId = sc.nextInt();
        System.out.print("Enter order quantity: ");
        int orderQuantity = sc.nextInt();

        Order order = new Order(orderId, orderQuantity, customer);
        order.addProduct(product);
        ordersList.add(order);

        // Additional functionalities: Displaying order information
        System.out.println("\nOrders:");
        for (Order ord : ordersList) {
            System.out.println("Order ID: " + ord.getOrderId() +
                    ", Quantity: " + ord.getQuantity()+
                    ", Customer: " + ord.getCustomer().getName());

            System.out.println("Products in the order:");
            for (Product prod : ord.getProducts()) {
                System.out.println("  Product ID: " + prod.getProductId() +
                        ", Name: " + prod.getName() +
                    ", Total Amount: " + (ord.getQuantity()*prod.getPrice()) );
            }

            System.out.println("-----------");
        }


        sc.close();
  }
}
