package user.model;

import department.model.DepartmentDTO;
import role.model.RoleDTO;

import java.util.List;

public class UserEntity {
    private String id;

    private String name;
    private String email;
    private int age;
    private List<DepartmentDTO> departmentList;
    private List<RoleDTO> roleList;


    public UserEntity(String id, String name, String email, int age, List<DepartmentDTO> departmentList, List<RoleDTO> roleList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.departmentList = departmentList;
        this.roleList = roleList;
    }

    public UserEntity() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public List<DepartmentDTO> getDepartmentList() {
        return departmentList;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentList(List<DepartmentDTO> departmentList) {
        this.departmentList = departmentList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", departmentList=" + departmentList +
                ", rolList=" + roleList +
                '}';
    }
}
