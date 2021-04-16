package simplecrud.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: Role
 * @Description: TODO
 * @Author: Shadow Zhu
 * @Date: 2021/4/12 14:04
 * @Version: v1.0
 */
@Getter
@Setter
public class Role {
    private int id;
    private String name;
    private String notes;


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name +
                '\'' +
                '}';
    }
}
