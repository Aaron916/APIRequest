public class APIRequest {
        // Main
        // Creates a RequestHandler and gets the list from the API.
        // Calls display.
        public static void main(String[] args){
    
            RequestHandler rh = new RequestHandler();
            
            listItem[] items = rh.getList();
    
            display(items);
        
        }
    
        // Display
        // Accepts a list to read through and print in a readable format.
        private static void display(listItem[] items) {
            for (listItem li : items) {
                System.out.println("Name: " + li.name + " | ID: " + li.id + " | List ID: " + li.listId);
            }
        }
}
