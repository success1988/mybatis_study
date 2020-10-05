package bean;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/4 6:01
 * @Description
 * @Version
 */
public class User {

    private String name;
    private String sex;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
