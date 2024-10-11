package group.model;

import user.model.UserDTO;
import java.util.List;

public class GroupDTO {

    /*
    - id (String): Identificador único del grupo.
    - nombre (String): Nombre del grupo.
    - descripcion (String): Descripción del grupo.
    - usuarios (Lista de Usuario): Lista de usuarios que pertenecen al grupo.
     */

    private String id;
    private String name;
    private String description;
    private List<UserDTO> userList;

    public GroupDTO(String id, String name, String description, List<UserDTO> userList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userList = userList;
    }

    public GroupDTO() {
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
        return "GroupDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userList=" + userList +
                '}';
    }
}
