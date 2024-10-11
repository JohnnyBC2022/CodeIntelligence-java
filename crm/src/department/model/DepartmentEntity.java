package department.model;

import user.model.UserDTO;

import java.util.List;

public class DepartmentEntity {
    /*
    - id (String): Identificador único del departamento.
    - nombre (String): Nombre del departamento.
    - descripcion (String): Descripción del departamento.
    - usuarios (Lista de Usuario): Lista de usuarios asignados al departamento.
     */

    private String id;
    private String name;
    private String description;
    private List<UserDTO> userList;

    public DepartmentEntity(String id, String name, String description, List<UserDTO> userList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userList = userList;
    }

    public DepartmentEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userList=" + userList +
                '}';
    }
}
