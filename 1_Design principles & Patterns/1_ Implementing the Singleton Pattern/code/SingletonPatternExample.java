public class SingletonPatternExample {
    static class Logger {
        private static Logger instance;
        private Logger() {
            System.out.println("Logger instance created.");
        }
       
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting the application...");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application is still running...");

        
        if (logger1 == logger2) {
            System.out.println("Only one instance of Logger exists. Singleton is working.");
        } else {
            System.out.println("Multiple instances detected. Singleton failed.");
        }
    }
}
