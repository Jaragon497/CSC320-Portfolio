public class Automobile {
    private String make;
    String model;
    String color;
    int year;
    int mileage;

    public Automobile(){
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }
    public Automobile(String make, String model, String color, int year, int mileage){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    public static Automobile newVehicle(String make, String model, String color, int year, int mileage){
        return new Automobile(make, model, color, year, mileage);
    }
    public static String[] listVehicleInfo(Automobile x){
        String[] info = new String[5];
        info[0] = "Make: " + x.make;
        info[1] = "Model: " + x.model;
        info[2] = "Color: " + x.color;
        info[3] = "Year: " + x.year;
        info[4] = "Mileage: " + x.mileage;

        return info;
    }

    public static void main(String[] args) {

        Automobile toyotaCorolla= new Automobile("Toyota", "Corolla", "Red", 2008, 82000);
        Automobile toyotaTundra = Automobile.newVehicle("Toyota", "Tundra", "White", 2022, 6000);
        System.out.println(toyotaCorolla);
        String[] v_info = listVehicleInfo(toyotaTundra);

        for (String attrib : v_info) {
            System.out.println(attrib);
        }


    }
}