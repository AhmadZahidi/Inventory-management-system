import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;

public class main{
    public static void main(String args[]){
        Scanner s1=new Scanner(System.in);
        
                        String name="";
                        int quantity=0;
                        String id="";
                        String price="";
                        String d="";
                        String m="";
                        String y="";
                        //food
                        String expiryDate="";
                        //stationary
                        String brand="";
                
            int departmentChoice=0;
                        
        System.out.println("INVENTORY\n");
        System.out.println("Option\n1.register/2. query\n");
        System.out.print("Choice:");
        int choiceOption=s1.nextInt();
        s1.nextLine();
        
        
        if(choiceOption==1){
                    System.out.println("How many inventory to register:");
                    int noReg=s1.nextInt();
                    s1.nextLine();
                    
                    Inventory inventory[]=new Inventory[noReg];
                 
                    
                try{
                    
                       
                        
                        
                        
                
                        PrintWriter OUT=new PrintWriter("checklist.txt");
                        for(int i=1;i<=inventory.length;i++){
                             System.out.println("Which department are you registering? (1.food/2.stationary)");
                        departmentChoice=s1.nextInt();
                        s1.nextLine();
                        
                        System.out.println("\nREGISTERING\n");
                    
                        System.out.print("id:");
                        id=s1.nextLine();
                        OUT.print(id+";");
                        
                        OUT.print(departmentChoice+";");
                        
                        System.out.print("name:");
                        name=s1.nextLine()+";";
                        OUT.print(name);
                    
                        System.out.print("quantity:");
                        quantity=s1.nextInt();
                        s1.nextLine();
                        OUT.print(quantity+";");
                        
                        
                        System.out.print("price:RM");
                        price=s1.nextLine();
                        OUT.print(price+";");
                        
                        System.out.println("register date (DDMMYYYY)");
                        String RegisterDate=s1.nextLine();
                        d=RegisterDate.substring(0,2);
                        m=RegisterDate.substring(2,4);
                        y=RegisterDate.substring(4,8);
                        //System.out.print("\nday:");
                        //d=s1.nextLine();
                        OUT.print(d+";");
                        //System.out.print("\nmonth:");
                       // m=s1.nextLine();
                        OUT.print(m+";");
                        //System.out.print("\nyear:");
                        //y=s1.nextLine();
                        OUT.print(y+";");
                        
                        if(departmentChoice==1){
                            System.out.print("Expiry date (DDMMYYYY)");
                            expiryDate=s1.nextLine();
                            
                            
                            String xd=expiryDate.substring(0,2);
                            String xm=expiryDate.substring(2,4);
                            String xy=expiryDate.substring(4,8);
                            OUT.print(xd+";"+xm+";");
                            OUT.print(xy+";");
                            
                            inventory[i-1]=new Foods(expiryDate,name,quantity,id,Double.parseDouble(price),Integer.parseInt(d),Integer.parseInt(m),Integer.parseInt(y));
                        }
                        else if(departmentChoice==2){
                            System.out.print("brand name:");
                            brand=s1.nextLine();
                            
                            OUT.print(brand+";");
                            
                            inventory[i-1]=new Stationery(brand,name,quantity,id,Double.parseDouble(price),Integer.parseInt(d),Integer.parseInt(m),Integer.parseInt(y));
                        }
                        double cost=inventory[i-1].calculate();
                        OUT.println(cost);
                    }
                        
                    
                    OUT.close();
                    
                    /*
                    */
                    }
                    catch (java.io.FileNotFoundException fnfe)
                    {
                        fnfe.printStackTrace();
                    }
                }
                else if(choiceOption==2){
                    try{
                    FileReader IN=new FileReader("checklist.txt");
                        Scanner fileIn=new Scanner(IN);
                    
                        System.out.println("Enter id inventory: ");
                        int userId=s1.nextInt();
                        s1.nextLine();
                    
                    
                        while(fileIn.hasNextLine()){
                        String line=fileIn.nextLine();
                        StringTokenizer st=new StringTokenizer(line,";");
                        
                        int Dchoice=0;
                        String find="";
                        String coun="";
                        String Id="";
                        String Price="";
                        String D="";
                        String M="";
                        String Y="";
                        String xD="";
                        String xM="";
                        String xY="";
                        String BRAND="";
                        String Quantity="";
                        double cost=0;
                        
                        while(st.hasMoreTokens()){
                            find=st.nextToken();
                            Dchoice=Integer.parseInt(st.nextToken());
                            name=st.nextToken();
                            Quantity=st.nextToken();
                            Id=find;
                            Price=st.nextToken();
                            D=st.nextToken();
                            M=st.nextToken();
                            Y=st.nextToken();
                            if(Dchoice==1){
                                xD=st.nextToken();
                                xM=st.nextToken();
                                xY=st.nextToken();
                            }
                            else if(Dchoice==2){
                                BRAND=st.nextToken();
                            }
                            cost=Double.parseDouble(st.nextToken());
                            }
                      
                        if(Dchoice==1){
                            
                            if(userId==Integer.parseInt(find)){
                                System.out.println("name:"+name+"\nquantity:"+Quantity+"\nid:"+Id
                                                    +"\nprice:RM"+Price+"\nExpregister date:"+D+"/"+M+"/"+ Y
                                                    +"\nExpiry date:"+xD+"/"+xM+"/"+xY+"\ntotal cost in inventory:RM"+cost);
                            }
                        
                        }
                        else if(Dchoice==2){
                            
                            if(userId==Integer.parseInt(find)){
                                System.out.println("name:"+name+"\nquantity:"+Quantity+"\nid:"+Id
                                                    +"\nprice:RM"+Price+"\nbrand type:"+BRAND+"\ntotal cost in inventory:RM"+cost);
                            }
                        }
                    }
                      fileIn.close() ; 
                      
                      
                      
                      
                }
                   
                            
                   catch (java.io.FileNotFoundException fnfe)
                    {
                        fnfe.printStackTrace();
                    }
                    
                   
                }
                
                
            
            }
            }
        
       
        
    
