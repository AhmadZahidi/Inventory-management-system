public abstract class Inventory{
    private String name;
    private int quantity;
    private String id;
    private double price;
    private Date date;
    
    Inventory(){}
    //aggreatiation
    Inventory(String n,int q,String id,double p,Date date){
        name=n;
        quantity=q;
        this.id=id;
        price=p;
        this.date=date;
    }
    //composition
    Inventory(String n,int q,String id,double p,int d,int m,int y){
        name=n;
        quantity=q;
        this.id=id;
        price=p;
        date=new Date(d,m,y);
    }
    public void setName(String n){
        name=n;
    }
    public void setQuantity(int q){
        quantity=q;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setPrice(double p){
        price=p;
    }
    public void setDate(Date d){
        date=d;
    }
    public String getName(){return name;}
    public int getQuantity(){return quantity;}
    public String getId(){return id;}
    public double getDouble(){return price;}
    public Date getDate(){return date;}
    
    public String toString(){
        return "\nDETAILS\n\n"+"name:"+name+"\nquantity:"+quantity
                +"\nId:"+id+"\nprice RM:"+price+"\ndate:"+date.toString();
    }
    public abstract double calculate();
}

class Foods extends Inventory{
    private String expiryDate;
    
    public Foods(){
        super();
    }
    public Foods(String expiryDate,String n,int q,String id,
                 double p,Date date){
        super(n,q,id,p,date);
        this.expiryDate = expiryDate;
    }
    public Foods(String expiryDate,String n,int q,String id,double p,int d,int m,int y){
        super(n,q,id,p,d,m,y);
        this.expiryDate = expiryDate;
    }
    public void setExpiryDate(String expiryDate){
        this.expiryDate = expiryDate;
    }
    public String getExpiryDate(){
        return expiryDate;
    }
    public String toString(){
        return  super.toString() + "\nExpiry Date : " + expiryDate;
    }
    public double calculate(){
        double total;
        total = getQuantity() * getDouble();
        return total;
    }
}

class Stationery extends Inventory{
    private String brand;
    
    public Stationery(){
        super();
    }
    public Stationery(String brand,String n,int q,String id,
                      double p,Date date){
        super(n,q,id,p,date);
        this.brand = brand;
    }
    public Stationery(String brand,String n,int q,String id,double p,int d,int m,int y){
        super(n,q,id,p,d,m,y);
        this.brand = brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public String toString(){
        return  super.toString() + "\nBrand : " + brand;
    }
    public double calculate(){
        double total;
        total = getQuantity() * getDouble();
        return total;
    }
}