package permission.model;

public class PermissionDTO {
    /*
    - nombre (String): Nombre del permiso.
     */

    private String name;

    public PermissionDTO(String name) {
        this.name = name;
    }

    public PermissionDTO(){

    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "PermissionDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
