package bean;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/3 8:56
 * @Description
 * @Version
 */
public class Father {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
