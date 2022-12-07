public class APIRequest {
        public static void main(String[] args){
    
            RequestHandler rh = new RequestHandler();
            
            listItem[] items = rh.getList();
    
            display(items);
        
        }
    
        private static void display(listItem[] items) {
            for (listItem li : items) {
                System.out.println("Name: " + li.name + " | ID: " + li.id + " | List ID: " + li.listId);
            }
        }
}
