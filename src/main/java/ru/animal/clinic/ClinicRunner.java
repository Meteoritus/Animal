package ru.animal.clinic;

import java.util.Arrays;
import java.util.Scanner;

/*реализация работы клиники*/
public class ClinicRunner {
	public static void main(String[] arg) {
                System.out.println("Welcom to the Animal Clinic!");
                String[][] clients = new String[10][2]; // массив клиентов
                
                /*Создаем объекты классов Client, Cat и Dog*/
		Client client = new Client();
                Cat cat = new Cat();
                Dog dog = new Dog();
                
                /*Реализуем ввод с клавиатуры*/
                Scanner reader = new Scanner(System.in);
                String exit = "no";
                
                try {
                    while(!exit.equals("yes")){
                    System.out.println("If you want add client with a pet enter 'add' \n" 
                                    + "If you want to see all clients enter 'all' \n"
                                    + "If you want to change name of client or pet enter 'change' \n"
                                    + "If you want to delete a client enter 'delete' ");
                
                
                    String choice = reader.next();
                    /*Выбор метода работы с базой клиентов клиники: добавление, вывод, изменение и удаление клиентов*/
                    switch (choice) {
                        case ("add"):
                            System.out.println("Enter client name: ");
                            /**
                             * обработка исключения при вводе имени клиента
                             */
                            try {
                                client.setName(reader.next());
                            } catch (UserException e) {
                                System.out.println(e.getMessage());
                                break;
                            }
                            /*метод поиска пустой ячейки массива для добавления нового клиента в базу*/
                            
                            for(int i=0; i<clients.length; i++){
                                if(clients[i][0] == null){
                                    clients[i][0] = client.getName();
                                    System.out.println("If you have a cat enter cat \n"
                                                + "if you have a dog enter dog");
                                    
                                    /*реализация выбора животного кошка/собака*/
                                    String choicePet = reader.next();
                                    switch (choicePet) {
                                        case ("cat"):
                                            System.out.println("Enter cat name: ");
                                            /**
                                             * Обработка исключения при вводе имени кошки
                                             */
                                            try {
                                                cat.setName(reader.next());
                                            } catch (UserException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            clients[i][1] = cat.getName();
                                            break;
                                    
                                        case ("dog"):
                                            System.out.println("Enter dog name: ");
                                            /**
                                             * Обрабокта исключения при вводе имени собаки
                                             */
                                            try {
                                                dog.setName(reader.next());
                                            } catch (UserException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            clients[i][1] = dog.getName();
                                            break;
                                    }
                                    break; // Выход из метода поиска пустой ячейки       
                                } 
                            }
                            break; //Выход из выбора метода добавления клиентов
                            
                        /*Вывод базы клиентов клиники*/    
                        case ("all"):
							System.out.println("Clinic clients base: ");
                            for(int i=0; i<clients.length; i++){
								if(clients[i][0] != null){
									System.out.println(clients[i][0] + ", " + clients[i][1]);
								}
                            }
                            break;
                            
                        /*Change client name*/   
                        case ("change"):
                            System.out.println("Enter the client name you want to change: ");
                            String lastName = reader.next();
                            System.out.println("Enter a new client name: ");
                            String newName = reader.next();
                            client.changeName(clients, lastName, newName);
                            break;
                            
                        /*Удаление клиента из базы*/    
                        case ("delete"):
                            System.out.println("Enter the client name you want to delete: ");
                            String deleteName = reader.next();
                            client.deleteClient(clients, deleteName);
                            break;
                    }
                
                    System.out.println("Exit: yes/no ");
                    exit = reader.next();
                    } 
                    }finally {
                        reader.close(); 
                    }
            }    
}