package bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/4 7:07
 * @Description
 * @Version
 */
public class SuperStar {

    private List<User> users;

    private Map<String,Address> addressMap;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> userList) {
        this.users = userList;
    }

    public Map<String, Address> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, Address> addressMap) {
        this.addressMap = addressMap;
    }

    public void joinParty(String place, Date partyDate){

    }
}
