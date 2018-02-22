public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Max Chehab", 1000, 2018, 2, 12);
        boss.setBonus(500);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Rodger", 0.24, 2018, 2, 12);
        staff[2] = new Manager("Tim", 12.34, 2018, 2, 12);
        Manager boss2 = (Manager) staff[2];
        boss2.setBonus(1000);

        for (Employee e : staff) {
            System.out.println(e.getName() + " " + e.getSalary());
        }
        System.out.println(boss.equals(staff[0]));
    }
}