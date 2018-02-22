public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary(){
        return super.getSalary() + bonus;
    }

    public void setBonus(double bonuns){
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object object){
        if(!super.equals(object)) return false;
        if(getClass() != object.getClass()) return false;
        Mananger manager = (Manager) object;
        return (bonus == manager.bonus);

    }
}