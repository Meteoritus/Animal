/*Класс клиент*/

public class Client{
	String name;
	
        void setName(String name){
            this.name = name;
        }
	
        String getName(){
            return "client " + name;
        }
        
        /*метод поиска клиента по имени и изменение его на новое*/
        void changeName(String[][] clients, String lastName, String newName){
            for(int i=0; i<clients.length; i++){
                                if(clients[i][0].contains(lastName)) {
                                    clients[i][0] = "client " + newName;
                                    System.out.println("The client " + lastName + " changed name to " + newName);
                                    break;
                                } else {
                                    System.out.println("The name " + "'" + lastName + "'" + " is not found in a base of client");
                                    break;
                                }
                            }
        }
        
        /*метод поиска удалаемого элемента из массива и его обнуление вместе с соответствующим питомцем*/
        void deleteClient(String[][] clients, String clientName){
            for(int i=0; i<clients.length; i++){
                                if(clients[i][0].contains(clientName)) {
                                    clients[i][0] = null;
                                    clients[i][1] = null;
                                    System.out.println("The client " + clientName + " is sucessfull delete from base");
                                    break;
                                }
                            }
        }
}