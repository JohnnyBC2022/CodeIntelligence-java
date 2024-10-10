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
    private List<RoleDTO> rolList;



    public UserEntity(String id, String name, String email, int age, List<DepartmentDTO> departmentList, List<RoleDTO> rolList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.departmentList = departmentList;
        this.rolList = rolList;
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

    public List<RoleDTO> getRolList() {
        return rolList;
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

    public void setRolList(List<RoleDTO> rolList) {
        this.rolList = rolList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", departmentList=" + departmentList +
                ", rolList=" + rolList +
                '}';
    }
}
